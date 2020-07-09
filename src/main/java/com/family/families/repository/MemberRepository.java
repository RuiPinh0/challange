package com.family.families.repository;

import com.family.families.model.Family;
import com.family.families.model.HighestFamilyAccAge;
import com.family.families.model.HighestFamilyRatio;
import com.family.families.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long>, JpaSpecificationExecutor {

    List<Member> findByFamilyId(Long id);

    List<Member> findByFamily(Family id);

    List<Member>findByMother_Id(Long id);

    List<Member>findByFather_Id(Long id);

    @Query(
            value = "select family_id as familyId, max_age as maxAge from (" +
                        "SELECT family_id, " +
                            "floor(sum(DATEDIFF(dd, birth_date, current_timestamp))/365.25) as max_age, " +
                            "min(birth_date) as older " +
                        "from member group by FAMILY_ID ) t " +
                    "group by family_id " +
                    "having max_age=(select max(max_age) from (" +
                        "SELECT family_id, floor(sum(DATEDIFF(dd, birth_date, current_timestamp))/365.25) as max_age " +
                        "from member group by FAMILY_ID)) " +
                    "order by older ",
            nativeQuery=true)
    List<HighestFamilyAccAge> findHigherFamilyAccumulatedAge();


    @Query( value =
            "select family_id as familyId, round(ratio,'6') as ratio from (" +
                "select family_id, " +
                    "count (*)/(DATEDIFF(dd, min(birth_date),  max(birth_date))/365.25) as ratio, " +
                    "min(birth_date) as oldest " +
                "from member " +
                "group by family_id) " +
            "where ratio = (" +
                    "select max(ratio) " +
                    "from (" +
                        "select family_id, " +
                            "count (*)/(DATEDIFF(dd, min(birth_date),  " +
                            "max(birth_date))/365.25) as ratio " +
                        "from member " +
                        "group by family_id))" +
            "order by oldest",
            nativeQuery=true)
    List<HighestFamilyRatio> findFamilyWithHighestAgeRatio();

    @Query(value = "SELECT a.* " +
            "FROM   member a " +
            "       LEFT JOIN (SELECT * " +
            "                  FROM   (SELECT first_name " +
            "                          FROM   member " +
            "                          GROUP  BY first_name) a, " +
            "                         (SELECT middle_name " +
            "                          FROM   member " +
            "                          GROUP  BY middle_name) b, " +
            "                         (SELECT last_name " +
            "                          FROM   member " +
            "                          GROUP  BY last_name) c " +
            "                  WHERE  middle_name = first_name " +
            "                          OR middle_name = last_name " +
            "                          OR last_name = first_name) c " +
            "              ON a.first_name = c.first_name " +
            "                  OR a.middle_name = c.middle_name " +
            "                  OR a.last_name = c.last_name " +
            "       LEFT JOIN (SELECT family_id, " +
            "                         birth_date, " +
            "                         father_id, " +
            "                         mother_id, " +
            "                         Count(*) " +
            "                  FROM   member " +
            "                  GROUP  BY family_id, " +
            "                            birth_date, " +
            "                            father_id, " +
            "                            mother_id " +
            "                  HAVING Count(*) > 1) b " +
            "              ON a.family_id = b.family_id " +
            "                 AND a.birth_date = b.birth_date " +
            "                 AND a.father_id = b.father_id " +
            "                 AND a.mother_id = b.mother_id " +
            "ORDER  BY a.id, " +
            "          a.birth_date ",
            nativeQuery=true)
    List<Member> getPossibleDuplicates();

}
