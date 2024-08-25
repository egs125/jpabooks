package com.shop.jpabooks.Service;

import com.shop.jpabooks.Domain.model.MemberDto;
import com.shop.jpabooks.Store.MemberStore;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    private MemberStore memberStore;

    public MemberService(MemberStore memberStore) {
        this.memberStore = memberStore;
    }

    public MemberDto findById(String id) {
        return this.memberStore.findById(id);
    }

    @Transactional(readOnly = true)
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
