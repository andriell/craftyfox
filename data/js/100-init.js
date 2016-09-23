var console = app.getBean("js-console");

var craftyFox = {
    app: app,
    hashTime: app.getBean("hashDateDaoImpl"),
    processor: app.getBean("processor"),

    pages: {},
    addParser: function (nane, process) {
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
    newHttpData: function (method, url, param) {
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
    },

    http: {
        request: app.getBean("js-http-request"),
        client: app.getBean("js-http-client"),

        get: function (url) {
            return craftyFox.http.request.get(url);
        },
        haed: function (url) {
            return craftyFox.http.request.haed(url);
        },
        options: function () {
            return craftyFox.http.request.options(url);
        },
        patch: function (url) {
            return craftyFox.http.request.patch(url);
        },
        post: function (url) {
            return craftyFox.http.request.post(url);
        },
        put: function (url) {
            return craftyFox.http.request.put(url);
        },
        execute: function (request) {
            return craftyFox.http.client.execute(request);
        },
        addCookie: function (name, value, domain, path) {
            craftyFox.http.client.addCookie(name, value, domain, path);
        }
    },

    informer: {
        beep: function () {
            var informer = app.getBean("js-informer-beep");
            if (informer == null) {
                return false;
            }
            return informer.sendMessage();
        },
        skype: function (usernames, message) {
            var informer = app.getBean("js-informer-skype");
            if (informer == null) {
                return false;
            }
            var r = true;
            for (var i = 0, len = usernames.length; i < len; i++) {
                r = r && informer.sendMessage(usernames[i], message);
            }
            return r;
        }
    }
};
var $ = craftyFox;

function nashornRunProcess(nane, property) {
    craftyFox.pages[nane](property);
}
