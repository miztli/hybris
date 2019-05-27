function (out) {
    out.push('<div ', this.domAttrs_(), '>');

    var tabpanels = this.getTabpanels();
    var uuid = this.uuid;
    if(this.lastChild.staticSection) {                                               //custom
        out.push('<div id="', uuid , '-content-wrapper" class="', this.$s('content-wrapper'), '">');//custom
        out.push('<div id="', uuid , '-content" class="', this.$s('content'), '">'); //custom
        if (tabpanels) {                                                             //custom
            tabpanels.redraw(out);                                                   //custom
        }                                                                            //custom
        if(this.lastChild.staticSection) {                                           //custom
            this.lastChild.redraw(out);                                              //custom
        }                                                                            //custom
        out.push("</div>");                                                          //custom
        out.push("</div>");                                                          //custom
    } else {                                                                         //custom
        if (tabpanels) {                                                             //custom
            tabpanels.redraw(out);                                                   //custom
        }                                                                            //custom
    }                                                                                //custom
    out.push("</div>");
};