package com.youji.controller;

import com.youji.common.ResponseCode;
import com.youji.common.ResponseResult;
import com.youji.req.ElfUpdateReq;
import com.youji.sevrice.IElfService;
import com.youji.sevrice.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"精灵模块"})
@RestController
@RequestMapping("/elf")
public class ElfController {
    @Autowired
    IElfService elfService;

    /**
     * 修改精灵昵称
     * @param req
     * @return
     */
    @ApiOperation(value = "修改精灵昵称", notes = "修改精灵昵称")
   // @ApiImplicitParam(paramType = "query", dataType = "String")

    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "userId", required = true, paramType = "query", dataType = "String"),
            @ApiImplicitParam(name = "nickname", value = "昵称", required = true, paramType = "query", dataType = "String"),
    })
    @ResponseBody
    @PostMapping("/updateNickname")
    public ResponseResult<Boolean> updateNickname(ElfUpdateReq req) {

        return ResponseResult.e(ResponseCode.OK, elfService.updateNickname(req));
    }

}
