package technology.touchmars.config;

import javax.servlet.annotation.MultipartConfig;

@MultipartConfig(location = "/tmp", fileSizeThreshold = 1024*1024, maxFileSize = 1024*1024*5, maxRequestSize = 1024*1024*25)
public class UploadFileConfig {
}
