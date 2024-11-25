package ru.zubrilovskaya.main;
import ru.zubrilovskaya.human.*;
import ru.zubrilovskaya.geometry.*;
import ru.zubrilovskaya.time.Time;
import ru.zubrilovskaya.house.House;
import ru.zubrilovskaya.human.student.*;
import ru.zubrilovskaya.cat.Cat;
import ru.zubrilovskaya.numbers.Fraction;
import ru.zubrilovskaya.weapons.Gun;

public class Main14 {
    public static void main(String[] args) {
        //1.4.9
//        Point [] pts = {new Point(1,2), new Point(2,2)};
//        List<Point> ptsList = new ArrayList<>();
//        ptsList.addAll(Arrays.asList(pts));
//
        NameConstructor builder = new NameConstructor()
                .setPatronymic("Ivanovich")
                .setName("Anton")
                .setSurname("Belov");
        Name name = builder.create();
        System.out.println(name);

        Time time = new Time (2222);
        time.setSeconds(2000);
        System.out.println(time);
        //1.4.1
        System.out.println("1.4.1:");
        Point dot1 = new Point(3,5);
        System.out.println("1: " + dot1);
        Point dot2 = new Point(25,6);
        System.out.println("2: " + dot2);
        Point dot3 = new Point(7,8);
        System.out.println("3: " + dot3);
        //1.4.2
        System.out.println("1.4.2:");
        Point dot_begin = new Point(1,3);
        Point dot_end = new Point(23,8);
        Line line1 = new Line(dot_begin, dot_end);
        System.out.println("1: " + line1);
        Line line2 = new Line(new Point(5,10), new Point(25,10));
        Point dot_end_2 = new Point(25,10);
        System.out.println("2: " + line2);
        Line line3 = new Line(dot_begin, dot_end_2);
        System.out.println("3: " + line3);
        //1.4.3
        System.out.println("1.4.3:");
        House house1 = new House(12);
        System.out.println(house1);
        //1.4.4
        System.out.println("1.4.4:");
        Time time1=new Time(1000);
        Time time2=new Time(2,3,5);
        System.out.println(time1);
        System.out.println(time2);
        System.out.println(house1);
        //1.4.5
        System.out.println("1.4.5:");
        Name name1 =  Name.withPersonal("Клеопатра");
        Name name2 = new Name("Пушкин", "Александр", "Сергеевич");
        Name name3 =  Name.withSurnamePersonalName("Маяковский", "Владимир");
        Name name4 =  Name.withSurnamePersonalName("Бонифатьевич", "Христофор");
        System.out.println(name1);
        System.out.println(name2);
        System.out.println(name3);
        System.out.println(name4);
        //1.4.6
        System.out.println("1.4.6:");
        Human human1= new Human("Лев", 170);
        Name nameHuman2 = builder
                .setName("Сергей")
                .setSurname("Пушкин")
                .create();
        Human human2 = new Human(nameHuman2, 168, human1);
        Human human3 = new Human("Александр", 167, human2);
        System.out.println(human1);
        System.out.println(human2);
        System.out.println(human3);
        //1.4.7
        System.out.println("1.4.7:");
        Student student1 = new Student("Вася", 3, 4, 5);
        Student student2 = new Student("Максим");
        System.out.println(student1);
        System.out.println(student2);
        //1.5.1
        System.out.println("1.5.1:");
        Gun gun1 = new Gun(0,3);
        gun1.shoot();
        gun1.shoot();
        gun1.shoot();
        gun1.shoot();
        gun1.shoot();
        //1.5.2
        System.out.println("1.5.2:");
        Cat cat = new Cat("Барсик");
        cat.meow();
        cat.meow(3);
        //1.5.3
        System.out.println("1.5.3:");
        Point p1 = new Point(1,1);
        Point p2 = new Point(10,15);
        Line line = new Line(p1,p2);
        System.out.println(line.length());
        //1.5.4
        System.out.println("1.5.4:");
        Time time3 =new Time(34056);
        Time time4 =new Time(4532);
        Time time5 =new Time(123);
        System.out.println(time3.whatHours());
        System.out.println(time4.whatMinutes());
        System.out.println(time5.whatSeconds());
        //1.5.5
        System.out.println("1.5.5:");
        Fraction fraction1 = new Fraction(12,14);
        Fraction fraction2 = new Fraction(2,4);
        Fraction res1 = fraction1.composition(fraction2);
        Fraction res2 = fraction1.minus(fraction2);
        Fraction res3 = fraction1.sum(fraction2);
        Fraction res4 = fraction1.div(fraction2);
        System.out.println(fraction1 + " * " + fraction2 + " = " + res1);
        System.out.println(fraction1 + " - " + fraction2 + " = " + res2);
        System.out.println(fraction1 + " + " + fraction2 + " = " + res3);
        System.out.println(fraction1 + " / " + fraction2 + " = " + res4);
        Fraction fraction3 = new Fraction(5,7);
        Fraction res5 = fraction1.sum(fraction2).div(fraction3).minus(5);
        System.out.println(" res5 :  " + res5);
        //1.5.6
        System.out.println("1.5.6:");
        Student student3 = new Student("Вася", 3,4,5,4);
        Student student4 = new Student("Петя", 5,5,5,5);
        System.out.println(student3);
        System.out.println(student3.averageValue());
        System.out.println(student3.isExcellentStudent());
        System.out.println(student4);
        System.out.println(student4.averageValue());
        System.out.println(student4.isExcellentStudent());
        //1.5.7
        System.out.println("1.5.7:");
        Point point1 = new Point(1,5);
        Point point2D2 = new Point(2,8);
        Point point3 = new Point(5,3);
        BrokenLine brokenLine1 = new BrokenLine(point1, point2D2, point3);
        System.out.println(brokenLine1.length());
        brokenLine1.addNewPoints(new Point(5,15), new Point(8,10));
        System.out.println(brokenLine1.length());
        //1.5.8
        System.out.println("1.5.8:");
        Square square1= new Square(new Point(5,3), 23);
        BrokenLine brokenLine2 = square1.getBroken();
        System.out.println(brokenLine2.length());
        Point lastPoint = brokenLine2.points.getLast();
        lastPoint.x = 15;
        lastPoint.y = 25;
        System.out.println(brokenLine2.length());

    }
}
