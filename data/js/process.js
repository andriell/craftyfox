var craftyFox = {
    process: {},
    addProcess: function(nane, process) {
        craftyFox.process[nane] = process;
    }
};

function craftyFoxRunProcess(nane, document) {
    craftyFox.process[nane](document);
}