package com.github.homespirit.hueaccesscontrol.groups;

import com.github.homespirit.hueaccesscontrol.bridge.Api;
import com.github.homespirit.hueaccesscontrol.bridge.dto.DeleteStatus;
import com.github.homespirit.hueaccesscontrol.bridge.dto.UpdateStatus;
import com.github.homespirit.hueaccesscontrol.groups.dto.Group;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
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

    @GetMapping("{id}")
    public ResponseEntity<Group> read(@PathVariable int id) {
        return api.read(id);
    }

    @PutMapping("{id}")
    public ResponseEntity<List<UpdateStatus<?>>> update(@PathVariable int id, @RequestBody @Valid Group group) {
        return api.update(id, group);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<List<DeleteStatus>> delete(@PathVariable int id) {
        return api.delete(id);
    }


}
