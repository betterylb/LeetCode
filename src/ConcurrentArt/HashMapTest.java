package ConcurrentArt;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class HashMapTest {
    public static void test() throws Exception{
        final HashMap<String, String> map = new HashMap<String, String>(2);
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            map.put(UUID.randomUUID().toString(), "");
                        }
                    }, "ftf" + i).start();
                }
            }
        }, "ftf");
        t.start();
        t.join();
    }

    public static void main(String[] args) throws Exception{
        test();
        Map<Integer,Integer> a = new ConcurrentHashMap<>();
    }

}
