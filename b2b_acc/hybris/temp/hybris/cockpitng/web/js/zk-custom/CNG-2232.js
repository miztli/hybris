/**
 * This code is responsible for not forwarding keyEvents from text input fields.
 * - delete, delete+alt, delete+ctrl
 * - backspace, backspace+alt, backspace+ctrl, backspace+cmd (delete entire text to the end on osx)
 * - left + any modifier (alt, ctrl, shift) except (left+alt+ctrl)
 * - right + any modifier (alt, ctrl, shift) except (right+alt+ctrl)
 * - end, end+shift
 * - home, home+shift
 */
zk.afterLoad('zul,zul.inp', function () {
    zul.inp.InputWidget.prototype.isCtrlKeyIgnored = function (evt) {
        var withoutModifier = !(evt.ctrlKey || evt.altKey || evt.shiftKey || evt.metaKey);
        var altXORCtrl = evt.altKey ? !evt.ctrlKey : evt.ctrlKey;

        switch (evt.keyCode) {
            case 8://backspace
                return withoutModifier || (altXORCtrl && !evt.shiftKey);// backspace supports cmd (metaKey)
            case 46://delete
                return withoutModifier || (altXORCtrl && !evt.shiftKey && !evt.metaKey); // alt or ctrl to remove word (and no other modifiers)
            case 37://left
            case 39://right
                return !(evt.altKey && evt.ctrlKey);
            case 35://end
            case 36://home
                return !(evt.altKey || evt.metaKey);//shift (selection) and ctrl (jump to begin/end of text) allowed
            default:
                return false;
        }
    };

    var xWidget = {};
    zk.override(zul.Widget.prototype, xWidget, {
        afterKeyDown_: function (evt) {
            var ignoreEvent = false;
            if (evt.target.$instanceof(zul.inp.InputWidget) && ("domTarget" in evt)) {
                var inputField = evt.domTarget;
                var isTextInput = inputField != null && "type" in inputField && (inputField.type === "text" || inputField.type === "password");
                ignoreEvent = isTextInput && evt.target.isCtrlKeyIgnored(evt);
            }
            if (!ignoreEvent) {
                return xWidget.afterKeyDown_.apply(this, arguments);
            }
        }
    });
});