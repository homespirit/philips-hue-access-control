package com.github.homespirit.hueaccesscontrol.rules;

import com.github.homespirit.hueaccesscontrol.bridge.Api;
import com.github.homespirit.hueaccesscontrol.bridge.dto.DeleteStatus;
import com.github.homespirit.hueaccesscontrol.bridge.dto.UpdateStatus;
import com.github.homespirit.hueaccesscontrol.rules.dto.Rule;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(RulesController.PATH)
public class RulesController {

    public static final String PATH = Api.BASE_PATH + "/rules";

    private RulesApi api;

    public RulesController(
            RulesApi api
    ) {
        this.api = api;
    }

    @GetMapping
    public ResponseEntity<Map<Integer, Rule>> list() {
        return api.list();
    }

    @GetMapping("{id}")
    public ResponseEntity<Rule> read(@PathVariable int id) {
        return api.read(id);
    }

    @PutMapping("{id}")
    public ResponseEntity<List<UpdateStatus<?>>> update(@PathVariable int id, @RequestBody @Valid Rule rule) {
        return api.update(id, rule);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<List<DeleteStatus>> delete(@PathVariable int id) {
        return api.delete(id);
    }


}
