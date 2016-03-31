var craftyFox = {
    process: {},
    addProcess: function(nane, process) {
        craftyFox.process[nane] = process;
    }
};

var $ = craftyFox;

function craftyFoxRunProcess(nane, document) {
    craftyFox.process[nane](document);
}