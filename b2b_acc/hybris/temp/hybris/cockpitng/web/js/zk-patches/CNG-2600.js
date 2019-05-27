/* This should be removed after upgrading to ZK 8.5.2 and higher - see comments to CNG-2600 */
/* #4518 allow a minimum zindex via w:minZIndex */
zk.afterLoad('zk', function() {
    var xWidget = {};
    zk.override(zk.Widget.prototype, xWidget, {
        setZIndex : function (zIndex, opts) {
            var adjustedZIndex = this.minZIndex ? Math.max(this.minZIndex, zIndex || 0) : zIndex;
            xWidget.setZIndex.apply(this, [adjustedZIndex, opts]);
            return this;
        },
        getZIndex : function () {
            var zIndex = xWidget.getZIndex.apply(this, arguments); //call original method
            return this.minZIndex ? Math.max(this.minZIndex, zIndex || 0) : zIndex;
        }
    });//zk.override
});//zk.afterLoad
