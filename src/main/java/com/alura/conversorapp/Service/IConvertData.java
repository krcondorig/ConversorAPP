package com.alura.conversorapp.Service;

public interface IConvertData {
    <T> T getData(String json, Class<T> clazz);
}
