package com.gms.common.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Service;

import com.gms.persistent.MGender;


@Service
public class CommonMasterDaoImpl implements CommonMasterDao {

	@Autowired
	HibernateTemplate template;
	
	@Override
	public Map<Integer, String> getAllGenders() {
		Map<Integer, String> retMap = new HashMap<Integer, String>();
		try {
			List<MGender> allGendersList = template.loadAll(MGender.class);
			for (MGender mGender : allGendersList) {
				retMap.put(mGender.getGenderCd(), mGender.getGenderDesc());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retMap;
	}

}
