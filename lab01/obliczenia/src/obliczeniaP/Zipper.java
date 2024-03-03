package obliczeniaP;

import java.io.*;
import java.util.zip.*;

public class Zipper {

    public Zipper(String entryPath, String exitPath) throws IOException {
        String sourceFile = entryPath;
        File fileToZip = new File(sourceFile);
        exitPath = exitPath + "/" + fileToZip.getName();

        File directories = new File(exitPath);
        if (!directories.exists()) {
            directories.mkdirs();
        }
        System.out.println("zapisze pod: "+directories.getAbsolutePath());

        FileOutputStream fos = new FileOutputStream(exitPath+ "/" + fileToZip.getName() +".zip");
        ZipOutputStream zipOut = new ZipOutputStream(fos);


        zipFile(fileToZip, fileToZip.getName(), zipOut);
        zipOut.close();
        fos.close();


        FileWriter fileWriter = new FileWriter(exitPath + "/good.txt");
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.print("Well done");
        printWriter.close();
    }
     void zipFile(File fileToZip, String fileName, ZipOutputStream zipOut) throws IOException {
        if (fileToZip.isHidden()) {
            return;
        }
        if (fileToZip.isDirectory()) {
            if (fileName.endsWith("/")) {
                zipOut.putNextEntry(new ZipEntry(fileName));
                zipOut.closeEntry();
            } else {
                zipOut.putNextEntry(new ZipEntry(fileName + "/"));
                zipOut.closeEntry();
            }
            File[] children = fileToZip.listFiles();
            assert children != null;
            for (File childFile : children) {
                zipFile(childFile, fileName + "/" + childFile.getName(), zipOut);
            }

            return;
        }


        FileInputStream fis = new FileInputStream(fileToZip);
        ZipEntry zipEntry = new ZipEntry(fileName);
        zipOut.putNextEntry(zipEntry);

        byte[] bytes = new byte[1024];
        int length;
        while((length = fis.read(bytes)) >= 0) {
            zipOut.write(bytes, 0, length);
        }

        fis.close();
    }

}
