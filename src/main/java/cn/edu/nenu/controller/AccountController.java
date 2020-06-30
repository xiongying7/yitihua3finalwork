package cn.edu.nenu.controller;

import cn.edu.nenu.domain.User;
import cn.edu.nenu.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/account")
public class AccountController {

    UserService userService;

//    @GetMapping("/{id}")
//    public ResponseEntity get(@PathVariable("id")Long id){
//        User user = userService.findById(id);
//        return ResponseEntity.ok(user); //json字符串
//    }

    @PostMapping
    public ResponseEntity createJSON(@RequestBody String json){
        return null;
    }




}
