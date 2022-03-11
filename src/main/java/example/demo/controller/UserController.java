package example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import example.demo.models.UserInfo;
import example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /**
     * 작성자 : 이상범
     * 주요기능 : Root 페이지
     */
    @RequestMapping("/")
    public String root() throws Exception {
        try {

        } catch (Exception e) {
            log.info("root-Exception : " + e);
        }
        return "index";
    }

    /**
     * 작성자 : 이상범
     * 주요기능 : 로그인 id, pw 체크 페이지 이동
     * 
     * @return userInfo(userID, userPwd)
     */
    @PostMapping("/board")
    @ResponseBody
    public void loginCheck(UserInfo userInfo) throws Exception {
        try {
            log.info("userID : " + userInfo.getUserID());
            // UserInfo findUser = userService.findUser(userInfo);
        } catch (Exception e) {
            log.info("loginCheck-Exception : " + e);
        }
    }

    @GetMapping("/board")
    public String board(UserInfo userInfo, Model model) throws Exception {
        log.info("userInfo.getUserID() : " + userInfo.getUserID());
        model.addAttribute("userID", userInfo.getUserID());
        return "board/board";
    }

    @GetMapping("/logout")
    public String logout() {
        log.info("cash clear");
        return "redirect:/";
    }

}// class
