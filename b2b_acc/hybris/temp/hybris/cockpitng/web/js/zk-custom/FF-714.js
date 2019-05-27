zk.afterLoad('zul.wgt', function() {
    var xPopup = {};
    zk.override(zul.wgt.Popup.prototype, xPopup, {
        onFloatUp : function() {
            if (!this.stayOpen === true) {
                return xPopup.onFloatUp.apply(this, arguments);
            }
        }
    });//zk.override
});//zk.afterLoad