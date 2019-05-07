package com.youji.controller;

import com.youji.common.Result;
import com.youji.pojo.Image;
import com.youji.sevrice.IImageService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Date;
import java.util.List;

import static java.lang.System.currentTimeMillis;

@Api(tags = {"文件上传"})
@Controller
@RequestMapping("/file")
public class FileUploadController {

    @ResponseBody
    @PostMapping(value = "/filesUpload", headers = "content-type=multipart/form-data")
    public Result filesUpload(@RequestParam("file") MultipartFile file) {
        String path = "D:/img/";
        //保存文件
        String fileName = saveFile(file, path);
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
    private String saveFile(MultipartFile file, String path) {
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
                // 转存文件
                file.transferTo(new File(savePath));
                return "http://127.0.0.1/" + fileName;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static void main(String[] args) {
        String aaa = "fdsdfasfsdf.jpg";
        //找到.的位置
        String suffix = aaa.substring(aaa.indexOf(".") + 1);
        System.out.println(currentTimeMillis() + "." + suffix);
    }
}
