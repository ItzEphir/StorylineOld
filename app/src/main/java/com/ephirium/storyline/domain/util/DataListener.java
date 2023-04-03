package com.ephirium.storyline.domain.util;

public interface DataListener<T> {
    void onChange(T value);
}
