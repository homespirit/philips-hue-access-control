package com.github.homespirit.hueaccesscontrol.common.api;

import java.util.regex.Pattern;

public class Api {

    public static final String BASE_PATH = "/api/{userId}";

    public static final Pattern USER_ID_PATTERN = Pattern.compile("(?<=^\\/api\\/)(?!\\/).*(?=\\/)");

}
