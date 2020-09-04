package com.inu.bo2.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller //(static 위치의 html 파일 호출 후, view)
//@RestController // 그냥 문자열 반환
public class HelloController {


    @ResponseBody
    @GetMapping("/hello")
    public String home2() {

        return "hello";
    }

    @GetMapping("/index")
    public String home() {

        return "index.html";
    }




    @ResponseBody
    @RequestMapping("/valueTest")
    public String valueTest(){
        String value = "test2 test";
        return value;
    }

 //   @Autowired
 //   ServiceTest serviceTest;
    @RequestMapping(value="/testValue", method = RequestMethod.GET)
    public String getTestValue(){
        String TestValue = "레스트컨트롤러 테스트";
        return TestValue;
    }

    // WEB-INF/jsp의 jsp 실행=> sufic: spring.mvc.view.prefix=/WEB-INF/jsp/, spring.mvc.view.suffix=.jsp
    //  compile('org.apache.tomcat.embed:tomcat-embed-jasper')
    //	compile('javax.servlet:jstl:1.2') 필요
@GetMapping("/jsp_test")
public ModelAndView test()  {
    ModelAndView mav = new ModelAndView("test");
    mav.addObject("name", "goddaehee");

    List<String> testList = new ArrayList<String>();
    testList.add("a"); testList.add("b");
    testList.add("c");

    mav.addObject("list", testList);
    return mav;
}

    @RequestMapping("/thymeleafTest")
    public String thymeleafTest(Model model) {

 //        VoTest testModel = new VoTest("inushon", "이누숄") ;
             model.addAttribute("testModel", "testModel");
             return "thymeleaf/thymeleafTest";
    }

}
