function getXPixel(val, data, xPadding, graph) {
    return ((graph.width - (xPadding * 2)) / (data.values.length - 1)) * val + (xPadding);
}

function getYPixel(val, data, yPadding, graph, maxY) {
    return graph.height - (((graph.height - yPadding * 2) / maxY) * val) - yPadding;
}

function drawGraph(data, canvasID, maxYVal) {
    var xPadding = 60;
    var yPadding = 30;
    var maxY = 100;
    if (maxYVal) {
        maxY = maxYVal;
    }

    var graph = document.getElementById(canvasID);
    var c = graph.getContext('2d');
    c.clearRect(0, 0, graph.width, graph.height);
    c.lineWidth = 1;
    c.strokeStyle = '#333';
    c.font = 'italic 8pt sans-serif';
    c.textAlign = "center";

    // Draw the axises
    c.beginPath();
    c.moveTo(xPadding, yPadding);
    c.lineTo(xPadding, graph.height - yPadding);
    c.lineTo(graph.width - xPadding, graph.height - yPadding);
    c.stroke();

    // Draw the Y value texts
    c.textAlign = "right";
    c.textBaseline = "middle";

    for (var i = 0; i < maxY; i += maxY / 10) {
        c.fillText(Math.round(i), xPadding - 5, getYPixel(i, data, yPadding, graph, maxY));
    }


    // Draw the line graph
    c.lineWidth = 2;
    c.strokeStyle = '#182F65';
    c.beginPath();
    c.moveTo(getXPixel(0, data, xPadding, graph), getYPixel(data.values[0].Y, data, yPadding, graph, maxY));
    for (var i = 1; i < data.values.length; i++) {
        c.lineTo(getXPixel(i, data, xPadding, graph), getYPixel(data.values[i].Y, data, yPadding, graph, maxY));
    }
    c.stroke();
}
