package com.example.eclipse_store.Spring_Demo.model;

import java.util.ArrayList;

public class Root {
    ArrayList<String> jokes = new ArrayList<>();

    public ArrayList<String> getJokes() {
        return this.jokes;
    }

    public void setJokes(ArrayList<String> jokes) {
        this.jokes = jokes;
    }

}
