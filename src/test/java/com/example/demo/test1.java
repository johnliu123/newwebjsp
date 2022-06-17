package com.example.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.ui.Model;

import com.example.demo.controller.Test1Controller;
import com.example.demo.controller.TestController;

import lombok.extern.slf4j.Slf4j;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class test1 {

	
	@Autowired
	private Test1Controller test1Controller;
	
	@Autowired
	private TestController testController;
	
	@Test
	public void test() {
		
		
		Model model=null;
//		HttpServletRequest request=null;
		MockHttpServletRequest request=new MockHttpServletRequest();
		HttpSession session = request.getSession();
		session.setAttribute("secretary", "secretary");
//		test1Controller.index();
		
		testController.newIndex(model,request);
		
//		assertEquals(30, 50);
		
	}
}
