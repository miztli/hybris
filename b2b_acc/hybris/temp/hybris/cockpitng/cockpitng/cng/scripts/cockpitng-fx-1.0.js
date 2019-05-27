/**
 * DnD Ghost
 */
zk.afterLoad("zk", function () {
    var sanitizeHtml = function (html) {
        return jq('<div/>').text(html).html();
    };

    var findGhostMessageInCollectionBrowser = function (collectionBrowserContainer, title, drag) {
        var collectionBrowserStatusBar = collectionBrowserContainer.find(".yw-listview-statusbar-button");
        if (collectionBrowserStatusBar && collectionBrowserStatusBar.length === 1 && collectionBrowserStatusBar[0]) {
            // extract the number
            var numberOfSelectedItem = parseInt(collectionBrowserStatusBar[0].textContent.split(" ")[0]);
            // check whether dragged object is selected : 'yw-selected' in grid and 'z-listitem-selected' in list view
            var isDraggedSelectedObject = !jq(drag.node).hasClass('yw-selected') && !jq(drag.node).hasClass('z-listitem-selected');
            if ((numberOfSelectedItem === 1 && isDraggedSelectedObject) || numberOfSelectedItem > 1) {
                title.innerHTML = sanitizeHtml(collectionBrowserStatusBar[0].textContent);
            }
        }
    };

    zk.DnD.ghost = function (drag, offset, msg) {
        var divGhost = document.createElement("div");
        zk.copy(divGhost.style, {
            position: "absolute",
            left: offset[0] + "px",
            top: offset[1] + "px"
        });
        if (jq(drag.node).hasClass('yw-dashboard-slot-draggable')) {

            divGhost.id = "zk_ddghost";
            var jCtr = jq(divGhost);
            jCtr.addClass("z-drag-ghost yw-dashboard-slot-ghost");

            var wgt = jq(drag.node);
            var node = jq(wgt).next().clone(true)[0];
            divGhost.appendChild(node);
            document.body.appendChild(divGhost);
            jCtr.fadeTo("slow", 0.5);
        }
        else {
            var title = document.createElement("span");
            jq(title).addClass("yw-draggable-ghost-title");
            title.innerHTML = sanitizeHtml(drag.node.textContent);
            // find parent collection browser
            var collectionBrowserContainer = jQuery("#" + drag.node.id).closest(".yw-com_hybris_cockpitng_collectionBrowser");
            if (collectionBrowserContainer) {
                findGhostMessageInCollectionBrowser(collectionBrowserContainer, title, drag);
            }
            var indicator = document.createElement("span");
            jq(indicator).addClass("yw-draggable-ghost-indicator");
            divGhost.appendChild(indicator);
            divGhost.appendChild(title);
            jq(divGhost).addClass("yw-draggable-ghost");
            document.body.appendChild(divGhost);
        }
        return divGhost;
    };

});

var extendedSplitLayout = (function () {

    var widget = {};

    widget.makeResizableAll = function () {
        $('[data-make-resizable="true"]').each(function () {
            var vesselId = $(this).attr('data-split-layout-id');
            if (vesselId) {
                makeResizable(vesselId, $(this).attr('data-chosen-layout'));
            }
        });
    };

    function makeResizable(uuid, layout) {
        if (layout === 'single') {
            return;
        }
        var vesselHolder = $('[data-split-layout-id="' + uuid + '"] > .yw-extendedsplitlayout-holder');
        var vesselChildren = vesselHolder.children();

        if (layout === 'triple') {
            vesselChildren = vesselChildren.not('.yw-extendedsplitlayout-box-third');
        } else if (layout === 'twixe' || layout === 'twixs') {
            vesselChildren = vesselChildren.filter('.yw-extendedsplitlayout-box-first');
        } else if (layout === 'mixleft') {
            vesselChildren = vesselChildren.filter('.yw-extendedsplitlayout-box-wrapper');
            vesselChildren = vesselChildren.add(vesselChildren.children().filter('.yw-extendedsplitlayout-box-first'));
        } else if (layout === 'mixright') {
            var vesselWrapperFilter = vesselChildren.filter('.yw-extendedsplitlayout-box-wrapper').children().filter('.yw-extendedsplitlayout-box-second');
            vesselChildren = vesselChildren.filter('.yw-extendedsplitlayout-box-first');
            vesselChildren = vesselChildren.add(vesselWrapperFilter);
        }

        vesselChildren.each(function () {
            var vessel = $(this);
            var resizeOptions = findResizeReverse(vessel, layout);
            vessel.resizable(resizeOptions);
        });
    }

    function findResizeReverse(elem, layout) {
        var direction = 'e';
        var resizableSibling = elem.siblings('.yw-extendedsplitlayout-box-second');

        if (layout === 'mixleft') {
            if (elem.hasClass('yw-extendedsplitlayout-box-first')) {
                direction = 's';
            } else if (elem.hasClass('yw-extendedsplitlayout-box-wrapper')) {
                resizableSibling = elem.siblings('.yw-extendedsplitlayout-box-third');
            }
        } else if (layout === 'mixright') {
            if (elem.hasClass('yw-extendedsplitlayout-box-first')) {
                resizableSibling = elem.siblings('.yw-extendedsplitlayout-box-wrapper');
            } else if (elem.hasClass('yw-extendedsplitlayout-box-second')) {
                direction = 's';
                resizableSibling = elem.siblings('.yw-extendedsplitlayout-box-third');
            }
        } else if (layout === 'twixs') {
            direction = 's';
        } else if (elem.hasClass('yw-extendedsplitlayout-box-second')) {
            resizableSibling = elem.siblings('.yw-extendedsplitlayout-box-third');
        }

        return {
            handles: direction,
            alsoResizeReverse: resizableSibling[0],
            minHeight: 100,
            minWidth: 100
        };
    }

    var observer = {};
    if (typeof MutationObserver === 'function') {
        (function (observer) {
            var mutationObserver = new MutationObserver(function (mutationRecords) {
                $.each(mutationRecords, function (index, mutationRecord) {
                    if (mutationRecord.type === 'childList') {
                        onVesselContentChanged();
                    }
                });
            });
            observer.start = function (context) {
                mutationObserver.observe(context, {
                    childList: true,
                    subtree: true
                });
            };
            observer.stop = function () {
                mutationObserver.disconnect();
            };
        })(observer);
    } else {
        observer.start = function (context) {
            setTimeout(function () {
                $(context).on('DOMSubtreeModified', onVesselContentChanged);
            }, 200);
        };
        observer.stop = function (context) {
            $(context).off('DOMSubtreeModified');
        };
    }
    observer.start($('[data-make-resizable]').context);

    var onVesselContentChangedTimeout;
    function onVesselContentChanged() {
		// avoid many invocation of _onVesselContentChanged. The method should be invoked once, 200ms after last event
        clearTimeout(onVesselContentChangedTimeout);
        onVesselContentChangedTimeout = setTimeout(function () {
			_onVesselContentChanged();
        }, 200);
    }

	function _onVesselContentChanged() {
        // find all split layouts. Such nodes contain data-make-resizable attribute
        var resizableElements = $('[data-make-resizable]');
        if (resizableElements.length > 0) {
            // stop observing changes in DOM. makeResizableAll changes DOM a little bit, therefore these changes shouldn't
            // be catch by our observer
            observer.stop(resizableElements.context);
            // add ui-resizable to split layout
            widget.makeResizableAll();
            // start observing again
            observer.start(resizableElements.context);
        }
    }

    return widget;
})();


