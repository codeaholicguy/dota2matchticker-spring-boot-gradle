package com.codeaholicguy.dota2matchticker.config.cache;

import com.codeaholicguy.dota2matchticker.constant.PropertyName;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.config.CacheConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author hoangnn
 */
@Configuration
public class EhCacheConfiguration {

    @Value(PropertyName.CACHE_NAME)
    private String cacheName;

    @Value(PropertyName.CACHE_POLICY)
    private String cachePolicy;

    @Value(PropertyName.CACHE_SIZE)
    private long cacheSize;

    @Value(PropertyName.CACHE_ETERNAL)
    private boolean cacheEternal;

    @Bean
    public EhCacheCacheManager ehCacheCacheManager() {
        CacheConfiguration cacheConfiguration = new CacheConfiguration();
        cacheConfiguration.setName(cacheName);
        cacheConfiguration.setMemoryStoreEvictionPolicy(cachePolicy);
        cacheConfiguration.setMaxEntriesLocalHeap(cacheSize);
        cacheConfiguration.eternal(cacheEternal);

        net.sf.ehcache.config.Configuration configuration = new net.sf.ehcache.config.Configuration();
        configuration.addCache(cacheConfiguration);

        return new EhCacheCacheManager(CacheManager.newInstance(configuration));
    }

}
