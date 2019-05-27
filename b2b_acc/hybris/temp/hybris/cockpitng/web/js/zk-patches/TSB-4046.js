/**
 * tested on 8.0.2.1
 */
zk.afterLoad('zul.mesh', function () {
    var old = {};
    zk.override(zul.mesh.HeaderWidget.prototype, old, {
        setFlexSize_:
            function (sz) {
                if ((sz.width !== undefined && sz.width != 'auto' &&
                    sz.width != '') || sz.width == 0) {
                    var flexMinWidth = this.domExtraAttrs ? this.domExtraAttrs['flexMinWidth'] : null;
                    var rvw = this._hflex == 'min' &&
                    this.firstChild && this.isRealVisible() ?
                        zk(this.$n('cave')).revisedWidth(sz.width) : sz.width;
                    if (flexMinWidth && rvw < flexMinWidth)
                        rvw = flexMinWidth;
                    this._hflexWidth = rvw;
                    return {width: rvw};
                } else
                    return
                this.$supers('setFlexSize_', arguments);
            }
    });
});