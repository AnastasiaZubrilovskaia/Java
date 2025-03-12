package ru.zubrilovskaya.main;

import ru.zubrilovskaya.different.DataStream;
import ru.zubrilovskaya.geometry.BrokenLine;
import ru.zubrilovskaya.geometry.ClosedLine;
import ru.zubrilovskaya.geometry.Point;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class NewMain {
    public static void main(String[] args) throws IOException {
        List<String> str = List.of("hhfsdk", "qjdh", "qhufuf", "fgqfd");
        int data=str.stream()
                .filter(x -> x.startsWith("q"))
                .map(String::length)
                .reduce(Integer::sum)
                .orElse(0);
        int data1 = DataStream.of(str).filter(x -> x.startsWith("q"))
                .map(String::length)
                .reduce(Integer::sum,0);
        System.out.println(data);
        System.out.println(data1);

        //сколько раз в списке строк встречается буква Q
        long count = str.stream()
                .flatMapToInt(String::chars)
                .filter(x -> x =='q')
                .count();
        System.out.println(count);

        long countVar2 = str.stream()
                .flatMap(x -> x.chars().boxed()) // изменено на x -> x.chars().boxed()
                .filter(x -> x == 'q')
                .count();
        System.out.println(countVar2);

        ////////////
        List<String> test = new ArrayList<>(Arrays.asList("hihuu", "qhjj", "tqqqop"));
        IntStream count1 = test.stream()
                .flatMapToInt(String::chars)
                .filter(x -> x =='q');
        System.out.println(count1.count()); //4
        //сохранение действия; то есть все изменения, которые произойдут потом, будут учтены
        IntStream count2 = test.stream()
                .flatMapToInt(String::chars)
                .filter(x -> x =='q');
        test.add("q");
        System.out.println(count2.count()); //5
        //стрима закрылась в 48 строке
//        test.add("q");
//        System.out.println(count2.count()); // IllegalStateException: stream has already been operated upon or closed


        //x->x.chars().boxed()
        //Stream.of()/build()/....
        Stream.Builder<String> build =  Stream.builder();
        build.add("ff");
        build.add("hhj");



        List<Point> pts = new ArrayList<>(List.of(new Point(2,-5), new Point(11,34)
                ,new Point(2,-5),new Point(0,-7), new Point(22,67)));

        File f = new File("D:\\Java_w\\Java\\src\\ru\\zubrilovskaya\\main\\points.txt");
        Scanner scanner = new Scanner(f);

        List<BrokenLine> polyList = Files.lines(f.toPath())
                .map(st->st.split(" "))
                .map(st -> new Point(
                        Integer.parseInt(st[0]),
                        Integer.parseInt(st[1])
                ))
                .distinct()
                .map(p -> new Point(p.x, Math.abs(p.y)))
                .sorted((p1, p2) -> p1.x - p2.x)
                .collect(Collectors.groupingBy(p -> p.y))
                .values()
                .stream()
                .map(BrokenLine::new)
                .toList();
        System.out.println(polyList);







//        Scanner scanner = new Scanner(new File("points.txt"));
//        List<BrokenLine> brokenLine = Stream.generate(() -> scanner.nextLine())
//                .takeWhile(x -> scanner.hasNext())
//                .map(st -> st.split(" "))
//                .map(st -> new Point(
//                        Integer.parseInt(st[0]),
//                        Integer.parseInt(st[1])
//                ))
//                .distinct()
//                .map(p -> new Point(p.x,p.y= Math.abs(p.y)))
//                .sorted(Comparator.comparingInt(p -> p.x))
//                .collect(()->new BrokenLine(), (line, p)->line.points.add(p),
//                        (line1, line2)->line1.points.addAll(line2.points));
//        System.out.println(brokenLine);
        //убрать одинаковые, у по модулю сделать, отсортировать по возрастанию x, сделать из точке ломанную// точки читаются из файла
//peek нарушает частоту, это функция, которая изменяет список
        //ни одна стрима не должна ничего менять

//дз:
        //в результате стримы набор полилайнов, где каждая полилайн (ломанная, которая прямая)
        List<Integer> list1 = List.of(1,2,3,4,5,6,7,8,9,10);
        double num = list1.stream()
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElse(0.0);
        List<String> list2 = str.stream()
                .map(String::toUpperCase)
                .toList();
        int summa1 = list1.stream()
                .filter(x->x%2==0)
                .reduce(Integer::sum)
                .orElse(0);
        int summa2 = list1.stream()
                .filter(x->x%2!=0)
                .reduce(Integer::sum)
                .orElse(0);
        List<String> list3 = List.of("111", "111", "234", "444");
        List<String> list4 = list3.stream()
                .distinct()
                .toList();
        long countStr = str.stream()
                .filter(x->x.startsWith("q"))
                .count();
        List<String> list5 = str.stream()
                .sorted()
                .toList();
        List<String> list6 = str.stream()
                .sorted(Collections.reverseOrder())
                .toList();
        int numberMin = list1.stream()
                .reduce(Integer::min)
                .orElse(0);
        int numberMax = list1.stream()
                .reduce(Integer::max)
                .orElse(0);
        int twoMin = list1.stream()
                .sorted()
                .distinct()
                .skip(1)
                .findFirst()
                .orElse(0);
        int twoMax = list1.stream()
                .sorted(Collections.reverseOrder())
                .distinct()
                .skip(1)
                .findFirst()
                .orElse(0);

   }
}