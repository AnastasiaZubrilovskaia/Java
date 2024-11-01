public class Way {
    private City city;
    private int pay;
    public Way (City city, int pay){
        this.pay = pay;
        this.city = city;
    }
    public City getCity(){
        return city;
    }

    public int getPay(){
        return pay;
    }
    public void setPay(int pay){
        this.pay = pay;
    }
    public String toString(){
        return city.getName() + " : " + pay + " руб";
    }
}
