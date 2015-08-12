/**
 *
 */
package com.codeaholicguy.dota2matchticker.model;

import com.codeaholicguy.dota2matchticker.constant.MatchType;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author hoangnn
 */
public class RecentResultMatch extends Match {

    private String result;
    private Team winner;

    public RecentResultMatch() {
        super();
        setType(MatchType.RECENT_MATCH);
    }

    public RecentResultMatch(String result, Team winner) {
        super();
        setType(MatchType.RECENT_MATCH);
        this.result = result;
        this.winner = winner;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Team getWinner() {
        return winner;
    }

    public void setWinner(Team winner) {
        this.winner = winner;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("result", result)
                .append("winner", winner)
                .toString();
    }
}
