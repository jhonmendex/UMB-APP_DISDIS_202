package co.edu.umb.ds.productinfo.model.util;

import co.edu.umb.ds.productinfo.business.exception.ApiRequestException;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtil {
    public final static String UPLOADED_FOLDER = System.getProperty("user.home")
            + File.separator + "productInfo" + File.separator;


    public static String saveImageProductFile(MultipartFile file, String name) throws ApiRequestException {
        try {
            createFolder();
            if (!file.isEmpty()) {
                byte[] bytes = file.getBytes();
                Path path = Paths.get(UPLOADED_FOLDER + name);
                Files.write(path, bytes);
                return UPLOADED_FOLDER + name;
            }
        } catch (IOException e) {
            throw new ApiRequestException("Error al guardar la imagen");
        }
        throw new ApiRequestException("Hubo un error");
    }


    private static void createFolder() throws IOException {
        Path folderDirectory = Paths.get(UPLOADED_FOLDER);
        if (!Files.exists(folderDirectory)) {
            Files.createDirectories(folderDirectory);
        }
    }

}
