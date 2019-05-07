package com.youji.controller;

import com.youji.pojo.Image;
import com.youji.sevrice.IImageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Date;
import java.util.List;

@Api(tags = {"图片模块"})
@Controller
@RequestMapping("/image")
public class ImageController {
    @Autowired
    IImageService service;

    @ResponseBody
    @GetMapping("/deleteById/{id}")
    public int deleteById(@PathVariable Integer id) {

        return service.deleteById(id);
    }

    @ResponseBody
    @GetMapping("/deleteUserId/{userId}")
    public int deleteUserId(@PathVariable Integer userId) {
        return service.deleteByUserId(userId);
    }

    @ResponseBody
    @GetMapping("/select/{userId}")
    public List<Image> select(@PathVariable Integer userId) {
        return service.selectByUserId(userId);
    }


    public void deleteUserId(String fileName) {
        String path = "E:/upload/";
    }
    @ResponseBody
    @PostMapping(value = "/filesUpload",  headers = "content-type=multipart/form-data")
    public boolean filesUpload(@RequestParam("files") MultipartFile[] files, @RequestHeader Integer userId) {
        String path = "E:/upload/";
        //判断file数组不能为空并且长度大于0
        if (files != null && files.length > 0) {
            //循环获取file数组中得文件
            for (int i = 0; i < files.length; i++) {
                MultipartFile file = files[i];
                //保存文件
                saveFile(file, path, userId);
            }
        }
        // 重定向
        return true;
    }

    /***
     * 保存文件
     * @param file
     * @return
     */
    private boolean saveFile(MultipartFile file, String path, Integer userId) {
        // 判断文件是否为空
        if (!file.isEmpty()) {
            try {
                File filepath = new File(path);
                if (!filepath.exists())
                    filepath.mkdirs();
                // 文件保存路径
                String savePath = path + file.getOriginalFilename();
                // 转存文件
                file.transferTo(new File(savePath));
                Image image = new Image();
                image.setAddTime(new Date());
                image.setUserId(userId);
                image.setImageSrc(path);
                service.save(image);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
