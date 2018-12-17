package com.github.homespirit.hueaccesscontrol.groups;

import com.github.homespirit.hueaccesscontrol.bridge.Api;
import com.github.homespirit.hueaccesscontrol.groups.dto.Group;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(GroupsController.PATH)
public class GroupsController {

    public static final String PATH = Api.BASE_PATH + "/groups";

    private GroupsApi api;

    public GroupsController(
            GroupsApi api
    ) {
        this.api = api;
    }

    @GetMapping
    public ResponseEntity<Map<Integer, Group>> list() {
        return api.list();
    }

}
