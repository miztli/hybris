var conn_visible = false;
var cng_drawmode = 0;
var selected = null;

function createWidgetConnection(source,target,label,s_index,t_index,isTarget, component, isSourceStub, isTargetStub)
{
    var connectionColor="#186ccf";
    var connectionHoverColor="#ffd01e";

    var outputAnchors = [ [ 0.1, 0, 0, -1 ],[ 0.2, 0, 0, -1 ],[ 0.3, 0, 0, -1 ],[ 0.4, 0, 0, -1 ],[ 0.5, 0, 0, -1 ],
        [ 0.6, 0, 0, -1 ],[ 0.7, 0, 0, -1 ],[ 0.8, 0, 0, -1 ],[ 0.9, 0, 0, -1 ],
        [ 0.1, 1, 0, 1 ],[ 0.2, 1, 0, 1 ],[ 0.3, 1, 0, 1 ],[ 0.4, 1, 0, 1 ],[ 0.5, 1, 0, 1 ],
        [ 0.6, 1, 0, 1 ],[ 0.7, 1, 0, 1 ],[ 0.8, 1, 0, 1 ],[ 0.9, 1, 0, 1 ]];

    var inputAnchors = [[ 0, 0.1, -1, 0 ],[ 1, 0.1, 1, 0 ],[ 0, 0.2, -1, 0 ],[ 1, 0.2, 1, 0 ],[ 0, 0.3, -1, 0 ],[ 1, 0.3, 1, 0 ],
        [ 0, 0.4, -1, 0 ],[ 1, 0.4, 1, 0 ],[ 0, 0.5, -1, 0 ],[ 1, 0.5, 1, 0 ],[ 0, 0.6, -1, 0 ],[ 1, 0.6, 1, 0 ],
        [ 0, 0.7, -1, 0 ],[ 1, 0.7, 1, 0 ],[ 0, 0.8, -1, 0 ],[ 1, 0.8, 1, 0 ],[ 0, 0.9, -1, 0 ],[ 1, 0.9, 1, 0 ]];


    var stubAnchors = [[ 0.05, 1, 0, 1 ], [ 0.1, 1, 0, 1 ],[ 0.2, 1, 0, 1 ],[ 0.3, 1, 0, 1 ],[ 0.4, 1, 0, 1 ],[ 0.5, 1, 0, 1 ],
        [ 0.6, 1, 0, 1 ], [ 0.7, 1, 0, 1 ], [ 0.8, 1, 0, 1 ], [ 0.9, 1, 0, 1 ], [ 0.95, 1, 0, 1 ]];



    var stub = [20 + 4 * s_index, 26 + 3 * t_index];
    var cngConnectionLabelClass = "cngConnectionLabelEmpty";
    if(label!=null && label!="")
    {
        cngConnectionLabelClass="cngConnectionLabel";
    }

    var cngConnectionEndpointClass = "cngConnectionEndpoint";
    var cngConnectorClass = "cngConnection";
    if(isTarget)
    {
        cngConnectorClass+= " cngTarget";
        cngConnectionLabelClass+= " cngTarget";
        cngConnectionEndpointClass+= " cngTarget";
    }

    var connectors=[[ "Flowchart", { stub:stub, midpoint:0.6, cssClass:cngConnectorClass }],
        [ "Bezier", { curviness:150, cssClass:cngConnectorClass }],
        [ "StateMachine", { curviness:50, cssClass:cngConnectorClass }]];

    var connectorType=connectors[0];

    if(cng_drawmode && cng_drawmode < 3 && cng_drawmode >= 0)
        connectorType=connectors[cng_drawmode];

    var inputAnchor;
    var outputAnchor;

    if(isSourceStub && !isTargetStub){
        inputAnchor= inputAnchors[t_index];
        outputAnchor = stubAnchors[s_index+t_index];
    }else if(!isSourceStub && isTargetStub){
        inputAnchor = stubAnchors[s_index+t_index];
        outputAnchor = outputAnchors[s_index];
    }
    else{
        inputAnchor= inputAnchors[t_index];
        outputAnchor= outputAnchors[s_index];
    }
    var ommitConnection=false;
    if(document.getElementsByClassName('no_stubs').length>0){
        ommitConnection =isSourceStub? !isTargetStub: isTargetStub;
    }


    if(!ommitConnection){
        var connection = jsPlumb.connect({
            source:jsPlumb.addEndpoint(source,{anchor:outputAnchor,isSource:true,
                endpoint:[ "Rectangle", { cssClass:cngConnectionEndpointClass, width:12, height:12, maxConnections: 1000 } ]}),
            target:jsPlumb.addEndpoint(target,{anchor:inputAnchor,isTarget:true,
                endpoint:[ "Rectangle", { cssClass:cngConnectionEndpointClass, width:8, height:8, maxConnections: 1000 } ]}),
            connector:connectorType,
            hoverPaintStyle:{ strokeStyle:connectionHoverColor, lineWidth:5 },
            paintStyle:{ strokeStyle:connectionColor, lineWidth:3},
            overlays:[
                ["Arrow", { location: 1 }],
                ["Label", { label:label.replace(/&/g, "&amp;").replace(/</g, "&lt;").replace(/>/g, "&gt;"), location:0.5, cssClass:cngConnectionLabelClass }]
            ],
            endpoint:[ "Rectangle", { cssClass:"cngConnectionEndpoint", width:14, height:14 } ]
        });
        fixClickThroughSVGBug(connection.canvas);
    }
}


