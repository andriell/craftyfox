var craftyFox = {
    pageParsers: {},
    addParser: function(nane, process) {
        craftyFox.pageParsers[nane] = process;
    }
};
var $ = craftyFox;

function nashornRunProcess(nane, property) {
    craftyFox.pageParsers[nane](property);
}

var console = app.getBean("js-console");
var processor = app.getBean("js-processor");