$.ui.plugin.add("resizable", "alsoResizeReverse", {

    start: function (event, ui) {

        var self = $(this).data("ui-resizable"), o = self.options,

            _store = function (exp) {
                $(exp).each(function () {
                    if (o.handles === "e") {
                        $(this).data("ui-resizable-alsoresize-reverse", {
                            width: parseInt($(this).width(), 10),
                            left: parseInt($(this).css('left'), 10)
                        });
                    } else if (o.handles === "s") {
                        $(this).data("ui-resizable-alsoresize-reverse", {
                            height: parseInt($(this).height(), 10),
                            top: parseInt($(this).css('top'), 10)
                        });
                    } else {
                        $(this).data("ui-resizable-alsoresize-reverse", {
                            width: parseInt($(this).width(), 10),
                            height: parseInt($(this).height(), 10),
                            left: parseInt($(this).css('left'), 10),
                            top: parseInt($(this).css('top'), 10)
                        });
                    }
                });
            };

        if (typeof (o.alsoResizeReverse) === 'object' && !o.alsoResizeReverse.parentNode) {
            if (o.alsoResizeReverse.length) {
                o.alsoResize = o.alsoResizeReverse[0];
                _store(o.alsoResizeReverse);
            } else {
                $.each(o.alsoResizeReverse, function (exp, c) {
                    _store(exp);
                });
            }
        } else {
            _store(o.alsoResizeReverse);
        }
    },

    resize: function (event, ui) {
        var self = $(this).data("ui-resizable"), o = self.options, os = self.originalSize, op = self.originalPosition,
            delta = {
                height: (self.size.height - os.height) || 0,
                width: (self.size.width - os.width) || 0,
                top: (self.position.top - op.top) || 0,
                left: (self.position.left - op.left) || 0
            },

            _alsoResizeReverse = function (exp, c) {
                $(exp).each(function () {
                    var el = $(this),
                        start = $(this).data("ui-resizable-alsoresize-reverse"),
                        style = {},
                        css = c && c.length ? c : ['width', 'height', 'top', 'left'];

                    $.each(css || ['width', 'height', 'top', 'left'], function (i, prop) {
                        var sum = (start[prop] || 0) - (delta[prop] || 0), // subtracting instead of adding
                            corr = 0;

                        if (prop === 'width') {
                            // correct for some divs having broad right border
                            if (self.element.context.id === 'map') {
                                corr = 5;
                            } else {
                                corr = 10;
                            }
                        }

                        if (sum && sum >= 0) {
                            style[prop] = sum + corr || null;
                        }
                    });

                    el.css(style);
                });
            };

        if (typeof (o.alsoResizeReverse) === 'object' && !o.alsoResizeReverse.nodeType) {
            $.each(o.alsoResizeReverse, function (exp, c) {
                _alsoResizeReverse(exp, c);
            });
        } else {
            _alsoResizeReverse(o.alsoResizeReverse);
        }
    },

    stop: function (event, ui) {
        var self = $(this).data("ui-resizable");

        $(this).removeData("ui-resizable-alsoresize-reverse");
    }
});
