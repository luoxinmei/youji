package com.youji.sevrice.impl;

import com.youji.dao.IElfDao;
import com.youji.pojo.Elf;
import com.youji.req.ElfUpdateReq;
import com.youji.sevrice.IElfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ElfServiceImpl implements IElfService {
    @Autowired
    IElfDao elfDao;


    @Override
    public Boolean updateNickname(ElfUpdateReq req) {
        Elf elf=new Elf();
        elf.setElfId(req.getUserId());
        elf.setNickname(req.getNickname());
        int i=elfDao.updateByPrimaryKeySelective(elf);
        return i==1?true:false;
    }
}

