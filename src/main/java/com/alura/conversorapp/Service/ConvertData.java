package com.alura.conversorapp.Service;

import com.google.gson.Gson;

public class ConvertData implements IConvertData {
    Gson gson = new Gson();

    @Override
    public <T> T getData(String json, Class<T> clazz) {
        try {
            return gson.fromJson(json, clazz);
        } catch (Exception e) {
            return null;
        }
    }
}
