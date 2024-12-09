package ru.zubrilovskaya.different;

import java.util.List;
import java.util.function.BiConsumer;

class ListConsumer implements BiConsumer<List<List<Integer>>, Integer>{
    @Override
    public void accept(List<List<Integer>> collection, Integer value) {
        if (value > 0) collection.get(0).add(value);
        else collection.get(1).add(value);
    }
}

