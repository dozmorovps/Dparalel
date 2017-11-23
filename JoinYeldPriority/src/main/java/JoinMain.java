public class JoinMain {

    private static class ChildThread
            extends Thread {

        public void run() {
            for(int i=0;i<10;i++){
                try {
                    System.out.println(Thread.currentThread().getName() + ": номер итерации ребенка: " + i);
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args){
        ChildThread childThread = new ChildThread();
        childThread.start();
        try {
            //join c задержкой по времени ожидает заданное количество времени после чего передает управление на другой поток (в нашем случае родительский) а затем после выполнения родительского доделывает дочерний.
            childThread.join(20);
            for (int i = 0; i < 50 ; i++) {
                System.out.println(Thread.currentThread().getName() + ": номер итерации родителя: " + i);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
