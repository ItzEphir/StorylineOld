package com.ephirium.storyline.feature.model;

public class Post {

    private final String fileSource;
    private final String name;
    private final String description;

    public Post(String name, String description, String fileSource){
        this.name = name;
        this.description = description;
        this.fileSource = fileSource;
    }

    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public String getFileSource(){
        return fileSource;
    }
}
