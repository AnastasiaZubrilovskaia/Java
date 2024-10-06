public class NameConstructor {
    String surname, name, middleName;
    public NameConstructor setName (String name){
        this.name = name;
        return this;
    }
    public NameConstructor setPatronymic  (String middleName){
        this.middleName = middleName;
        return this;
    }
    public NameConstructor setSurname  (String surname){
        this.surname = surname;
        return this;
    }
    public Name create(){
        return new Name (surname, name, middleName);
    }
}
