package com.sst.dao;

import java.util.List;

import com.sst.model.Question;

public interface QuestionDao 
{
	public int insertquestion(Question question);
	public List getDisableMember();
	
}
