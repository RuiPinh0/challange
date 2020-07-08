package com.family.families.service;

import com.family.families.model.Family;
import com.family.families.model.Member;

import java.util.List;

public interface MemberService {

    Member getMember(Long id);

    List<Member> getByFamilyId(Long id);

    List<Member> getByFamilyId(Family family);

    Member updateMember(Member member);

    void deleteMember(Member member);

    Member createMember(Member member);

    List<Member> getMemberByFamilyId(Long id);
}
