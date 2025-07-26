package Utils;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


public class SimpleFiles {
    
    public static void storeImageAtResources(File logo, int uniqueImgId, String imageName) throws Exception {
        Files.copy(logo.toPath(), Paths.get("resources/" + uniqueImgId + "_" + imageName), StandardCopyOption.REPLACE_EXISTING);
    }
    
    public static void deleteFile(String path) throws Exception {
        
    }
    
    public static void purgeResources() throws Exception {
        
    }
}
