package ru.zubrilovskaya.weapons;
public class Pistol extends Gun {
    private int speed;

    public Pistol(int maxBullet, int speed){
        super(0, maxBullet);
        this.speed = speed;
    }
    public Pistol(int maxBullet){
        this(maxBullet, maxBullet / 2);

    }
    public Pistol(){
        this(30, 30);
    }

    public void setSpeed(int speed){
        if (speed <= 0) throw new IllegalArgumentException("speed must be positive");
        this.speed = speed;
    }
    public int getSpeed(){
        return speed;
    }

    public void shootN(int N){
        for (int i = 0; i < speed*N; i++){
            super.shoot();
        }
    }

    @Override
    public void shoot(){
        for (int i = 0; i < speed; i++){
            super.shoot();
        }
    }

}
