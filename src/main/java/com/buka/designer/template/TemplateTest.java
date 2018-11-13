package com.buka.designer.template;

/**
 * 测试
 */
public class TemplateTest {

    public static void main(String[] args) {

        Ticket trainTicket = new TrainTicket();
        trainTicket.buyTicket();

        Ticket shipTicket = new ShipTicket();
        shipTicket.buyTicket();

    }
}
