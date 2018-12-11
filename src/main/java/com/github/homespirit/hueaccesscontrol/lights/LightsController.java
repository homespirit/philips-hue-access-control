package com.github.homespirit.hueaccesscontrol.lights;

import com.github.homespirit.hueaccesscontrol.bridge.Api;
import com.github.homespirit.hueaccesscontrol.bridge.dto.DeleteStatus;
import com.github.homespirit.hueaccesscontrol.bridge.dto.UpdateStatus;
import com.github.homespirit.hueaccesscontrol.lights.dto.Light;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(LightsController.PATH)
public class LightsController {

    public static final String PATH = Api.BASE_PATH + "/lights";


    private LightsApi api;

    public LightsController(
            LightsApi api
    ) {
        this.api = api;
    }

    @GetMapping
    public ResponseEntity<Map<Integer, Light>> list() {
        return api.list();
    }

    @GetMapping("{id}")
    public ResponseEntity<Light> read(@PathVariable int id) {
        return api.read(id);
    }

    @PutMapping("{id}")
    public ResponseEntity<List<UpdateStatus<?>>> update(@PathVariable int id, @RequestBody @Valid Light light) {
        return api.update(id, light);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<List<DeleteStatus>> delete(@PathVariable int id) {
        return api.delete(id);
    }

}
