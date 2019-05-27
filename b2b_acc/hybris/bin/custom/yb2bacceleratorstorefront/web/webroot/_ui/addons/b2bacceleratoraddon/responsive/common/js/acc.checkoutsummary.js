ACC.checkoutsummary = {

	_autoload: [
		"bindAllButtons",
	    "bindScheduleReplenishment",
		"replenishmentInit"
	],

	bindAllButtons: function()
	{
		ACC.checkoutsummary.toggleActionButtons('.place-order-form');
		
	},
	
	toggleActionButtons: function(selector) {
		
		var cssClass = $(document).find(selector);
		var checkoutBtns = cssClass.find('.checkoutSummaryButton');
		var checkBox = cssClass.find('input[name=termsCheck]')	
		
		if(checkBox.is(':checked')) {
			checkoutBtns.prop('disabled', false);
		}
		
		checkBox.on('click', function() {
			var checked = $(this).prop('checked');

			if(checked) {
				checkoutBtns.prop('disabled', false);
			} else {
				checkoutBtns.prop('disabled', true);
			}
		});
	},

    validateDate: function(date,dateFormat) {
    	var validDate = true;
		try{
			$.datepicker.parseDate(dateFormat, date);
		} catch(err){
			//Bad date detected 
			validDate = false;
		}	
		return validDate;
    },

	toggleReplenishmentScheduleDateError: function(showError) {
		if (showError) {
			var datePickerElem = $('#replenishmentSchedule .datepicker');
			if (!datePickerElem.hasClass('has-error')) {
				datePickerElem.addClass('has-error');
			}
			$('#errorReplenishmentStartDate').show();
		} else {
			$('#replenishmentSchedule .datepicker').removeClass('has-error');
			$('#errorReplenishmentStartDate').hide();
		}
	},

	bindScheduleReplenishment: function(data)
	{
		var form = $('#placeOrderForm1');
		var placeReplenishment = false;
		
		$(document).on("click",".scheduleReplenishmentButton",function(e){
			e.preventDefault();
			
			var termChecked = $(this).closest("form").find('input[name=termsCheck]').is(':checked');	
			form.find('input[name=termsCheck]').prop('checked', termChecked);
			
			var titleHtml =$('.scheduleReplenishmentButton').first().html();
			
			ACC.colorbox.open(titleHtml,{
				href: "#replenishmentSchedule",
				inline: true,
				width:"620px",
				onComplete: function(){
					ACC.checkoutsummary.toggleReplenishmentScheduleDateError(false);
					$(this).colorbox.resize();
					placeReplenishment = false;
				},
				onClosed: function() {
					
					if (placeReplenishment) {
						form.submit();
					}
					
					$(".replenishmentOrderClass").val(false);
				}
			});
			
			$("input:radio[name=replenishmentRecurrence]").click(function() {
				if ($("#replenishmentStartDate").val() != '') {
					$('#replenishmentSchedule .js-replenishment-actions').show();
				}
				switch(this.value)
				{
					case "DAILY":

						$('.scheduleformD').show();
						$('.scheduleformW').hide();
						$('.scheduleformM').hide();

						break;
					case "WEEKLY":
						$('.scheduleformD').hide();
						$('.scheduleformW').show();
						$('.scheduleformM').hide();
						break;
					default:
						$('.scheduleformD').hide();
						$('.scheduleformW').hide();
						$('.scheduleformM').show();
				};


				$.colorbox.resize();
			});
			
		});
		
		$(document).on("click",'#replenishmentSchedule #cancelReplenishmentOrder', function (e) {
			e.preventDefault();
			$(".replenishmentOrderClass").val(false);
			$.colorbox.close();
		});
		
		$(document).on("click",'#replenishmentSchedule #placeReplenishmentOrder', function (e){
			e.preventDefault();

			var localeDateFormat = $('#replenishmentSchedule').data('dateForDatePicker');
			var dateEntered = $("#replenishmentStartDate").val();

			if(ACC.checkoutsummary.validateDate(dateEntered, localeDateFormat)){
				$(".replenishmentOrderClass").val(true);
				placeReplenishment = true;
				$.colorbox.close();	
			} else{
				ACC.checkoutsummary.toggleReplenishmentScheduleDateError(true);
				$.colorbox.resize();
			}

		});

		$(document).on("change",'#replenishmentStartDate', function (e) {
			ACC.checkoutsummary.toggleReplenishmentScheduleDateError(false);
			$.colorbox.resize();
		});


		$(document).on("click",'#replenishmentSchedule .js-open-datepicker', function (){
			$('#replenishmentSchedule .hasDatepicker').datepicker('show');
		});

	},

	replenishmentInit: function ()
	{
		var placeOrderFormReplenishmentOrder = $('#replenishmentSchedule').data("placeOrderFormReplenishmentOrder");
		var placeOrderFormReplenishmentRecurrence = $('#replenishmentSchedule').data("placeOrderFormReplenishmentRecurrence");
		var dateForDatePicker = $('#replenishmentSchedule').data("dateForDatePicker");
		var placeOrderFormNDays = $('#replenishmentSchedule').data("placeOrderFormNDays");
		var placeOrderFormNthDayOfMonth = $('#replenishmentSchedule').data("placeOrderFormNthDayOfMonth");
		
		if (placeOrderFormReplenishmentOrder === undefined) {
			return;
		}
		
		// replenishment schedule data not set to cart yet
		if (!placeOrderFormReplenishmentOrder) {
		
			$('#replenishmentSchedule .js-replenishment-actions').hide();
		
			// default value for daily
			$("input:radio[name='replenishmentRecurrence'][value=DAILY]").prop('checked', false);
			$('.scheduleformD').hide();
			$("#nDays option[value=" + placeOrderFormNDays + "]").attr('selected', 'selected');

			// default value for weekly
			$("input:radio[name='replenishmentRecurrence'][value=WEEKLY]").prop('checked', false);
			$('.scheduleformW').hide();
		
			// default value for monthly
			$("input:radio[name='replenishmentRecurrence'][value=MONTHLY]").prop('checked', false);
			$('.scheduleformM').hide();
		
			if (placeOrderFormNthDayOfMonth != '')		
				$("#nthDayOfMonth option[value=" + placeOrderFormNthDayOfMonth + "]").attr('selected', 'selected');

			$("#replenishmentStartDate").val("");
		}
		else {
			switch(placeOrderFormReplenishmentRecurrence)
			{
				case "DAILY":
					$('.scheduleformD').show();
					break;
				case "WEEKLY":
					$('.scheduleformW').show();
					break;
				default:
					$('.scheduleformM').show();
			};

		}

		$(".js-replenishment-datepicker").datepicker({
			dateFormat: dateForDatePicker,
		    onClose: function() {
		    	if ($(this).val() == '' ) {
		    		$('#replenishmentSchedule .js-replenishment-actions').hide();
		    	}
		    	else {
		    		if ($("input:radio[name=replenishmentRecurrence]").is(':checked')) {
			        	$('#replenishmentSchedule .js-replenishment-actions').show();
                        $.colorbox.resize();
			        }
		    	}
		    		
		    }
		});	
		
	}

};
