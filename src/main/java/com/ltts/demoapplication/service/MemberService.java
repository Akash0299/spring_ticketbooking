package com.ltts.demoapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ltts.demoapplication.bo.MemberBo;
import com.ltts.demoapplication.model.Member;

@Service
public class MemberService {
        @Autowired
        MemberBo mb;
        
        public void insertMember(Member m) {
        	mb.save(m);
        }
        
        public Member getMember(String name) {
        	return mb.getById(name);
        }
}
