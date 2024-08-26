package com.shop.jpabooks.Service;

import com.shop.jpabooks.Domain.model.MemberDto;
import com.shop.jpabooks.Store.MemberStore;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberStore memberStore;

    public MemberDto findById(String id) {
        return this.memberStore.findById(id);
    }

    public List<MemberDto> findAll() {
        return this.memberStore.findAll();
    }

    @Transactional
    public void register(MemberDto member) {
        this.memberStore.register(member);
    }

    @Transactional
    public void update(MemberDto member) {
        this.memberStore.update(member);
    }
}
