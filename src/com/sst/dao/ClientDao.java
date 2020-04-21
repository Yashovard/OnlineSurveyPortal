package com.sst.dao;

import java.util.List;

import com.sst.model.Client;
/**
 *
 * @author Yashovardhan Singh 
 */
public interface ClientDao 
{
	public int insertClient(Client client);
	public int insertintoregistration_table(String cemail_id,String password);
	public int updateClinet(Client client);
	public Client getFromcregistration(String email_id);
	public List GetEnableClient();
	public List getDisableClient();
}
