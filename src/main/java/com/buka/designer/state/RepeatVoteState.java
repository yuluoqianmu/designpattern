package com.buka.designer.state;

/**
 * Created by shaomaolin on 2018/11/13.
 */
public class RepeatVoteState implements VoteState{

    /**
     *
     * @param user 投票人
     * @param voteItem 投票项
     * @param context 投票上下文，用来在实现状态对应的功能处理的时候，
     */
    @Override
    public void vote(String user, String voteItem, StateContext context) {
        System.out.println("请不要重复投票！");
    }
}
