package com.inu.bo2.web;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {

        return "hello";
    }

}

/*
 //   @ResponseBody
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

@RequestMapping("/jsp_test")
public ModelAndView test() throws Exception{
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
*/