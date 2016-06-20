var console = app.getBean("js-console");
var processor = app.getBean("processor");
var httpContext = app.getBean("process-http-context");

var craftyFox = {
    app: app,
    pages: {},
    addParser: function(nane, process) {
        craftyFox.pages[nane] = process;
    },
    newJsDataHtml: function (pageName) {
        var data = app.getBean("process-js-data-html");
        data.setProcessBeanId("process-js");
        data.setPageName(pageName);
        return data;
    },
    newJsDataJson: function (pageName) {
        var data = app.getBean("process-js-data-json");
        data.setProcessBeanId("process-js");
        data.setPageName(pageName);
        return data;
    },
    newJsDataString: function (pageName) {
        var data = app.getBean("process-js-data-string");
        data.setProcessBeanId("process-js");
        data.setPageName(pageName);
        return data;
    },
    newJsDataBin: function (pageName) {
        var data = app.getBean("process-js-data-bin");
        data.setProcessBeanId("process-js");
        data.setPageName(pageName);
        return data;
    },
    newHttpData: function(method, url, param) {
        var data = app.getBean("process-http-data");
        data.setProcessBeanId("process-http");
        data.setMethod(method);
        data.setUrl(url);
        if (param) {
            data.setData(param);
        }
        return data;
    }
};
var $ = craftyFox;

function nashornRunProcess(nane, property) {
    craftyFox.pages[nane](property);
}
