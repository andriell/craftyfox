package com.github.andriell.processor.js;

import org.jsoup.Jsoup;

/**
 * Created by Rybalko on 19.04.2016.
 */
public class DataConverterHtml implements DataConverter {
    public Object convert(String s) {
        return Jsoup.parse(s);
    }
}
