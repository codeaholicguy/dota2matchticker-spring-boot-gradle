/**
 *
 */
package com.codeaholicguy.dota2matchticker.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author hoangnn
 */
public class TournamentMatch {

    private String matchUrl;
    private String liveIn;
    private Tournament tournament;

    public TournamentMatch() {
    }

    public TournamentMatch(String matchUrl, String liveIn, Tournament tournament) {
        this.matchUrl = matchUrl;
        this.liveIn = liveIn;
        this.tournament = tournament;
    }

    public String getMatchUrl() {
        return matchUrl;
    }

    public void setMatchUrl(String matchUrl) {
        this.matchUrl = matchUrl;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
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
                .append("matchUrl", matchUrl)
                .append("liveIn", liveIn)
                .append("tournament", tournament)
                .toString();
    }
}
