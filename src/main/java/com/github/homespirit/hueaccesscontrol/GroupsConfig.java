package com.github.homespirit.hueaccesscontrol;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@ConfigurationProperties(prefix = "hue")
@Data
public class GroupsConfig {

    private Map<String, Config> profiles;

    @Data
    public static class Config {

        private Operations[] groups;

    }

    @Data
    public static class Operations {

        public int[] ids;

        public String[] operations;

    }

}

