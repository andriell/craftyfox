package com.github.andriell.processor.js;

import org.jsoup.Jsoup;
import org.jsoup.parser.Parser;

/**
 * Created by Rybalko on 19.04.2016.
 */
public class DataConverterXml implements DataConverter {
    public Object convert(String s) {
        return Jsoup.parse(s, "",  Parser.xmlParser());
    }
}
