package com.JYSHS.AfterSchool.login;

import com.JYSHS.AfterSchool.aggregate.user.MemberEntity;

import java.util.Optional;


public interface MemberRepository {
    Optional<MemberEntity> findByEmail(String userEmail);

    public MemberEntity save(MemberEntity member);

}