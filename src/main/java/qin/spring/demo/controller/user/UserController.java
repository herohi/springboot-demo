package qin.spring.demo.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import qin.spring.demo.entity.user.User;
import qin.spring.demo.helpers.response.Resp;
import qin.spring.demo.model.user.RequestUserDetailBean;
import qin.spring.demo.modules.auth.annotation.CurrentUser;
import qin.spring.demo.service.user.UserService;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 获取当前登录的用户信息
     */
    @GetMapping(path = "/current")
    public Resp getCurrentUser(@CurrentUser User user) {
        return Resp.success(user);
    }

    /**
     * 更新用户的详细信息
     */
    @GetMapping(path = "/current")
    public Resp updateCurrentUser(@CurrentUser User user, @RequestBody RequestUserDetailBean requestUserDetailBean) {
        return Resp.success("success");
    }
}
