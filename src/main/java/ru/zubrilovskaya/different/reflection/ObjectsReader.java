package ru.zubrilovskaya.different.reflection;


import ru.zubrilovskaya.annotations.ToString;
import ru.zubrilovskaya.annotations.Variant;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@ToString(value= Variant.YES)
public class ObjectsReader<T>{
    String fileName;
    Class <T> clazz;

    public ObjectsReader(String fileName, Class<T> clazz) {
        this.fileName = fileName;
        this.clazz = clazz;
    }

    public List<T> toRead() {
        List<T> list = new ArrayList<>();
        try (BufferedReader buffer = new BufferedReader(new FileReader(fileName))) {
            String temp;
            while ((temp = buffer.readLine()) != null) {
                list.add(comeToT(temp));
            }
            return list;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private T comeToT(String str)  {
        try{
            int index = str.indexOf("{");
            String className = str.substring(0, index );
            if (className.equals(clazz.getName())){
                T ob = clazz.getDeclaredConstructor().newInstance();
                String fieldsAndValues = str.substring(index + 1, str.length() -1 );
                String[] fieldAndValue = fieldsAndValues.split(", ");
                for(String st: fieldAndValue){
                    String[] temp = st.split("=");
                    String field = temp[0];
                    String value = temp[1];

                    Field f = clazz.getDeclaredField(field);
                    f.setAccessible(true);
                    if (f.getType() == int.class){
                        f.set(ob, Integer.parseInt(value));
                    }else if(f.getType() == String.class){
                        f.set(ob, value);
                    }
                    else{
                        Class<?> fieldClass = f.getType();
                        f.set(ob, fieldClass.cast(value));
                    }
                }
                return ob;

            }else throw new RuntimeException("Тип не соответствует");
        }catch (NoSuchMethodException | InvocationTargetException|
                InstantiationException | NoSuchFieldException | IllegalAccessException e){
            throw new RuntimeException(e);
        }
    }
}
