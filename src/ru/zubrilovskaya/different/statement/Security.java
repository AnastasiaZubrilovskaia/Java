package ru.zubrilovskaya.different.statement;

import java.util.List;

public class Security {
    List<Statement> list;

    public Security(List<Statement> list) {
        this.list = list;
    }

    public void check(Statement statement){
        if (list.contains(statement)) statement.mark = false;
        else {
            statement.signatures.add("Безопасность");
            new Personnel(true).check(statement);
        }
    }
}
