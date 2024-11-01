import java.util.ArrayList;
import java.util.List;

public class Main32 {
    public static void main (String[] args){
        Town city1 = new Town("Saratov");
        Town city2 = new Town("Moscow");
        Town city3 = new Town("Piter");
        city1.addWay(city2, 345);
        city1.addWay(city3,800);
        System.out.println(city1);
        System.out.println(city2);
        System.out.println(city3);
        Pistol gun1 = new Pistol(10, 2);
        gun1.reload(9);
        gun1.shoot();
        gun1.shoot();
        gun1.shoot();
        gun1.shoot();
        gun1.shoot();
        Pistol gun2 = new Pistol(10, 2);
        gun2.reload(9);
        System.out.println("2");
        gun2.shootN(2);
        System.out.println("1");
        gun2.shoot();
        System.out.println("1");
        gun2.shoot();
        System.out.println("1");
        gun2.shoot();
        //
        Parrot parrot1 = new Parrot("Parrot", "Hello World, I am a parrot");
        parrot1.toSing();

        //
        Student s= new Student("Tom",2, 3, 4, 5);
        s.rule = new Rule();
        Student s2= new Student("Tim", 2, 3, 4, 5);
        s2.rule = new Rule();
        List<String> l= new ArrayList<>(List.of("123","23", "querty"));
    }
}
