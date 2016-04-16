package com.github.andriell.processor.js;

import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.entity.ContentType;
import org.json.JSONObject;

/**
 * Created by Rybalko on 14.04.2016.
 */
public class ProcessJsDataJson extends ProcessJsDataAbstract {
    private String craftName;
    private JSONObject json;

    public String getCraftName() {
        return craftName;
    }

    public void setCraftName(String craftName) {
        this.craftName = craftName;
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
