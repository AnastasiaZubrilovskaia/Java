public  class RangeRule implements Checker{
    int min;
    int max;
    public RangeRule(int min, int max){
        this.max = max;
        this.min = min;
    }
    public boolean check (int mark){
        return mark>=min && mark<=max;
    }
}
