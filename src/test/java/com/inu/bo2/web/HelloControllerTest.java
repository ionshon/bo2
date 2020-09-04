package com.inu.bo2.web;


//import org.springframework.stereotype.Controller;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.web.bind.annotation.ResponseBody;

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
    public void return_HELLO() throws Exception {
        String hello = "hello";
        mvc.perform(get("hello"))
   //             .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
     //   return "html";
    }

/*
//    @ResponseBody
    @Test
    @RequestMapping("/valueTest")
    public String valueTest(){
        String value = "test test";
        return value;
    }
*/
}
