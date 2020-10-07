package com.thewithel;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class MainCopyFiles {
    public static void main(String[] args) {
        try {
            //creating empty file
//            Path fileToCreate = FileSystems.getDefault().getPath("Examples", "file2.txt");
//            Files.createFile(fileToCreate);

            //creating directory
//            Path dirToCreate = FileSystems.getDefault().getPath("Examples", "Dir4");
//            Files.createDirectory(dirToCreate);

            //creating multiple directories
            Path multipleDirectories = FileSystems.getDefault().getPath("Examples", "Dir2\\Dir3\\Dir4\\Dir5\\Dir6");
            Files.createDirectories(multipleDirectories);

            //we couldve also done
//            Path multipleDirectories = FileSystems.getDefault().getPath("Examples\\Dir2\\Dir3\\Dir4\\Dir5\\Dir6\\Dir7");


//            //deleting file
//            Path fileToDelete = FileSystems.getDefault().getPath("Examples", "Dir1", "filecopy.txt");
//            Files.deleteIfExists(fileToDelete);

            //renaming is achieved by moving to the same path but with other name
//            Path fileToMove = FileSystems.getDefault().getPath("Examples", "file2.txt");
//            Path destinatio = FileSystems.getDefault().getPath("Examples", "file1.txt");
//            Files.move(fileToMove, destinatio);

//            //moving file
//            Path fileToMove = FileSystems.getDefault().getPath("Examples", "file1copy.txt");
//            Path destinatio = FileSystems.getDefault().getPath("Examples", "Dir1", "filecopy.txt");
//            Files.move(fileToMove, destinatio);

            //copying file
//            Path sourceFile = FileSystems.getDefault().getPath("Examples", "file1.txt");
//            Path copyFile = FileSystems.getDefault().getPath("Examples", "file1copy.txt");
//            //method for copying below, when you try copy to name of file that already exists,
//            //you will get exception, or you can pass third parameter StandardCopyOption.REPLACE_EXISTING
//            Files.copy(sourceFile, copyFile, StandardCopyOption.REPLACE_EXISTING);
//
            //copying directory
//            //you can also copy directories, but files inside arent copied by default
//            sourceFile = FileSystems.getDefault().getPath("Examples", "Dir1");
//            copyFile = FileSystems.getDefault().getPath("Examples", "Dir4");
//            Files.copy(sourceFile, copyFile, StandardCopyOption.REPLACE_EXISTING);
            //you can move directories

        } catch(IOException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
