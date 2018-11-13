package com.buka.designer.template;

/** 编程是门艺术，设计源于生活！
 */
public abstract class Ticket {

    //模板方法
    public void buyTicket() {
        login();
        selectTicket();
        pay();
    }

    public final void login() {
        System.out.println("登录。。。");
    }

    //子类必须实现
    public abstract void selectTicket();

    //子类可以不实现
    public void pay() {
        System.out.println("支付宝。。。");
    }
}
