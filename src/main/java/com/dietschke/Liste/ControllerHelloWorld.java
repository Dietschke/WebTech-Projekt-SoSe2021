package com.dietschke.Liste;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
public class ControllerHelloWorld {

    @RequestMapping("/")
        public String index(){
        return "Hello World!";
    }

    @RequestMapping("/welcome")
    public String welcome() {
        return "Willkommen auf WasBraucheIchDafuerNochmal?";
    }

}
