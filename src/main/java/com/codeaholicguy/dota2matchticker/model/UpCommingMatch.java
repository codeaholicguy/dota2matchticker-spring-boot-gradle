/**
 *
 */
package com.codeaholicguy.dota2matchticker.model;

import com.codeaholicguy.dota2matchticker.constant.MatchType;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author hoangnn
 */
public class UpCommingMatch extends Match {

    private String liveIn;

    public UpCommingMatch() {
        super();
        setType(MatchType.UPCOMMING_MATCH);
    }

    public UpCommingMatch(String liveIn) {
        super();
        setType(MatchType.UPCOMMING_MATCH);
        this.liveIn = liveIn;
    }

    public String getLiveIn() {
        return liveIn;
    }

    public void setLiveIn(String liveIn) {
        this.liveIn = liveIn;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("liveIn", liveIn)
                .toString();
    }
}
