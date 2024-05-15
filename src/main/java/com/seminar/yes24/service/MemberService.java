package com.seminar.yes24.service;

import com.seminar.yes24.dto.response.MemberFindDto;
import com.seminar.yes24.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;


    public MemberFindDto findMemberById(Long id){
        return MemberFindDto.of(memberRepository.findMemberById(id));
    }


}
