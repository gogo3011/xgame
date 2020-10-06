package Utils.Helpers;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
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

    public static ArrayList<String> scanForJsonFiles(String path) {
        return FileHelper.getFilesInFolder(path, "json");
    }

    public static JSONObject getJsonContents(String path) {
        String json = "";
        try {
            json = Files.readString(Paths.get(path));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject = (JSONObject) parser.parse(json);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return jsonObject;
    }
}
