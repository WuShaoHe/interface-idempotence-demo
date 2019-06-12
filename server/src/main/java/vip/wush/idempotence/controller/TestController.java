package vip.wush.idempotence.controller;

import org.springframework.web.bind.annotation.*;
import vip.wush.idempotence.annotation.NoRepeatSubmit;

/**
 * @ClassName: TestController
 * @Description: TODO
 * @Author: wush
 * @Date: 2019/6/12 11:15
 */

@RestController
public class TestController {

    @PostMapping("hello")
    @NoRepeatSubmit
    public Object hello(@RequestBody String name){

        return "hello, " + name;
    }



    @PostMapping("hello2")
    public Object hello2(@RequestBody  String name){

        return "hello, " + name;
    }


}
