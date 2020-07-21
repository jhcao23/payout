package technology.touchmars.util;

import technology.touchmars.model.WalletType;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Instant;

public class FileUtil {

    // stub method to allocate a new File for user's new uploaded Part from web browser
    public static File allocateFile4User(String username, String filename){
        String userHome = System.getProperty("user.home");
        return new File(userHome+File.separator+Instant.now().toEpochMilli()+"_"+filename);
    }

    public static File writeInputStream2File(InputStream in, File file) throws IOException {
        try{
            Files.copy(in, file.toPath());
            return file;
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }



}
