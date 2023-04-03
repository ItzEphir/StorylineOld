package com.ephirium.storyline.feature.model;

public class Post {
    private final String name;
    private final String description;

    public Post(String name, String description){
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
}
