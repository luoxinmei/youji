package com.youji.dao;

import com.youji.pojo.Elf;

public interface IElfDao {

    int updateByPrimaryKeySelective(Elf elf);
}