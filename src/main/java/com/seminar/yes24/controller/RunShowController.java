package com.seminar.yes24.controller;

import com.seminar.yes24.dto.common.ResponseDto;
import com.seminar.yes24.dto.response.RunShowFindDto;
import com.seminar.yes24.service.RunShowService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class RunShowController {

    private final RunShowService runShowService;
    @GetMapping("/runShow/{runShowId}")
    public ResponseDto<RunShowFindDto> getRunShowDetail(
            @PathVariable Long runShowId
    ){
        return ResponseDto.ok(runShowService.findRunShowById(runShowId));
    }
}
