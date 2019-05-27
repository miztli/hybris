/* #4177 highlight matching drop targets on drag start. Opens closed tree node when dragged object is over a node. */
zk.afterLoad('zk', function() {
    var DROP_TARGET_MARKER = 'data-drop-target';
    var DROP_KEYS = 'data-drop-keys';
    var DRAG_KEY = 'data-drag-key';
    var MATCHING_DROP_TARGET_CLASS = 'z-drag-matching-drop-target';
    var NOT_MATCHING_DROP_TARGET_CLASS = 'z-drag-not-matching-drop-target';

    var xWidget = {};
    zk.override(zk.Widget.prototype, xWidget, {
        bind_: function() {
            xWidget.bind_.apply(this, arguments);
            if(this._droppable || this._draggable) {
                this._synchDropTargetDataAttribute(); //intially mark any drop and drag target only if necessary
            }
        },

        setDroppable: function(droppable) {
            xWidget.setDroppable.apply(this, arguments);
            this._synchDropTargetDataAttribute(); //update drop target on dynamic changes
        },

        setDraggable: function(draggable) {
            xWidget.setDraggable.apply(this, arguments);
            this._synchDropTargetDataAttribute(); //update drop target on dynamic changes
        },

        _synchDropTargetDataAttribute: function () {
            jq(this).attr(DROP_TARGET_MARKER, this._droppable ? true : null);
            jq(this).attr(DROP_KEYS, this._droppable ? this._droppable : null);
            jq(this).attr(DRAG_KEY, this._draggable ? this._draggable : null);
        }
    });//zk.override

    var highlightDroppableAreas = function(handle)
    {
        var draggedKey = handle.getAttribute(DRAG_KEY);

        var foundElements = jq('[' + DROP_TARGET_MARKER + ']');
        for(var i in foundElements)
        {
            if(foundElements[i] && foundElements[i].getAttribute)
            {
                var droppedKey = foundElements[i].getAttribute(DROP_KEYS).split(",");
                var isTheSameNode = handle === foundElements[i];
                if(!isTheSameNode && droppedKey.indexOf(draggedKey) !== -1)
                {
                    jq(foundElements[i]).addClass(MATCHING_DROP_TARGET_CLASS, true);
                }
                else
                {
                    jq(foundElements[i]).addClass(NOT_MATCHING_DROP_TARGET_CLASS, true);
                }
            }
        }
    };
    //store the current target to verify if the user moved the cursor to a different row
    var currentDnDTarget;
    //Used to cancel timer if user moves to a different row
    var currentDnDTimeout;

    function handleDnDTreeitemTimeout(target){
    };
    function updateGhost(event)
    {
        var target = event.target;
        var foundDroppableTarget = false;
        while(target && target.parent){
            if(jQuery(target).hasClass(MATCHING_DROP_TARGET_CLASS) && jQuery(target).hasClass("z-drag-over")) {
                foundDroppableTarget = true;
                break;
            }
            target=target.parent;
        }
        
        var draggableGhost = jQuery(".yw-draggable-ghost");
        if(foundDroppableTarget) {
            draggableGhost.removeClass("yw-draggable-ghost-not-droppable-target");
            draggableGhost.addClass("yw-draggable-ghost-droppable-target");
        }
        else {

            draggableGhost.removeClass("yw-draggable-ghost-droppable-target");
            draggableGhost.addClass("yw-draggable-ghost-not-droppable-target");
        }
    }

    var xDraggable = {};
    zk.override(zk.Draggable.prototype, xDraggable, {
        dragInProgress : false,
        _updateDrag : function(pt,evt) {
            // eq : this.super();
            var result = xDraggable._updateDrag.apply(this, arguments);
            if(zk.ff) {
                target = zk.$(document.elementFromPoint(evt.domEvent.clientX, evt.domEvent.clientY));
                evt.target = target;
            } else
            {
                target = evt.target;
            }
            //target may be a child of listitem
            updateGhost(evt);
            //loop on ancestor untill finding no more widgets or the current treeitem.
            // ! find the 1st treeitem anscestor, assume that the 1st anscestor is the one to open.
            // target.parent should always be != null for treeitem attached to page
            while(target && target.parent){
                if(target.className === "zul.sel.Treeitem"){
                    if(currentDnDTarget !== target){
                        //avoid multiple timeout running in paralel
                        clearTimeout(currentDnDTimeout);
                        currentDnDTarget = target;
                        //setOpen will trigger load if child of target not yet rendered
                        var handle = this.handle;
                        var dragInProgress = this.dragInProgress;
                        currentDnDTimeout = setTimeout(function(){
                            if(target !== currentDnDTarget){return;}
                            if(!target.isOpen())
                            {
                                target.setOpen(true);
                                if(target.nChildren > 1)
                                {
                                    setTimeout(function() {if(dragInProgress) {highlightDroppableAreas(handle);}}, 500);
                                }
                            }
                        },1000);
                    }
                    break;
                }else{
                    target=target.parent;
                }
            }
            return result;
        },
        _startDrag : function(evt) {
            this.dragInProgress = true;
            xDraggable._startDrag.apply(this, arguments);  //call original method
            highlightDroppableAreas(this.handle);
        },
        _finishDrag : function() {
            this.dragInProgress = false;
            xDraggable._finishDrag.apply(this, arguments); //call original method
            jq('.' + MATCHING_DROP_TARGET_CLASS).removeClass(MATCHING_DROP_TARGET_CLASS);
            jq('.' + NOT_MATCHING_DROP_TARGET_CLASS).removeClass(NOT_MATCHING_DROP_TARGET_CLASS);
        }
    });//zk.override
});//zk.afterLoad


zk.afterLoad('zk', function() {
    var $getDropTarget = zk.DnD.getDropTarget;
    zk.DnD.getDropTarget = function(evt) {
        if(zk.ff) {
            var targetNode = document.elementFromPoint(evt.domEvent.clientX, evt.domEvent.clientY);
            return zk.$(targetNode);
        } else {
            return $getDropTarget.apply(this, arguments);
        }
    };
});
