package com.seminar.yes24.repository;

import com.seminar.yes24.domain.Member;
import com.seminar.yes24.domain.RunShow;
import com.seminar.yes24.exception.CustomException;
import com.seminar.yes24.exception.ErrorCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

    default Member findMemberById(Long id) {
        return findById(id)
                .orElseThrow(
                        () -> new CustomException(ErrorCode.MEMBER_NOT_FOUND)
                );
    }
}
