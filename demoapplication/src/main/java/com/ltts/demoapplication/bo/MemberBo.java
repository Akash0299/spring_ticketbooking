package com.ltts.demoapplication.bo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ltts.demoapplication.model.Member;

@Repository
public interface MemberBo extends JpaRepository<Member, String> {

}
