package com.family.families.controller;

import com.family.families.exceptions.MemberNotFoundException;
import com.family.families.model.Member;
import com.family.families.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MemberController {

    @Autowired
    MemberService memberService;


    @GetMapping("/member/{id}")
    public Member getMember(@PathVariable(value = "id")Long id) throws MemberNotFoundException {
        return memberService.getMember(id);
    }


    @GetMapping("/member/family/{id}")
    public List<Member> getMemberByFamily(@PathVariable(value = "id")Long id) throws MemberNotFoundException {
        return memberService.getMemberByFamilyId(id);
    }

    @PostMapping("/member")
    public Member createMember(Member member) throws MemberNotFoundException {
        return memberService.createMember(member);
    }

    @PutMapping("/member")
    public Member updateMember(Member member) throws MemberNotFoundException {
        return memberService.updateMember(member);
    }

    @PatchMapping("/member")
    public Member patchMember(Member member) throws MemberNotFoundException {
        return memberService.updateMember(member);
    }
    @DeleteMapping("/member")
    public void deleteMember(Member member) throws MemberNotFoundException {
        memberService.deleteMember(member);
    }
    
}
