package com.github.homespirit.hueaccesscontrol.lights.dto;

import lombok.Data;

import java.util.List;

@Data
public class Capabilities {

    private Boolean certified;

    private Control control;

    private Streaming streaming;

    @Data
    public static class Control {

        private Integer mindimlevel;

        private Integer maxlumen;

        private String colorgamuttype;

        private List<List<Double>> colorgamut; // todo

        private Ct ct;

        @Data
        public static class Ct {

            private Integer min;

            private Integer max;

        }

    }

    @Data
    public static class Streaming {

        private Boolean renderer;

        private Boolean proxy;

    }

}
