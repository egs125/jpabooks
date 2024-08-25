package com.shop.jpabooks.Repository;

import com.shop.jpabooks.Domain.jpo.MemberJpo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberJpo, String> {
}
