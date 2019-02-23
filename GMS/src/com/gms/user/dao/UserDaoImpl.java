package com.gms.user.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gms.common.constants.CommonConstants;
import com.gms.common.dao.CommonDao;
import com.gms.persistent.TUserDtls;
import com.gms.persistent.TUserInfo;
import com.gms.user.beans.UserBean;
@Service
public class UserDaoImpl implements UserDao {

	@Autowired
	HibernateTemplate hibernateTemplate;
	@Autowired
	CommonDao commonDao;

	@Autowired
	SessionFactory sessionFactory;

	@Override
	@Transactional
	public boolean createOrUpdateUser(UserBean userBean)throws Exception {
		boolean retFalg = false;
		Session session = null;
		Transaction tx = null;
		TUserInfo tUserInfo = null;
		TUserDtls tUserDtls = null;
		try {

			session = sessionFactory.openSession();
			tx = session.beginTransaction();

			Criteria cr = session.createCriteria(TUserInfo.class);
			cr.add(Restrictions.eq("recordStatus", CommonConstants.RECORD_STATUS_C));
			cr.add(Restrictions.eq("loginId", userBean.getLoginId()));

			List rs = cr.list();

			if(rs != null && !rs.isEmpty()){
				tUserInfo = (TUserInfo) rs.get(0);
			}

			cr = session.createCriteria(TUserDtls.class);
			cr.add(Restrictions.eq("recordStatus", CommonConstants.RECORD_STATUS_C));
			cr.add(Restrictions.eq("tUserInfo", tUserInfo));
			rs = cr.list();


			if(rs != null && !rs.isEmpty()){
				tUserDtls = (TUserDtls) rs.get(0);
			}

			if(tUserInfo == null && tUserDtls == null) {
				tUserInfo = new TUserInfo();
				tUserInfo.setRecordCreatedOn(commonDao.getDate());
				tUserInfo.setRecordCreatedBy(userBean.getUserSrno());

				tUserDtls = new TUserDtls();
				tUserDtls.setRecordCreatedOn(commonDao.getDate());
				tUserDtls.setRecordCreatedBy(userBean.getUserSrno());

			}



			tUserInfo.setLoginId(userBean.getLoginId());
			tUserInfo.setLoginPassword(userBean.getLastName());
			tUserInfo.setLangCd(CommonConstants.ENG_LANG_CD);
			tUserInfo.setRecordStatus(CommonConstants.RECORD_STATUS_C);
			tUserInfo.setRecordUpdatedBy(userBean.getUserSrno());
			tUserInfo.setRecordUpdatedOn(commonDao.getDate());
			tUserInfo.setUserType(userBean.getUserType());

			Integer userId  =(Integer) hibernateTemplate.save(tUserInfo);
			
			tUserDtls.setUserSrNo(userId);
			tUserDtls.setFirstName(userBean.getFirstName());
			tUserDtls.setLastName(userBean.getLastName());
			tUserDtls.setGenderCd(userBean.getGenderCd());
			tUserDtls.setDob(userBean.getDob());
			tUserDtls.setMobileNo(userBean.getMobileNo());
			//tUserDtls.settUserInfo(tUserInfo);
			tUserDtls.setLangCd(CommonConstants.ENG_LANG_CD);
			tUserDtls.setRecordStatus(CommonConstants.RECORD_STATUS_C);
			tUserDtls.setRecordUpdatedBy(userBean.getUserSrno());
			tUserDtls.setRecordUpdatedOn(commonDao.getDate());

			
			hibernateTemplate.saveOrUpdate(tUserDtls);

			tx.commit();
			retFalg = true;

		} catch (Exception e) {
			retFalg = false;
			tx.rollback();
			e.printStackTrace();
		}
		return retFalg;
	}

	@Override
	public Set<UserBean> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserBean validateUser(UserBean userBean) {
		Session session = null;
		UserBean retUserBean = null;
		try {
			session = sessionFactory.openSession();

			Criteria cr = session.createCriteria(TUserInfo.class);
			cr.add(Restrictions.eq("recordStatus", CommonConstants.RECORD_STATUS_C));
			cr.add(Restrictions.eq("loginId", userBean.getLoginId()));
			cr.add(Restrictions.eq("loginPassword", userBean.getLoginPassword()));
			
			List<TUserInfo> userInfoList = cr.list();
			
			if(userInfoList != null && !userInfoList.isEmpty()) {
				retUserBean = new UserBean();
				for (TUserInfo tUserInfo : userInfoList) {
					retUserBean.setUserSrno(tUserInfo.getUserSrno());
					retUserBean.setLoginId(tUserInfo.getLoginId());
					retUserBean.setFirstName(tUserInfo.gettUserDtls().getFirstName());
					retUserBean.setLastName(tUserInfo.gettUserDtls().getLastName());
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return retUserBean;
	}

	@Override
	public Set<String> getAllExistingLoginId() {
		Session session = null;
		Set<String> retList = null;
		try {
			session = sessionFactory.openSession();
			Criteria cr = session.createCriteria(TUserInfo.class);
			//cr.add(Restrictions.eq("recordStatus", CommonConstants.RECORD_STATUS_C));

			List<TUserInfo> rs = cr.list();
			if(rs != null && !rs.isEmpty()) {
				retList = new HashSet<String>();
				for (TUserInfo tUserInfo : rs) {
					retList.add(tUserInfo.getLoginId());
				}
			}


		} catch (Exception e) {
			e.printStackTrace();
		}
		return retList;
	}

	@Override
	public Boolean checkForLoginId(String loginId) {
		Boolean retFlag = false;
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Criteria cr = session.createCriteria(TUserInfo.class);
			cr.add(Restrictions.eq("loginId", loginId));
			List<TUserInfo> rs = cr.list();
			if(rs != null && !rs.isEmpty()) {
				retFlag = true;
			}


		} catch (Exception e) {
			e.printStackTrace();
		}
		return retFlag;
	}

	@Override
	public Integer getUserByLoginId(String loginId) {
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Criteria cr = session.createCriteria(TUserInfo.class);
			cr.add(Restrictions.eq("loginId", loginId));
			cr.add(Restrictions.eq("recordStatus", CommonConstants.RECORD_STATUS_C));
			List<TUserInfo> rs = cr.list();
			if(rs != null && !rs.isEmpty()) {
				return rs.get(0).getUserSrno();
			}


		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return null;
	}

	@Override
	public String getUserFullNameByUserSrNo(Integer userSrNO) {

		String retName = null;
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Criteria cr = session.createCriteria(TUserInfo.class);
			cr.add(Restrictions.eq("userSrno", userSrNO));
			cr.add(Restrictions.eq("recordStatus", CommonConstants.RECORD_STATUS_C));
			List<TUserInfo> rs = cr.list();
			if(rs != null && !rs.isEmpty()) {
				retName =  rs.get(0).gettUserDtls().getFirstName();
				retName += " " + rs.get(0).gettUserDtls().getLastName();
			}


		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return retName;
	
	}
}
