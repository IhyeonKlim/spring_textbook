package com.JYSHS.AfterSchool.login;

import com.JYSHS.AfterSchool.aggregate.user.MemberEntity;
import org.springframework.stereotype.Repository;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class MemberStore implements MemberRepository{
    private Map<String, MemberEntity> map;

    public MemberStore(){
        this.map = new LinkedHashMap<>();
    }

    @Override
    public Optional<MemberEntity> findByEmail(String userEmail) {
        return Optional.empty();
    }

    @Override
    public MemberEntity save(MemberEntity member) {
        return null;
    }
}
