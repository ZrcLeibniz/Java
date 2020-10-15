package zrc.threadmethod.sleep;

public class SimpleTimer {
    public static void main(String[] args) {
        int reMain = 10;
        if (args.length == 1) {
            reMain = Integer.parseInt(args[0]);
        }
        while (true) {
            System.out.println("reMain:" + reMain);
            reMain--;
            if (reMain < 0) {
                break;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Done");
    }
}
