com.hybris.table.Table = zk.$extends(zk.Widget, {
	_frozen: false,
	_scrollLayer: false,
	_contentChange: false,
	_contentUpdateTime: false,
	_classDef: {
		cellCls: "y-tablecell",
        stickyCls: "y-tablecell-sticky",
        stickyHeaderCls: "y-tablecell-header-sticky",
        headerCls: "y-tableheader",
        rowCls: "y-tablerow",
        scrollActiveCls: "y-scroll-bar-active",
        scrollXCls : "y-scroll-x",
        scrollYCls : "y-scroll-y",
        leftScrollCls: "y-scroll-sticky-left",
        topScrollCls: "y-scroll-sticky-top",
        animScrollCls: "y-scroll-animate",
        animScrollHideShowCls: "y-scroll-animate-opacity",
        hideScrollCls: "y-scroll-hide-sticky",
        horizontalScrollCls: "y-scroll-horizontal",
        layerCls: "y-scroll-table-container",
        layerTablePart: "-tbllay"
	},

	_getTablePlainHTMLContents: function(id){
		if(!id){
			id = "#" + this.uuid;
		}
		if(id){
			return $(id).html().replace(/(<[^\s\/>]+\s)id=['"][^'"]+['"]\s/g, "$1");
		}
		return false;
	},

	_getLayerHTMLContents: function(id){
		if(!id){
			id = "#" + this.uuid;
		}
		if(id){
			if(id.indexOf("#")< 0){
				id = "#" + id;
			}
			$(id).data('scrollTableID', id.substring(1, id.length) + this._classDef.layerTablePart);
			return '<table class="'+ this.getZclass() + '" id="' + $(id).data('scrollTableID') + '">' + this._getTablePlainHTMLContents(id) + '</table>';
		}
		return false;
	},

	_isContentChanged: function(id){
		if(!id){
			id = "#" + this.uuid;
		}
		if($(id).data('scrollTableID')){
			var _scrollTableID = "#" + $(id).data('scrollTableID');
			if($(_scrollTableID).index() >= 0){
				var _originalCollapsed = $(id + ' .' + this._classDef.rowCls + "." + this._classDef.rowCls + "-collapsed"),
					_copyCollapsed = $(_scrollTableID + ' .' + this._classDef.rowCls + "." + this._classDef.rowCls + "-collapsed");
				if($(id + ' .' + this._classDef.rowCls).length !== $(_scrollTableID + ' .' + this._classDef.rowCls).length ||
					_originalCollapsed.length !== _copyCollapsed.length) {
					$(id).data('contentChanged', true);
				}else if(_originalCollapsed.length > 0 && _originalCollapsed.length == _copyCollapsed.length){
					_originalCollapsed.each(function(i, _elem){
						if($(_elem).index() != $(_copyCollapsed[i]).index()){
							$(id).data('contentChanged', true);
							return false;
						}
					});
				}
			}else{
				$(id).data('contentChanged', true);
			}
		}else{
			$(id).data('contentChanged', true);
		}
		return $(id).data('contentChanged');
	},

	setFrozen: function (frozen) {
		this._frozen = frozen;
		if (!frozen && this.desktop) {
			this.setupRowContents();
		}
		this.fire('onFrozen', {frozen: frozen});
	},

	requestStickyTableUpdate: function(){
		if(this._scrollLayer){
			var _req = new Date().getTime(),
				_me = this;
			_me._contentUpdateTime = _req;
			$('#' + _me.uuid).data('contentChanged', true);
			window.setTimeout(function(){
				if(_me._contentUpdateTime == _req && $('#' + _me.uuid).data('contentChanged') && $('#' + _me.uuid).next() && $('#' + _me.uuid).next().hasClass(_me._classDef.layerCls)){
					if($('#' + _me.uuid).hasClass(_me._classDef.scrollActiveCls)){
						return;
					}
					if($('#' + _me.uuid).data('scrollTableID')){
						$("#" + $('#' + _me.uuid).data('scrollTableID')).html(_me._getTablePlainHTMLContents());
					}else{
						$('#' + _me.uuid).next().html(_me._getLayerHTMLContents());
					}
					$('#' + _me.uuid).data('contentChanged', false);
				}
			}, 300);
		}
	},

	setupRowContents: function(){
		for (var w = this.firstChild; w; w = w.nextSibling){
			if(w.widgetName.indexOf("Row") < 0 && typeof(w.updateRowContents) != "function"){
				for(var x = w.firstChild; x; x = x.nextSibling)
					x.updateRowContents();
			}else{
				w.updateRowContents();
			}
		}
		if($('#' + this.parent.uuid).data('hscroll') > 0){
			var _h = this.getScrollStylingObject($('#' + this.parent.uuid).data('hscroll'), 0);
			$('#' + this.uuid + " ." + this._classDef.stickyCls + ":not([style])").css(_h);
			$('#' + this.uuid + " ." + this._classDef.stickyHeaderCls + ":not([style])").css(_h);
		}
		this.requestStickyTableUpdate();
		$('#' + this.uuid).data('contentChanged', true);
	},

	setupRows: function(){
		var _me = this;
		$('#' + _me.parent.uuid).data('vscroll', 0);
		$('#' + _me.parent.uuid).data('hscroll', 0);
		window.setTimeout(function(){ 
			$('#' + _me.parent.uuid).scrollLeft(0);
			$('#' + _me.parent.uuid).scrollTop(0);
			$('#' + _me.uuid).attr('class', _me.getZclass());
			_me.setupRowContents();
		}, 0);
	},

	isFrozen: function() {
		return this._frozen;
	},

	getZclass : function() {
		return this._zclass != null ? this._zclass : 'y-' + this.widgetName;
	},

    redraw : function(out) {
        out.push('<table ', this.domAttrs_() + '>');
		for (var w = this.firstChild; w; w = w.nextSibling)
			w.redraw(out);
        out.push('</table>');
        var _me = this;
        _me.setupRows();
    },

    getScrollStylingObject: function(h, v){
    	v = "translate(" + (h !== 0 ? (parseInt(h) + "px, ") : "0, ") + (v !== 0 ? (parseInt(v) + "px") : "0") + ")";
    	return {
			"-ms-transform": v,
			"-webkit-transform": v,
			"transform": v
		};
    },

	addScroll : function() {
    	var targetSelector = "#" + this.uuid,
    		containerSelector = "#" + this.parent.uuid,
			container = $(containerSelector),
			_me = this,
			_scrollWidthSpace = 15;
			_scrollTarget = $(targetSelector).hasClass(_me.getZclass()) ? $(targetSelector) : false,
			_scrolls = {
				scrollBarSize: false,
				addScrollClass: function(cID,tID){
					var _hsc = $(cID).data('hscroll'), 
						_vsc = $(cID).data('vscroll'),
						_dir = false;

					if($(cID).scrollLeft() != _hsc){
                        $(tID).addClass(_me._classDef.scrollXCls);
                        _dir = "horizontal";
                    }else{
	                    if($(cID).scrollTop() != _vsc){
	                        $(tID).addClass(_me._classDef.scrollYCls);
	                        _dir = "vertical";
	                    }
                	}
                	var pScroll = {vscroll: $(cID).scrollTop(), hscroll: $(cID).scrollLeft()};
					$(cID).data('dir', _dir);
					return pScroll;
				},
				updateScroll: function (sID,cID){
					if(!sID){
						sID = targetSelector;
					}
					if(!cID){
						cID = containerSelector;
					}
					var pScroll = {vscroll: $(cID).scrollTop(), hscroll: $(cID).scrollLeft()};
					$(cID).data('vscroll', pScroll.vscroll);
					$(cID).data('hscroll', pScroll.hscroll);
					
					var _h = _me.getScrollStylingObject(pScroll.hscroll, 0),
						_v = _me.getScrollStylingObject(0, pScroll.vscroll);
					$(sID + " ." + _me._classDef.stickyCls).css(_h);
					$(sID + " ." + _me._classDef.stickyHeaderCls).css(_h);
					$(sID + " ." + _me._classDef.headerCls).css(_v);
					return pScroll;
				},
				startScroll: function(cID,tID){
					var _cont = $(cID),
						_scrollLay = $(tID).next() && $(tID).next().hasClass(_me._classDef.layerCls) ? $(tID).next() : _me._scrollLayer;
					$(tID).attr('class', _me.getZclass());
					this.addScrollClass(cID, tID);
					if($(cID).data('dir') === false){
						return;
					}
                    if(!_scrollLay || _me._isContentChanged(tID)){
                    	_scrollLay = $(tID).next();
                    	_scrollLay.html(_me._getLayerHTMLContents(tID));
                    	$(tID).data('contentChanged', false);
                    }
                    var _scr = this.isScrollable(cID, tID);
                    var _h = _scr.horizontal ? (_cont.height() - this.getScrollBarWidth()) : _cont.height(),
                    	_w = _scr.vertical ? (_cont.width() - this.getScrollBarWidth()) : _cont.width(),
                    	_t = _cont.offset().top,
                    	_l = _cont.offset().left;
                    
                    _scrollLay.css({
                        'top': _t,
                        'left': _l,
                        'width': _w,
                        'height' : _h
                    });
                    var pScroll = this.updateScroll(cID, cID);
                    $(tID + _me._classDef.layerTablePart).css(
                    	_me.getScrollStylingObject((pScroll.hscroll * -1), (pScroll.vscroll * -1))
                    );
                    $(tID).addClass(_me._classDef.scrollActiveCls);
 
                    var _offsetContainer = $(cID).offset(),
                    	_offsetLayer = _scrollLay.offset();
                    if(_offsetLayer.top != _offsetContainer.top){
                    	_t = _t - (_scrollLay.offset().top - $(cID).offset().top);
                    	_scrollLay.css("top", _t);
                    }
                    if(_offsetLayer.left != _offsetContainer.left){
                    	_l = _l - (_scrollLay.offset().left - $(cID).offset().left);
                    	_scrollLay.css("left", _l);
                    }
				},
				endScroll: function(cID,tID){
                    this.updateScroll(cID, cID);
                    $(tID).removeClass(_me._classDef.scrollActiveCls);
                    $(tID).removeClass(_me._classDef.scrollYCls);
                    $(tID).removeClass(_me._classDef.scrollXCls);
                    $(cID).data('dir', false);
				},
				checkDirection: function(cID, tID){
					var pScroll = {vscroll: $(cID).scrollTop(), hscroll: $(cID).scrollLeft()},
						dir = $(cID).data('dir');
					if(dir === false && $(cID).hasClass(_me._classDef.scrollActiveCls)){
						this.startScroll(cID, tID);
						return;
					}
					if(dir == "horizontal"){
						if(pScroll.vscroll != $(cID).data('vscroll') && pScroll.hscroll == $(cID).data('hscroll')){
							this.startScroll(cID, tID);
							return;
						}
					}else{
						if(pScroll.hscroll != $(cID).data('hscroll') && pScroll.vscroll == $(cID).data('vscroll')){
							this.startScroll(cID, tID);
							return;
						}
					}
					$(cID).data('vscroll', pScroll.vscroll);
					$(cID).data('hscroll', pScroll.hscroll);
				},
				updateWheel: function (cID,tID){
					this.updateScroll(tID, cID);
				},
				init: function (){
					var cID = containerSelector,
						tID = targetSelector;
                    $(tID).attr('class', _me.getZclass());
                    container.children('.' + _me._classDef.layerCls).remove();
                    container.scrollLeft(0);
                    container.scrollTop(0);

                    $(cID).data('vscroll', 0);
					$(cID).data('hscroll', 0);
                    this.isScrollable(cID, tID);
                    _scrollWidthSpace = parseInt(this.getScrollBarWidth());
                    if(!$(tID).next().hasClass(_me._classDef.layerCls)){
                        $(tID).after('<div class="' + _me._classDef.layerCls + '"></div>');
                        _me._scrollLayer = $(tID).next();
                        _me.requestStickyTableUpdate();
                    }
                },
                isScrollable: function(cID,tID) {
                	if(!cID){
                		cID = container.attr("id");
                	}else{
                		if(cID.indexOf('#') == 0){
                			cID = cID.substring(1, cID.length);
                		}
                	}
                    var node = document.getElementById(cID),
                        overflowY = window.getComputedStyle(node)['overflow-y'],
                        overflowX = window.getComputedStyle(node)['overflow-x'],
                        scTarget = _scrollTarget;
                    if(tID && tID.indexOf('#') == 0){
                    	scTarget = $(tID);
                    }
                    if(scTarget){
                        if((overflowX === 'scroll' || overflowX === 'auto') && node.scrollWidth > (node.clientWidth - this.getScrollBarWidth())){
                            scTarget.addClass(this.horizontalScrollCls);
                        }else{
                            scTarget.removeClass(this.horizontalScrollCls);
                        }
                    }
                    return {
                        vertical: (overflowY === 'scroll' || overflowY === 'auto') && node.scrollHeight > node.clientHeight,
                        horizontal: (overflowX === 'scroll' || overflowX === 'auto') && node.scrollWidth > node.clientWidth
                    };
                },
                getScrollBarWidth: function(){
                    if(this.scrollBarSize === false){
                        var $outer = $('<div>').css({visibility: 'hidden', width: 100, overflow: 'scroll'}).appendTo('body'),
                            widthWithScroll = $('<div>').css({width: '100%'}).appendTo($outer).outerWidth();
                        $outer.remove();
                        this.scrollBarSize = 100 - widthWithScroll;
                    }
                    return this.scrollBarSize;
                }
			};

		_scrolls.init();

		var _wheelsTriggered = false,
			_containerMouseDown = false,
			_scrollEventTime = false,
            _scrollMouseEventTime = false,
            _scrollMousePressed = false,
            _scrollBarTimeout = 500,
            _scrollMouseDelta = 20,
            _scrollMouseTimeout = 50;

		container.on('mousewheel', function(event, delta) {
			var scrollTop = this.scrollTop,
				cID = "#" + this.id,
				tID = "#" + this.children[0].id;
			event.preventDefault();
			_scrolls.isScrollable(cID, tID);
			if(event.deltaY != 0){
				this.scrollTop = (scrollTop + ((event.deltaY * event.deltaFactor) * -1));
			}else{
				this.scrollLeft -= (delta * _scrollMouseDelta);
			}
			_wheelsTriggered = true;
			_scrolls.updateWheel(cID, tID);
			_scrollMouseEventTime = event.timeStamp;
			
			window.setTimeout(function(){
				_wheelsTriggered = false;
				if(_scrollMouseEventTime == event.timeStamp){
					_scrolls.endScroll(cID,tID);
				}
			}, _scrollMouseTimeout);
		});

		container.on("scroll", function(event, d){
			var cID = "#" + this.id,
				tID = "#" + this.children[0].id;
			if(!_wheelsTriggered && $(cID).children(tID).index() >= 0 ){
				_scrolls.isScrollable(cID, tID);				
				if(!_scrollEventTime && !$(cID).data('dir')){
                    _scrolls.startScroll(cID, tID);
                }else{
                	_scrolls.checkDirection(cID, tID);
                }
                _scrollEventTime = event.timeStamp;
                if(_containerMouseDown && !_scrollMousePressed){
                	_scrollMousePressed = {c: cID, t: tID};
                }
				window.setTimeout(function(){
					if(_scrollEventTime == event.timeStamp && !_scrollMousePressed){
                        _scrolls.endScroll(cID, tID);
                        _scrollEventTime = false;
                    }
				}, _scrollBarTimeout);
			}
		});

		container.mousedown(function(e){
			_containerMouseDown = true;
		});

		window.addEventListener('mouseup', function(){
			if(_containerMouseDown){
				if(_scrollMousePressed && typeof(_scrollMousePressed) == "object"){
					_scrolls.endScroll(_scrollMousePressed.c, _scrollMousePressed.t);
					_scrollMousePressed = false;
					_scrollEventTime = false;
				}
				_containerMouseDown = false;
			}
		}, false);
		window.addEventListener("resize", function(){ _scrolls.isScrollable() });
	},

	getScroll : function (){
		var _p = $("#" + this.uuid).parent(),
			_vscr = _p.scrollTop(),
			_hscr = _p.scrollLeft();
		return {left: _hscr, top: _vscr};
	},

	bind_: function (desktop, skipper, after) {
		this.$supers(com.hybris.table.Table, 'bind_', arguments);
		this.addScroll();
		this.setupRows();
	}
});
