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
    public JSONObject getDataJson() {
        return (JSONObject) getData();
    }

    public void setResponse(byte[] body, ContentType contentType, HttpRequest request, HttpResponse response) {
        setHttpParam(request, response, contentType);
        setData(new JSONObject(new String(body, contentType.getCharset())));
    }
}
