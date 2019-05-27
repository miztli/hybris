// This is an override code for clientInfo function.
// Original implementation throws an exception during window resizing:

// An exception java.lang.ClassCastException: java.lang.Double cannot be cast to java.lang.Integer
// This may happen when browser zooms in/out in mobile device and then the screen width/height become double value.

$(document).ready(function () {
    var _portrait = {'0': true, '180': true}, //default portrait definition
        _initLandscape = jq.innerWidth() > jq.innerHeight(), // initial orientation is landscape or not
        _initDefault = _portrait[window.orientation]; //default orientation

    zAu.cmd0.clientInfo = function (dtid) {
        zAu._cInfoReg = true;
        var orient = '',
            dpr = 1;

        if (zk.mobile) {
            //change default portrait definition because landscape is the default orientation for this device/browser.
            if ((_initLandscape && _initDefault) || (!_initLandscape && !_initDefault)) {
                _portrait = {'-90': true, '90': true};
            }

            orient = _portrait[window.orientation] ? 'portrait' : 'landscape';
        } else {
            orient = jq.innerWidth() > jq.innerHeight() ? 'landscape' : 'portrait';
        }

        if (window.devicePixelRatio) {
            dpr = window.devicePixelRatio;
        }

        zAu.send(new zk.Event(zk.Desktop.$(dtid), 'onClientInfo',
            [new Date().getTimezoneOffset(),
                zk.parseInt(screen.width), zk.parseInt(screen.height), screen.colorDepth,
                zk.parseInt(jq.innerWidth()), zk.parseInt(jq.innerHeight()), zk.parseInt(jq.innerX()), zk.parseInt(jq.innerY()), dpr.toFixed(1), orient],
            {implicit: true, rtags: {onClientInfo: 1}}));
    };
});

