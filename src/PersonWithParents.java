public class PersonWithParents {
    PersonWithName son;
    PersonWithName father;
    public PersonWithParents (PersonWithName son, PersonWithName father){
        this.son = son;
        this.father = father;
    }
    public String toString(){
        if (son.name.surname == null && son.name.middleName != null && father.name.surname != null){
            return father.name.surname + " " + son.name;
        }
        else if (son.name.middleName == null && son.name.surname == null && father.name.personalName != null){
            return father.name.surname + " " + son.name + " " + father.name.personalName + "ович";
        }
        else if (son.name.middleName == null && father.name.personalName != null){
            return son.name + " " + father.name.personalName + "ович";
        }
        return son.name + "";
    }
}
