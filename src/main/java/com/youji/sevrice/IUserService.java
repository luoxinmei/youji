package com.youji.sevrice;

import com.youji.pojo.User;
import com.youji.req.UserCheckReq;
import com.youji.req.UserLoginReq;
import com.youji.req.UserRegisterReq;
import com.youji.req.UserUpdatePwdReq;

public interface IUserService {

    /**
     * 检查用户是否存在
     *
     * @param   req
     * @return
     */
    Boolean checkUserName(UserCheckReq req);

    /**
     * 用户注册
     *
     * @param req
     * @return
     */
    Boolean register(UserRegisterReq req);

    /**
     * 用户登录
     *
     * @param req
     * @return
     */
    User login(UserLoginReq req);

    /**
     * 用户修改密码
     * @param   req
     * @return
     */
    Boolean updatePassword(UserUpdatePwdReq req );

}
