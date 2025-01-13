package ru.zubrilovskaya.different.converter;

public class Converter {
    Openable open;
    Transformable transform;
    Writable write;

    public Converter(Openable open, Transformable transform, Writable write) {
        this.open = open;
        this.transform = transform;
        this.write = write;
    }

    public void convert(String lastFile, String newFile){
        String string = open.open(lastFile);
        String newString = transform.trans(string);
        write.write(newString, newFile);
    }
}
