var console = app.getBean("js-console");

var informer = {
    beep: function() {
        var informer = app.getBean("js-informer-beep");
        if (informer == null) {
            return false;
        }
        return informer.sendMessage(null);
    }
};

var craftyFox = {
    app: app,
    hashTime: app.getBean("hashDateDaoImpl"),
    processor: app.getBean("processor"),
    httpContext: app.getBean("process-http-context"),
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
    newJsDataXml: function (pageName) {
        var data = app.getBean("process-js-data-xml");
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
    },
    hashTimeSec: function (str, int) {
        return craftyFox.hashTime.checkSec(str, int);
    },
    hashTimeMin: function (str, int) {
        return craftyFox.hashTime.checkMinute(str, int);
    },
    hashTimeHour: function (str, int) {
        return craftyFox.hashTime.checkHour(str, int);
    },
    hashTimeDay: function (str, int) {
        return craftyFox.hashTime.checkDay(str, int);
    },
    hashTimeUpdate: function (str) {
        return craftyFox.hashTime.update(str);
    }
};
var $ = craftyFox;

function nashornRunProcess(nane, property) {
    craftyFox.pages[nane](property);
}
