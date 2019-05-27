com.hybris.codeeditor.CodeEditor = zk.$extends(zk.Widget, {
    _value: '',
    _syntax: '',
    _readonly: false,
    _codemirror: null,

    getSyntax: function () {
        return this._syntax;
    },

    getValue: function () {
        return this._value;
    },

    setValue: function (value) {
        if (this._value !== value) {
            this._value = value;
            if (this.desktop && _codemirror) {
                _codemirror.setValue(value);
                _codemirror.modified = false;
            }
        }
    },

    setSyntax: function (syntax) {
        if (this._syntax !== syntax) {
            this._syntax = syntax;
        }
    },

    setReadonly: function (readonly) {
        if (this._readonly !== readonly) {
            this._readonly = readonly;
        }
    },

    isReadonly: function () {
        return this._readonly;
    },

    redraw: function (out) {
        out.push('<div ', this.domAttrs_(), '><textarea width="100%" id="', this.uuid, '-textarea">', zUtl.encodeXML(this.getValue()), '</textarea>',
            '</div>');
    },

    onSize: function () {
        if (_codemirror) {
            _codemirror.setSize(this.getWidth(), this.getHeight());
        }
    },

    _doAfterUnbind: function () {

    },

    _fireChanged: function (data) {
        this.fire("onChange", {rawValue: data});
    },

    _doAfterBind: function () {
        var wgt = this;
        var textAreaCode = this.uuid + '-textarea';
        _codemirror = CodeMirror.fromTextArea(document.getElementById(textAreaCode),
            {
                mode: this.getSyntax(),
                lineNumbers: true,
                readOnly: wgt.isReadonly(),
                extraKeys: {
                    "Ctrl-Space": function (cm) {
                        CodeMirror.showHint(cm, CodeMirror.xmlHint, {
                            schemaInfo: {}
                        });
                    }
                }
            });
        _codemirror.modified = false;
        _codemirror.on("blur", function (instance) {
            if (instance.modified) {
                wgt._fireChanged(instance.getValue());
            }
            instance.modified = false;
        });
        _codemirror.on("change", function (instance) {
            instance.modified = true;
            instance.save();
        });
        _codemirror.setSize(this.getWidth(), this.getHeight());
        $('#' + textAreaCode).data('cmInstance', _codemirror);
    },

    bind_: function (desktop, skipper, after) {
        this.$supers('bind_', arguments);
        zWatch.listen({onSize: this});
        var self = this;
        after.push(function () {
            self._doAfterBind();
        });
    },

    unbind_: function (skipper, after) {
        var self = this;
        zWatch.unlisten({onSize: this});
        after.push(function () {
            self._doAfterUnbind();
        });
        this.$supers('unbind_', arguments);
    }
});
