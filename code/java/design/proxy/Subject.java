package design.proxy;

/**
 * 主题
 * 接口或抽象类 定义真实主题和代理类实现业务方法
 *
 * @author: hongke.yin
 * @time: 2021/7/1
 */
public interface Subject {

    /**
     * 执行器
     */
    String execute(String name);
}
