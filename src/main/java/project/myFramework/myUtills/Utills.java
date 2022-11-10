package project.myFramework.myUtills;

import org.apache.log4j.Logger;
import project.testData.User;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

public class Utills {
    final static Logger log = Logger.getLogger(Utills.class);
    private final static int maxIterations = 1000;
    private static final int oneHundred = 100;

    public static User[][] arrHelper(List<User> list) {
        //List<User> list = JsonParser.userData();
        User[][] a = new User[list.size()][1];
        for (int x = 0; x < list.size(); x++) {
            a[x][0] = list.get(x);
        }
        return a;
    }

    public static int getRanomInt() {
        return (int) (Math.random() * oneHundred);
    }

    public static String getTimeFormat(String pattern, Locale loc) {
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern, loc);
        return dateTime.format(formatter);
    }

    public static String getTimeFormat(String pattern) {
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return dateTime.format(formatter);
    }

    public static int getNextLeapYear() {
        int currenYear = Integer.parseInt(Utills.getTimeFormat("yyyy"));
        while ((currenYear % 4) != 0) {
            currenYear++;
        }
        return currenYear;
    }

    public static long checkFiles(String dirPath) {
        File dir = new File(dirPath);
        File[] files = dir.listFiles();
        if (files == null || files.length == 0) {
            return 0;
        } else {
            return files.length;
        }
    }


    public static File getLastModifiedFile(String dirPath) {
        File dir = new File(dirPath);
        File[] files = dir.listFiles();

        File lastModifiedFile = files[0];
        for (int i = 1; i < files.length; i++) {
            if (lastModifiedFile.lastModified() < files[i].lastModified()) {
                lastModifiedFile = files[i];
            }
        }
        return lastModifiedFile;
    }

    public static File waitToJpeg(String ext,String filesPath, long initialQuantity) {

        int iteration = 0;
        while (Utills.checkFiles(filesPath) != initialQuantity + 1) {
            iteration++;
            if (iteration > maxIterations) {
                break;
            }
        }

        File newFile = Utills.getLastModifiedFile(filesPath);
        if (newFile.getPath().endsWith(".tmp")) {
            iteration = 0;
            while (newFile.exists()) {
                iteration++;
                if (iteration > maxIterations) {
                    break;
                }
            }

            while (Utills.checkFiles(filesPath) != initialQuantity + 1) {
                iteration++;
                if (iteration > maxIterations) {
                    break;
                }
            }
        }
        newFile = Utills.getLastModifiedFile(filesPath);
        if (newFile.getPath().endsWith(".crdownload")) {
            iteration = 0;
            while (newFile.exists()) {
                iteration++;
                if (iteration > maxIterations) {
                    break;
                }
            }

            iteration = 0;
            while (Utills.checkFiles(filesPath) != initialQuantity + 1) {
                iteration++;
                if (iteration > maxIterations) {
                    break;
                }
            }
        }
        newFile = Utills.getLastModifiedFile(filesPath);
        log.info("Last file name "+newFile.getName());
        if(newFile.getPath().endsWith("."+ext)) {
            return newFile;
        }else {return null;}
    }

    public static String getExt(String name){
        String[] words = name.split("\\.");
        return words[words.length-1];
    }

    public static void deleteFolder(String path){
        File file = new File(path);
        if(file.exists()){
            file.delete();
        }
        if(file.exists()){
            String[] paths = file.list();
            for(String str:paths){
                deleteFolder(path+"\\"+str);
            }
            file.delete();
        }

    }

}

