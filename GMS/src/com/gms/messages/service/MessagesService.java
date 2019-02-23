package com.gms.messages.service;

import java.util.List;

import com.gms.exceptions.GMSException;
import com.gms.messges.bean.InboxBean;
import com.gms.messges.bean.MessageBean;
import com.gms.user.beans.UserBean;

public interface MessagesService {
	
	public boolean sendMail(MessageBean messageBean,UserBean userBean) throws GMSException, Exception;
	public List<InboxBean> inboxMails(UserBean userBean,Boolean flag) throws GMSException;

}
