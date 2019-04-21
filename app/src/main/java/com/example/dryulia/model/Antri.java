package com.example.dryulia.model;

public class Antri {
    int id;
    String quee_text;
    String queue_date;
    String status;

    public Antri(int id, String quee_text, String queue_date, String status) {
        this.id = id;
        this.quee_text = quee_text;
        this.queue_date = queue_date;
        this.status = status;
    }

    public Antri(String quee_text, String queue_date, String status) {
        this.quee_text = quee_text;
        this.queue_date = queue_date;
        this.status = status;
    }

    public Antri() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuee_text() {
        return quee_text;
    }

    public void setQuee_text(String quee_text) {
        this.quee_text = quee_text;
    }

    public String getQueue_date() {
        return queue_date;
    }

    public void setQueue_date(String queue_date) {
        this.queue_date = queue_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
