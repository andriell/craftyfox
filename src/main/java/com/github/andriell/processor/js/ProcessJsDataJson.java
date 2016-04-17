package com.github.andriell.processor.js;

import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.entity.ContentType;
import org.json.JSONObject;

/**
 * Created by Rybalko on 14.04.2016.
 */
public class ProcessJsDataJson extends ProcessJsDataAbstract {
    private String pageName;
    private JSONObject json;

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public JSONObject getJson() {
        return json;
    }

    public void setJson(JSONObject json) {
        this.json = json;
    }

    public void setResponse(byte[] body, ContentType contentType, HttpRequest request, HttpResponse response) {
        setJson(new JSONObject(new String(body, contentType.getCharset())));
    }
}
