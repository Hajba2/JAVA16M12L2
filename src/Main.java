public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        new Thread(new PrintRunnable(9)).start();
    }
}