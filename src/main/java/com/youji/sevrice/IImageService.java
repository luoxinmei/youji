package com.youji.sevrice;

import com.youji.pojo.Image;

import java.util.List;

public interface IImageService {



    /**
     * 根据主键删除照片
     * @param id
     * @return0
     */
    int deleteById(Integer id);
    /**
     * 根据用户id删除照片
     * @param userId
     * @return
     */
    int deleteByUserId(Integer userId);
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
