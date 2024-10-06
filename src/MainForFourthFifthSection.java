import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainForFourthFifthSection {
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

        Time time5 = new Time (2222);
        time5.setSeconds(2000);
        System.out.println(time5);


    }
}
