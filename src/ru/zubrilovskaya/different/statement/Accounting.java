package ru.zubrilovskaya.different.statement;

public class Accounting {

    public void check(Statement statement){
        if (!statement.getSignatures().contains("отдел кадров")) {
            new Personnel(true).check(statement);
            return;
        }
        if (Character.isUpperCase(statement.getText().charAt(0))) {
            statement.signatures.add("бухгалтерия");
            statement.mark = true;
        } else statement.mark = false;
    }
}
