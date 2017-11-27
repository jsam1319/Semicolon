package kr.or.kosta.semicolon.orderlist.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.kosta.semicolon.orderlist.domain.OrderList;
import kr.or.kosta.semicolon.orderlist.service.OrderListService;

@Controller
@RequestMapping("/olist")
public class OrderListController {
	@Inject
	OrderListService listService;

	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String orderListDetail() {
		return "/order/listdetail";
	}
}
