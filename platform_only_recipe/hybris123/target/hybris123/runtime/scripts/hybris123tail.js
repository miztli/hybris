// <![CDATA[
	 function colorTest(result, item_id){
    try{
      var res = (""+result).trim();
      var origItemId=item_id.trim();
      item_id=item_id.trim();
      item_id = item_id.replace(/\./g,'\\.').replace(/\_/g,'\\_');

  	  var newClass = "isa_success";
  	  var newColor = "#99ff99";//green
  	  var newText = "Passed";
      var newpulseclass="teststatusgreen"
  	  
  	  if (res.includes("Running")){
  	  	newClass = "is_running";
  	  	newColor = "#ffffb3"; // yellow
  	  	newText = "...Running...";
        newpulseclass="teststatusyellow"
  	  } else if (res.includes("NotYetRun")){
  	  	newClass = "is_notrun";
  	  	newColor = "#b3ecff"; //blue
  	  	newText = "Not yet run";
        newpulseclass="teststatusblue"
  	  } else if (res.includes("ail")){ 
  	  	newClass = "isa_error";
  	  	newColor = "#ffd6cc";//red
  	  	newText= "failed";
        newpulseclass="teststatusred"
  	  } 
  	  
      $("#"+item_id+"Result").removeClass( "isa_error isa_success isa_info is_notrun is_running" ).addClass(newClass);
      $("#"+item_id+"Snippet").removeClass( "isa_error isa_success isa_info is_notrun is_running" ).addClass(newClass);
  	  try{
        parent.frames.frame0.$('span[name="'+item_id+'play"]').removeClass( "teststatusgreen teststatusyellow teststatusblue teststatusred" ).addClass(newpulseclass);
  	  }catch(Err){
  		  console.log("Err1 "+Err);
  	  }
      $("#"+item_id+"Result").html(newText);
    }
    catch(err){
      console.log("In catch "+err)
    }
	}
  function runATest(item_id) {
        var encodedItemId = item_id.replace(/\./g,'\\.').replace(/\_/g,'\\_');
        $("#"+encodedItemId+"Result").removeClass( "isa_error isa_success  is_notrun isa_info" ).addClass("is_running");
        $("#"+encodedItemId+"Snippet").removeClass( "isa_error isa_success is_notrun  isa_info" ).addClass("is_running");
 		$("#"+encodedItemId+"Result").html("...Running...");
          
        $.ajax({url: "http://localhost:8080/hybris123/tdd?test="+item_id,
        	success: function(result){

            /*$.ajax({url: "https://hybris123admin.cfapps.eu10.hana.ondemand.com/hybris123Admin?task=ken.lomax@sap.com|one|two",
              success: function(result){
              },
              error: function(XMLHttpRequest, textStatus, errorThrown) {
              }
            });*/

	        },
      		error: function(XMLHttpRequest, textStatus, errorThrown) {

          }
  		  });
      };

      function showRow(index) {
      	if (index==-1){
      	  for (i = 0; i <= 40; i++) { 
             $('#row'+i).show();
         }
         return;
      	}
       	for (i = 0; i <= 40; i++) { 
             $('#row'+i).hide();
        }
        $("#row"+index).show();
      };

      function clickCopySpan(spanid){
        var span = document.getElementById(spanid) ;
        var click= new Event('click');
        span.dispatchEvent(click);
      };


 	function clickGitSpan(spanid){
        var span = document.getElementById(spanid) ;
        var click= new Event('click');
        span.dispatchEvent(click);
      };
 
// ]]>