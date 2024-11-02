public class MainTest {
    public static void main(String[] args){
        BankAccount account = new BankAccount(300);
        account.refill(400);
        account.refill(500);
        account.withdrawing(300);
        System.out.println(account);
    }
}
