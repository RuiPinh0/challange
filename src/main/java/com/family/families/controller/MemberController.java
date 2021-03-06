package com.family.families.controller;

import com.family.families.exceptions.MemberNotFoundException;
import com.family.families.model.HighestFamilyAccAge;
import com.family.families.model.HighestFamilyRatio;
import com.family.families.model.Member;
import com.family.families.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/member")
public class MemberController {

    @Autowired
    MemberService memberService;


    @GetMapping("/{id}")
    public Member getMember(@PathVariable(value = "id")Long id) throws MemberNotFoundException {
        return memberService.getMember(id);
    }


    @GetMapping("/family/{id}")
    public List<Member> getMemberByFamily(@PathVariable(value = "id")Long id) throws MemberNotFoundException {
        return memberService.getMemberByFamilyId(id);
    }

    @PostMapping
    public Member createMember(@Valid @RequestBody Member member) throws MemberNotFoundException {
        return memberService.createMember(member);
    }

    @PutMapping
    public void updateMember(@Valid @RequestBody Member member) throws MemberNotFoundException {
        memberService.putMember(member);
    }

    @PatchMapping
    public Member patchMember(@Valid @RequestBody Member member) throws MemberNotFoundException {
        return memberService.patchMember(member);
    }
    @DeleteMapping
    public void deleteMember(@Valid @RequestBody Member member) throws MemberNotFoundException {
        memberService.deleteMember(member);
    }

    @GetMapping("/higherage")
    public List<HighestFamilyAccAge> getFamilyHigherAccumulatedAge() throws MemberNotFoundException {
        return memberService.getFamilyHigherAccumulatedAge();
    }


    @GetMapping("/ratio")
    public List<HighestFamilyRatio> getFamilyHigherAgeRatio() throws MemberNotFoundException {
        return memberService.getFamilyHigherAgeRatio();
    }

    @GetMapping("/duplicates")
    public List<Member> getPossibleDuplicates() throws MemberNotFoundException {
        return memberService.getPossibleDuplicates();
    }
}
