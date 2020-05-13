package com.groupware.controller.board;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.groupware.dto.BoardVO;
import com.groupware.service.board.BoardService;

@Controller
@RequestMapping("/board")
public class CommonBoardController {
	
	@RequestMapping("/regist")
	public String registForm(Model model) throws Exception {
		String url = "board/regist";
		
		Calendar day = Calendar.getInstance();		//현재 시간
		Date startDate = day.getTime();
		String startDateStr = new SimpleDateFormat("yyyy-MM-dd").format(startDate);
		day.add(Calendar.DATE, 30);
		Date endDate = day.getTime();
		String endDateStr = new SimpleDateFormat("yyyy-MM-dd").format(endDate);
		
		model.addAttribute("startDate",startDateStr);
		model.addAttribute("endDate",endDateStr);
			
		return url;
	}
}
