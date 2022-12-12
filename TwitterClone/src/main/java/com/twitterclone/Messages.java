package com.twitterclone;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "messages")
public class Messages {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String content;
    private int producerID;

    public Messages(int id, String content, int producerID) {
        super();
        this.id = id;
        this.content = content;
        this.producerID = producerID;
    }

    public Messages() {

    }

    public Messages(String content, Integer producerID) {
        this.content = content;
        this.producerID = producerID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getProducerID() {
        return producerID;
    }

    public void setProducerID(int producerID) {
        this.producerID = producerID;
    }
}
