package com.buka.designer.state;

/**
 * Created by shaomaolin on 2018/11/12.
 */
public interface VoteState {

    /**
     * 处理状态对应的行为
     * @param user 投票人
     * @param voteItem 投票项
     * @param context 投票上下文，用来在实现状态对应的功能处理的时候，可以回调上下文的数据
     *
     */
    void vote(String user, String voteItem, StateContext context);
}
