package ru.zubrilovskaya.database;

public class Connection {
    DataBase data;

    public Connection(DataBase data) {
        if(data.toConnect()) this.data = data;
        else this.data = null;
    }

    public String getData(int ind) {
        if (data == null)  return null;
        if (ind < 0 || ind >= data.list.size()) return null;
        return data.list.get(ind);
    }
    public void setData(String st){
        if (data != null) data.list.add(st);
    }
}
