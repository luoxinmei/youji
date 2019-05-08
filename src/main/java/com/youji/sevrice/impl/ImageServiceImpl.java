package com.youji.sevrice.impl;

import com.youji.dao.IImageDao;
import com.youji.pojo.Image;
import com.youji.sevrice.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

@Service
public class ImageServiceImpl implements IImageService {
    @Autowired
    IImageDao dao;

    @Override
    public int deleteById(Integer id) {

        return dao.deleteById(id);
    }

    @Override
    public int deleteByUserId(Integer userId) {
        List<Image> images = dao.selectByUserId(userId);
        for (Image image : images) {
            String imageName = image.getImageName();
            String filePath = "D:/img/" +  imageName;
            File file = new File(filePath);
            if (file.exists()) {
                file.delete();
            }
        }

        return dao.deleteByUserId(userId);
    }

    @Override
    public List<Image> selectByUserId(Integer userId) {
        return dao.selectByUserId(userId);
    }

    @Override
    public int save(Image image) {
        return dao.save(image);
    }
}
