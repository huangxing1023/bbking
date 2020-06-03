package com.family.bbkingweb.controller;

import com.family.bbkingweb.dao.entity.user.User;
import com.family.bbkingweb.dao.entity.contribute.UploadFile;
import com.family.bbkingweb.service.UploadService;
import org.apache.commons.collections.map.HashedMap;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("upload")
public class UploadController {
    private static final Logger log = LoggerFactory.getLogger(UploadController.class);
    private String  url;
    @Autowired
    private UploadService uploadService;
    @ResponseBody
    @RequestMapping("uploadVideo")
    public Map<String,Object> uploadVideo(@RequestParam("file") MultipartFile file){
        Map<String,Object> result = new HashedMap();
        System.out.print("上传文件==="+"\n");
        //判断文件是否为空
        if (file.isEmpty()) {
            result.put("status","failed");
            result.put("msg","上传文件不可为空");
            return result;
        }

        String videoFieldId = "";
        // 获取文件名
        String fileName = file.getOriginalFilename();
//        System.out.print("上传的文件名为: "+fileName+"\n");

        fileName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "_" + fileName;
        System.out.print("（加个时间戳，尽量避免文件名称重复）保存的文件名为: "+fileName+"\n");//可连接个人id


        //加个时间戳，尽量避免文件名称重复
        String path = "E:/Resources/videos/" +fileName;
        //String path = "E:/fileUpload/" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "_" + fileName;
        //文件绝对路径
        System.out.print("保存文件绝对路径"+path+"\n");

        //创建文件路径
        File dest = new File(path);

        //判断文件是否已经存在
        if (dest.exists()) {
            result.put("status","failed");
            result.put("msg","文件已经存在");
            return result;
        }

        //判断文件父目录是否存在
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdir();
        }

        try {
            //上传文件
            file.transferTo(dest); //保存文件
            System.out.print("保存文件路径"+path+"\n");
            //url="http://你自己的域名/项目名/images/"+fileName;//正式项目
            url="http://localhost:8080/images/"+fileName;//本地运行项目
            User user = (User) SecurityUtils.getSubject().getPrincipal();
            UploadFile uploadFile = new UploadFile();
            uploadFile.setId(UUID.randomUUID().toString());
            videoFieldId = uploadFile.getId();
            uploadFile.setPath(path);
            uploadFile.setUrl(url);
            uploadFile.setCreator(user.getId());
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String date = sf.format(new Date());
            uploadFile.setCreateTime(date);
            int flag = uploadService.saveUploadFile(uploadFile);
            System.out.print("保存的完整url===="+url+"\n");
        } catch (IOException e) {
            result.put("status","error");
            return result;
        }
        result.put("status","success");
        result.put("url",url);
        result.put("videoFieldId",videoFieldId);
        return result;
    }

    @ResponseBody
    @RequestMapping("uploadImagie")
    public Map<String,Object> uploadImagie(@RequestParam("file") MultipartFile file){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Map<String,Object> result = new HashedMap();
        System.out.print("上传文件==="+"\n");
        //判断文件是否为空
        if (file.isEmpty()) {
            result.put("status","failed");
            result.put("msg","上传文件不可为空");
            return result;
        }

        String imageFieldId = "";
        // 获取文件名
        String fileName = file.getOriginalFilename();
//        System.out.print("上传的文件名为: "+fileName+"\n");

        fileName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "_" + fileName;
        System.out.print("（加个时间戳，尽量避免文件名称重复）保存的文件名为: "+fileName+"\n");//可连接个人id


        //加个时间戳，尽量避免文件名称重复
        String path = "E:/Resources/images/" +fileName;
        //String path = "E:/fileUpload/" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "_" + fileName;
        //文件绝对路径
        System.out.print("保存文件绝对路径"+path+"\n");

        //创建文件路径
        File dest = new File(path);

        //判断文件是否已经存在
        if (dest.exists()) {
            result.put("status","failed");
            result.put("msg","文件已经存在");
            return result;
        }

        //判断文件父目录是否存在
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdir();
        }

        try {
            //上传文件
            file.transferTo(dest); //保存文件
            System.out.print("保存文件路径"+path+"\n");
            //url="http://你自己的域名/项目名/images/"+fileName;//正式项目
            url="http://localhost:8080/images/"+fileName;//本地运行项目
            User user = (User) SecurityUtils.getSubject().getPrincipal();
            UploadFile uploadFile = new UploadFile();
            uploadFile.setId(UUID.randomUUID().toString());
            imageFieldId = uploadFile.getId();
            uploadFile.setPath(path);
            uploadFile.setUrl(url);
            uploadFile.setCreator(user.getId());
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String date = sf.format(new Date());
            uploadFile.setCreateTime(date);
            int flag = uploadService.saveUploadFile(uploadFile);
            System.out.print("保存的完整url===="+url+"\n");
        } catch (IOException e) {
            result.put("status","error");
            return result;
        }
        result.put("status","success");
        result.put("url",url);
        result.put("imageFieldId",imageFieldId);
        return result;
    }
}
