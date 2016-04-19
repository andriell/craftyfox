package com.github.andriell.processor.js;

import com.github.andriell.processor.http.ProcessHttpDataListenerInterface;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.entity.ContentType;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class ProcessJsData extends ProcessJsDataAbstract implements ProcessHttpDataListenerInterface {
    public Document getDataHtml() {
        return (Document) getData();
    }

    public void setResponse(byte[] body, ContentType contentType, HttpRequest request, HttpResponse response) {
        setHttpParam(request, response, contentType);
        DataConverter converter = getConverter();
        setData(converter.convert(new String(body, contentType.getCharset())));
    }
}
