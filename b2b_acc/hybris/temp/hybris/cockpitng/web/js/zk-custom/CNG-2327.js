/**
 * to prevent firing onBlur when choosing a day on the popup calendar.
 * based on 8.0.2
 */
zk.afterLoad('zul.db', function() {
    var oldWidget = {};
    zk.override(zul.db.Calendar.prototype, oldWidget, {
        focus_: function (timeout) {
            if (this.isOpen()){
                return;
            }
            oldWidget.focus_.apply(this, arguments);
        }
    });
});