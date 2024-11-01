
public class Human {
    private int height;
    private Name name;
    final Human father;

    public Human(String nameSecond, int height) {
        this(new Name("", nameSecond, ""), height, null);
    }
    public Human(Name name, int height) {
        this(name, height, null);
    }
    public Human(String nameSecond, int height, Human father) {
        this(new Name("", nameSecond, ""), height, father);
        if (father != null){
            name.setSurname(father.name.getSurname());
            name.setMiddleName(father.name.personalName + "ович");
        }
    }
    public void setHeight(int height) {
        if (height <=0 || height > 500) throw new IllegalArgumentException("height must be > 0 and < 500");
        this.height = height;
    }
    public int getHeight(){
        return height;
    }
    public Human getFather(){
        return father;
    }

    public Human(Name name, int height, Human father) {
        setHeight(height);
        this.name = name;
        this.father = father;
        if (father != null){
            if (name.getSurname() == null || name.getSurname().isBlank()) name.setSurname(father.name.getSurname());
            if (name.getMiddleName() == null || name.getMiddleName().isBlank()) name.setMiddleName(father.name.personalName + "ович");
        }
    }
    public Name getName(){
        return name;
    }
    public String toString() {
         return name + ", " + height;
    }
}
