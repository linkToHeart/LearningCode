package com.jvm.oom;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 随着JDK8的到来，JVM不再有PermGen。但类的元数据信息（metadata）还在，只不过不再是存储在连续的堆空间上，而是移动到叫做“Metaspace”的本地内存（Native memory）中。
 * 因为PermSpace（永久保存区域）在java8之后就放在了Heap中，所以java8之后就移除了PermSize和MaxPermSize这两个参数
 * VM Args:-XX:PermSize=10M -XX:MaxPermSize=10M
 */
public class JavaMethodAreaOOM {
    public static void main(String[] args) {
        while(true){
            /**Spring、Hibernate等对类进行增强时使用CGLib字节码技术，增强的越多，
             * 就需要越大的方法区来保证动态生成的Class可以载入内存*/
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setCallback(new MethodInterceptor() {
                public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                    return methodProxy.invokeSuper(o, objects);
                }
            });
            enhancer.create();
        }
    }

    static class OOMObject {

    }
}
