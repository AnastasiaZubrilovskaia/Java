package ru.zubrilovskaya.storage;

public final class Storage<T> {
    final T ob;

    public Storage(T ob) {
        this.ob = ob;
    }
    public T getOb(T altern){
        if (ob == null) return altern;
        return ob;
    }
}
