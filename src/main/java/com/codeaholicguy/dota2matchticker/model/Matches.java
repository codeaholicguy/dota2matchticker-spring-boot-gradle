/**
 *
 */
package com.codeaholicguy.dota2matchticker.model;

import java.util.List;

/**
 * @author hoangnn
 */
public class Matches {

    private String type;
    private List<? extends Match> matches;

    public Matches() {
    }

    public Matches(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<?> getMatches() {
        return matches;
    }

    public void setMatches(List<? extends Match> matches) {
        this.matches = matches;
    }

    @Override
    public String toString() {
        return new org.apache.commons.lang3.builder.ToStringBuilder(this)
                .append("type", type)
                .append("matches", matches)
                .toString();
    }
}
