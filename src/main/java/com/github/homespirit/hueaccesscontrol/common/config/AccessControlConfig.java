package com.github.homespirit.hueaccesscontrol.common.config;

import lombok.Data;

import java.util.Map;

@Data
public class AccessControlConfig<TConfig> {

    private Map<String, TConfig> profiles;

    @Data
    public static class Grants {
        private int[] ids;

        private String[] operations;
    }
}
