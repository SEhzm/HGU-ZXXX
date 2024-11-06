package site.hgu7.upload;

import com.qiniu.common.QiniuException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/file/upload")
public class uploadController {

    @Autowired
    private IQiniuService qiniuService;


    @PostMapping
    public String upload(@RequestParam(name = "file", required = false) MultipartFile file) throws QiniuException, IOException {
        // 检查文件是否为空
        if (file == null || file.isEmpty()) {
            throw new IllegalArgumentException("文件不能为空");
        }

        // 将 MultipartFile 转换为 File
        File tempFile = File.createTempFile(System.currentTimeMillis() + file.getOriginalFilename(), ".tmp");
        file.transferTo(tempFile);

        try {
            // 调用七牛云上传方法
            String result = qiniuService.uploadFile(tempFile, System.currentTimeMillis() + file.getOriginalFilename());
//            System.out.println("访问地址： " + result);
            return result;
        } finally {
            // 删除临时文件
            if (tempFile.exists()) {
                tempFile.delete();
            }
        }
    }

}
