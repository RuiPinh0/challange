package com.family.families.service;

import com.family.families.model.HighestFamilyAccAge;
import com.family.families.model.HighestFamilyRatio;
import com.family.families.model.Member;

import java.util.List;

public interface MemberService {

    Member getMember(Long id);

    void deleteMember(Member member);

    Member createMember(Member member);

    List<Member> getMemberByFamilyId(Long id);

    void putMember(Member member);

    Member patchMember(Member member);

    List<HighestFamilyAccAge> getFamilyHigherAccumulatedAge();

    List<HighestFamilyRatio> getFamilyHigherAgeRatio();

    List<Member> getPossibleDuplicates();
}
