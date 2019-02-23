package com.gms.common.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gms.common.dao.CommonDao;
@Service
public class CommonServiceImpl implements CommonService {

	@Autowired
	CommonDao commonDao;
	@Override
	public Date getDate() {
		return commonDao.getDate();
	}

}
