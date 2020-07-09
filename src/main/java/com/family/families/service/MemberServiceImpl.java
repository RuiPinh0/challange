package com.family.families.service;

import com.family.families.exceptions.IsParentException;
import com.family.families.exceptions.MemberNotFoundException;
import com.family.families.exceptions.NoResultFoundException;
import com.family.families.model.Family;
import com.family.families.model.HighestFamilyAccAge;
import com.family.families.model.HighestFamilyRatio;
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
        return memberRepository.findByFamilyId(id);
    }

    @Override
    public void putMember(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member patchMember(Member member) {
        Member memberAux = memberRepository
                .findById(member.getId())
                .orElseThrow(() -> new MemberNotFoundException(member.getId()));

        replaceUpdatableFields(memberAux, member);

        return memberRepository.save(memberAux);
    }

    @Override
    public List<HighestFamilyAccAge> getFamilyHigherAccumulatedAge() {
        List<HighestFamilyAccAge> highestFamilyAccAges = memberRepository.findHigherFamilyAccumulatedAge();

        if(highestFamilyAccAges.isEmpty()){
            throw new NoResultFoundException();
        }
        return highestFamilyAccAges;
    }

    @Override
    public List<HighestFamilyRatio> getFamilyHigherAgeRatio() {
        List<HighestFamilyRatio> highestFamilyRatios = memberRepository.findFamilyWithHighestAgeRatio();

        if(highestFamilyRatios.isEmpty()){
            throw new NoResultFoundException();
        }
        return highestFamilyRatios;
    }

    @Override
    public List<Member> getPossibleDuplicates() {
        List<Member> possibleDuplicates = memberRepository.getPossibleDuplicates();

        if(possibleDuplicates.isEmpty()){
            throw new NoResultFoundException();
        }
        return possibleDuplicates;
    }

    private void replaceUpdatableFields(Member memberAux, Member member) {
        if(member.getBirthDate()!=null && !member.getBirthDate().equals(memberAux.getBirthDate())){
            memberAux.setBirthDate(member.getBirthDate());
        }
        if(member.getFirstName()!=null && !member.getFirstName().equalsIgnoreCase(memberAux.getFirstName())){
            memberAux.setFirstName(member.getFirstName());
        }
        if(member.getMiddleName()!=null && !member.getMiddleName().equalsIgnoreCase(memberAux.getMiddleName())){
            memberAux.setMiddleName(member.getMiddleName());
        }
        if(member.getLastName()!=null && !member.getLastName().equalsIgnoreCase(memberAux.getLastName())){
            memberAux.setLastName(member.getLastName());
        }
        if(member.getFatherId()!=null && !member.getFatherId().equals(memberAux.getFatherId())){
            memberAux.setFatherId(member.getFatherId());
        }
        if(member.getMotherId()!=null && !member.getMotherId().equals(memberAux.getMotherId())){
            memberAux.setMotherId(member.getMotherId());
        }
        if(member.getSpouseId()!=null && !member.getSpouseId().equals(memberAux.getSpouseId())){
            memberAux.setSpouseId(member.getSpouseId());
        }
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
