package com.buka.designer.state;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shaomaolin on 2018/11/12.
 */
public class StateContext {

    //持有状体处理对象
    private VoteState state;
    //记录用户投票结果
    private Map<String, String> mapVote = new HashMap<>();
    //记录用户投票次数
    private Map<String, Integer> mapVoteCount = new HashMap<>();

    //获取投票结果
    public Map<String, String> getMapVote() {
        return mapVote;
    }

    //投票
    public void vote(String user, String voteItem) {
        Integer oldVoteCount = mapVoteCount.get(user);

        if (oldVoteCount == null)
            oldVoteCount = 0;
        oldVoteCount += 1;

        mapVoteCount.put(user, oldVoteCount);

        if (oldVoteCount == 1) {
            state = new NormalVoteState();
        } else if (oldVoteCount > 1 && oldVoteCount < 5) {
            state = new RepeatVoteState();
        } else if (oldVoteCount >= 5 && oldVoteCount <= 8) {
            state = new SpiteVoteState();
        } else if (oldVoteCount > 8) {
            state = new BlackVoteState();
        }

        state.vote(user, voteItem, this);

    }

}
