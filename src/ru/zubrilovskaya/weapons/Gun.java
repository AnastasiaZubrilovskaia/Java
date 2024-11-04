package ru.zubrilovskaya.weapons;
public class Gun extends Weapon implements Weaponable {
    final int maxBullet;
    public Gun(int bullet, int maxBullet){
        super(bullet);
        if(maxBullet < 0) throw new IllegalArgumentException(" number of bullets must be positive");
        this.maxBullet = maxBullet;
    }
    public int getMaxBullet(){
        return maxBullet;
    }
    public int unload(){
        int number = getBullet();
        decreaseAmmo(number);
        return number;
    }
    @Override
    public void reload(int number){
        int bullet = getBullet();
        if (number < 0) throw new IllegalArgumentException("number of bullets must be positive");
        else if (number + bullet > maxBullet){
            System.out.println(number - (maxBullet - bullet));
            super.reload(maxBullet - bullet);

        }
        else{
            super.reload(number);
        }
    }

    public boolean isLoaded (){
        return getBullet() > 0;
    }
    @Override
    public void  shoot(){
        if (isLoaded()){
            decreaseAmmo(1);
            System.out.println("Бах!");
        }else System.out.println("Клац!");
    }

}
