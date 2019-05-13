ACC.myCompanyNavigation = {

    _autoload: [
        "myCompanyNavigation",
        "unitCollapse"
    ],


    myCompanyNavigation: function(){


        var aCompData = [];
        var oMyCompanyData = $('.companyNavComponent');


        //the my company hook for the desktop

        var oMMainNavDesktopCom = $(".js-secondaryNavCompany .js-nav__links");

        if(oMyCompanyData){
            var cLinks = oMyCompanyData.find("a");
            for(var i = 0; i < cLinks.length; i++){
                aCompData.push({link: cLinks[i].href, text: cLinks[i].title});
            }
        }

        //create Welcome User + expand/collapse and close button
        //This is for mobile navigation. Adding html and classes.
        var oUserInfo = $(".js-logged_in");
        //Check to see if user is logged in
        if(oUserInfo && oUserInfo.length === 1 && oMyCompanyData.length > 0)
        {


            //FOR DESKTOP

            //FOR MOBILE
            //create a My Company Top link for desktop - in case more components come then more parameters need to be passed from the backend

            //add my company icon
            //<span class="glyphicon glyphicon-list-alt"></span>
            var myCompanyHook = $('<div>').addClass('myCompanyLinksHeader js-myCompany-toggle').data({'toggle':'collapse', 'parent':'.nav__right'}).text(oMyCompanyData.data("title"));
            myCompanyHook.insertBefore(oMyCompanyData);

            //For toggling collapse myCompany on Desktop instead of with Bootstrap.js
            $('.myCompanyLinksHeader').click(function () {
                $(this).toggleClass('show');
                $(".js-secondaryNavCompany").slideToggle(400);
                if ( $(this).hasClass('show') ) {
                    $('.myAccountLinksHeader').removeClass('show'); // hide the other one
                    $('.js-secondaryNavAccount').slideUp(400);
                }
                return false;
            });

            $('.js-userAccount-Links').append($('<li>').addClass('auto').append($('<div>').addClass('myCompanyLinksContainer js-myCompanyLinksContainer')));
            var $subNav = $('<div>').addClass('sub-nav').append(
            		$('<a>').attr('id', 'signedInCompanyToggle').addClass('myCompanyLinksHeader collapsed js-myCompany-toggle').data({'toggle':'collapse', 'target':'.offcanvasGroup3'})
            		.text(oMyCompanyData.data("title")).append($('<span>').addClass('glyphicon glyphicon-chevron-down myCompanyExp')));
            $('.js-myCompanyLinksContainer').append($subNav);
            //add UL element for nested collapsing list
            $('.js-myCompanyLinksContainer').append($('<ul>').addClass('js-myCompany-root offcanvasGroup3 offcanvasNoBorder subNavList js-nav-collapse-body  collapse sub-nav').data('trigger','#signedInCompanyToggle'));

            //For toggling collapse on Mobile instead of with Bootstrap.js
            $('#signedInCompanyToggle ').click(function () {
                $(this).toggleClass('show');
                $(".offcanvasGroup3").slideToggle(400);
                if ( $(this).hasClass('show') ) {
                    $(this).find('span').removeClass('glyphicon-chevron-down').addClass('glyphicon-chevron-up');
                    $('#signedInUserAccountToggle').removeClass('show'); // hide the other one
                    $('#signedInUserAccountToggle').find('span').removeClass('glyphicon-chevron-up').addClass('glyphicon-chevron-down');
                    $('.offcanvasGroup2').slideUp(400);
                }
                else {
                    $(this).find('span').removeClass('glyphicon-chevron-up').addClass('glyphicon-chevron-down');
                }
            });


            //My Company links for desktop
            for(var j = aCompData.length - 1; j >= 0; j--){
                var oLink = $('<a>').attr({'title':aCompData[j].text, 'href':aCompData[j].link}).text(aCompData[j].text);
                $('.js-myCompany-root').append($('<li>').addClass('auto ').append(oLink));
            }

        }
        //desktop

        for(var k = 0; k < aCompData.length; k++){
            var oLink = $('<a>').attr({'title':aCompData[k].text, 'href':aCompData[k].link}).text(aCompData[k].text);
            oMMainNavDesktopCom.get(0).appendChild($('<li>').addClass('auto col-md-4').append(oLink).get(0));
        }

        //hide and show contnet areas for desktop
        $('.js-secondaryNavAccount').on('shown.bs.collapse', function () {

            if($('.js-secondaryNavCompany').hasClass('in')){
                $('.js-myCompany-toggle').click();
            }

        });

        $('.js-secondaryNavCompany').on('shown.bs.collapse', function () {

            if($('.accNavComponentAccount').hasClass('in')){
                $('.js-myAccount-toggle').click();
            }

        });

    },
    
    /**
     * Expands/Collapses the unit tree.
     */
    unitCollapse: function(){
    	$('.panel-heading').click(function() {
    		// parent ('.panel-default') has two children: this '.panel-heading' and '.panel-collapse'
    		$parent = $(this).parent();
    		$content = $parent.children('.panel-collapse');
    		// expand/collapse content
    		$content.toggleClass('in');
		});
    }

};