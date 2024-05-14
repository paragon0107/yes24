package com.seminar.yes24.service;

import com.seminar.yes24.domain.Show;
import com.seminar.yes24.dto.response.ShowDataDto;
import com.seminar.yes24.dto.response.ShowRankingDto;
import com.seminar.yes24.repository.ShowRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ShowService {
    private final ShowRepository showRepository;

    @Transactional(readOnly = true)
    public List<ShowDataDto> getMainCarasel(){
        Page<Show> page = showRepository.findAll(PageRequest.of(0, 12));
        return page.getContent().stream()
                .map(show -> new ShowDataDto(
                        show.getId(),
                        show.getTitle(),
                        show.getSubTitle(),
                        show.getImg()))
                .collect(Collectors.toList());
    }


}
