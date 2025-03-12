package ru.zubrilovskaya.storage;

public class Storage<T> {
    private final T ob;
    private static final Storage EMPTYSTORAGE = new Storage(null);

    private Storage(T ob) {
        this.ob = ob;
    }
    @SuppressWarnings("unchecked")
    public static <T> Storage<T> empty(){
        return EMPTYSTORAGE;
    }

    @SuppressWarnings("unchecked")
    public static <T> Storage<T> of(T ob){
        if(ob == null) return EMPTYSTORAGE;
        return new Storage<>(ob);
    }


    public T getOb(T altern){
        if (ob == null) return altern;
        return ob;
    }
}
