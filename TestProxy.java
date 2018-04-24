package sort;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 运用代理模式运行时动态织入统计各个排序算法运行时间的代码
 * 注意：被代理类的被代理方法必须是public
 */
public class TestProxy implements MethodInterceptor {

    private Object object;

    public TestProxy(Object object) {
        this.object = object;
    }

    public Object newInstance() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(object.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        if (method.getName().contains("solution")) {
            long start = System.currentTimeMillis();
            Object obj = methodProxy.invokeSuper(o, objects);
            long end = System.currentTimeMillis();
            System.out.println("排序花费时间 = " + (end - start));
            System.out.println(Arrays.toString((int[]) objects[0]));
            return obj;
        }
        return methodProxy.invokeSuper(o, objects);
    }
}
