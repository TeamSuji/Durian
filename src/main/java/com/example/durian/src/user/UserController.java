package com.example.durian.src.user;

import com.example.durian.config.BaseException;
import com.example.durian.config.BaseResponse;
import com.example.durian.src.user.model.GetUserRes;
import com.example.durian.utils.JwtService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private final UserProvider userProvider;
    @Autowired
    private final UserService userService;
    @Autowired
    private final JwtService jwtService;

    public UserController(UserProvider userProvider, UserService userService, JwtService jwtService) {
        this.userProvider = userProvider;
        this.userService = userService;
        this.jwtService = jwtService;
    }

    @ResponseBody
    @GetMapping("/{userIdx}")
    public BaseResponse<GetUserRes> getUserInfo(@PathVariable("userIdx") int userIdx) {
        System.out.println("entered");
        try {
            GetUserRes getUserRes = userProvider.getUserByIdx(userIdx);
            System.out.println("getUserRes = " + getUserRes.getName());
            return new BaseResponse<>(getUserRes);
        } catch (BaseException exception) {
            return new BaseResponse<>(exception.getStatus());
        }
    }
}
