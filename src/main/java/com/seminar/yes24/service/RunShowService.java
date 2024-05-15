package com.seminar.yes24.service;

import com.seminar.yes24.dto.response.RunShowFindDto;
import com.seminar.yes24.repository.RunShowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RunShowService {

    private final RunShowRepository runShowRepository;
    public RunShowFindDto findRunShowById(Long runShowId){
        return RunShowFindDto.of(runShowRepository.findRunShowById(runShowId));
    }
}
