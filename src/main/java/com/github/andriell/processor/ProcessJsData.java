package com.github.andriell.processor;


import org.jsoup.nodes.Document;

public class ProcessJsData {
    private String processName;
    private Document document;

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }
}
