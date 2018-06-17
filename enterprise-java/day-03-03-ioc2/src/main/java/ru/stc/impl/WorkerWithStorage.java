package ru.stc.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.stc.api.Storage;
import ru.stc.api.Worker;

@Component
public class WorkerWithStorage implements Worker {
    private final Storage storage;

    @Autowired
    public WorkerWithStorage(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void doSomeWork(int workKind) {
        int result = storage.getValue() * workKind;
        storage.saveValue(result);
    }
}
