package com.github.homespirit.hueaccesscontrol.scenes;

import com.github.homespirit.hueaccesscontrol.bridge.Api;
import com.github.homespirit.hueaccesscontrol.bridge.dto.DeleteStatus;
import com.github.homespirit.hueaccesscontrol.bridge.dto.UpdateStatus;
import com.github.homespirit.hueaccesscontrol.scenes.dto.Scene;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(ScenesController.PATH)
public class ScenesController {

    public static final String PATH = Api.BASE_PATH + "/scenes";

    private ScenesApi api;

    public ScenesController(
            ScenesApi api
    ) {
        this.api = api;
    }

    @GetMapping
    public ResponseEntity<Map<String, Scene>> list() {
        return api.list();
    }

    @GetMapping("{id}")
    public ResponseEntity<Scene> read(@PathVariable String id) {
        return api.read(id);
    }

    @PutMapping("{id}")
    public ResponseEntity<List<UpdateStatus<?>>> update(@PathVariable String id, @RequestBody @Valid Scene group) {
        return api.update(id, group);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<List<DeleteStatus>> delete(@PathVariable String id) {
        return api.delete(id);
    }


}
