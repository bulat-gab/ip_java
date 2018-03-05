package ru.stc.impl;

import ru.stc.api.Storage;

import java.beans.ConstructorProperties;

//@Component
public class MockStorage implements Storage {
    private final int value;

    @ConstructorProperties("value")
    public MockStorage(int value) {
        this.value = value;
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public void saveValue(int value) {
        System.out.printf("Value %d saved...", value);
    }
}
