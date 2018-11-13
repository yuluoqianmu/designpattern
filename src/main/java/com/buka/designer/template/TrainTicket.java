package com.buka.designer.template;

/**
 * 火车票
 */
public class TrainTicket extends Ticket{

    @Override
    public void selectTicket() {
        System.out.println("选择火车票。。。");
    }

    @Override
    public void pay() {

        System.out.println("使用微信支付。。。");

    }
}
