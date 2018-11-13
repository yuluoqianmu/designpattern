package com.buka.designer.state;

/**
 * Created by shaomaolin on 2018/11/13.
 */
public class BlackVoteState implements VoteState{

    /**
     *
     * @param user 投票人
     * @param voteItem 投票项
     * @param context 投票上下文，用来在实现状态对应的功能处理的时候，可以回调上下文的数据
     */
    @Override
    public void vote(String user, String voteItem, StateContext context) {
        //记录黑名单中，禁止登录系统
        System.out.println("进入黑名单，将禁止登录和使用本系统");
    }
}
