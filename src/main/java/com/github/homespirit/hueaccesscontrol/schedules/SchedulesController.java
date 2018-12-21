package com.github.homespirit.hueaccesscontrol.schedules;

import com.github.homespirit.hueaccesscontrol.bridge.Api;
import com.github.homespirit.hueaccesscontrol.bridge.dto.DeleteStatus;
import com.github.homespirit.hueaccesscontrol.bridge.dto.UpdateStatus;
import com.github.homespirit.hueaccesscontrol.schedules.dto.Schedule;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(SchedulesController.PATH)
public class SchedulesController {

    public static final String PATH = Api.BASE_PATH + "/schedules";

    private SchedulesApi api;

    public SchedulesController(
            SchedulesApi api
    ) {
        this.api = api;
    }

    @GetMapping
    public ResponseEntity<Map<Integer, Schedule>> list() {
        return api.list();
    }

    @GetMapping("{id}")
    public ResponseEntity<Schedule> read(@PathVariable int id) {
        return api.read(id);
    }

    @PutMapping("{id}")
    public ResponseEntity<List<UpdateStatus<?>>> update(@PathVariable int id, @RequestBody @Valid Schedule schedule) {
        return api.update(id, schedule);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<List<DeleteStatus>> delete(@PathVariable int id) {
        return api.delete(id);
    }


}
