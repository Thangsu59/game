package com.game.service;

import java.util.List;
import java.util.Map;

import com.game.vo.BoardInfoVO;
import com.game.vo.SingInfoVO;
import com.game.vo.TestInfoVO;

public interface SingInfoService {

	List<SingInfoVO> selectSingInfoList(SingInfoVO sing);
	SingInfoVO selectSingInfo(String siNum);
	int insertSingInfo(Map<String,String> sing);
	int updateSingInfo(Map<String,String> sing);
	int deleteSingInfo(String siNum);
}
