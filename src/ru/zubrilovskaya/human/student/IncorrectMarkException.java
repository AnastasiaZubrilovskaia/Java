package ru.zubrilovskaya.human.student;

public class IncorrectMarkException extends IllegalArgumentException{
    private int mark;
    public IncorrectMarkException(int mark){
        super(String.format("Нельзя добавть оценку %d", mark));
        this.mark =mark;
    }
    public int getMark(){
        return mark;
    }
}


