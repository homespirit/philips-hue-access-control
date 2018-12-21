package com.github.homespirit.hueaccesscontrol.schedules;

import com.github.homespirit.hueaccesscontrol.bridge.api.HueCrudApi;
import com.github.homespirit.hueaccesscontrol.schedules.dto.Schedule;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class SchedulesApi extends HueCrudApi<Integer, Schedule> {

    @Override
    public String path() {
        return "/schedules";
    }

    @Override
    public ParameterizedTypeReference<Map<Integer, Schedule>> listResponseType() {
        return new ParameterizedTypeReference<>() {
        };
    }

    @Override
    public ParameterizedTypeReference<Schedule> readResponseType() {
        return new ParameterizedTypeReference<>() {
        };
    }
}
