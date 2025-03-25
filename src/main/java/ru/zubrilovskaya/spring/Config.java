package ru.zubrilovskaya.spring;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import ru.zubrilovskaya.human.student.Checker;
import ru.zubrilovskaya.human.student.Student;

import java.util.Date;
import java.util.List;
import java.util.function.Predicate;

@Configuration
@ComponentScan(basePackages = "ru.zubrilovskaya.spring")
public class Config {

    @Bean
    public String hello(){
        return "Hello world!";
    }

    @Bean
    @Scope("prototype")
    public int random(){
        int random = (int) (Math.random()*((max() - min()) + 1)) + min();
        return random;
    }

    @Bean
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

    @Bean
    @Scope("prototype")
    public Response response(List<Response> responseList){
        return responseList.stream()
                .max(Response::compareTo).get();
    }

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
