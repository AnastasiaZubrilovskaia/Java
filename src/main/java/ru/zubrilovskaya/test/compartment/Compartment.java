package ru.zubrilovskaya.test.compartment;

import java.util.ArrayList;
import java.util.List;
/**
 * Написать класс который отображает 1 купе в купе 4 места верхнее и нижнее
 * у них есть номера
 * мы будем продавать билеты (регистрировать людей) у любого человека есть имя и пол
 * гарантируйте мне что все люди в купе будут одного пола
 * 1 купивший билет определяет какой пол будет в купе
 **/
public class Compartment {
    String gender;
    List<Person> people = new ArrayList<>();
    List<Integer> places = new ArrayList<>();

    public String getGender() {
        return gender;
    }

    public List<Person> getPeople() {
        return new ArrayList<>(people);
    }

    public void payPlace(Person person, Integer place) {
        if(people.isEmpty()) {
            this.gender = person.gender;
            setPlaces(place);
            people.add(person);
        }
        else if(person.gender == gender){
            setPlaces(place);
            people.add(person);
        }
        else throw new IllegalArgumentException("Пол должен быть: " + gender);
    }

    public List<Integer> getPlaces() {
        return new ArrayList<>(places);
    }

    void setPlaces(Integer place) {
        if(places.size() == 4) throw new IllegalArgumentException("Места все проданы");
        if (places.contains(place)) throw new IllegalArgumentException("Место продано");
        if(place > 4 || place <= 0) throw new IllegalArgumentException("Таких мест нет");
        places.add(place);
    }
}
