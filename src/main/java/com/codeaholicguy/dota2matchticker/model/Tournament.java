/**
 *
 */
package com.codeaholicguy.dota2matchticker.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author hoangnn
 */
public class Tournament {

    private String name;
    private String logo;

    public Tournament() {
    }

    public Tournament(String name, String logo) {
        this.name = name;
        this.logo = logo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("name", name)
                .append("logo", logo)
                .toString();
    }
}
