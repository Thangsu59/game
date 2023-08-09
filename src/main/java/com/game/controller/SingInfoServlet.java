package com.game.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.game.common.CommonView;
import com.game.service.SingInfoService;
import com.game.service.impl.SingInfoServiceImpl;
import com.game.vo.SingInfoVO;
import com.google.gson.Gson;


@WebServlet("/sing-info/*")
public class SingInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private SingInfoService siService = new SingInfoServiceImpl();
	    private Gson gson = new Gson();
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = CommonView.getCmd(request);
		String json = "";
		if("list".equals(cmd)) {
			List<SingInfoVO> list = siService.selectSingInfoList(null);
			json = gson.toJson(list);
		}
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(json);
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
