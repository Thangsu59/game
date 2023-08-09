package com.game.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.game.common.MybatisSqlSessionFactory;
import com.game.mapper.SingInfoMapper;
import com.game.mapper.TestInfoMapper;
import com.game.service.SingInfoService;
import com.game.service.TestInfoService;
import com.game.vo.SingInfoVO;
import com.game.vo.TestInfoVO;

public class SingInfoServiceImpl implements SingInfoService {
	
	private SqlSessionFactory ssf = MybatisSqlSessionFactory.getSqlSessionFactory();
	@Override
	public List<SingInfoVO> selectSingInfoList(SingInfoVO sing) {
		try(SqlSession session = ssf.openSession()){
			SingInfoMapper siMapper = session.getMapper(SingInfoMapper.class);
			return siMapper.selectSingInfoList(sing);
		}catch(Exception e) {
			throw e;
		}
	}
	@Override
	public SingInfoVO selectSingInfo(String siNum) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int insertSingInfo(Map<String, String> sing) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int updateSingInfo(Map<String, String> sing) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int deleteSingInfo(String siNum) {
		// TODO Auto-generated method stub
		return 0;
	}

}
