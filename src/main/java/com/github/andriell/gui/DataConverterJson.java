package com.github.andriell.gui;

import org.json.JSONObject;

/**
 * Created by Rybalko on 19.04.2016.
 */
public class DataConverterJson implements DataConverter {
    public Object convert(String s) {
        return new JSONObject(s);
    }
}
