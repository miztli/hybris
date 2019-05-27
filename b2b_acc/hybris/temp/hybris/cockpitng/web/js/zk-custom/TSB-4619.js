/**
 ZK version: 8.0.0
 The patch for #4418 [listbox] Horizontal scroll in listbody covers rows content if rows attribute is used
 */
zk.afterLoad('zul.sel', function () {
    var xListbox = {};
    zk.override(zul.sel.Listbox.prototype, xListbox, {
        _calcHgh: function () {
            // eq: this.super()
            var result = xListbox._calcHgh.apply(this, arguments);
            // find body div
            var lbbody = this.$n('body');
            // activate if rows attribute is used and a horizontal scrollbar is active
            if (this.getRows() && lbbody.clientWidth < lbbody.scrollWidth) {
                // add the scrollbar height/width to the calculated body height
                lbbody.style.height = (parseInt(lbbody.style.height) + jq.scrollbarWidth()) + "px";
            }
            return result;
        },
        _calcSize: function () {
            xListbox._calcSize.apply(this, arguments);
            this._calcHgh();
        }
    });
});
