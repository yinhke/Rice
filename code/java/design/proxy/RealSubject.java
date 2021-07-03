package design.proxy;

/**
 * 真实主题
 *
 * @author: hongke.yin
 * @time: 2021/7/1
 */
public class RealSubject implements Subject {

    @Override
    public String execute(String name) {
        System.out.println("execute");
        return name;
    }
}
