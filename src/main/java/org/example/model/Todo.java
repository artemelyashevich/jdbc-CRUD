package org.example.model;

public class Todo {
    private String text;
    private int id;
    private int person_id;

    public Todo(String text, int person_id, int id) {
        this.text = text;
        this.person_id = person_id;
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public int getId() {
        return id;
    }

    public int getPerson_id() {
        return person_id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "text='" + text + '\'' +
                ", id=" + id +
                ", person_id=" + person_id +
                '}';
    }
}
