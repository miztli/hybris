ACC.paymentType = {
		
		_autoload: [
		    		"bindPaymentTypeSelect",
		    		"showHideCostCenterSelect"
		    	],

	bindPaymentTypeSelect: function ()
	{
		$("input:radio[name='paymentType']").change(function()
		{
			ACC.paymentType.showHideCostCenterSelect();
		});
	},

	showHideCostCenterSelect: function() {
		var paymentTypeSelected =  $("input:radio[name='paymentType']:checked").val();
		if(paymentTypeSelected == "ACCOUNT") {
			$("#costCenter").show();
		} else {
			$("#costCenter").hide();
		}
	}
}
	
	
