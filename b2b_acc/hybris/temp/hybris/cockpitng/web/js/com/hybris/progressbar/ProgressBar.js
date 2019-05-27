com.hybris.progressbar.ProgressBar = zk.$extends(zk.Widget, {
    _lastUpdatePercentage : 0,
    _timeToIncreaseOnePercent : 0,
    _maxPercentage : 0,
    _intervalId: 0,

    getLastUpdatePercentage: function() {
        return this._lastUpdatePercentage;
    },

    setLastUpdatePercentage : function(lastUpdatePercentage) {
        if (this._lastUpdatePercentage !== lastUpdatePercentage) {
            this._lastUpdatePercentage = lastUpdatePercentage;
        }
    },

    getMaxPercentage: function() {
        return this._maxPercentage;
    },

    setMaxPercentage : function(maxPercentage) {
        if (this._maxPercentage !== maxPercentage) {
            this._maxPercentage = maxPercentage;
        }
    },

    getTimeToIncreaseOnePercent: function() {
        return this._timeToIncreaseOnePercent;
    },

    setTimeToIncreaseOnePercent : function(timeToIncreaseOnePercent) {
        if (this._timeToIncreaseOnePercent !== timeToIncreaseOnePercent) {
            this._timeToIncreaseOnePercent = timeToIncreaseOnePercent;
        }
    },

    redraw : function(out) {
        out.push('<div id="', this.uuid, '-progressbar-bar" class="yw-processes-list-item-content-progressbar-bar">');
        out.push('<div id="', this.uuid, '-progressbar-progress" class="yw-processes-list-item-content-progressbar-progress">');
        out.push('</div>');
        out.push('</div>');
    },

    _fireChanged: function(data) {
        this.fire("onChange",{rawValue:data});
    },

    bind_: function (evt) {
        this.$supers('bind_', arguments);
        this.runProgressBar();
    },

    unbind_: function (evt) {
        this.$supers('unbind_', arguments);

        if(!!this._intervalId)
        {
            clearInterval(this._intervalId);
        }
    },

    runProgressBar: function(){

        var element = document.getElementById(this.uuid + '-progressbar-progress');
        var width = this._lastUpdatePercentage;
        element.style.width = width + '%';
        var widget = this;
        if(this._timeToIncreaseOnePercent > 0) {
            var frame = function() {
                if (parseInt(width) >= parseInt(widget._maxPercentage)) {
                    clearInterval(widget._intervalId);
                } else {
                    width++;
                    element.style.width = width + '%';
                }
            };
            this._intervalId = setInterval(frame, this._timeToIncreaseOnePercent);
        }

    }
});
