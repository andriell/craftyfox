var console = app.getBean("js-console");
var processor = app.getBean("processor");

var craftyFox = {
    pages: {},
    addParser: function(nane, process) {
        craftyFox.pages[nane] = process;
    }
};
var $ = craftyFox;

function nashornRunProcess(nane, property) {
    craftyFox.pages[nane](property);
}
