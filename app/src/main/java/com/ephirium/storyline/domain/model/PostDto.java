package com.ephirium.storyline.domain.model;

import com.google.firebase.firestore.DocumentId;

import java.util.ArrayList;
import java.util.List;

public class PostDto {
    @DocumentId
    public String id;
    public String name;
    public String description;
    // public List<String> authors = new ArrayList<>();
    // public List<String> genres = new ArrayList<>();
}
