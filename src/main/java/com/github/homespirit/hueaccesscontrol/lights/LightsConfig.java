package com.github.homespirit.hueaccesscontrol.lights;

import com.github.homespirit.hueaccesscontrol.common.config.AccessControlConfig;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "hue")
public class LightsConfig extends AccessControlConfig<LightsConfig.ResourceConfig> {

    @Data
    public static class ResourceConfig {
        private Grants[] lights;
    }

}
