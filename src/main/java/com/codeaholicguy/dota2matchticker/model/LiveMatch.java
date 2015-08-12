/**
 *
 */
package com.codeaholicguy.dota2matchticker.model;

import com.codeaholicguy.dota2matchticker.constant.MatchType;

/**
 * @author hoangnn
 */
public class LiveMatch extends Match {

    private String stream;
    private String result;

    public LiveMatch() {
        super();
        setType(MatchType.LIVE_MATCH);
    }

    public LiveMatch(String stream, String result) {
        super();
        setType(MatchType.LIVE_MATCH);
        this.stream = stream;
        this.result = result;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return new org.apache.commons.lang3.builder.ToStringBuilder(this)
                .append("stream", stream)
                .append("result", result)
                .toString();
    }
}
