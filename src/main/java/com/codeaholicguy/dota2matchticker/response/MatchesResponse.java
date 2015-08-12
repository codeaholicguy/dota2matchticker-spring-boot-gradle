/**
 * 
 */
package com.codeaholicguy.dota2matchticker.response;

import com.codeaholicguy.dota2matchticker.model.Matches;

/**
 * @author hoangnn
 * 
 */

/**
 * @author hoangnn
 * 
 */
public class MatchesResponse extends BaseResponse {

	private Matches data;

	public MatchesResponse() {
	}

	public Matches getData() {
		return data;
	}

	public void setData(Matches data) {
		this.data = data;
	}

}
