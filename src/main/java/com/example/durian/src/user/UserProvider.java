package com.example.durian.src.user;

import com.example.durian.config.BaseException;
import com.example.durian.config.BaseResponseStatus;
import com.example.durian.src.user.model.GetUserRes;
import com.example.durian.utils.JwtService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProvider {
    private final UserDao userDao;
    private final JwtService jwtService;

    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public UserProvider(UserDao userDao, JwtService jwtService) {
        this.userDao = userDao;
        this.jwtService = jwtService;
    }

    public GetUserRes getUserByIdx(int user_idx) throws BaseException {
        try {
            GetUserRes getUserRes = userDao.getUserInfo(user_idx);
            return getUserRes;
        } catch (Exception exception) {
            throw new BaseException(BaseResponseStatus.DATABASE_ERROR);
        }
    }
}
