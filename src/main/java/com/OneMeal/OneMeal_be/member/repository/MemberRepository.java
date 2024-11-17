package com.OneMeal.OneMeal_be.member.repository;

import com.OneMeal.OneMeal_be.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {
    Optional<Member> findByUsername(String username);
    Boolean existsByUsername(String username);
    Member save(Member member);
}
