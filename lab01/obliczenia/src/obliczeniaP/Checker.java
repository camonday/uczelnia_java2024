package obliczeniaP;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;

public class Checker {
    public static boolean checkMD5(String folderPath) throws IOException, NoSuchAlgorithmException {
        String filePath = createZipFilePath(folderPath);
        String oldie = readFileContent(folderPath);
        String newbie = CounterMD5.countMD5(filePath);

        return oldie.equals(newbie);
    }

    public static String readFileContent(String folderPath){
        Path filePath = Paths.get(folderPath, "MD5.txt");
        String content = "";

        try {
            content = new String(Files.readAllBytes(filePath));
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }

        return content;
    }

    public static String createZipFilePath(String folderPath) {
        Path path = Paths.get(folderPath);
        Path fileName = path.getFileName(); // Get the last part of the path
        if (fileName != null) {
            String zipFileName = fileName.toString() + ".zip"; // Append .zip to the last part of the path
            folderPath += "/" +zipFileName;
            return folderPath;
        } else {
            return null;
        }
    }
}
