package design.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 *
 * @author: hongke.yin
 * @time: 2021/7/1
 */
public class DynamicProxy implements InvocationHandler {

    private Subject subject;

    public Subject getInstance(Subject subject) {
        this.subject = subject;
        Class<?> clazz = subject.getClass();
        return (Subject) Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before real subject do something");
        Object result = method.invoke(this.subject, args);
        System.out.println("before real subject do something");
        return result;
    }

    public static void main(String[] args) {
        DynamicProxy dynamicProxy = new DynamicProxy();
        Subject subject = dynamicProxy.getInstance(new RealSubject());
        subject.execute("dynamic");
    }
}
