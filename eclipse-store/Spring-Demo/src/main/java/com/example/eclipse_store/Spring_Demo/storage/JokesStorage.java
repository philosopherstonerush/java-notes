package com.example.eclipse_store.Spring_Demo.storage;

import com.example.eclipse_store.Spring_Demo.model.Root;
import org.eclipse.store.integrations.spring.boot.types.concurrent.Read;
import org.eclipse.store.integrations.spring.boot.types.concurrent.Write;
import org.eclipse.store.storage.embedded.types.EmbeddedStorage;
import org.eclipse.store.storage.embedded.types.EmbeddedStorageManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JokesStorage {

    private final EmbeddedStorageManager storageManager;

    @Autowired
    public JokesStorage(EmbeddedStorageManager storageManager) {
        this.storageManager = storageManager;
    }

    public void setRoot(Root root) {
        this.storageManager.setRoot(root);
        this.storageManager.storeRoot();
    }

    @Read
    public String oneJoke(Integer id) {
        String joke;
        Root root = (Root) storageManager.root();
        if(id > root.getJokes().size()) {
            throw new RuntimeException("This cannot happen");
        }
        joke = root.getJokes().get(id);
        return joke;
    }

    @Read
    public List<String> allJokes() {
        Root root = (Root) storageManager.root();
        return new ArrayList<>(root.getJokes());
    }

    @Write
    public Integer addNewJokes(String joke) {
        Root root = (Root) storageManager.root();
        root.getJokes().add(joke);
        storageManager.store(root.getJokes());
        return root.getJokes().size();
    }

}
