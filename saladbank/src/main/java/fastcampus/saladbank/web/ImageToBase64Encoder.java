package fastcampus.saladbank.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.util.Base64;

@Slf4j
public class ImageToBase64Encoder {

    private String filePath;

    public ImageToBase64Encoder(String filePath) {
        this.filePath = filePath;
    }

    public String imageToBase64() throws IOException {
        ClassPathResource resource = new ClassPathResource("img/" + filePath + ".png");
        byte[] bytes = FileCopyUtils.copyToByteArray(resource.getInputStream());
        return Base64.getEncoder().encodeToString(bytes);
    }
}
