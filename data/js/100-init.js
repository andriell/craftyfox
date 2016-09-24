var console = app.getBean("js-console");

var craftyFox = {
    app: app,

    hashTime: {
        hashTime: app.getBean("hashDateDaoImpl"),

        sec: function (str, int) {
            return craftyFox.hashTime.hashTime.checkSec(str, int);
        },
        min: function (str, int) {
            return craftyFox.hashTime.hashTime.checkMinute(str, int);
        },
        hour: function (str, int) {
            return craftyFox.hashTime.hashTime.checkHour(str, int);
        },
        day: function (str, int) {
            return craftyFox.hashTime.hashTime.checkDay(str, int);
        },
        update: function (str) {
            return craftyFox.hashTime.hashTime.update(str);
        }
    },

    process: {
        processor: app.getBean("processor"),
        listeners: {},

        listener: function (nane, process) {
            craftyFox.process.listeners[nane] = process;
        },
        trigger: function (pageName, data) {
            var processJsData = app.getBean("process-js-data");
            processJsData.setPageName(pageName);
            processJsData.setData(data);
            return craftyFox.process.processor.add(processJsData);
        }
    },

    http: {
        request: app.getBean("js-http-request"),
        client: app.getBean("js-http-client"),

        get: function(url) {
            return craftyFox.http.execute(craftyFox.http.newGetRequest(url));
        },
        head: function(url) {
            return craftyFox.http.execute(craftyFox.http.newHeadRequest(url));
        },
        options: function(url) {
            return craftyFox.http.execute(craftyFox.http.newOptionsRequest(url));
        },
        patch: function(url) {
            return craftyFox.http.execute(craftyFox.http.newPatchRequest(url));
        },
        post: function(url) {
            return craftyFox.http.execute(craftyFox.http.newPostRequest(url));
        },
        put: function(url) {
            return craftyFox.http.execute(craftyFox.http.newPutRequest(url));
        },

        newGetRequest: function (url) {
            return craftyFox.http.request.get(url);
        },
        newHeadRequest: function (url) {
            return craftyFox.http.request.head(url);
        },
        newOptionsRequest: function () {
            return craftyFox.http.request.options(url);
        },
        newPatchRequest: function (url) {
            return craftyFox.http.request.patch(url);
        },
        newPostRequest: function (url) {
            return craftyFox.http.request.post(url);
        },
        newPutRequest: function (url) {
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
    craftyFox.process.listeners[nane](property);
}
