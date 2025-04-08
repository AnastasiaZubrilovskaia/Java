package ru.zubrilovskaya.spring;
import org.springframework.context.annotation.*;
import ru.zubrilovskaya.human.student.Checker;
import ru.zubrilovskaya.human.student.Student;

import java.util.*;
import java.util.function.Predicate;

@Configuration
@ComponentScan
@ComponentScan(basePackages = "ru.zubrilovskaya.postprocesses")
public class Config {
    List<Integer> nums = new ArrayList<>();
    @Bean
    public String hello(){
        return "Hello world!";
    }

    @Bean
    @Scope("prototype")
    public int random(){
        if(nums.isEmpty()){
            for(int i=0; i<100; i++) nums.add(i);
        }
        Random random = new Random();
        int index = random.nextInt(1, 100);
        return  nums.remove(index);
    }

    @Bean
    @Lazy
    public Date date(){
        return new Date();
    }

    @Bean
    public Predicate<Integer> range(){
        return new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer >= 2 && integer <= 5;
            }
        };
    }

    @Bean
    public int max(){
        return 100;
    }

    @Bean
    public int min(){
        return 0;
    }

    //9.2.2
    @Bean
    public Response response1(){
        return new Response("Очень хорошо", 4);
    }

    @Bean
    public Response response2(){
        return new Response("Сойдет", 3);
    }

    @Bean
    @Scope("prototype")
    public Response response3(){
        return new Response("Сложно сказать", random());
    }

    //9.2.3
    @Bean
    @Scope("prototype")
    public Response response(List<Response> responseList){
//        return responseList.stream()
//                .max(Response::compareTo).get();
        return responseList.stream()
                .max(Comparator.comparingInt(x->x.mark))
                .orElse(null);
    }
    //9.2.4
    @Bean
    public Checker forCheck(Predicate<Integer> p){
        return (int mark) -> p.test(mark);
    }

    @Bean
    public Student student1(Checker checker){
        return new Student("Petr", checker);
    }

    @Bean
    public Student student2(Checker checker){
        return new Student("Ivan", checker);
    }

}
