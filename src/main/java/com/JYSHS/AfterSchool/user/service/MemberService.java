package com.JYSHS.AfterSchool.user.service;

import com.JYSHS.AfterSchool.aggregate.club.CommunityMember;
import com.JYSHS.AfterSchool.user.service.sdo.MemberCdo;
import com.JYSHS.AfterSchool.shared.NameValueList;

import java.util.List;

public interface MemberService {
	//
	String registerMember(MemberCdo member);
	CommunityMember findMemberById(String memberId);
	CommunityMember findMemberByEmail(String memberEmail);
	List<CommunityMember> findMembersByName(String name);
	void modifyMember(String memberId, NameValueList member);
	void removeMember(String memberId);
}