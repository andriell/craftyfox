package com.github.andriell.processor.js;


import org.jsoup.nodes.Document;

public class ProcessJsData {
    private String craftName;
    private Document document;

    public String getCraftName() {
        return craftName;
    }

    public void setCraftName(String craftName) {
        this.craftName = craftName;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }
}
