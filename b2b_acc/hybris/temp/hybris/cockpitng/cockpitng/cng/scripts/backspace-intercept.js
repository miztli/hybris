$(document).ready(function(){
    $(document).keydown(function(e){
        var valid = $(document.activeElement).is("input:focus, textarea:focus");
        if(e.keyCode === 8 && !valid)
        { return false; }
    });
});
