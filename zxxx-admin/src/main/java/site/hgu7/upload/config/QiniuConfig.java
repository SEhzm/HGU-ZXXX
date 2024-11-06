package site.hgu7.upload.config;


import com.google.gson.Gson;
import com.qiniu.common.Zone;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QiniuConfig {

    @Value("${qiniu.accessKey}")
    private String accessKey;

    @Value("${qiniu.secretKey}")
    private String secretKey;

    @Value("${qiniu.zone}")
    private String zone;

    /**
     * 配置空间的存储区域
     */
    @Bean
    public com.qiniu.storage.Configuration qiNiuConfig() throws Exception {
        switch (zone) {
            case "huadong":
                return new com.qiniu.storage.Configuration(Zone.huadong());
            case "huabei":
                return new com.qiniu.storage.Configuration(Zone.huabei());
            case "huanan":
                return new com.qiniu.storage.Configuration(Zone.huanan());
            case "beimei":
                return new com.qiniu.storage.Configuration(Zone.beimei());
            default:
                throw new Exception("存储区域配置错误");
        }
    }

    /**
     * 构建一个七牛上传工具实例
     */
    @Bean
    public UploadManager uploadManager() throws Exception {
        return new UploadManager(qiNiuConfig());
    }

    /**
     * 认证信息实例
     */
    @Bean
    public Auth auth() {
        return Auth.create(accessKey, secretKey);
    }

    /**
     * 构建七牛空间管理实例
     */
    @Bean
    public BucketManager bucketManager() throws Exception {
        return new BucketManager(auth(), qiNiuConfig());
    }

    @Bean
    public Gson gson() {
        return new Gson();
    }

}
