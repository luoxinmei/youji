package com.youji.dao;

import com.youji.pojo.Image;

import java.util.List;

public interface IImageDao {


    /**
     * 根据主键删除照片
     * @param userId
     * @return
     */
    int deleteByUserId(Integer userId);
    /**
     * 根据主键删除照片
     * @param id
     * @return
     */
    int deleteById(Integer id);

    /**
     * 根据userId查询照片集合
     * @return
     */
    List<Image> selectByUserId(Integer userId);

    /**
     * 保存照片
     * @param image
     */
    int save(Image image);
}