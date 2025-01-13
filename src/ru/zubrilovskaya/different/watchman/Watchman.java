package ru.zubrilovskaya.different.watchman;

//паттерн "Посетитель" (Visitor)

public class Watchman {
    public boolean checkUser(Person person){
        return false;
    }
    public boolean checkUser(Pupil pupil) {
        return !pupil.name.isEmpty() && !pupil.studentCard.isEmpty();
    }
    public boolean checkUser(Teacher teacher) {
        return !teacher.name.isEmpty() && (!teacher.identificationCard.isEmpty() || !teacher.post.isEmpty());
    }
}
