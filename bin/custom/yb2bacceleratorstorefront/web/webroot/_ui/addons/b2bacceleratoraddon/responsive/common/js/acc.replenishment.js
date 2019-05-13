ACC.replenishment = {
	_autoload: [
		"bindToCancelReplenishmentOrderActionButton",
		"bindToCancelReplenishmentOrderCancelButton"
	],

	bindToCancelReplenishmentOrderActionButton: function ()
	{
		$(document).on("click", '.js-replenishment-cancel-button', ACC.replenishment.handleCancelReplenishmentOrderButtonClick);
	},
	bindToCancelReplenishmentOrderCancelButton: function ()
	{
		$(document).on("click", '.js-replenishment-order-cancel-modal-cancel-button', ACC.replenishment.handleCancelReplenishmentOrderCancelButtonClick);
	},

	handleCancelReplenishmentOrderButtonClick: function() {
		var replenishmentNumber = $(this).data('job-code');
		var popupTitle = ACC.common.encodeHtml($(this).data('popup-title'));

		ACC.colorbox.open(popupTitle,{
			inline: true,
			className: "replenishment-order-cancel-modal",
			href: "#popup_confirm_replenishment_order_cancellation_" + replenishmentNumber,
			width: '435px',


			onComplete: function ()
			{
				$(this).colorbox.resize();
			}

		});

	},

	handleCancelReplenishmentOrderCancelButtonClick: function() {
		ACC.colorbox.close();
	}
};