package com.gms.common.dao;

import java.util.Date;

import org.springframework.stereotype.Service;
@Service
public class CommonDaoImpl implements CommonDao {

	@Override
	public Date getDate() {
		Date retDate = null;
		try {
			retDate = new Date();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retDate;
	}

}
