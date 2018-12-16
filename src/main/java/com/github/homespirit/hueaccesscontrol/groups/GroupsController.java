package com.github.homespirit.hueaccesscontrol.groups;

import com.github.homespirit.hueaccesscontrol.bridge.Api;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(GroupsController.PATH)
public class GroupsController {

    public static final String PATH = Api.BASE_PATH + "/groups";

}
