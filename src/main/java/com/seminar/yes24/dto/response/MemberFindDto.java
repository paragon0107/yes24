package com.seminar.yes24.dto.response;

import com.seminar.yes24.domain.Member;

public record MemberFindDto(
        Long id
) {
    public static MemberFindDto of(Member member){

        return new MemberFindDto(member.getMemberId());

    }
}
