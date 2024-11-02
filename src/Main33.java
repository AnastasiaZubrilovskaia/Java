import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main33 {
    public static void main(String[] args){
        //3.3.1
        System.out.printf("%.3f%n", sum(2, new Fraction(3,5), 2.3));
        System.out.printf("%.3f%n", sum(3.6, new Fraction(49,12), new Fraction(3,2)));
        System.out.printf("%.3f%n", sum(new Fraction(1,3), 1));
        //3.3.2
        Bird bird1 = new Sparrow("Sparrow");
        Bird bird2 = new Cuckoo("Cuckoo");
        Bird bird3 = new Parrot("Parrot", "Hello World");
        birdMarket(bird1, bird2, bird3);
        //3.3.3
        Shape figure1 = new Square(new Point2D(34,5),4);
        Shape figure2 = new Square(new Point2D(-34,15),8);
        Shape figure3 = new Square(new Point2D(4,25),10);
        Shape figure4 = new Circle(new Point2D(23,4),5);
        Shape figure5 = new Circle(new Point2D(3,46),3);
        System.out.printf("%.3f%n",generalArea(figure1, figure2, figure3, figure4, figure5));
        //3.3.4
        Cat cat1 = new Cat("Cat1");
        Cat cat2 = new Cat("Cat2");
        Cat cat3 = new Cat("Cat3");
        meow(cat1, cat2, cat3);
        //3.3.5
        Line line = new Line(2,4,5,6);
        BrokenLine brokenLine = new BrokenLine(new Point2D(2,5), new Point2D(5,5), new Point2D(10,10));
        System.out.printf("%.3f%n", sumLength(brokenLine, line));
        //3.3.8
        Shooter shooter1 = new Shooter("Ivan");
        shooter1.setGun(new Gun(2,2));
        Shooter shooter2 = new Shooter("Petr");
        shooter2.setGun(new Pistol(2));
        shooter2.getGun().reload(3);
        Shooter shooter3 = new Shooter("Tom");
        shooter1.shoot();
        shooter2.shoot();
        shooter3.shoot();
        //3.3.9
        Town A = new Town("A");
        City B = new City("B");
        City C = new City("C");
        Town D = new Town("D");
        City E = new City("E");
        A.addWay( B,12);
        A.addWay( C,122);
        B.addWay( C,32);
        D.addWay( B,222);
        D.addWay( E,112);
        E.addWay( C,45);
        System.out.println(A);
        System.out.println(B);
        System.out.println(C);
        System.out.println(D);
        System.out.println(E);
        //
        Student st1 = new Student("Alex");
        st1.rule = new Rule();
        List<Integer> marks1 = new ArrayList<>(List.of(2,3,4));
        st1.setMark(marks1);
        Student st2 = new Student("Ivan");
        st2.rule = new Rule1();
        List<Integer> marks2 = new ArrayList<>(List.of(2,3,4));
        st2.setMark(marks2);
        Student st3 = new Student("Petr");
        st3.rule = new RangeRule(2,5);
        List<Integer> marks3 = new ArrayList<>(List.of(2,3,4));
        st3.setMark(marks3);
        //
        List<String> s = new ArrayList<>(List.of("123", "23", "querty"));
        s.sort(new StringComparator());
        System.out.println(s);
        List<String> s1 = new ArrayList<>(List.of("123", "23", "1111"));
        s1.sort(Comparator.naturalOrder());
        System.out.println(s1);
        List<String> s2 = new ArrayList<>(List.of("123", "23", "1111"));
        Collections.sort(s2);
        System.out.println(s2);
    }
    public static double sum(Number... numbers){
        double sum = 0.0;
        for (Number num: numbers){
            sum+=num.doubleValue();
        }
        return sum;
    }
    public static void birdMarket(Bird... birds){
        for (Bird bird : birds){
            if(bird != null) bird.toSing();
        }
    }
    public static double generalArea(Shape... shapes){
        double area = 0.0;
        for (Shape s: shapes){
            if (s != null)  area+=s.area();
        }
        return area;
    }
    public static void meow(Meowable... objects){
        for(Meowable ob: objects){
            if (ob != null) ob.meow();
        }
    }
    public static double sumLength(Lengthable... lengths){
        double len = 0.0;
        for (Lengthable l : lengths){
            if (l != null) len+=l.length();
        }
        return len;
    }
    public static BrokenLine newBroken(BrokenLineable... brokenLines){
        List<Point2D> points = new ArrayList<>();
        for (BrokenLineable brokenLine: brokenLines){
            if(brokenLine != null) points.addAll(brokenLine.getBroken().points2D);
        }
        return new BrokenLine(points);
    }
}