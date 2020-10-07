package com.thewithel;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

//root node has to be included in paths -> different ways to get it

public class Main {

    public static void main(String[] args) {
        Path path = FileSystems.getDefault().getPath("WorkingDirectoryFile.txt");
        printFile(path);
        //can accept two arguments first is folder in our working directory
        //"If file has three or more directories deep, you add each subdirectory
        //as a parameter in the order that you want them to apear in the path"
//        Path filePath = FileSystems.getDefault().getPath("Files", "SubdirectoryFile.txt");

        //you can also do this, that way (remember about ordering)
        Path filePath = Paths.get(".", "Files", "SubdirectoryFile.txt");
        printFile(filePath);
        filePath = Paths.get("D:\\zCoding\\MainRepos\\JavaCourse\\PathsOutThere.txt");
        //also correct - passing three arguments
//        filePath = Paths.get("D:\\zCoding\\", "MainRepos\\JavaCourse", "\\PathsOutThere.txt");
        printFile(filePath);

        System.out.println();
        filePath = Paths.get(".");
        System.out.println(filePath.toAbsolutePath());

        Path path2 = FileSystems.getDefault().getPath(".", "files", "..", "files", "SubdirectoryFile.txt");
        System.out.println(path2.normalize().toAbsolutePath());
        printFile(path2.normalize());

        Path path3 = FileSystems.getDefault().getPath("thisfiledoesnotexist.txt");
        //you can create path to file that does not exists
        System.out.println(path3.toAbsolutePath());

        Path path4 = Paths.get("D:\\someFolder\\doesntexits\\something", "\\123456", "\\wata.txt");
        System.out.println(path4.toAbsolutePath());

        //exists method checks if the path exists, you can also use notExists
        filePath = FileSystems.getDefault().getPath("files");
        System.out.println("Exists = " + Files.exists(filePath));

        Path path5 = Paths.get("D:\\Program Files (x86)\\PotPlayer\\PotPlayerMini64.exe");

        System.out.println("Executable = " + Files.isExecutable(path5));
        System.out.println("Exists = " + Files.exists(path4));

        //CHECK STH
//        String pathCheck = path.toString();
//        File file = new File(pathCheck);
//        if (! file.exists()) {
//            throw new IllegalArgumentException("The file " + path + " does not exist");
//        }
//        try {
//            Process p = Runtime.getRuntime().exec(file.getAbsolutePath());
//        } catch (IOException e){
//            e.printStackTrace();
//        }
    }

    private static void printFile(Path path) {
        System.out.println();
        System.out.println("Path = " + path);
        try (BufferedReader fileReader = Files.newBufferedReader(path)) {
            String line;
            while ((line = fileReader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
