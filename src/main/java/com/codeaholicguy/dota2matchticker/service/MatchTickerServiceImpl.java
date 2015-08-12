/**
 *
 */
package com.codeaholicguy.dota2matchticker.service;

import com.codeaholicguy.dota2matchticker.constant.MatchType;
import com.codeaholicguy.dota2matchticker.constant.PropertyName;
import com.codeaholicguy.dota2matchticker.model.Matches;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author hoangnn
 */
@Service
public class MatchTickerServiceImpl implements MatchTickerService {

    @Autowired
    private CacheManager ehCacheCacheManager;

    @Value(PropertyName.CACHE_NAME)
    private String cacheName;

    @Override
    public Matches getUpCommingMatchs() throws IOException {
        return (Matches) ehCacheCacheManager.getCache(cacheName).get(MatchType.UPCOMMING_MATCH).get();
    }

    @Override
    public Matches getRecentResultMatchs() throws IOException {
        return (Matches) ehCacheCacheManager.getCache(cacheName).get(MatchType.RECENT_MATCH).get();
    }

    @Override
    public Matches getLiveMatchs() throws IOException {
        return (Matches) ehCacheCacheManager.getCache(cacheName).get(MatchType.LIVE_MATCH).get();
    }

}
