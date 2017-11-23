public class YeldMain {

    /*
    * пример ипользования yeld() (случайным образом переключает выполнение между родительским и дочерним потоком)
    * данная команда очень часто используется при программировании микроконтроллеров
    * */
    private static class ChildThread
            extends Thread {
        public void run() {
            for(int i=0;i<5;i++){
                System.out.println(Thread.currentThread().getName() + ": номер итерации ребенка: " + i);
                if(i==3) {
                    Thread.yield();
                }
            }
        }
    }

    public static void main(String[] args){
        YeldMain.ChildThread childThread = new YeldMain.ChildThread();
        childThread.start();
        Thread.yield();
        for (int i = 0; i < 5 ; i++) {
            System.out.println(Thread.currentThread().getName() + ": номер итерации родителя: " + i);
        }

    }

}
