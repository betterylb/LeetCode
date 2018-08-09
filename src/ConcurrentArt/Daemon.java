package ConcurrentArt;

import java.util.concurrent.TimeUnit;

public class Daemon {
    public static void main(String[] args) throws Exception{
        Thread thread = new Thread(new DaemonRunner(), "DaemonRunner");
        thread.setDaemon(true);
        thread.start();
        TimeUnit.SECONDS.sleep(5);
    }
    static class DaemonRunner implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+"启动");
            try {
                SleepUtils.second(10);
                System.out.println(Thread.currentThread().getId()+"结束");
            } finally {
                System.out.println("DaemonThread finally run.");
            }
        }
    }
}
