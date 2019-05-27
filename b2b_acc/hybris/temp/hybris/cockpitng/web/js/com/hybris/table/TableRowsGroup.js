com.hybris.table.TableRowsGroup = zk.$extends(zul.wgt.Nodom, {

	_collapsed: false,
	tclass: null,

	getZclass: function () {
		return this._zclass != null ? this._zclass : 'y-' + this.widgetName;
	},

	setTclass: function (tclass) {
		this.tclass = tclass;
		this._updateChildClasses();
	},

	getTclass: function() {
		return this.tclass;
	},

	setCollapsed: function (collapsed) {
		this._collapsed = collapsed;
		if (this.desktop) {
			this._updateChildClasses();
			this.fire('onCollapsed', {collapsed: collapsed});
		}
	},

	isCollapsed: function () {
		return this._collapsed;
	},

	redraw: function (out) {
		out.push('<tr id="', this.uuid, '-tmp', '" style="display:none"></tr>');
		for (var w = this.firstChild; w; w = w.nextSibling) {
			this._updateChildClasses(w);
			w.redraw(out);
		}
	},

	appendChild: function (w, ignoreDom) {
		this._updateChildClasses(w);
		this.$supers('appendChild', arguments);
		w.updateRowContents(true);
	},

	setSclass: function (sclass) {
		this.$supers('setSclass', arguments);
		this._updateChildClasses();
	},

	_updateChildClasses: function(w) {
		if (w === undefined) {
			for (var child = this.firstChild; child; child = child.nextSibling) {
				this._updateChildClasses(child);
			}
		} else {
			var tclass;
			if (w === this.firstChild) {
				tclass = w.$s('header');
			}
			if (this._collapsed) {
				tclass = tclass ? tclass + ' ' + w.$s('collapsed') : w.$s('collapsed');
			}
			if (this.getSclass()) {
				tclass = tclass ? tclass + ' ' + this.getSclass() : this.getSclass();
			}
			if (this.getTclass()) {
				tclass = tclass ? tclass + ' ' + this.getTclass() : this.getTclass();
			}

			w.setTclass(tclass);
		}
	},

	getParentTable : function(){
		if(!this.parent){
			return false;
		}
		return (typeof(this.parent.getParentTable) === "function") ? this.parent.getParentTable() : (this.parent.widgetName === "table" ? this.parent : this.parent.parent);
	},

    updateRowContents: function(){
    	for (var w = this.firstChild; w; w = w.nextSibling) {
    		if(typeof(w.updateRowContents) == "function"){
    			w.updateRowContents();
    		}
    	}
    }
});
