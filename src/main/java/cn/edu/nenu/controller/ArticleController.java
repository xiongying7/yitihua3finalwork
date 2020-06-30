package cn.edu.nenu.controller;

import cn.edu.nenu.config.CommonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


@Controller
@Slf4j
public class ArticleController {

    @RequestMapping("/file1/index")
    public String index(){
        return "article/file1";
    }


    @RequestMapping("/file1/upload")
    public String upload(@RequestParam(value = "file1", required = false) MultipartFile file1) {

        if(!file1.isEmpty()) {

            String path = "d:\\";
            File destFile = new File(path,file1.getOriginalFilename());
            try {
                file1.transferTo(destFile);
            } catch (IllegalStateException | IOException e) {
                e.printStackTrace();
            }
        }
        return "article/success1";
    }

    @RequestMapping("/file1/download")
    public ResponseEntity download(){

        String filePath = "d:\\xshell-console-log";
        Resource res = CommonUtil.loadFileAsResource(filePath);
        String contentType = null;
        try {
            Path path = Paths.get(res.getFile().getAbsolutePath());
            contentType = Files.probeContentType(path);
        } catch (IOException e) {
            log.error("Could not determine file type. 无法获取文件类型。",e);
        }
        // Fallback to the default content type if type could not be determined
        if (contentType == null){
            contentType = "application/octet-stream";
        }
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION,"attachment;filename=\""+res.getFilename()+"\"")
                .body(res);
    }


}

