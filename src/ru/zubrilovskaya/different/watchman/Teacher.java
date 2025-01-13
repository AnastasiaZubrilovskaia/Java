package ru.zubrilovskaya.different.watchman;

public class Teacher extends Person{
    String identificationCard;
    String post;

    public Teacher(String name, String identificationCard, String post) {
        super(name);
        this.identificationCard = identificationCard;
        this.post = post;
    }

    public String getIdentificationCard() {
        return identificationCard;
    }

    public String getPost() {
        return post;
    }
}
