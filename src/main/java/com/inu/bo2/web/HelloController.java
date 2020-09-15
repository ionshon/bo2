package com.inu.bo2.web;


import com.inu.bo2.vo.Hoge;
import com.inu.bo2.vo.VoTest;
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
    public String home() {

        return "hello";
    }

    // jsp 와 같이 동작 안함.


    @RequestMapping(value = "/index")
    public String home1(){

        return "index.html";
    }


    @GetMapping("/index2")
    public String home2() {

        return "index2.html";
    }




    @ResponseBody
    @RequestMapping("/valueTest")
    public String valueTest(){
        String value = "test2 ajax 성공";
        return value;
    }

 //   @Autowired
 //   ServiceTest serviceTest;
    @RequestMapping(value="/testValue", method = RequestMethod.GET)
    public String getTestValue(){
        String TestValue = "레스트컨트롤러 테스트";
        return TestValue;
    }

    // WEB-INF/jsp의 jsp 실행을 위해 => sufic: spring.mvc.view.prefix=/WEB-INF/jsp/
    //                                       spring.mvc.view.suffix=.jsp
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

    @GetMapping("/thymeleafTest")
    public String thymeleafTest(Model model) {

        //    VoTest testModel = new VoTest("inushon", "이누숄") ;
        //        model.addAttribute("testModel", "testModel");
        Hoge hoge = new Hoge();
        hoge.id = 10;
        hoge.value = "hoge thymeleaf 성공";
        model.addAttribute("testModel", hoge);
        return "thymeleafTest";
    }

    // https://strongstar.tistory.com/17 강의
    @RequestMapping("obj")
    public String index(Model model) {
        model.addAttribute("msg", "data..");
        model.addAttribute("msg2", "<h1>END</h1><br /><h2>END</h2>");
        DataObject data = new DataObject(123, "star");
        model.addAttribute("object", data);
        return "obj";
    }

    static class DataObject {
        public int id;
        public String name;

        public DataObject(int id, String name) {
            super();
            this.id = id;
            this.name = name;
        }
    }

// 조건, 분기, 반복문
    @RequestMapping("/conti/{num}")
    public ModelAndView index(@PathVariable int num, ModelAndView mav) {
        mav.setViewName("condi");

        mav.addObject("num", num);
        mav.addObject("check", num % 2 == 0);
        mav.addObject("trueVal", "Even number.");
        mav.addObject("falseVal", "Odd number.");

        ArrayList<String[]> list = new ArrayList<String[]>();
        list.add(new String[]{"kim", "kim@a.com"});
        list.add(new String[]{"lee", "lee@b.com"});
        mav.addObject("list", list);

        return mav;
    }

// 전처리

    @RequestMapping("/fronti/{num}")
    public ModelAndView index2 ( @PathVariable int num, ModelAndView mav){
        mav.setViewName("fronti");

        mav.addObject("num", num);
        if (num >= 0) {
            mav.addObject("check", "num >= list.size() ? 0 : num");
        } else {
            mav.addObject("check", "num*-1 >= list.size() ? 0 : num*-1");
        }

        ArrayList<Person> list = new ArrayList<Person>();
        list.add(new Person("kim", "kim@a.com"));
        list.add(new Person("lee", "lee@b.com"));
        list.add(new Person("park", "park@c.com"));

        mav.addObject("list", list);

        return mav;
    }

    static class Person {
        public String name;
        public String email;

        public Person(String name, String email) {
            this.name = name;
            this.email = email;
        }
    }

}
