public class Person {
    public String name;
    public int height;
    public Person(String name, int height){
        this.name = name;
        this.height = height;
    }
    public String toString(){
        return name + ", рост: " + height;
    }
}
