package com.gms.messages.dao;



import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gms.common.constants.CommonConstants;
import com.gms.common.dao.CommonDao;
import com.gms.exceptions.GMSException;
import com.gms.messges.bean.InboxBean;
import com.gms.messges.bean.MessageBean;
import com.gms.persistent.TMessagesInfo;
import com.gms.persistent.TUserMessagesMapping;
import com.gms.user.beans.UserBean;
import com.gms.user.dao.UserDao;
@Service
public class MessagesDaoImpl implements MessagesDao {

	@Autowired
	HibernateTemplate hibernateTemplate;
	@Autowired
	CommonDao commonDao;
	@Autowired
	UserDao userDao;
	@Autowired
	SessionFactory sessionFactory;

	@Override
	@Transactional
	public boolean sendMail(MessageBean messageBean, UserBean userBean) throws GMSException,Exception {

		if(hibernateTemplate == null)
			throw new GMSException("unable to connect database,please try after some time");



		boolean retFalg = false;

		List<Integer> toUserList = new ArrayList<Integer>();
		List<Integer> ccUserList = new ArrayList<Integer>();
		List<Integer> bccUserList = new ArrayList<Integer>();

		int presentUser = userBean.getUserSrno();



		TMessagesInfo tMessagesInfo = new TMessagesInfo();
		tMessagesInfo.setSubject(messageBean.getSubject());
		tMessagesInfo.setMessage(messageBean.getMessage());

		tMessagesInfo.setLangCd(CommonConstants.ENG_LANG_CD);
		tMessagesInfo.setRecordStatus(CommonConstants.RECORD_STATUS_C);
		tMessagesInfo.setRecordCreatedBy(presentUser);
		tMessagesInfo.setRecordUpdatedBy(presentUser);
		tMessagesInfo.setRecordCreatedOn(commonDao.getDate());
		tMessagesInfo.setRecordUpdatedOn(commonDao.getDate());
		tMessagesInfo.setStatusCd(1);


		Integer tMessagesInfoId = (Integer) hibernateTemplate.save(tMessagesInfo);


		//TO Users
		for (String loginId : messageBean.getTo().split(",")) {
			Integer userSrNo = userDao.getUserByLoginId(loginId);
			if(userSrNo != null)
				toUserList.add(userSrNo);

		}

		//CC Users
		for (String loginId : messageBean.getCc().split(",")) {
			Integer userSrNo = userDao.getUserByLoginId(loginId);
			if(userSrNo != null)
				ccUserList.add(userSrNo);

		}

		//BCC Users
		for (String loginId : messageBean.getBcc().split(",")) {
			Integer userSrNo = userDao.getUserByLoginId(loginId);
			if(userSrNo != null)
				bccUserList.add(userSrNo);

		}



		if(toUserList == null || toUserList.isEmpty())
			throw new GMSException("please check your Email");


		//To Users
		for (Integer userSrNo : toUserList) {

			TUserMessagesMapping tUserMessagesMapping = new TUserMessagesMapping();
			tUserMessagesMapping.setUserSrNo(userSrNo);
			tUserMessagesMapping.setMessageSrNo(tMessagesInfoId);
			tUserMessagesMapping.setMessageTypeCd(CommonConstants.MESSAGE_TYPE_TO);
			tUserMessagesMapping.setLangCd(CommonConstants.ENG_LANG_CD);
			tUserMessagesMapping.setRecordStatus(CommonConstants.RECORD_STATUS_C);
			tUserMessagesMapping.setRecordCreatedBy(presentUser);
			tUserMessagesMapping.setRecordUpdatedBy(presentUser);
			tUserMessagesMapping.setRecordCreatedOn(commonDao.getDate());
			tUserMessagesMapping.setRecordUpdatedOn(commonDao.getDate());

			hibernateTemplate.saveOrUpdate(tUserMessagesMapping);

		}

		//CC Users
		for (Integer userSrNo : ccUserList) {

			TUserMessagesMapping tUserMessagesMapping = new TUserMessagesMapping();
			tUserMessagesMapping.setUserSrNo(userSrNo);
			tUserMessagesMapping.setMessageSrNo(tMessagesInfoId);
			tUserMessagesMapping.setMessageTypeCd(CommonConstants.MESSAGE_TYPE_CC);
			tUserMessagesMapping.setLangCd(CommonConstants.ENG_LANG_CD);
			tUserMessagesMapping.setRecordStatus(CommonConstants.RECORD_STATUS_C);
			tUserMessagesMapping.setRecordCreatedBy(presentUser);
			tUserMessagesMapping.setRecordUpdatedBy(presentUser);
			tUserMessagesMapping.setRecordCreatedOn(commonDao.getDate());
			tUserMessagesMapping.setRecordUpdatedOn(commonDao.getDate());

			hibernateTemplate.saveOrUpdate(tUserMessagesMapping);

		}

		//BCC Users
		for (Integer userSrNo : bccUserList) {

			TUserMessagesMapping tUserMessagesMapping = new TUserMessagesMapping();
			tUserMessagesMapping.setUserSrNo(userSrNo);
			tUserMessagesMapping.setMessageSrNo(tMessagesInfoId);
			tUserMessagesMapping.setMessageTypeCd(CommonConstants.MESSAGE_TYPE_BCC);
			tUserMessagesMapping.setLangCd(CommonConstants.ENG_LANG_CD);
			tUserMessagesMapping.setRecordStatus(CommonConstants.RECORD_STATUS_C);
			tUserMessagesMapping.setRecordCreatedBy(presentUser);
			tUserMessagesMapping.setRecordUpdatedBy(presentUser);
			tUserMessagesMapping.setRecordCreatedOn(commonDao.getDate());
			tUserMessagesMapping.setRecordUpdatedOn(commonDao.getDate());

			hibernateTemplate.saveOrUpdate(tUserMessagesMapping);

		}

		retFalg = true;



		return retFalg;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<InboxBean> inboxMails(UserBean userBean,Boolean flag) throws GMSException {

		List<InboxBean> allInboxMgs = null;
		Session session = null;
		try {



			if(hibernateTemplate == null)
				throw new GMSException("unable to connect database,please try after some time");

			StringBuffer query = new StringBuffer();
			query.append(" SELECT m.recordUpdatedBy as fromUserSrno,um.messageSrNo as messageSrNo,m.subject as subject,um.recordUpdatedOn as receivedDate ");
			query.append(" ,m.message as message,um.userSrNo as coachId  ");
			query.append(" FROM TUserMessagesMapping um,TMessagesInfo m ");
			query.append(" WHERE um.recordStatus = ?  ");//AND um.userSrNo = ?
			query.append(" AND um.messageSrNo = m.messageSrNo ");
			if(flag)
				query.append(" AND um.invitedUser = "+userBean.getUserSrno());//AND um.userSrNo = ?
			else
				query.append(" AND um.invitedUser is null");
			
			query.append(" ORDER BY um.recordUpdatedOn DESC ");

			session = sessionFactory.openSession();
			Query HQLQuery = session.createQuery(query.toString()).setResultTransformer(Transformers.aliasToBean(InboxBean.class));
			HQLQuery.setParameter(0, CommonConstants.RECORD_STATUS_C);
			//HQLQuery.setParameter(1, userBean.getUserSrno());

			allInboxMgs = HQLQuery.list();

			for (InboxBean inboxBean : allInboxMgs) {
				inboxBean.setFrom(userDao.getUserFullNameByUserSrNo(inboxBean.getFromUserSrno()));
				inboxBean.setCoachName(userDao.getUserFullNameByUserSrNo(inboxBean.getCoachId()));
			}

		} catch (Exception e) {
			e.printStackTrace();
			if(session != null){
				session.close();
			}
		}



		return allInboxMgs;
	}

}
