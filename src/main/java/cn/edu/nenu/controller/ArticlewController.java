package cn.edu.nenu.controller;

import lombok.extern.apachecommons.CommonsLog;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@CommonsLog
@Controller
@RequestMapping("articlew")
public class ArticlewController {

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list() {
        return "articlew/list";
    }

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String form() {
        return "articlew/form";
    }

}
