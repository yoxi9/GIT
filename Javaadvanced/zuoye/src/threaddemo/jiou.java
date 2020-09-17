package threaddemo;

class Test extends Thread{
    @Override
    public void run() {
        super.run();
        for (int i = 2; i <=100; i += 2) {
            System.out.println(Thread.currentThread().getName()+i);
        }
    }
}
class Tset1 extends Thread{
    @Override
    public void run() {
        for (int i=1;i<=100;i+=2){
            System.out.println(Thread.currentThread().getName()+i);
        }
    }
}

public class jiou {
    public static void main(String[] args) {
Test T=new Test();
Tset1 T1=new Tset1();
T.setName("偶数线程：");
T.start();
T1.setName("奇数线程：");
T1.start();
    }
}

