package com.github.homespirit.hueaccesscontrol.bridge.dto;

import lombok.Data;

@Data
public class Device {

    private String name;

    private SoftwareUpdate swupdate;

    private String swconfigid;

    private String productid;

    private String uniqueid;

}
