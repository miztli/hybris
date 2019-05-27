CockpitNG = function (domElement) {
    this.$widget = CockpitNG.widgetRoot(domElement);
    if (!this.$widget) {
        throw "Unable to determine widget root! Use 'widget' tag or 'cng-root' class/attribute.";
    }
    this.$widget.$cng = this;
    this.$id = document.$currentWidget;
};

CockpitNG.prototype.id = function () {
    return this.$id;
};

CockpitNG.prototype.root = function () {
    return this.$widget;
};

CockpitNG.prototype.container = function () {
    return $(this.$widget).closest(".z-html").get(0) || document.getElementById(this.$id) || this.$widget.parentNode;
};

CockpitNG.prototype.relative = function (path) {
    return "widgetJarResource/" + this.$widget.$code + "/" + path;
};

CockpitNG.prototype.absolute = function (path) {
    return "jarResource/" + this.$widget.$code + "/" + path;
};

CockpitNG.prototype.socketEvent = function (socketId, data, type) {
    if (this.$widget) {
        if (typeof(data) === "function") {
            if (!this.$widget.$socketHandlers) {
                this.$widget.$socketHandlers = [];
            }

            if (!this.$widget.$socketHandlers[socketId]) {
                this.$widget.$socketHandlers[socketId] = [];
            }

            this.$widget.$socketHandlers[socketId].push(data);
        } else {
            if (type) {
                data.$class = type;
            }
            /* send zk event to that widget*/
            CockpitNG.sendEvent(this.container(), 'onSocketOutput_' + socketId, data);
        }
    }
};

CockpitNG.prototype.sendSocketEvent = function (socketId, data, type) {
    this.socketEvent(socketId, data, type);
};

CockpitNG.prototype.onSocketEvent = function (socketId, handler) {
    this.socketEvent(socketId, handler);
};

CockpitNG.prototype.fireSocketEvent = function (socketId, data) {
    if (this.$widget.$socketHandlers && this.$widget.$socketHandlers[socketId]) {
        data = JSON.parse(data);
        var handlers = this.$widget.$socketHandlers[socketId];
        for (var idx = 0; idx < handlers.length; idx++) {
            var handler = handlers[idx];
            if (handler.length == 0) {
                handler.call(this.$widget);
            } else if (handler.length == 1) {
                handler.call(this.$widget, data);
            } else if (handler.length == 2) {
                handler.call(this.$widget, socketId, data);
            }
        }
    }
};

CockpitNG.prototype.getSessionInfo = function () {
    return this.$widget.$sessionInfo;
};

CockpitNG.prototype.model = function (id, value, type) {
    if (!this.$widget.$model) {
        this.$widget.$model = {};
    }
    if (typeof(id) === "undefined") {
        return this.$widget.$model;
    } else if (typeof(value) === "undefined") {
        if (this.$widget.$model) {
            return this.$widget.$model[id];
        } else {
            return null;
        }
    } else if (typeof(value) === "function") {
        if (!this.$widget.$modelHandlers) {
            this.$widget.$modelHandlers = [];
        }

        if (!this.$widget.$modelHandlers[id]) {
            this.$widget.$modelHandlers[id] = [];
        }

        this.$widget.$modelHandlers[id].push(value);
    } else {
        this.$widget.$model[id] = value;
        if (type) {
            value.$class = type;
        }

        CockpitNG.sendEvent(this.container(), 'onModelChange', {"key": id, "value": value});
        CockpitNG.notifyModelEventHandlers(this.$widget, id, value);
    }
};

CockpitNG.prototype.getModelValue = function (name) {
    return this.model(name);
};

CockpitNG.prototype.setModelValue = function (name, value, type) {
    return this.model(name, value, type);
};

CockpitNG.prototype.onModelChange = function (name, value) {
    if (typeof(name) === "function") {
        this.model(null, name);
    } else {
        this.model(name, value);
    }
};

CockpitNG.prototype.fireModelChange = function (property, value) {
    var $widget = this.$widget;
    var doNotification = function (handlers, property, value) {

        if (value) {
            try {
                value = JSON.parse(value);
            } catch (ignore) {
            }
        }
        for (var idx = 0; idx < handlers.length; idx++) {
            var handler = handlers[idx];
            if (handler.length == 0) {
                handler.call($widget);
            } else if (handler.length == 1) {
                handler.call($widget, $widget.$model);
            } else if (handler.length == 2 && value) {
                handler.call($widget, property, value);
            } else if (handler.length == 3 && value) {
                handler.call($widget, $widget.$model, property, value);
            }
        }

    };

    if (this.$widget.$modelHandlers && !(typeof(property) === "undefined") && this.$widget.$modelHandlers[property]) {
        doNotification(this.$widget.$modelHandlers[property], property, value);

        if (property == null) {
            for (var idx = 0; idx < this.$widget.$modelHandlers.length; idx++) {
                var key = this.$widget.$modelHandlers[idx];
                var v = undefined;
                if (value != null) {
                    v = value[key];
                }
                doNotification(this.$widget.$modelHandlers[key], key, v);
            }
        }
    }

    if (property && this.$widget.$modelHandlers && this.$widget.$modelHandlers[null]) {
        doNotification(this.$widget.$modelHandlers[null], property, value);
    }
};

