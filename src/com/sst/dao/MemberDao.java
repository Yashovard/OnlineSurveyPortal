package com.sst.dao;

import java.util.List;

import com.sst.model.Member;


public interface MemberDao
{
	public int insertMember(Member member);
	public int insertintoregistration_table(String email_id,String password );
	public Member getFrommregistration(String email_id);
	public int UpdateProfile(Member member);
	public List getEnableMember();
	public List getDisableMember();
}
