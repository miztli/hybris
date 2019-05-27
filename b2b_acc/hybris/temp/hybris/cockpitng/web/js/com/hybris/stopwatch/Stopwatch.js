com.hybris.stopwatch.Stopwatch = zk.$extends(zul.wgt.Label, {
    _intervalId: undefined,
    _startTime: -1,
    _stopTime: -1,
    _running: false,
    _displayEmptyHours: false,
    _displayDays: false,
    _timeDelimiter: ":",
    _daysDelimiter: "d ",

    bind_: function (evt) {
        this.$supers('bind_', arguments);
        var endTime = this._stopTime >= 0 ? this._stopTime : this.getCurrentTime();
        this.setValue(this.getDisplayTime(endTime));

        if (this._running === true) {
            this.startTimer();
        }
    },

    unbind_: function (evt) {
        this.$supers('unbind_', arguments);
        this.stopTimer();
    },

    setReset:function (reset) {
        if (reset) {
            this.setRunning(false);
            this._startTime = -1;
            this._stopTime = -1;
            this.setValue(this.getDisplayTime(this._stopTime));
        }
    },

    setRunning: function (running) {
        if (this._running !== running) {
            this._running = running;
            if (this._running === true) {
                this.startTimer();
            } else {
                this.stopTimer();
            }
        }
    },

    getDisplayTime: function (currentTime) {
        var startTime = this._startTime >= 0 ? this._startTime : currentTime;

        var duration = Math.floor(Math.abs((currentTime - startTime)) / 1000);

        var d = 0;
        var days = "";

        if (this._displayDays) {
            d = Math.floor(duration / (3600 * 24));
            duration = Math.floor(duration % (3600 * 24));
            days = d > 0 ? d + this._daysDelimiter : "";
        }

        var h = Math.floor(duration / 3600);
        var m = Math.floor(duration % 3600 / 60);
        var s = Math.floor(duration % 3600 % 60);

        var hours = (h > 0 || this._displayEmptyHours || d > 0) ? (((h < 10 && h >= 0) ? "0" : "") + h + this._timeDelimiter) : "";
        var minutes = ((m < 10 && m >= 0) ? "0" : "") + m + this._timeDelimiter;
        var seconds = ((s < 10 && s >= 0) ? "0" : "") + s;

        return days + hours + minutes + seconds;
    },

    getCurrentTime: function () {
        return new Date().getTime();
    },

    startTimer: function () {
        if (!this._intervalId && this._running === true) {
            var widget = this;
            this._intervalId = setInterval(function () {
                widget.updateTime(widget);
            }, 1000);
        }
    },

    stopTimer: function () {
        if (this._intervalId) {
            clearInterval(this._intervalId);
            this._intervalId = undefined;
        }
    },

    updateTime: function (widget) {
        widget.setValue(widget.getDisplayTime(widget.getCurrentTime()));
    },

    setStartTime: function (startTime) {
        if (this._running === false) {
            this._startTime = startTime;
        }
    },

    setStopTime: function (stopTime) {
        if (this._running === false) {
            this._stopTime = stopTime;
        }
    },

    setDisplayEmptyHours: function (displayEmptyHours) {
        this._displayEmptyHours = displayEmptyHours;
    },

    setTimeDelimiter: function (timeDelimiter) {
        this._timeDelimiter = timeDelimiter;
    },

    setDaysDelimiter: function (daysDelimiter) {
        this._daysDelimiter = daysDelimiter;
    },

    setDisplayDays: function (displayDays) {
        this._displayDays = displayDays;
    }
})
;