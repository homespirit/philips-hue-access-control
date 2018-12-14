package com.github.homespirit.hueaccesscontrol.summary;

import com.github.homespirit.hueaccesscontrol.bridge.Api;
import com.github.homespirit.hueaccesscontrol.summary.dto.Summary;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(SummaryController.PATH)
public class SummaryController {

    public static final String PATH = Api.BASE_PATH;


    private SummaryApi api;

    public SummaryController(SummaryApi api) {
        this.api = api;
    }

    @GetMapping
    public ResponseEntity<Summary> summarize() {
        return api.list();
    }

}
