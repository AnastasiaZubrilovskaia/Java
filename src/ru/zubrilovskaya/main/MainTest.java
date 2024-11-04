package ru.zubrilovskaya.main;
import ru.zubrilovskaya.comparator.StringComparator;
import ru.zubrilovskaya.test.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainTest {
    public static void main(String[] args){
        BankAccount account = new BankAccount(300);
        account.refill(400);
        account.refill(500);
        account.withdrawing(300);
        System.out.println(account);
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
}
