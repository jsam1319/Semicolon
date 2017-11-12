package kr.or.kosta.semicolon.index.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @packgename	kr.or.kosta.semicolon.index.controller
 * @filename			IndexController.java
 * @author 			JaeHyun
 * @since				2017. 11. 8.
 * @see					Index 페이지의 Controller
 *
 * == Modification Infomation (수정 이력) ==
 * 
 *   DATE		  AUTHOR		 NOTE
 * --------		-----------	---------------------------------------
 * 2017. 11. 8.		JaeHyun			최초 생성
 *
 *
 */
@Controller
public class IndexController {

	/**
	 * <pre>
	 * 1. 개      요 : Index View 이동
	 * 2. 처리내용 : 최초 홈페이지 방문 시 보여주는 Index 페이지로 이동하는 메소드
	 * </pre>
	 * @Method Name : index
	 * @return Index Page Name(index.jsp)
	 */
	@RequestMapping(value="/")
	public String index() {
		return "index";
	}
}
