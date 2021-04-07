package com.example.notes;

public class Note {
    private String name;
    private String description;

    public static final Note[] notes = {
            new Note ("to get up early", "I need to go to my office"),
            new Note("to buy a new TV" , "old tv is very bad")
    };

    public Note(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }
    public String toString(){
        return this.name;
    }
}
