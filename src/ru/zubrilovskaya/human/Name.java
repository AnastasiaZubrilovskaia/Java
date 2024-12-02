package ru.zubrilovskaya.human;
//import lombok.Builder;
//@Builder

public class Name {
    private   String surname;
    final  String personalName;
    private String middleName;
    public  Name (String surname, String personalName, String middleName){
        if (personalName ==  null || personalName.isBlank()) throw new IllegalArgumentException("Error");
        setSurname(surname);
        setMiddleName(middleName);
        this.personalName = personalName;
    }

    public void setSurname(String surname){
        if (surname ==  null || surname.isBlank()) throw new IllegalArgumentException("Error");
        this.surname = surname;
    }
    public void setMiddleName(String middleName){
        if  (middleName ==  null || middleName.isBlank())throw new IllegalArgumentException("Error");
        this.middleName = middleName;
    }

    public String getSurname(){
        return surname;
    }
    public String getMiddleName(){
        return middleName;
    }
    public static Name withSurnamePersonalName(String surname, String personalName){
        return new Name(surname,personalName, " ");
    }
    public static  Name withPersonal(String personalName){
        return  new Name("", personalName, "");
    }
    public static  Name WithSurname(String surname){
        return  new Name(surname, "", "");
    }
    public static  Name withMiddleName(String middleName){
        return  new Name("", "", middleName);
    }
    public static  Name withPersonalNameMiddleName(String personalName,String middleName){
        return  new Name("", personalName, middleName);
    }

    public String toString(){
        if (surname != null && personalName!= null && middleName == null){
            return surname + " " + personalName;
        } else if (surname == null && middleName == null) {
            return personalName;
        } else if (personalName == null && middleName == null) {
            return surname;
        } else if (surname == null && personalName == null) {
                return middleName;
        } else if (surname == null) {
            return personalName;
        }
        return surname + " " + personalName + " " + middleName;
    }
}
