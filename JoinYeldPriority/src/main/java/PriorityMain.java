public class PriorityMain {

    /*
    пример выполнения нитей расставляя приоритеты или убирая их.
    если приоритерыт убрать то выполняться по упоминанию в коде.
    а именно:
    Thread-0
    Thread-2
    Thread-1

    в случае расстановки приоритетов:
    Thread-2
    Thread-1
    Thread-0

    также стоит отметить что приоритеты это численные значения о 1 до 10
    и возможно более "точная" настройка. однако при высокоуровневом программировании
    а также учитывая разную аппаратную составляющую ПК пользователей, расстановка приоритетов не целесообразна
    но при программировании микроконтроллеров данный способ управления нитями очень даже пригоден,
     */

    private static class ChildThread1 extends Thread {
        public void run() {
            for(int i=0;i<2000;i++){ }
            System.out.println(Thread.currentThread().getName());
        }
    }

    private static class ChildThread2 extends Thread {
        public void run() {
            for(int i=0;i<2000;i++){ }
            System.out.println(Thread.currentThread().getName());
        }
    }

    private static class ChildThread3 extends Thread {
        public void run() {
            for(int i=0;i<2000;i++){ }
            System.out.println(Thread.currentThread().getName());
        }
    }

    public static void main(String[] args){
        ChildThread1 childThread1 = new ChildThread1();
        ChildThread2 childThread2 = new ChildThread2();
        ChildThread3 childThread3 = new ChildThread3();

        childThread3.setPriority(Thread.MAX_PRIORITY);
        childThread2.setPriority(Thread.NORM_PRIORITY);
        childThread1.setPriority(Thread.MIN_PRIORITY);

        childThread1.start();
        childThread3.start();
        childThread2.start();
    }
}
