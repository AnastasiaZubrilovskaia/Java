package ru.zubrilovskaya.different.statement;

public class Personnel {
    boolean place;

    public Personnel(boolean place) {
        this.place = place;
    }
    public void check(Statement statement){
        if (place){
            statement.signatures.add("отдел кадров");
            new Accounting().check(statement);
        }
        else statement.mark = false;
    }
}