CockpitNG.prototype.local = function (key) {
    if (!this.$widget.$loc) {
        this.$widget.$loc = {};
        this.$widget.$loc.local = {};
        this.$widget.$loc.global = {};
    }
    if (typeof(key) === "undefined") {
        return this.$widget.$loc.local;
    } else {
        var result = CockpitNG.extractLocalized(this.$widget.$loc.local, key);
        if (result) {
            return result;
        } else {
            return "[" + key + "]";
        }
    }
};

CockpitNG.prototype.global = function (key) {
    if (!this.$widget.$loc) {
        this.$widget.$loc = {};
        this.$widget.$loc.local = {};
        this.$widget.$loc.global = {};
    }
    if (typeof(key) === "undefined") {
        return this.$widget.$loc.global;
    } else {
        var result = CockpitNG.extractLocalized(this.$widget.$loc.global, key);
        if (result) {
            return result;
        } else {
            return "[" + key + "]";
        }
    }
};

CockpitNG.prototype.settings = function (key, def) {
    if (typeof(key) === "undefined") {
        return this.$widget.$config;
    } else {
        var result = CockpitNG.extract(this.$widget.$config, key);
        if (!result) {
            result = def;
        }
        return result;
    }
};

CockpitNG.prototype.ready = function (handler) {
    if (!this.$widget.$readyHandlers) {
        this.$widget.$readyHandlers = [];
    }

    this.$widget.$readyHandlers.push(handler);
};

CockpitNG.prototype.fireAdapterReady = function () {
    if (this.$widget.$readyHandlers) {
        var handlers = this.$widget.$readyHandlers;
        for (var idx = 0; idx < handlers.length; idx++) {
            var handler = handlers[idx];
            if (handler.length == 0) {
                handler.call(this.$widget);
            } else if (handler.length == 1) {
                handler.call(this.$widget, this);
            }
        }
    }
};

CockpitNG.widgetRoot = function (domElement, selector) {
    if (!domElement) {
        domElement = document.$currentWidget || document.currentScript || $('script').last().get(0);
    }
    if (typeof(domElement) === "string") {
        domElement = document.getElementById(domElement);
    }
    if (domElement) {
        if (!selector) {
            return CockpitNG.widgetRoot(domElement, "[cng-root]") ||
                CockpitNG.widgetRoot(domElement, ".cng-root") ||
                CockpitNG.widgetRoot(domElement, "widget");
        } else {
            return $(domElement).find(selector).get(0) ||
                $(domElement).closest(".widget_body").find(selector).get(0) ||
                $(domElement).closest(selector).get(0) ||
                $(domElement).parent().find(selector).get(0);
        }
    } else {
        return null;
    }
};

CockpitNG.extract = function (context, key) {
    if (context && key) {
        var split = key.split(".");
        if (split.length > 0) {
            context = context[split[0]];
            split.shift();
            key = split.join(".");
            return CockpitNG.extractLocalized(context, key);
        }
    } else {
        return context;
    }

};

CockpitNG.sendEvent = function (domElement, eventName, data) {
    var zkWidget = zk.Widget.$(domElement);

    if (zkWidget != null) {
        zAu.send(new zk.Event(zkWidget, eventName, data));
    }
};

CockpitNG.extractLocalized = function (local, key) {
    return CockpitNG.extract(local, key);
};

CockpitNG.assignModel = function (target, model) {
    var root = CockpitNG.widgetRoot(target);
    if (root) {
        root.$model = JSON.parse(model);
        CockpitNG.notifyModelEventHandlers(target, null);
    }
};

CockpitNG.assignSessionInfo = function (target, sessionInfo) {
    var root = CockpitNG.widgetRoot(target);
    if (root) {
        root.$sessionInfo = JSON.parse(sessionInfo);
    }
};

CockpitNG.assignLocalization = function (target, local, global) {
    var root = CockpitNG.widgetRoot(target);
    if (root) {
        root.$loc = [];
        root.$loc.local = JSON.parse(local);
        root.$loc.global = JSON.parse(global);
    }
};

CockpitNG.assignSettings = function (target, config) {
    var root = CockpitNG.widgetRoot(target);
    if (root) {
        root.$config = JSON.parse(config);
    }
};

CockpitNG.notifySocketEventHandlers = function (target, socketId, data) {
    var root = CockpitNG.widgetRoot(target);
    if (root && root.$cng) {
        root.$cng.fireSocketEvent(socketId, data);
    }
};

CockpitNG.notifyModelEventHandlers = function (target, property, value) {
    var root = CockpitNG.widgetRoot(target);
    if (root && root.$cng) {
        root.$cng.fireModelChange(property, value);
    }
};

CockpitNG.notifyAdapterReady = function (target) {
    var root = CockpitNG.widgetRoot(target);
    if (root && root.$cng) {
        root.$cng.fireAdapterReady();
    }
};

CockpitNG.assignCode = function (target, code) {
    var root = CockpitNG.widgetRoot(target);
    if (root) {
        root.$code = code;
    }
};