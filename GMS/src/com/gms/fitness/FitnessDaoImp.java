package com.gms.fitness;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.gms.common.constants.CommonConstants;
import com.gms.common.dao.CommonDao;
import com.gms.persistent.TMessagesInfo;
import com.gms.persistent.TUserDtls;
import com.gms.persistent.TUserInfo;
import com.gms.persistent.TUserMessagesMapping;
import com.gms.user.beans.UserBean;
import com.gms.user.dao.UserDao;

@Repository
public class FitnessDaoImp {
	
	
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	UserDao userDao;
	@Autowired
	CommonDao commonDao;
	@Autowired
	HibernateTemplate hibernateTemplate;
	
	public Map<Integer, String> getAllCoaches() {
		Map<Integer, String> retMap = null;
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Criteria cr = session.createCriteria(TUserInfo.class);
			cr.add(Restrictions.eq("recordStatus", CommonConstants.RECORD_STATUS_C));
			//cr.add(Restrictions.eq("userType", "Y"));

			List<TUserInfo> rs = cr.list();
			if(rs != null && !rs.isEmpty()) {
				retMap = new HashMap<Integer, String>();
				for (TUserInfo tUserInfo : rs) {
					
					
					retMap.put(tUserInfo.getUserSrno(), userDao.getUserFullNameByUserSrNo(tUserInfo.getUserSrno()));
					//retList.add(tUserInfo.getLoginId());
				}
			}


		} catch (Exception e) {
			e.printStackTrace();
		}
		return retMap;
	}
	
	
	public void addEvent(FitnessBean fitnessBean,UserBean userBean) {
		TMessagesInfo tMessagesInfo = new TMessagesInfo();
		tMessagesInfo.setSubject(fitnessBean.getEventTitle());
		tMessagesInfo.setMessage(fitnessBean.getEventDesc());

		tMessagesInfo.setLangCd(CommonConstants.ENG_LANG_CD);
		tMessagesInfo.setRecordStatus(CommonConstants.RECORD_STATUS_C);
		tMessagesInfo.setRecordCreatedBy(userBean.getUserSrno());
		tMessagesInfo.setRecordUpdatedBy(userBean.getUserSrno());
		tMessagesInfo.setRecordCreatedOn(commonDao.getDate());
		tMessagesInfo.setRecordUpdatedOn(commonDao.getDate());
		tMessagesInfo.setStatusCd(1);


		Integer tMessagesInfoId = (Integer) hibernateTemplate.save(tMessagesInfo);
		
		
		TUserMessagesMapping tUserMessagesMapping = new TUserMessagesMapping();
		tUserMessagesMapping.setUserSrNo(Integer.parseInt(fitnessBean.getCoaches()));
		tUserMessagesMapping.setMessageSrNo(tMessagesInfoId);
		tUserMessagesMapping.setMessageTypeCd(CommonConstants.MESSAGE_TYPE_TO);
		tUserMessagesMapping.setLangCd(CommonConstants.ENG_LANG_CD);
		tUserMessagesMapping.setRecordStatus(CommonConstants.RECORD_STATUS_C);
		tUserMessagesMapping.setRecordCreatedBy(userBean.getUserSrno());
		tUserMessagesMapping.setRecordUpdatedBy(userBean.getUserSrno());
		tUserMessagesMapping.setRecordCreatedOn(commonDao.getDate());
		tUserMessagesMapping.setRecordUpdatedOn(commonDao.getDate());

		hibernateTemplate.saveOrUpdate(tUserMessagesMapping);
	}
	
	public void inviteTOEvent(String msgId,String inviteUser,UserBean userBean) {
		try {

			
			Session session = null;
			session = sessionFactory.openSession();
			Criteria cr = session.createCriteria(TUserMessagesMapping.class);
			cr.add(Restrictions.eq("messageSrNo", Integer.parseInt(msgId)));
			
			List<TUserMessagesMapping> list = cr.list();
			
			if(list != null && list.size() > 0) {
				Integer val = list.get(0).getUserSrNo();
				TUserMessagesMapping tUserMessagesMapping = new TUserMessagesMapping();
				tUserMessagesMapping.setInvitedUser(Integer.parseInt(inviteUser));
				tUserMessagesMapping.setUserSrNo(val);
				tUserMessagesMapping.setMessageSrNo(Integer.parseInt(msgId));
				tUserMessagesMapping.setMessageTypeCd(CommonConstants.MESSAGE_TYPE_TO);
				tUserMessagesMapping.setLangCd(CommonConstants.ENG_LANG_CD);
				tUserMessagesMapping.setRecordStatus(CommonConstants.RECORD_STATUS_C);
				tUserMessagesMapping.setRecordCreatedBy(userBean.getUserSrno());
				tUserMessagesMapping.setRecordUpdatedBy(userBean.getUserSrno());
				tUserMessagesMapping.setRecordCreatedOn(commonDao.getDate());
				tUserMessagesMapping.setRecordUpdatedOn(commonDao.getDate());

				hibernateTemplate.saveOrUpdate(tUserMessagesMapping);
			}
			
			
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
