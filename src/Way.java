public class Way {
    public City city;
    public int pay;
    public Way (City city, int pay){
        this.city = city;
        this.pay = pay;
    }
    public String toString(){
        return city.name + " : " + pay + " руб";
    }
}
