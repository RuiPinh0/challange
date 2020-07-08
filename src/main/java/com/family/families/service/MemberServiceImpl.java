package com.family.families.service;

import com.family.families.exceptions.IsParentException;
import com.family.families.exceptions.MemberNotFoundException;
import com.family.families.model.Family;
import com.family.families.model.Member;
import com.family.families.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService{

    @Autowired
    MemberRepository memberRepository;

    @Override
    public Member getMember(Long id) {
        return memberRepository.findById(id).orElseThrow(() -> new MemberNotFoundException(id));
    }

    @Override
    public List<Member> getByFamilyId(Long id) {
        return memberRepository.findByFamily(id);
    }

    @Override
    public List<Member> getByFamilyId(Family family) {
        return memberRepository.findByFamily(family);
    }

    @Override
    public Member updateMember(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public void deleteMember(Member member) {
        if(isParent(member)){
            memberRepository.delete(member);
        }else{
            throw new IsParentException();
        }
    }


    @Override
    public Member createMember(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public List<Member> getMemberByFamilyId(Long id) {
        return memberRepository.findByFamily(id);
    }

    private boolean isParent(Member member) {
        if(!memberRepository.findByMother_Id(member.getId()).isEmpty()){
            return true;
        }
        if(!memberRepository.findByFather_Id(member.getId()).isEmpty()){
            return true;
        }
        return false;
    }
}
