package com.github.homespirit.hueaccesscontrol.lights;

import com.github.homespirit.hueaccesscontrol.common.api.Api;
import com.github.homespirit.hueaccesscontrol.common.api.HueRestTemplate;
import com.github.homespirit.hueaccesscontrol.common.api.dto.UpdateStatus;
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

    private HueRestTemplate hueRestTemplate;

    public LightsController(
            HueRestTemplate hueRestTemplate
    ) {
        this.hueRestTemplate = hueRestTemplate;
    }

    @GetMapping
    public ResponseEntity<Map<Integer, Light>> list() {
        return hueRestTemplate.list(LightsApi.DEFINITION);
    }

    @GetMapping("{id}")
    public ResponseEntity<Light> read(@PathVariable int id) {
        return hueRestTemplate.read(LightsApi.DEFINITION, id);
    }

    @PutMapping("{id}")
    public ResponseEntity<List<UpdateStatus<?>>> update(@PathVariable int id, @RequestBody @Valid Light light) {
        return hueRestTemplate.update(LightsApi.DEFINITION, id, light);
    }

}
