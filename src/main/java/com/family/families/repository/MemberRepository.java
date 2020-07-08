package com.family.families.repository;

import com.family.families.model.Family;
import com.family.families.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long>, JpaSpecificationExecutor {

    List<Member> findByFamily(Long id);

    List<Member> findByFamily(Family id);

    List<Member>findByMother_Id(Long id);

    List<Member>findByFather_Id(Long id);

}
