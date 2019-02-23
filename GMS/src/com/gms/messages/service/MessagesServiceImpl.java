package com.gms.messages.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gms.exceptions.GMSException;
import com.gms.messages.dao.MessagesDao;
import com.gms.messges.bean.InboxBean;
import com.gms.messges.bean.MessageBean;
import com.gms.user.beans.UserBean;
@Service
public class MessagesServiceImpl implements MessagesService {

	@Autowired
	MessagesDao messagesDao;
	@Override
	public boolean sendMail(MessageBean messageBean, UserBean userBean) throws GMSException, Exception {
		return messagesDao.sendMail(messageBean, userBean);
	}
	@Override
	public List<InboxBean> inboxMails(UserBean userBean,Boolean flag) throws GMSException {
		return messagesDao.inboxMails(userBean,flag);
	}

}
