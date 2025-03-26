package ru.zubrilovskaya.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.zubrilovskaya.test.A;

//@Component
//public class InjectTest {
//    int num;
//    String str;
//    @Autowired
//    A a;
//
//    public InjectTest() {
//    }
//
//    @Autowired
//    public InjectTest(@Qualifier("num") int num){
//        this.num = num;
//    }
//
//    @Autowired
//    public void setStr( @Qualifier("str") String str) {
//        this.str = str;
//    }
//
//    @Override
//    public String toString() {
//        return "InjectTest{" +
//                "num=" + num +
//                ", str='" + str + '\'' +
//                ", a=" + a +
//                '}';
//    }
//}

//в Config
//@Bean
//@Qualifier("A")
//public A a(){
//    return new A(1,2,"1", "2");
//}
//@Bean
//@Qualifier("str")
//public String str(){
//    return "text";
//}
//
//@Bean
//@Qualifier("num")
//public int num(){
//    return 42;
//}
//в Main
//System.out.println(ctx.getBean(InjectTest.class));
