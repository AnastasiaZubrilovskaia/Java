package ru.zubrilovskaya.different;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class ListSuplier implements Supplier <List<List<Integer>>> {

    @Override
    public List<List<Integer>> get() {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        res.add(new ArrayList<>());
        return res;
    }
}
