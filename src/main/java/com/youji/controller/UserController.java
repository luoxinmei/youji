package com.youji.controller;


import com.youji.common.ResponseCode;
import com.youji.common.ResponseResult;
import com.youji.pojo.User;
import com.youji.req.UserCheckReq;
import com.youji.req.UserLoginReq;
import com.youji.req.UserRegisterReq;
import com.youji.req.UserUpdatePwdReq;
import com.youji.sevrice.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"用户登录模块"})
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    IUserService userService;
    /**
     * 登录方法
     *
     * @param req
     * @return
     */

    @ApiOperation(value = "用户登录", notes = "根据用户和密码进行登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "password", value = "用户密码", required = true, paramType = "query", dataType = "String"),
    })

    @PostMapping("/login")
    @ResponseBody
    public ResponseResult<User> login(UserLoginReq req ) {
        User user = userService.login(req);
        if (user == null) {
            return ResponseResult.e(ResponseCode.FAIL, null);
        }
        return ResponseResult.e(ResponseCode.OK, user);
    }

    /**
     * 检查用户名是否存在
     *
     * @param req
     * @return
     */

    @ApiOperation(value = "检查用户名是否存在", notes = "检查用户名是否存在")
    @ApiImplicitParam(name = "username", value = "用户名", required = true, paramType = "query", dataType = "String")

    @GetMapping("/checkUser")
    @ResponseBody
    public ResponseResult<Boolean> checkUser(UserCheckReq req) {

        return ResponseResult.e(ResponseCode.OK, userService.checkUserName(req));
    }

    /**
     * 用户注册
     *
     * @param req
     * @return
     */
    @ApiOperation(value = "用户注册", notes = "根据用户和密码和身份证进行注册")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "password", value = "用户密码", required = true, paramType = "query", dataType = "String"),
    })

    @PostMapping("/register")
    @ResponseBody
    public ResponseResult<Boolean> register( UserRegisterReq req) {

        return ResponseResult.e(ResponseCode.OK, userService.register(req));
    }

    /**
     * 修改用户信息
     * @param req
     * @return
     */
    @ApiOperation(value = "修改用户密码", notes = "修改用户密码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "用户名", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "password", value = "用户密码", required = true, paramType = "query", dataType = "String"),
    })


    @PostMapping("/updatePassword")
    @ResponseBody
    public ResponseResult<Boolean> updatePassword(UserUpdatePwdReq req){

        return ResponseResult.e(ResponseCode.OK, userService.updatePassword(req));
    }
}
