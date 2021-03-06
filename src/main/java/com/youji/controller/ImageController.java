package com.youji.controller;

import com.youji.common.Result;
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
    @PostMapping(value = "/fileUpload", headers = "content-type=multipart/form-data")
    public Result filesUpload(@RequestParam("file") MultipartFile file, @RequestHeader Integer userId) {
        String path = "D:/img/";
        //保存文件
        String fileName = saveFile(file, path, userId);
        if (fileName != null) {
            return Result.success(fileName);
        }
        return Result.error();
    }

    /***
     * 保存文件
     * @param file
     * @return
     */
    private String saveFile(MultipartFile file, String path, Integer userId) {
        // 判断文件是否为空
        if (!file.isEmpty()) {
            try {
                File filepath = new File(path);
                if (!filepath.exists())
                    filepath.mkdirs();
                // 获取文件名
                String originalFilename = file.getOriginalFilename();
                //找到.的位置
                String suffix = originalFilename.substring(originalFilename.indexOf(".") + 1);
                String fileName = System.currentTimeMillis() + "." + suffix;
                String savePath = path + fileName;
                String imgUrl = "http://127.0.0.1/" + fileName;
                // 转存文件
                file.transferTo(new File(savePath));

                Image image = new Image();
                image.setAddTime(new Date());
                image.setUserId(userId);
                image.setImageName(fileName);
                image.setImageSrc(imgUrl);
                service.save(image);
                return imgUrl;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
