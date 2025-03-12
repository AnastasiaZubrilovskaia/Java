package ru.zubrilovskaya.different.statement;

import java.util.ArrayList;
import java.util.List;

public class Statement {
    String author;
    String text;
    List<String> signatures = new ArrayList<>();
    boolean mark = false;

    public Statement(String author, String text) {
        this.author = author;
        this.text = text;
    }

    public String getAuthor() {
        return author;
    }

    public String getText() {
        return text;
    }

    public boolean isMark() {
        return mark;
    }

    public List<String> getSignatures() {
        return new ArrayList<>(signatures);
    }
}
