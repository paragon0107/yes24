package com.seminar.yes24.controller;

import com.seminar.yes24.dto.common.ResponseDto;
import com.seminar.yes24.dto.response.RunShowFindDto;
import com.seminar.yes24.dto.response.RunShowSearchDto;
import com.seminar.yes24.service.RunShowService;
import lombok.RequiredArgsConstructor;
import org.hibernate.dialect.unique.CreateTableUniqueDelegate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class RunShowController {
    private final RunShowService runShowService;

    @GetMapping("/runshow/{runShowId}")
    public ResponseDto<RunShowFindDto> getRunShowDetail(
            @PathVariable Long runShowId
    ){
        return ResponseDto.ok(runShowService.findRunShowById(runShowId));
    }

    @PostMapping("/runshow/book/{runShowId}")
    public ResponseDto<Long> bookRunShow(
            @RequestHeader Long memberId,
            @PathVariable Long runShowId
    ){
        return ResponseDto.created(runShowService.saveBookingById(memberId,runShowId));
    }

    @GetMapping("/runshow/search")
    public ResponseDto<List<RunShowSearchDto>> getRunShowSearch(
            @RequestParam String query
    ){
        return ResponseDto.ok(runShowService.findRunShowByKeyWord(query));
    }
}
