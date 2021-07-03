package design.proxy;

/**
 * 静态代理
 *
 * @author: hongke.yin
 * @time: 2021/7/1
 */
public class StaticProxy implements Subject {
    private Subject subject;

    public StaticProxy(Subject subject) {
        this.subject = subject;
    }

    @Override
    public String execute(String name) {
        System.out.println("before real subject do something");
        subject.execute("aa");
        System.out.println("after real subject do something");
        return name;
    }

    public static void main(String[] args) {
        StaticProxy staticProxy = new StaticProxy(new RealSubject());
        staticProxy.execute("static");
    }
}
