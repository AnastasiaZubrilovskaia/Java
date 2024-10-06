//import lombok.Buider;
//@Builder

public class Name {
    public  String surname;
    public String personalName;
    public String middleName;
    public  Name (String surname, String personalName, String middleName){
        this.middleName = middleName;
        this.surname = surname;
        this.personalName = personalName;

    }
    public static Name surnamePersonalName(String surname, String personalName){
        return new Name(surname,personalName, " ");
    }
    public static  Name personal(String personalName){
        return  new Name("", personalName, "");
    }
    public static  Name surnameName(String surname){
        return  new Name(surname, "", "");
    }
    public static  Name withMiddleName(String middleName){
        return  new Name("surname", "", middleName);
    }

    public String toString(){
        if (surname != null && middleName == null){
            return surname + " " + personalName;
        } else if (surname == null) {
            return personalName;
        }
        return surname + " " + personalName + " " + middleName;
    }
}
