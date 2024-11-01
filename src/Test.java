public class Test {
    public static void main(String[] args){
        int[] arr={1,2,3};
        int[] arr2={1,2,3};
        String str1 = "hello";
        String str2 = "hello";
        String str3 = new String("hello");
        System.out.println(arr==arr2);
        System.out.println(str1 == str2);
        System.out.println(str1 == str3);
    }
}
