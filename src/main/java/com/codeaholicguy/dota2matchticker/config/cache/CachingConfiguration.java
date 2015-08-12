package com.codeaholicguy.dota2matchticker.config.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.*;
import org.springframework.cache.support.CompositeCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hoangnn
 */
@Configuration
@EnableCaching
public class CachingConfiguration implements CachingConfigurer {

    @Qualifier("ehCacheCacheManager")
    @Autowired(required = false)
    private CacheManager ehCacheCacheManager;

    @Qualifier("redisCacheManager")
    @Autowired(required = false)
    private CacheManager redisCacheManager;

    @Bean
    @Override
    public CacheManager cacheManager() {

        List<CacheManager> cacheManagers = new ArrayList<>();

        if (this.ehCacheCacheManager != null) {
            cacheManagers.add(this.ehCacheCacheManager);
        }

        if (this.redisCacheManager != null) {
            cacheManagers.add(this.redisCacheManager);
        }

        CompositeCacheManager cacheManager = new CompositeCacheManager();

        cacheManager.setCacheManagers(cacheManagers);
        cacheManager.setFallbackToNoOpCache(false);

        return cacheManager;
    }

    @Override
    public CacheResolver cacheResolver() {
        return null;
    }

    @Bean
    @Override
    public KeyGenerator keyGenerator() {
        return new SimpleKeyGenerator();
    }

    @Override
    public CacheErrorHandler errorHandler() {
        return null;
    }
}
