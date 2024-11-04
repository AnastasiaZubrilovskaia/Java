package ru.zubrilovskaya.weapons;
public abstract class Weapon{
    private int ammo;
    public Weapon(int ammo){
        if (ammo <0) throw new RuntimeException();
        this.ammo = ammo;
    }
    abstract void shoot();
    public int getBullet(){
        return ammo;
    }
    public void decreaseAmmo(int number){
        if (number <= ammo) ammo-=number;
        else ammo = 0;
    }
    public void reload (int ammo){
        if (ammo<0) throw new RuntimeException();
        this.ammo +=ammo;
    }
}
