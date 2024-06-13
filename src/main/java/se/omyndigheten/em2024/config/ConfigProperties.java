package se.omyndigheten.em2024.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Krille on 12/06/2024 11:51
 */
@Configuration
public class ConfigProperties {

    @Value("${external:true}")
    private boolean external;

    @Bean
    public boolean external() {
        return external;
    }
}
