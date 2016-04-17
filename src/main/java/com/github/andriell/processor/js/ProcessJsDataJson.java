package com.github.andriell.processor.js;

import com.github.andriell.processor.http.ProcessHttpDataListenerInterface;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.entity.ContentType;
import org.json.JSONObject;

/**
 * Created by Rybalko on 14.04.2016.
 */
public class ProcessJsDataJson extends ProcessJsDataAbstract  implements ProcessHttpDataListenerInterface {
    private JSONObject dataJson;

    public JSONObject getDataJson() {
        return dataJson;
    }

    public void setDataJson(JSONObject dataJson) {
        this.dataJson = dataJson;
    }

    public void setResponse(byte[] body, ContentType contentType, HttpRequest request, HttpResponse response) {
        setHttpParam(request, response, contentType);
        setDataJson(new JSONObject(new String(body, contentType.getCharset())));
    }
}
