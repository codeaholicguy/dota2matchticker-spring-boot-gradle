/**
 *
 */
package com.codeaholicguy.dota2matchticker.job;

import com.codeaholicguy.dota2matchticker.constant.MatchType;
import com.codeaholicguy.dota2matchticker.constant.PropertyName;
import com.codeaholicguy.dota2matchticker.parser.GosuGamersParser;
import net.sf.ehcache.CacheException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.annotation.PostConstruct;
import java.io.IOException;

/**
 * @author hoangnn
 */
@Component
public class GosuGamersParsingJob {

    private static final Log LOGGER = LogFactory.getLog(GosuGamersParsingJob.class);

    private static final Integer INTERVAL = 120000;

    @Autowired
    private CacheManager ehCacheCacheManager;

    @Value(PropertyName.CACHE_NAME)
    private String cacheName;

    private TaskScheduler scheduler = new ConcurrentTaskScheduler();

    @PostConstruct
    private void executeJob() {
        scheduler.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                executeParsing();
            }
        }, INTERVAL);
    }

    /**
     * Parse from gosugamer.
     */
    private void executeParsing() throws CacheException {
        try {
            Long start = System.currentTimeMillis();
            Cache matchesCache = ehCacheCacheManager.getCache(cacheName);
            matchesCache.put(MatchType.LIVE_MATCH, GosuGamersParser.getInstance().getLiveMatches());
            matchesCache.put(MatchType.UPCOMMING_MATCH, GosuGamersParser.getInstance().getUpCommingMatches());
            matchesCache.put(MatchType.RECENT_MATCH, GosuGamersParser.getInstance().getRecentResultMatches());
            Long end = System.currentTimeMillis();
            LOGGER.info("finish parsing: " + ((end - start) / 1000) + "s");
        } catch (IllegalArgumentException | IllegalStateException | IOException e) {
            LOGGER.error(e.getMessage());
        }
    }
}
