package com.buka.designer.state;

/**
 * Created by shaomaolin on 2018/11/13.
 */
public class Client {
    public static void main(String[] args) {
        StateContext context = new StateContext();

        for (int i=0; i<10; ++i) {
            context.vote("张三", "A");
        }
    }
}
