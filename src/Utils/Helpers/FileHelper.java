package Utils.Helpers;

import java.io.File;
import java.util.ArrayList;
import java.util.Objects;

public class FileHelper {

    public FileHelper(){
    }

    public static ArrayList<String> getFilesInFolder(String path, String extension){
        ArrayList<String> files = new ArrayList<>();
        File folder = new File(path);
        for (final File fileEntry : Objects.requireNonNull(folder.listFiles())) {
            if (!fileEntry.isDirectory()) {
                String fileName = fileEntry.getName();
                if (getFileExtension(fileName).equals(extension)) {
                    files.add(folder + "\\" + fileName);
                }
            }
        }
        return files;
    }

    public static String getFileExtension(String fileName){
        String extension = "";

        int i = fileName.lastIndexOf('.');
        int p = Math.max(fileName.lastIndexOf('/'), fileName.lastIndexOf('\\'));

        if (i > p) {
            extension = fileName.substring(i+1);
        }
        return extension;
    }
}
