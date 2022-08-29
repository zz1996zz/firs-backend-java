package fastcampus.saladbank.web;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

@Slf4j
public class ImageToBase64Encoder {

    public String imageToBase64(String imageName) throws IOException {
        String filePath = makeFilePath(imageName);
        InputStream inputStream = new FileInputStream(filePath);
        byte[] byteArray = IOUtils.toByteArray(inputStream);
        return Base64.getEncoder().encodeToString(byteArray);
    }

    private String makeFilePath(String imageName) {
        return "src/main/resources/img/" + imageName + ".png";
    }
}
