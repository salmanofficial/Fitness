package com.gms.common.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gms.common.dao.CommonMasterDao;
@Service
public class CommonMasterServiceImpl implements CommonMasterService {

	@Autowired
	CommonMasterDao commonMasterDao;
	
	@Override
	public Map<Integer, String> getAllGenders() {
		return commonMasterDao.getAllGenders();
	}

}
