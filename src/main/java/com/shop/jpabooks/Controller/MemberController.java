package com.shop.jpabooks.Controller;

import com.shop.jpabooks.Domain.model.MemberDto;
import com.shop.jpabooks.Service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/member")
@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/{id}")
    public MemberDto findById(@PathVariable String id) {
        return this.memberService.findById(id);
    }

    @GetMapping("/all")
    public List<MemberDto> findAll() {
        return this.memberService.findAll();
    }

    @PostMapping
    public void register(@RequestBody MemberDto member) {
        this.memberService.register(member);
    }

    @PutMapping
    public void update(@RequestBody MemberDto member) {
        this.memberService.update(member);
    }
}
