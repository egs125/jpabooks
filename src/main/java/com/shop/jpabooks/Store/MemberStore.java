package com.shop.jpabooks.Store;

import com.shop.jpabooks.Domain.jpo.MemberJpo;
import com.shop.jpabooks.Domain.model.MemberDto;
import com.shop.jpabooks.Repository.MemberRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class MemberStore {

    @PersistenceContext
    EntityManager em;

    private final MemberRepository memberRepository;

    public MemberDto findById(String id) {
        MemberDto result = null;

        Optional<MemberJpo> member = this.memberRepository.findById(id);
        if ( member.isPresent() ) {
            result = MemberJpo.toDto(member.get());
        }

        return result;
    }

    public List<MemberDto> findAll() {
        List<MemberJpo> members = this.memberRepository.findAll();
        return members.stream().map(MemberJpo::toDto).collect(Collectors.toList());
    }

    public void register(MemberDto member) {
        Optional<MemberJpo> entity = this.memberRepository.findById(member.getId());
        if ( entity.isPresent() ) {
            throw new IllegalStateException("중복");
        }

        this.memberRepository.save(MemberDto.toJpo(member));
    }

    public void update(MemberDto member) {
        MemberJpo entity = this.memberRepository.findById(member.getId()).orElse(null);
        if ( null == entity ) {
            throw new IllegalStateException("Not found user");
        }

        entity.setUserName(member.getUserName());
        this.memberRepository.save(entity);
    }

}
