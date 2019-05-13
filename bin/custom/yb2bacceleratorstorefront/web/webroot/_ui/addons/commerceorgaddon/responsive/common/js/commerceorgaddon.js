ACC.commerceorg = {

    _autoload: [
        "bindToSelectBudget",
        "bindToDeselectBudget",
        "bindToSelectLink",
        "bindToDeselectLink",
        "bindToActionConfirmationModalWindow",
        "disablePermissionConfirmation",
        "bindToSelectUser",
        "bindToDeselectUser",
	    "bindToUnitAddUserButton",
	    "disablePermissionConfirmation",
        "bindPermissionTypeSelectionForAddNew",
        "bindToRemoveUserFromUnit",
        "budgetFormInit"
    ],

    bindToSelectBudget: function()
    {
        $(document).on('click','.js-selectBudget',function(){
            var url = $(this).attr('url');
            $.postJSON(url,{}, ACC.commerceorg.selectionCallback);
            return false;
        });

    },

    bindToDeselectBudget: function()
    {
        $(document).on('click','.js-deselectBudget',function(){
            var url = $(this).attr('url');
            $.postJSON(url,{}, ACC.commerceorg.deselectionCallback);
            return false;
        });
    },

    selectionCallback: function(budget)
    {
    	$(document).find('#card-' + budget.normalizedCode).addClass("selected");
    	$(document).find('#span-' + budget.normalizedCode).html($('#enableDisableLinksTemplate').tmpl(budget));
    },

    deselectionCallback: function(budget)
    {
    	$(document).find('#card-' + budget.normalizedCode).removeClass("selected");
    	$(document).find('#span-' + budget.normalizedCode).html($('#enableDisableLinksTemplate').tmpl(budget));
    },

    disablePermissionConfirmation: function(data)
    {
        $(document).on("click",".js-disable-permission-confirmation",function(e){
            e.preventDefault();

            ACC.colorbox.open("",{
                inline:true,
                href: "#disablePermission",
                width:"620px",
                onComplete: function(){
                    $(this).colorbox.resize();
                }
            });
        });

        $(document).on("click",'#disablePermission #cancelDisablePermission', function (e) {
            e.preventDefault();
            $.colorbox.close();
        });
    },

    bindPermissionTypeSelectionForAddNew: function ()
    {
        $('#selectNewPermissionType').on("change", function (e)
        {
            $.ajax({
                url: ACC.config.encodedContextPath + '/my-company/organization-management/manage-permissions/getNewPermissionForm',
                async: true,
                data: {'permissionType':$(this).val()},
                dataType: "html",
                beforeSend: function ()
                {
                    $("#addNewPermissionForm").html(ACC.address.spinner);
                }
            }).done(function (data)
            {
                $("#addNewPermissionForm").html($(data).html());
                ACC.commerceorg.bindPermissionTypeSelectionForAddNew();
            });
        })
    },

    bindToSelectUser: function()
    {
        $(document).on('click','.js-selectUser',function(){
            var url = $(this).attr('url');
            $.postJSON(url,{}, ACC.commerceorg.userSelectionCallback);
            return false;
        });
    },

    bindToDeselectUser: function()
    {
        $(document).on('click','.js-deselectUser',function(){
            var url = $(this).attr('url');
            $.postJSON(url,{}, ACC.commerceorg.userSelectionCallback);
            return false;
        });
    },

    bindToRemoveUserFromUnit: function()
    {
        $(document).on('click','.js-remove-user-from-unit',function(){
        	var removeUserFromUnit = $(this).parents('.card');
        	var counterElem = $(this).parents('.account-cards').prev('.account-list-header').find('.counter');

        	$.postJSON(this.getAttribute('url'), {}, function(){
        		removeUserFromUnit.remove();
                counterElem.text(counterElem.text() - 1);
        	});

        	return false;
        });
    },

    userSelectionCallback: function(user)
    {
        var userNormalizedId = typeof user.normalizedUid != 'undefined' ? user.normalizedUid : user.normalizedCode;

        $(document).find('#selection-' + userNormalizedId).html($('#enableDisableLinksTemplate').tmpl(user));
        $(document).find('#roles-' + userNormalizedId).html($('#userRolesTemplate').tmpl(user));
        if (user.selected)
        {
        	$(document).find('#row-' + userNormalizedId).addClass("selected");
        }
        else
        {
        	$(document).find('#row-' + userNormalizedId).removeClass("selected");
        }
    },

    bindToSelectLink: function()
    {
        $(document).on('click','.js-selectLink',function(){
            var url = $(this).attr('url');
            $.postJSON(url,{}, ACC.commerceorg.selectionCallbackLink);
            return false;
        });
    },

    bindToDeselectLink: function()
    {
        $(document).on('click','.js-deselectLink',function(){
            var url = $(this).attr('url');
            $.postJSON(url,{}, ACC.commerceorg.deselectionCallbackLink);
            return false;
        });
    },

    selectionCallbackLink: function(permission)
    {
    	$(document).find('#row-' + permission.normalizedCode).addClass("selected");
    	$(document).find('#span-' + permission.normalizedCode).html($('#enableDisableLinksTemplate').tmpl(permission));
    },

    deselectionCallbackLink: function(permission)
    {
    	$(document).find('#row-' + permission.normalizedCode).removeClass("selected");
    	$(document).find('#span-' + permission.normalizedCode).html($('#enableDisableLinksTemplate').tmpl(permission));
    },


    bindToActionConfirmationModalWindow: function()
    {
        $('.js-action-confirmation-modal a').click(function(e){
            e.preventDefault();

            var title = ACC.common.encodeHtml($(this).data('action-confirmation-modal-title'));
            var id = $(this).data('action-confirmation-modal-id');
            var modalWindow = $('#js-action-confirmation-modal-content-' + id);

            if (modalWindow.data('useSourceElementUrl') === true) {
                var url = $(this).prop('href');

                modalWindow.find('.url-holder').each(function(index, element) {
                    var target = $(element);

                    if (target.is("form")) {
                        target.prop('action', url);
                    } else {
                        target.prop('href', url);
                    }
                });
            }

            ACC.colorbox.open(title,{
                inline:true,
                href:modalWindow,
                width:"480px",
                onComplete: function(){
                    ACC.colorbox.resize();
                }
            });
        });

        $('.js-action-confirmation-modal-cancel').click(function(e){
            e.preventDefault();
            ACC.colorbox.close();
        });
    },

    bindToUnitAddUserButton: function()
    {
        $('.js-add-user-action').click(function(e) {
            $(this).parent('.add-user-action-menu').toggleClass('open');
            return false;
        });
    },
    
    budgetFormInit: function() 
    {
        var dateFormatForDatePicker = $('#editB2bBudgetform').data("dateFormatForDatePicker");

        $("#budgetStartDate").datepicker({dateFormat: dateFormatForDatePicker});
        $(document).on("click", '#editB2bBudgetform .js-open-datepicker-budgetStartDate', function () {
            $("#budgetStartDate").datepicker('show');
        });

        $("#budgetEndDate").datepicker({dateFormat: dateFormatForDatePicker});
        $(document).on("click", '#editB2bBudgetform .js-open-datepicker-budgetEndDate', function () {
            $("#budgetEndDate").datepicker('show');
        });

        $.validator.addMethod("dateValidator", function(value, element){
    		var dt = $.datepicker.parseDate($('#editB2bBudgetform').data("dateFormatForDatePicker"), value); 
			return this.optional(element) || !/Invalid|NaN/.test(new Date(dt).toString());
    	}, $.validator.messages.date);
        
        $('#editB2bBudgetform').validate({
            rules: {
                startDate: {
                    required: true,
                    dateValidator: true,
                    date: false
                },
                endDate: {
                    required: true,
                    dateValidator: true,
                    date: false
                }
            }
        });
    }
};
