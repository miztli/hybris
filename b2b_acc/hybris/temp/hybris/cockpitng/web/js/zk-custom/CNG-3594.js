/**
invert ctrlKey for up/down in tree, flip select/focus behavior
https://potix.freshdesk.com/support/tickets/5613
**/
zk.afterLoad('zul.sel', function() {
    var xTree = {};
    zk.override(zul.sel.Tree.prototype, xTree, {
        _doKeyDown : function(evt) {
            if(evt.keyCode === 38 || evt.keyCode === 40) {
                evt.ctrlKey = !evt.ctrlKey;
                evt.data.ctrlKey = !evt.data.ctrlKey;
            }
            return xTree._doKeyDown.apply(this, arguments);
        }
    });//zk.override
});//zk.afterLoad