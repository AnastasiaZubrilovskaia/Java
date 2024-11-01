public class Cuckoo extends Bird{
    public Cuckoo(String name){
        super(name);
    }
    public void toSing(){
        String res = "";
        int count = (int) (Math.random()*10)+1;
        for (int i = 0; i < count; i++){
            res = res  + " ку-ку ";
        }
        System.out.println(name + ": " + res);
    }
}
