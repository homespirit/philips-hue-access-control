package com.github.homespirit.hueaccesscontrol.schedules.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.homespirit.hueaccesscontrol.lights.dto.LightAction;
import lombok.Data;

import javax.annotation.security.DenyAll;
import java.util.List;
import java.util.Map;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Schedule {

    private String name;

    private String description;

    private Command command;

    private String localtime;

    private String time;

    private String created;

    private String status;

    private Boolean autodelete;

    private String starttime;

    private Boolean recycle;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class Command {

        private String address;

        private CommandBody body;

        private String method;

    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class CommandBody {

        private Integer status;

        private Boolean flag;

        private String scene;

    }

}
