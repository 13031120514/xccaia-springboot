package com.xc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.CacheManager;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.*;

import javax.annotation.Resource;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;


@Configuration
public class RedisConfig {

  @Resource
  private LettuceConnectionFactory lettuceConnectionFactory;
  private Logger logger = LoggerFactory.getLogger(RedisConfig.class);
  private Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
  //过期时间1天
  private Duration timeToLive = Duration.ofDays(1);

/*
  @Bean
  public RedisCacheManager cacheManager(RedisConnectionFactory connectionFactory) {

    RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig()
        .entryTtl(this.timeToLive)
        .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(keySerializer()))
        .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(valueSerializer()))
        .disableCachingNullValues();
    Map<String, RedisCacheConfiguration> cacheConfigurationMap = new HashMap<>();
    cacheConfigurationMap.put("users", config);
    cacheConfigurationMap.put("default", config);
    RedisCacheManager redisCacheManager = RedisCacheManager.builder(connectionFactory)
        .cacheDefaults(config)
        .transactionAware()
        .withInitialCacheConfigurations(cacheConfigurationMap)
        .build();
    logger.debug("自定义RedisCacheManager加载完成");
    return redisCacheManager;
  }
*/


  @Bean
  public RedisCacheConfiguration redisCacheConfiguration(){
    Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
    RedisCacheConfiguration configuration = RedisCacheConfiguration.defaultCacheConfig();
    configuration = configuration.serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(jackson2JsonRedisSerializer)).entryTtl(
        Duration.ofDays(30));
    return configuration;
  }

  @Bean
  public CacheManager cacheManager(RedisConnectionFactory connectionFactory) {
    //初始化一个RedisCacheWriter
    RedisCacheWriter redisCacheWriter = RedisCacheWriter.nonLockingRedisCacheWriter(connectionFactory);
    //设置CacheManager的值序列化方式为 fastJsonRedisSerializer,但其实RedisCacheConfiguration默认使用StringRedisSerializer序列化key，
    Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
    RedisSerializationContext.SerializationPair<Object> pair = RedisSerializationContext.SerializationPair.fromSerializer(jackson2JsonRedisSerializer);
    RedisCacheConfiguration defaultCacheConfig=RedisCacheConfiguration.defaultCacheConfig().serializeValuesWith(pair);
    return new RedisCacheManager(redisCacheWriter, defaultCacheConfig);
  }


  @Bean(name = "redisTemplate")
  public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
    RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
    redisTemplate.setConnectionFactory(redisConnectionFactory);
    redisTemplate.setKeySerializer(keySerializer());
    redisTemplate.setHashKeySerializer(keySerializer());
    redisTemplate.setValueSerializer(valueSerializer());
    redisTemplate.setHashValueSerializer(valueSerializer());
    logger.debug("自定义RedisTemplate加载完成");
    return redisTemplate;
  }

  @Bean(name = "stringRedisTemplate")
  public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
    StringRedisTemplate redisTemplate = new StringRedisTemplate();
    redisTemplate.setConnectionFactory(redisConnectionFactory);
    redisTemplate.setKeySerializer(keySerializer());
    redisTemplate.setHashKeySerializer(keySerializer());
    redisTemplate.setValueSerializer(keySerializer());
    redisTemplate.setHashValueSerializer(valueSerializer());
    logger.debug("自定义StringRedisTemplate加载完成");
    return redisTemplate;
  }

  private RedisSerializer<String> keySerializer() {
    return new StringRedisSerializer();
  }

  private RedisSerializer<Object> valueSerializer() {
    return new GenericJackson2JsonRedisSerializer();
  }

  @Bean
  public KeyGenerator myKeyGenerator() {
    return (target, method, params) -> {
      StringBuilder sb = new StringBuilder();
      sb.append(target.getClass().getName());
      sb.append(method.getName());
      for (Object obj : params) {
        sb.append(obj.toString());
      }
      return sb.toString();
    };
  }
}

