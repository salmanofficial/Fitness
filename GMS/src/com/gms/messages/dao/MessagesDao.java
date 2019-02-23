package com.gms.messages.dao;

import java.util.List;

import com.gms.exceptions.GMSException;
import com.gms.messges.bean.InboxBean;
import com.gms.messges.bean.MessageBean;
import com.gms.user.beans.UserBean;

public interface MessagesDao {
	public boolean sendMail(MessageBean messageBean,UserBean userBean) throws GMSException, Exception;
	public List<InboxBean> inboxMails(UserBean userBean,Boolean flag) throws GMSException;
}
