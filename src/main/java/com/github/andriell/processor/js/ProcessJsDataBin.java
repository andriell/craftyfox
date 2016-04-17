package com.github.andriell.processor.js;

import com.github.andriell.processor.http.ProcessHttpDataListenerInterface;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.entity.ContentType;

/**
 * Created by Rybalko on 14.04.2016.
 */
public class ProcessJsDataBin extends ProcessJsDataAbstract  implements ProcessHttpDataListenerInterface {
    public byte[] getBytes() {
        BinData binData = (BinData) getData();
        if (binData == null) {
            return null;
        }
        return binData.getBytes();
    }

    public void setBytes(byte[] bytes) {
        setData(new BinData(bytes));
    }

    public void setResponse(byte[] body, ContentType contentType, HttpRequest request, HttpResponse response) {
        setHttpParam(request, response, contentType);
        setBytes(body);
    }

    public class BinData {
        private byte[] bytes;

        public BinData(byte[] bytes) {
            this.bytes = bytes;
        }

        public byte[] getBytes() {
            return bytes;
        }
    }
}
