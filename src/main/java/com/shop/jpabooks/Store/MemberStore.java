package com.shop.jpabooks.Store;

import com.shop.jpabooks.Domain.jpo.MemberJpo;
import com.shop.jpabooks.Domain.model.MemberDto;
import com.shop.jpabooks.Repository.MemberRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class MemberStore {

    @PersistenceContext
    EntityManager em;

    private MemberRepository memberRepository;

    public MemberStore(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

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
        try {
            Optional<MemberJpo> entity = this.memberRepository.findById(member.getId());
            if ( entity.isPresent() ) {
                throw new Exception("eeee");
            }
        } catch (Exception e) {
            System.out.println("중복");
        }

        this.memberRepository.save(MemberDto.toJpo(member));
    }

    public void update(MemberDto member) {
        try {
            MemberJpo entity = this.memberRepository.findById(member.getId()).orElse(null);
            if ( null != entity ) {
                entity.setUserName(member.getUserName());
                this.memberRepository.save(entity);
            } else {
                System.out.println("@@@@@@@@");
            }


        } catch (Exception e) {
            System.out.println("그런 사람 없습니다");
        }
    }

}
