package ru.zubrilovskaya.different.watchman;

public class Pupil extends Person{
    String studentCard;

    public Pupil(String name, String studentCard) {
        super(name);
        this.studentCard = studentCard;
    }

    public String getStudentCard() {
        return studentCard;
    }
}
