package ru.zubrilovskaya.human;


public class TestHuman {

    public void checkMin(Human human){
        if (human.getHeight() <= 0) throw new ValidateException("Рост человека меньше 0");
    }

    private void check(Human human){
        if (human.getHeight() <= 0 || human.getHeight() >= 200){
            throw new ValidateException("Рост человека не в диапазоне от 1 до 200");
        }
    }

    public void checkName (Human human){
        if (human.getName() == null) {
            throw new ValidateException("Имя человеку не задано");
        }
    }
}
