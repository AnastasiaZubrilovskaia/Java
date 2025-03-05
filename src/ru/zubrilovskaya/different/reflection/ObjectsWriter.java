package ru.zubrilovskaya.different.reflection;


import ru.zubrilovskaya.annotations.Validate;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;

@Validate({String.class, Integer.class})
public class ObjectsWriter {
    String fileName;

    public ObjectsWriter(String fileName) {
        this.fileName = fileName;
    }

    public void toWrite(List<?> objects) {
        try(FileWriter f = new FileWriter(fileName)){
            String temp;
            for (Object ob: objects){
                temp=toText(ob);
                f.write(temp + "\n");
            }
        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }

    private String toText(Object ob){
        Class<?> clazz = ob.getClass();
        StringBuilder str = new StringBuilder();
        str.append(clazz.getName()).append("{");
        Field[] fields = clazz.getDeclaredFields();
        try {
            for(Field field: fields){
                field.setAccessible(true);
                str.append(field.getName()).append("=").append(field.get(ob));
                if (!field.equals(fields[fields.length-1])) str.append(", ");
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return str + "}";
    }
}
