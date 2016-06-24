package com.github.andriell.processor.js;

import com.github.andriell.processor.http.ProcessHttpDataListenerInterface;
import org.apache.http.HttpResponse;
import org.apache.http.entity.ContentType;
import org.jsoup.nodes.Document;

import java.nio.charset.Charset;

public class ProcessJsData extends ProcessJsDataAbstract implements ProcessHttpDataListenerInterface {
    public Document getDataHtml() {
        return (Document) getData();
    }

    public void setResponse(byte[] body, ContentType contentType, String request, HttpResponse response) {
        setHttpParam(request, response, contentType);
        DataConverter converter = getConverter();
        String s = null;
        Charset charset = null;
        if (contentType != null) {
            charset = contentType.getCharset();
        }
        if (charset == null) {
            s = new String(body);
        } else {
            s = new String(body, charset);
        }

        setData(converter.convert(s));
    }
}
