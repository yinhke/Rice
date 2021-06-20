package singleton;

/**
 * 单例--双重检查模式
 */
public class SingletonTest {


    /**
     * volatile关键字保证指令顺序执行，线程间可见
     */
    public static volatile SingletonTest singletonTest;

    /**
     * 首次判断是否存在对象
     * synchronized关键字加锁类
     *
     * @return
     */
    public static SingletonTest getInstance() {
        if (singletonTest == null) {
            synchronized (SingletonTest.class) {
                if (singletonTest == null) {
                    singletonTest = new SingletonTest();
                }
            }
        }
        return singletonTest;
    }

    /**
     * 开启1000的请求并发测试
     *
     * @param args
     */
    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                System.out.println(SingletonTest.getInstance());
            }).start();
        }
    }
}
