zk.afterLoad('ckez', function () {

    function shouldEncode(elem) {
        var htmlElem = document.getElementById(elem.name);
        if (htmlElem && htmlElem.parentNode) {

            return htmlElem.parentNode.getAttribute('base64encoded') === "true";
        }
        return false;
    }

    ckez.CKeditor.onBlur = function (event, ahead) {
        var editor = event.editor || event,
            wgt = zk.Widget.$(editor.element.getId());

        if (zk.currentFocus === wgt) return;

        if (wgt._tidChg) {
            clearInterval(wgt._tidChg);
            wgt._tidChg = null;
        }

        if (!editor.document)
            editor.document = editor.element.getDocument();

        if (wgt.$class._checkEditorDirty(editor)) {
            var val = editor.getData();
            wgt._value = val;

            if (shouldEncode(this)) {
                val = B64.encode(val);
            }

            wgt.fire('onChange', {value: val}, {sendAhead: ahead});
            editor.resetDirty();
        }
    };
});//zk.afterLoad