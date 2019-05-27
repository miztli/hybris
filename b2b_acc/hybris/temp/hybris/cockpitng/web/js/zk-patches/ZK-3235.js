/**
ZK version: 8.0.0
The patch for InputWidget (demicalbox and doublebox). Do not fix the input text upon the format during typing.
*/
zk.afterLoad('zul.inp', function() {
	var oldWidget = {};
	function _onChangeData(wgt, inf, selbk) {
		inf.start = zk(wgt.getInputNode()).getSelectionRange()[0];
		if (selbk) inf.bySelectBack = true;
		return inf;
	}
	zk.override(zul.inp.InputWidget.prototype, oldWidget, {
		updateChange_: function () {
			if (zul.inp.validating) return false; 

			var inp = this.getInputNode(),
				value = inp.value;
			if (!this._reVald && value == this._defRawVal )
				return false; 

			var wasErr = this._errmsg,
				vi = this._validate(value);
			if (!vi.error || vi.server) {
				var upd, data;
				if (vi.rawValue != null) { 
					data = {rawValue: vi.rawValue};
				} else if (!vi.error) {

					value = this.coerceToString_(vi.value);
					//during typing, don't fix the input text upon format
					if (zk.currentFocus != this && inp.value !== value) {
						inp.value = value;					
					}
					this._reVald = false;



					upd = wasErr || !this._equalValue(vi.value, this._value);
					if (upd) {
						this._value = vi.value; 
						this._defRawVal = value;
					}
				}
				if (upd || vi.server)
					this.fire('onChange',
						_onChangeData(this,
							data != null ? data: {value: this.marshall_(vi.value)}),
						vi.server ? {toServer:true}: null, 90);
			}
			return true;
		}
	});
	
});