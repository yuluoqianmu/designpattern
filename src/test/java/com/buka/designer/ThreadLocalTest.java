package com.buka.designer;

/**
 * Created by shaomaolin on 2018/12/5.
 */
public class ThreadLocalTest {

    static class ResourceClass{
        public final static ThreadLocal<String> RESOURCE_1 = new ThreadLocal<>();
        public final static  ThreadLocal<String> RESOURCE_2 = new ThreadLocal<>();
    }

    static class A {
        public void setOne(String value) {
            ResourceClass.RESOURCE_1.set(value);
        }

        public void setTwo(String value) {
            ResourceClass.RESOURCE_2.set(value);
        }
    }

    static class B {
        public void display() {
            System.out.println(ResourceClass.RESOURCE_1.get()+":"+ResourceClass.RESOURCE_2.get());
        }
    }

    public static void main(String[] args) {
        final A a = new A();
        final B b = new B();

        for (int i=0; i<15; i++) {
            final String resource1 = "线程" + i;
            final String resource2 = " value = (" + i + ")";

            new Thread(){
                public void run() {
                    try {
                        a.setOne(resource1);
                        a.setTwo(resource2);
                        b.display();
                    } finally {
                        ResourceClass.RESOURCE_1.remove();
                        ResourceClass.RESOURCE_2.remove();
                    }
                }
            }.start();
        }
    }
}
