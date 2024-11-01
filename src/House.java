public class House {
    private int floors;
    public House (int floors){
        setFloors(floors);
    }
    public void setFloors(int floors){
        if(floors <= 0) throw new IllegalArgumentException(" number of floors must be positive");
        this.floors = floors;
    }
    public int getFloors(){
        return floors;
    }
    public  String toString(){
        if (floors == 1){
            return "дом с " + floors + " этажом";
        }
        return "дом с " + floors + " этажами";
    }
}
