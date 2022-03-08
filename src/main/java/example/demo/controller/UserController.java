package example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import example.demo.models.UserInfo;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class UserController {

    @RequestMapping("/")
    public String root() {
        return "index";
    }

    @GetMapping("/board")
    public String loginCheck(@RequestParam UserInfo userInfo) {
        log.info(userInfo.getUserID());
        log.info(userInfo.getUserPwd());
        return "board/board";
    }

}
