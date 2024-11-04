package ru.zubrilovskaya.weapons;
public class Shooter {
    private String name;
    private Weaponable gun;

    public Shooter(String name) {
        setName(name);
    }
    public void setName(String name){
        this.name = name;
    }
    public void setGun(Weaponable gun){
        this.gun = gun;
    }
    public String getName(){
        return name;
    }
    public Weaponable getGun(){
        return gun;
    }
    public void shoot(){
        if (gun != null) gun.shoot();
        else System.out.println("не могу участвовать в перестрелке");
    }

}
