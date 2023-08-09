package com.game.mapper;

import java.util.List;

import com.game.vo.BoardInfoVO;
import com.game.vo.SingInfoVO;

public interface SingInfoMapper {

	List<SingInfoVO> selectSingInfoList(SingInfoVO sing);
	SingInfoVO selectSingInfo(String siNum);
	int insertSingInfo(SingInfoVO sing);
	int updateSingInfo(SingInfoVO sing);
	int deleteSingInfo(SingInfoVO sing);
}