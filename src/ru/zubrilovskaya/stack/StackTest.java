package ru.zubrilovskaya.stack;
public class StackTest {
    public int[] arr = new int[100];
    public int size = 0;
    public StackTest(int size){
        this.arr = new int[size];
    }
    public StackTest(){

    }
    public void push(int num){
        arr[size++] = num;
    }
    public int pop (){
        return arr[--size];
    }
    public String toString(){
        String str = "[ ";
        if (size == 0) return "[ ]";
        for (int i = size-1; i>=0; i--){
            str += arr[i] + " ";
        }
        return str + "]";
    }
}
