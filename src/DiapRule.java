public abstract class DiapRule implements Checker{
    int min;
    int max;
    public DiapRule(int min, int max){
        this.max = max;
        this.min = min;
    }
    public boolean check (int mark){
        return mark>=2;
    }
}
