package cn.tedu.baking.controller;

import cn.tedu.baking.response.JsonResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping("/v1/")
public class UploadController {
    @PostMapping("upload")
    /*                                     与InfoView中上传头像的name属性一致*/
    public JsonResult upload(MultipartFile file) throws IOException {
        /*获取原始文件名*/
        String fileName = file.getOriginalFilename();
        /*获取文件名中的后缀名*/
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        /*设置随机的名称*/
        fileName = UUID.randomUUID() + suffix;
        //指定一个文件夹路径用来储存图片
        String dirPath = "f:/files";
        //准备日期路径
        SimpleDateFormat sdf = new SimpleDateFormat("/yyyy-MM-dd/");
        String dataPath = sdf.format(new Date());
        //准备对象，封装上面的文件夹路径与日期路径
        File dirFile = new File(dirPath + dataPath);
        //如果文件夹不存在，穿件文件夹
        if (!dirFile.exists()) {
            dirFile.mkdirs();
        }
        //准备一个完整的文件路径
        String filePath = dirPath + dataPath + fileName;
        System.out.println(filePath);
        //把文件保存到指定的路径
        file.transferTo(new File(filePath));
        //讲路径返回给前端
        return JsonResult.ok(dataPath + fileName);
    }
}
