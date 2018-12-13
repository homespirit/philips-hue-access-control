package com.github.homespirit.hueaccesscontrol.lights;

import com.github.homespirit.hueaccesscontrol.lights.dto.LightState;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(LightsController.PATH + "/{id}/state")
public class LightStateController {

    private LightStateApi lightStateApi;

    public LightStateController(LightStateApi lightStateApi) {
        this.lightStateApi = lightStateApi;
    }

    @PutMapping
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody @Valid LightState lightState) {
        return lightStateApi.update(id, lightState);
    }

}
