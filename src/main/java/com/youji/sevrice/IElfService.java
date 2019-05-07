package com.youji.sevrice;

import com.youji.req.ElfUpdateReq;

public interface IElfService {

    /**
     * 修改精灵昵称
     * @param req
     * @return
     */
    Boolean updateNickname(ElfUpdateReq req);
}
