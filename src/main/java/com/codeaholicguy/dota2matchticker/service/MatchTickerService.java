/**
 * 
 */
package com.codeaholicguy.dota2matchticker.service;

import com.codeaholicguy.dota2matchticker.model.Matches;

import java.io.IOException;

/**
/**
 * @author hoangnn
 * 
 */
public interface MatchTickerService {

	Matches getUpCommingMatchs() throws IOException;

	Matches getRecentResultMatchs() throws IOException;

	Matches getLiveMatchs() throws IOException;

}
