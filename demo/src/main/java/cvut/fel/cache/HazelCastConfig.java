package cvut.fel.cache;

import com.hazelcast.config.Config;
import com.hazelcast.config.MapConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HazelCastConfig {
    @Bean
    public Config myHazelCastConfig() {
        Config config = new Config();

        // books cache
        MapConfig mapConfig = new MapConfig();
        mapConfig.setName("booksCache");
        mapConfig.setTimeToLiveSeconds(600); // TTL of 10 minutes
        config.getMapConfigs().put("booksCache", mapConfig);

        // authors cache
        MapConfig libraryMapConfig = new MapConfig();
        libraryMapConfig.setName("libraryCache");
        libraryMapConfig.setTimeToLiveSeconds(600); // TTL of 10 minutes
        config.getMapConfigs().put("libraryCache", libraryMapConfig);

        // publisher cache
        MapConfig publisherMapConfig = new MapConfig();
        publisherMapConfig.setName("publisherCache");
        publisherMapConfig.setTimeToLiveSeconds(600); // TTL of 10 minutes
        config.getMapConfigs().put("publisherCache", publisherMapConfig);

        return config;
    }
}

