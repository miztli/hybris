com.hybris.visjs.NetworkChart= zk.$extends(zk.Widget, {

    ACTION_ADD_NODES_KEY : "ADD",
    ACTION_UPDATE_NODES_KEY : "UPDATE",
    ACTION_REMOVE_NODES_KEY : "REMOVE",

    NODE_TYPE : "node",
    EDGE_TYPE : "edge",

    VIS_EVENT_CLICK : "click",
    VIS_EVENT_DOUBLE_CLICK : "doubleClick",
    VIS_EVENT_SELECT_NODE : "selectNode",
    VIS_EVENT_DESELECT_NODE : "deselectNode",
    VIS_EVENT_SELECT_EDGE : "selectEdge",
    VIS_EVENT_DESELECT_EDGE : "deselectEdge",
    VIS_EVENT_HOVER_EDGE : "hoverEdge",
    VIS_EVENT_BLUR_EDGE : "blurEdge",
    VIS_EVENT_HOVER_NODE : "hoverNode",
    VIS_EVENT_BLUR_NODE : "blurNode",

    ON_NODE_CLICKED_EVENT : "onClickNode",
    ON_EDGE_CLICKED_EVENT : "onClickEdge",
    ON_NODE_DOUBLE_CLICKED_EVENT : "onDoubleClickNode",
    ON_EDGE_DOUBLE_CLICKED_EVENT : "onDoubleClickEdge",
    ON_NODE_SELECTED_EVENT : "onSelectNode",
    ON_NODES_DESELECTED_EVENT : "onDeselectNodes",
    ON_EDGE_SELECTED_EVENT : "onSelectEdge",
    ON_EDGES_DESELECTED_EVENT : "onDeselectEdges",
    ON_NODE_ADD_EVENT : "onAddNode",
    ON_NODE_EDIT_EVENT : "onEditNode",
    ON_NODES_REMOVE_EVENT : "onRemoveNodes",
    ON_EDGE_ADD_EVENT : "onAddEdge",
    ON_EDGE_EDIT_EVENT : "onEditEdge",
    ON_EDGES_REMOVE_EVENT : "onRemoveEdges",
    ON_EDGE_HOVER_EVENT : "onHoverEdge",
    ON_EDGE_BLUR_EVENT : "onBlurEdge",
    ON_NODE_HOVER_EVENT : "onHoverNode",
    ON_NODE_BLUR_EVENT : "onBlurNode",

    _nodes: new vis.DataSet([]),
    _edges: new vis.DataSet([]),
    _options: {},
    _networkchart : null,

    redraw : function(out)
    {
        out.push('<div ', this.domAttrs_(), '></div>');
    },

    setOptions : function(opt)
    {
        try
        {
            this._options = JSON.parse(opt);
            this.evaluateOptions(this._options);
            this.initializeManipulationFunctions(this._options);
        }
        catch(err)
        {
            window.console.error("Options are not valid JSON object", opt);
            this._options = {};
        }
    },

    evaluateOptions : function(options)
    {
        for(var option in options)
        {
            if(options.hasOwnProperty(option))
            {
                if(typeof options[option] === 'string')
                {
                    try
                    {
                        if(options[option].startsWith("function"))
                        {
                            options[option] = new Function("return " + options[option])();
                        }
                        else
                        {
                            options[option] = eval(options[option]);
                        }
                    }
                    catch(err)
                    {
                        // do nothing, it's expected exception
                    }
                }
                if(typeof options[option] === 'object')
                {
                    this.evaluateOptions(options[option]);
                }
            }
        }
    },

    initializeManipulationFunctions : function(options)
    {
        var self = this;
        if(options.manipulation)
        {
            if(options.manipulation.addNode)
            {
                options.manipulation.addNode = function(data, callback)
                {
                    self.fire(self.ON_NODE_ADD_EVENT, data);
                    callback();
                };
            }
            if(options.manipulation.addEdge)
            {
                options.manipulation.addEdge = function(data, callback)
                {
                    data.fromNode = self.findNodeById(data.from);
                    data.toNode = self.findNodeById(data.to);
                    self.fire(self.ON_EDGE_ADD_EVENT, data);
                    callback();
                };
            }
            if(options.manipulation.editNode)
            {
                options.manipulation.editNode = function(data, callback)
                {
                    self.fire(self.ON_NODE_EDIT_EVENT, data);
                    callback();
                };
            }
            if(options.manipulation.editEdge)
            {
                options.manipulation.editEdge = function(data, callback)
                {
                    var edgeUpdate = {};
                    edgeUpdate.previous = self.findEdgeById(data.id);
                    edgeUpdate.current = {};
                    edgeUpdate.current.to = data.to;
                    edgeUpdate.current.from = data.from;
                    edgeUpdate.current.toNode = self.findNodeById(data.to);
                    edgeUpdate.current.fromNode = self.findNodeById(data.from);
                    self.fire(self.ON_EDGE_EDIT_EVENT, edgeUpdate);
                    callback();
                };
            }
            if(options.manipulation.deleteNode)
            {
                options.manipulation.deleteNode = function(data, callback)
                {
                    var nodesToRemove = self.findNodesByIds(data.nodes);
                    self.fire(self.ON_NODES_REMOVE_EVENT, {nodes : nodesToRemove});
                    callback();
                };
            }
            if(options.manipulation.deleteEdge)
            {
                options.manipulation.deleteEdge = function(data, callback)
                {
                    var edgesToRemove = self.findEdgesByIds(data.edges);
                    self.fire(self.ON_EDGES_REMOVE_EVENT, {edges : edgesToRemove});
                    callback();
                };
            }
        }
    },

    setNetwork : function (network)
    {
        var parsedNetwork = JSON.parse(network);
        this.setInitNodes(parsedNetwork.nodes);
        this.setInitEdges(parsedNetwork.edges);
    },

    setRedrawNetwork : function(network)
    {
        this._nodes.clear();
        this._edges.clear();
        var parsedNetwork = JSON.parse(network);
        if(parsedNetwork.nodes)
        {
            this._nodes.update(parsedNetwork.nodes);
        }
        if(parsedNetwork.edges)
        {
            this._edges.update(parsedNetwork.edges);
        }
    },

    setInitNodes : function(initNodes)
    {
        this._nodes = new vis.DataSet([]);
        if(initNodes)
        {
            this._nodes.update(initNodes);
        }
    },

    setInitEdges : function(initEdges)
    {
        this._edges = new vis.DataSet([]);
        if(initEdges)
        {
            this._edges.update(initEdges);
        }
    },

    setNetworkUpdate : function(networkUpdates)
    {
        networkUpdates = JSON.parse(networkUpdates);

        if(networkUpdates && networkUpdates.updates)
        {
            for(var key in networkUpdates.updates)
            {
                var networkUpdate = networkUpdates.updates[key];
                if(networkUpdate && networkUpdate.entity)
                {
                    var action = networkUpdate.action;
                    if (networkUpdate.entity.type === this.NODE_TYPE)
                    {
                        this.updateEntity(this._nodes, action, networkUpdate.entity);
                    }
                    else if (networkUpdate.entity.type === this.EDGE_TYPE)
                    {
                        this.updateEntity(this._edges, action, networkUpdate.entity);
                    }
                }
            }
        }
    },

    updateEntity : function(dataSet, action, entity)
    {
        if(action === this.ACTION_ADD_NODES_KEY)
        {
            dataSet.add(entity);
        }
        else if(action === this.ACTION_UPDATE_NODES_KEY)
        {
            dataSet.update(entity);
        }
        else if(action === this.ACTION_REMOVE_NODES_KEY)
        {
            dataSet.remove(entity);
        }
    },

    bind_: function (evt)
    {
        this.$supers('bind_', arguments);
        var self = this;
        var container = this.$n();
        var data =
            {
                nodes: this._nodes,
                edges: this._edges
            };
        this._networkchart = new vis.Network(container, data, this._options);

        /*
         EVENTS
         */

        var _clickTimeout = null;

        this._networkchart.on(self.VIS_EVENT_CLICK, function (params)
        {
            var visContext = this;
            clearTimeout(self._clickTimeout);
            self._clickTimeout = setTimeout(function()
            {
                var foundNode = self.findNode(visContext, params);
                if(foundNode)
                {
                    self.fire(self.ON_NODE_CLICKED_EVENT, foundNode);
                }
                else
                {
                    var foundEdge = self.findEdge(visContext, params);
                    if(foundEdge)
                    {
                        self.fire(self.ON_EDGE_CLICKED_EVENT, foundEdge);
                    }
                }
            }, 250);
        });

        this._networkchart.on(self.VIS_EVENT_DOUBLE_CLICK, function (params)
        {
            clearTimeout(self._clickTimeout);
            var foundNode = self.findNode(this, params);
            if(foundNode)
            {
                self.fire(self.ON_NODE_DOUBLE_CLICKED_EVENT, foundNode);
            }
            else
            {
                var foundEdge = self.findEdge(this, params);
                if(foundEdge)
                {
                    self.fire(self.ON_EDGE_DOUBLE_CLICKED_EVENT, foundEdge);
                }
            }

        });

        this._networkchart.on(self.VIS_EVENT_SELECT_NODE, function (params)
        {
            var foundNode = self.findNode(this, params);
            if(foundNode)
            {
                self.fire(self.ON_NODE_SELECTED_EVENT, foundNode);
            }
        });

		this._networkchart.on(self.VIS_EVENT_HOVER_EDGE, function (params)
		{
			var foundEdge = self.findEdge(this, params);
			if(foundEdge)
			{
				self.fire(self.ON_EDGE_HOVER_EVENT, foundEdge);
			}
		});

		this._networkchart.on(self.VIS_EVENT_BLUR_EDGE, function (params)
		{
			var foundEdge = self.findEdge(this, params);
			if(foundEdge)
			{
				self.fire(self.ON_EDGE_BLUR_EVENT, foundEdge);
			}
		});

		this._networkchart.on(self.VIS_EVENT_HOVER_NODE, function (params)
		{
			var foundNode = self.findNode(this, params);
			if(foundNode)
			{
				self.fire(self.ON_NODE_HOVER_EVENT, foundNode);
			}
		});

		this._networkchart.on(self.VIS_EVENT_BLUR_NODE, function (params)
		{
			var foundNode = self.findNode(this, params);
			if(foundNode)
			{
				self.fire(self.ON_NODE_BLUR_EVENT, foundNode);
			}
		});

        var sendDeselectionEvents = function(previousSelection)
        {
            if(previousSelection && previousSelection.nodes)
            {
                var deselectedNodes = self.findNodesByIds(previousSelection.nodes);
                if(deselectedNodes.length > 0)
                {
                    self.fire(self.ON_NODES_DESELECTED_EVENT, {nodes : deselectedNodes});
                }
            }

            if(previousSelection && previousSelection.edges)
            {
                var deselectedEdges = self.findEdgesByIds(previousSelection.edges);
                if(deselectedEdges.length > 0)
                {
                    self.fire(self.ON_EDGES_DESELECTED_EVENT, {edges : deselectedEdges});
                }
            }
        };

        this._networkchart.on(self.VIS_EVENT_DESELECT_NODE, function (params)
        {
            sendDeselectionEvents(params.previousSelection);
        });

        this._networkchart.on(self.VIS_EVENT_DESELECT_EDGE, function (params)
        {
            sendDeselectionEvents(params.previousSelection);
        });

        this._networkchart.on(self.VIS_EVENT_SELECT_EDGE, function (params)
        {
            var foundEdge = self.findEdge(this, params);
            if(foundEdge)
            {
                self.fire(self.ON_EDGE_SELECTED_EVENT, foundEdge);
            }
        });

    },

    unbind_: function (evt)
    {
        this.$supers('unbind_', arguments);
        this._networkchart.destroy();
    },

    findNode : function(context, params)
    {
        var selectedNode = params.node;
        if (params.pointer && params.pointer.DOM) {
			selectedNode = context.getNodeAt(params.pointer.DOM);
		}
        return this.findNodeById(selectedNode);
    },

    findEdge : function(context, params)
    {
        var selectedEdge = params.edge;
        if (params.pointer && params.pointer.DOM) {
            selectedEdge = context.getEdgeAt(params.pointer.DOM);
		}
        return this.findEdgeById(selectedEdge);
    },

    findNodeById : function(nodeId)
    {
        for(var key in this._nodes._data)
        {
            if(key === nodeId)
            {
                return this._nodes._data[key];
            }
        }
    },

    findNodesByIds : function(ids)
    {
        var nodes = [];
        for(var key in ids)
        {
            var node = this.findNodeById(ids[key]);
            nodes.push(node);
        }
        return nodes;
    },

    findEdgeById :  function(edgeId)
    {
        for(var key in this._edges._data)
        {
            if(key === edgeId)
            {
                return this._edges._data[key];
            }
        }
    },

    findEdgesByIds : function(ids)
    {
        var edges = [];
        for(var key in ids)
        {
            var edge = this.findEdgeById(ids[key]);
            edges.push(edge);
        }
        return edges;
    }
});
