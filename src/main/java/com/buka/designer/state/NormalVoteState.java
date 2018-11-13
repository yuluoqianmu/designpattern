package com.buka.designer.state;

/**
 * Created by shaomaolin on 2018/11/13.
 */
public class NormalVoteState implements VoteState{

    /**
     * 正常投票
     * @param user 投票人
     * @param voteItem 投票项
     * @param context 投票上下文，用来在实现状态对应的功能处理的时候，
     */
    @Override
    public void vote(String user, String voteItem, StateContext context) {
        context.getMapVote().put(user, voteItem);
        System.out.println("正常投票成功！");
    }
}
