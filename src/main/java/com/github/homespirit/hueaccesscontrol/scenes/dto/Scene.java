package com.github.homespirit.hueaccesscontrol.scenes.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Scene {

    private String name;

    private String type;

    private String group;

    private List<String> lights;

    private String owner;

    private Boolean recycle;

    private Boolean locked;

    private AppData appdata;

    private String picture;

    private String lastupdated;

    private Integer version;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class AppData {

        private Integer version;

        private String data;

    }

}
