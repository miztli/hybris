com.hybris.table.TableHeader = zk.$extends(zk.Widget, {

	getZclass : function() {
		return this._zclass != null ? this._zclass : 'y-' + this.widgetName;
	},

    redraw : function(out) {
        out.push('<thead ', this.domAttrs_() + '>');
		for (var w = this.firstChild; w; w = w.nextSibling)
			w.redraw(out);
        out.push('</thead>');
    }

});
