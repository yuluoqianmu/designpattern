package com.buka.designer.state;

import org.springframework.util.StringUtils;

/**
 * Created by shaomaolin on 2018/11/13.
 */
public class SpiteVoteState implements VoteState{

    /**
     *
     * @param user 投票人
     * @param voteItem 投票项
     * @param context 投票上下文，用来在实现状态对应的功能处理的时候，可以回调上下文的数据
     */
    @Override
    public void vote(String user, String voteItem, StateContext context) {
        String str = context.getMapVote().get(user);

        if (!StringUtils.isEmpty(str)) {
            context.getMapVote().remove(user);
        }
        System.out.println("你有恶意刷屏行为，取消投票资格!");
    }
}
