package com.inu.bo2.web;


//import org.springframework.stereotype.Controller;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void 헬로를_리턴한다() throws Exception {
        String hello = "hello";
        mvc.perform(get("/hello"))
   //             .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
     //   return "html";
    }

/*
    @Test

    public ModelAndView testfwe() throws Exception{

        mvc.perform(get("/jsp_test"))
            ModelAndView mav = new ModelAndView("test");
        mav.addObject("name", "goddaehee");

        List<String> testList = new ArrayList<String>();
        testList.add("a"); testList.add("b");
        testList.add("c");

        mav.addObject("list", testList);
        return mav;
    }
*/
}