function fixClickThroughSVGBug(svg) {
    if ($('body').is('.ie9, [class*="safari5"]')) {
        svg.addEventListener("click", function(e) {
            var el = findFirstUnderlyingNonSvgElement(e.clientX, e.clientY, this);
            if (el && zk.Widget.$(el)) {
                zk.Widget.$(el).fire("onClick");
            }
            return false;
        }, false);
    }
}

function findFirstUnderlyingNonSvgElement(x, y, el) {
    $(el).hide();
    var bottomEl = document.elementFromPoint(x, y);
    if ($(bottomEl).is('svg')) {
        bottomEl = findFirstUnderlyingNonSvgElement(x, y, bottomEl);
    }
    $(el).show();
    return bottomEl;
}


function drawSelection(component)
{
    var selectionColor = "#085abc";
    var selectionConnector = ["Straight", {cssClass:"cngSelection"}];
    var borderWidth = 4;

    if(component)
    {
        jsPlumb.connect({
            source:jsPlumb.addEndpoint(component,{anchor:[0,0,0,0],endpoint:[ "Blank"]}),
            target:jsPlumb.addEndpoint(component,{anchor:[0,1,0,0],endpoint:[ "Blank"]}),
            connector:selectionConnector,
            paintStyle:{ strokeStyle:selectionColor, lineWidth:borderWidth }
        });
        jsPlumb.connect({
            source:jsPlumb.addEndpoint(component,{anchor:[0,1,0,0],endpoint:[ "Blank"]}),
            target:jsPlumb.addEndpoint(component,{anchor:[1,1,0,0],endpoint:[ "Blank"]}),
            connector:selectionConnector,
            paintStyle:{ strokeStyle:selectionColor, lineWidth:borderWidth }
        });
        jsPlumb.connect({
            source:jsPlumb.addEndpoint(component,{anchor:[1,1,0,0],endpoint:[ "Blank"]}),
            target:jsPlumb.addEndpoint(component,{anchor:[1,0,0,0],endpoint:[ "Blank"]}),
            connector:selectionConnector,
            paintStyle:{ strokeStyle:selectionColor, lineWidth:borderWidth }
        });
        jsPlumb.connect({
            source:jsPlumb.addEndpoint(component,{anchor:[1,0,0,0],endpoint:[ "Blank"]}),
            target:jsPlumb.addEndpoint(component,{anchor:[0,0,0,0],endpoint:[ "Blank"]}),
            connector:selectionConnector,
            paintStyle:{ strokeStyle:selectionColor, lineWidth:borderWidth }
        });
    }

}

function cngShowlabels(val)
{
    if(val)
        document.body.className+= " cng-connectionLabelsVisible";
    else
        document.body.className=document.body.className.replace(" cng-connectionLabelsVisible","");
}

function cngShowinputs(val)
{
    if(val)
        document.body.className+= " cng-targetConnectionsVisible";
    else
        document.body.className=document.body.className.replace(" cng-targetConnectionsVisible","");
}

function cngShowConnections(val)
{
    if(val)
    {
        if(document.body.className.search(" cng-connectionsVisible") < 0)
            document.body.className+= " cng-connectionsVisible";
    }
    else
        document.body.className=document.body.className.replace(" cng-connectionsVisible","");
}

function selectWidgetConnections(widgetID)
{
    if(conn_visible)
    {
        if(selected == widgetID && widgetID != null)
        {
            selected = null;
        }
        else
        {
            selected = widgetID;
        }
        drawConnections(selected);
        drawSelection(selected);
    }
}

function cngResetConnections()
{
    if(jsPlumb) {
        selected=null;
        cngShowConnections(false);
        jsPlumb.deleteEveryEndpoint();
        jsPlumb.detachEveryConnection();
    }
}

function showConnectionsChecked(event)
{
    cngResetConnections();

    conn_visible = event.data;
    jsPlumb.importDefaults({
        ConnectorZIndex:5
    });

    if(event.data && drawConnections)
    {
        drawConnections(null);
    }
}


function drawConnections(uid)
{
    cngShowConnections(true);
    drawConnectionsFunction(uid);
}

function drawConnectionsRequest()
{
    cngResetConnections();

    conn_visible = true;
    jsPlumb.importDefaults({
        ConnectorZIndex:5
    });

    drawConnections(null);
}
