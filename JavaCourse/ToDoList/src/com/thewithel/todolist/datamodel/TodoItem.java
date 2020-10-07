package com.thewithel.todolist.datamodel;

import java.time.LocalDate;

public class TodoItem {

    private String shortDestription;
    private String details;
    private LocalDate deadline;

    public TodoItem(String shortDestription, String details, LocalDate deadline) {
        this.shortDestription = shortDestription;
        this.details = details;
        this.deadline = deadline;
    }

    public String getShortDestription() {
        return shortDestription;
    }

    public void setShortDestription(String shortDestription) {
        this.shortDestription = shortDestription;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return shortDestription;
    }
}
