package com.cj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    //@RequestMapping("/{moduleName}")
    public String module(@PathVariable String moduleName) {
        return "pages/"+moduleName;
    }

}
