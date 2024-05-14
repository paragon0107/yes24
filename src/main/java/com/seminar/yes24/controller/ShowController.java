package com.seminar.yes24.controller;

import com.seminar.yes24.dto.common.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ShowController {
    @GetMapping("/show-main")
    public ResponseDto<>
}
