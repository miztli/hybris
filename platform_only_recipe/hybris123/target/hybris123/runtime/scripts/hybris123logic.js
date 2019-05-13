angular.module('myApp', [])
	.controller('myCtrl', ['$scope', function($scope) {
		$scope.currentStatus = "Select your OS, ZipName, Folder and Personalize..";

		var splitIndex = 0;
    	$scope.$watch('ziphome', function(ziphomeString) {
    		if (ziphomeString) {
	    		splitIndex = Math.max(ziphomeString.lastIndexOf('/'), ziphomeString.lastIndexOf('\\'));
		    $scope.trailhome = ziphomeString.substring(0,splitIndex);
		    $scope.zipname = ziphomeString.substring(splitIndex+1);
    		}
    	});
	    
	      $scope.callSubmitForms = function() {	    	
           if (window.history && typeof history.pushState === 'function' && typeof window.URL === 'function') {
               try {
                   var url = new URL(window.location.href);
                   url.searchParams.set('os', $scope.OS);
                   url.searchParams.set('trailhome', $scope.trailhome);
                   url.searchParams.set('zipname', $scope.zipname);
                   
                   if (url.href !== window.location.href) {
                       history.pushState({}, "foo", url.href)
                   }
               } catch (_) {
                   // ignore, optional
               }
           }
	       submitForms();
	    };
	    
		$scope.initFromUrl = function () {
		    var urlIgnoreOS = getParameterByName('ignoreOS')
	        var urlOS = getParameterByName('os')      
	        var urlZip = getParameterByName('zipname')
	        var urlTrailHome = getParameterByName('trailhome')
		
		    if (urlIgnoreOS!=null) 
		    	$scope.ignoreOS = urlIgnoreOS;
		    else
		    	$scope.ignoreOS = false;
		    	
		    if (urlOS!=null)
		    	$scope.OS = urlOS;
		    else
		    	$scope.OS = getOS();
		    
			$.ajax({url: "http://localhost:8080/hybris123/tdd?test=gety123dir",
				success: function(result){		
					$scope.$apply(function(){
						//console.log("in gety123Dir success "+ result+ " "+$scope.ziphome);        
						$scope.ziphome=result 	 
						var splitIndex = Math.max(result.lastIndexOf('/'), result.lastIndexOf('\\'));
						$scope.trailhome = result.substring(0,splitIndex);
						//console.log("in gety123Dir with trailhome"+result.substring(0,splitIndex));        
						$scope.zipname = result.substring(splitIndex+1);
						
						$scope.callSubmitForms();
										
			   		 });
			    }
			});
			
			if (urlZip!=null)
		    	$scope.zipname = urlZip;
		    	
		    if (urlTrailHome!=null)
		    	$scope.trailhome = urlTrailHome; 
		};    
	}]);

	window.onbeforeunload = function () {
        window.scrollTo(0,0);
	}
	

    function submitForms(){
	    document.forms['form0'].submit();
	    document.forms['form1'].submit();
	    return true;
	}
    
    function getOS() {
		if(navigator.platform.toString().toLowerCase().includes("win")) {
			return "Windows";
		} else {
			return "Mac";
		}
    }
    
	$(document).ready(function(){
		$("select[name='os']").val(getOS());
		
		$("#toolbox").click(function(){
				$("#setup").slideToggle(500);
			  $(this).text(function(i, text){
				  return text === "Open Toolbox" ? "Close Toolbox" : "Open Toolbox";
			  })
		});
		
		$("#personal").click(function(){
			  $(this).val('Updating...').prop('disabled',true);
				setTimeout(function () {
			  		$("#personal").val('Personalize').prop('disabled',false);  
				}, 5000);
		});
	});