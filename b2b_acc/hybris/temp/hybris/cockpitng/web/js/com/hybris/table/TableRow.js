com.hybris.table.TableRow = zk.$extends(zk.Widget, {

	tclass: null,

	getZclass : function() {
		return this._zclass != null ? this._zclass : 'y-' + this.widgetName;
	},

	redraw : function(out) {
		out.push('<tr ', this.domAttrs_() + '>');
		for (var w = this.firstChild; w; w = w.nextSibling) {
			w.redraw(out);
		}
		out.push('</tr>');
		this.updateRowContents(true);
	},

	setTclass: function (tclass) {
		this.tclass = tclass;
		this.updateDomClass_();
	},

	getTclass: function() {
		return this.tclass;
	},

	domClass_: function(no) {
		var domClass = this.$supers('domClass_', arguments);
		var tclass;
		if (!no || !no.tclass) {
			tclass = this.getTclass();
		}
		return tclass ? domClass + ' ' + tclass : domClass;
	},

	updateRowContents : function(initial) {
		var _parentTable = this.getParentTable();
		if(!_parentTable) {
			return; 
		}
		if(initial && _parentTable) {
			var _parentTableLeft = _parentTable && typeof(_parentTable.getScroll) === "function" ? _parentTable.getScroll().left : false,
			_row = $("#" + this.uuid),
			_stickyCls = _row.parent().hasClass('y-tableheader') ? '.y-tablecell-header-sticky' : '.y-tablecell-sticky';
			_row.children().removeAttr("style");
			_row.children(_stickyCls).css(_parentTable.getScrollStylingObject(_parentTableLeft, 0));
		}
		if(typeof(_parentTable.requestStickyTableUpdate) === "function") {
			_parentTable.requestStickyTableUpdate();
		}
	},

	getParentTable : function() {
		if(!this.parent) {
			return false;
		}
		return (typeof(this.parent.getParentTable) === "function") ? this.parent.getParentTable() : (this.parent.widgetName === "table" ? this.parent : this.parent.parent);
	}
});
