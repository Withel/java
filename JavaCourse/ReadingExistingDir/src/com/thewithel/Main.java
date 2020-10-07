package com.thewithel;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class Main {

    public static void main(String[] args) {

        //filter for looking into directories
//        DirectoryStream.Filter<Path> filter =
//                new DirectoryStream.Filter<Path>() {
//                    public boolean accept(Path path) throws IOException {
//                        return (Files.isRegularFile(path));
//                    }
//                };

        //with lambda expressions
        DirectoryStream.Filter<Path> filter = p -> Files.isRegularFile(p);

//        Path directory = FileSystems.getDefault().getPath("FileTree\\Dir2");

        //now we're using separator to not hard code it, because its bad practice
        Path directory = FileSystems.getDefault().getPath("FileTree" + File.separator + "Dir2");
        //try with resources, directory stream
        try (DirectoryStream<Path> contents = Files.newDirectoryStream(directory, filter)) {
            for (Path file : contents) {
                System.out.println(file.getFileName());
            }

        } catch (IOException | DirectoryIteratorException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        String separator = File.separator;
        System.out.println(separator);
        separator = FileSystems.getDefault().getSeparator();
        System.out.println(separator);

        try {
            Path tempFile = Files.createTempFile("mvapp", ".appext");
            System.out.println("Temporary file path = " + tempFile.toAbsolutePath());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        Iterable<FileStore> stores = FileSystems.getDefault().getFileStores();
        for (FileStore store : stores) {
            System.out.println("Drive letter = " + store);
            System.out.println(store.name());
        }
        System.out.println("\n\n");
        Iterable<Path> rootPaths = FileSystems.getDefault().getRootDirectories();
        for(Path path : rootPaths){
            System.out.println(path);
        }

        System.out.println("\n\nWALKING TREE FOR DIR2");
        Path dir2Path = FileSystems.getDefault().getPath("FileTree" + File.separator + "Dir2");
        //these test i just to create linked list and check if I can get these paths to Linked list
        //I can xddd
        PrintNames test = new PrintNames();
        try {
            Files.walkFileTree(dir2Path, test);
        } catch (IOException e){
            System.out.println(e.getMessage());
        }

//        System.out.println("\n\n");
//        for(Path path : test.test){
//            System.out.println(path.toAbsolutePath());
//        }

        System.out.println("\n\n---Copy Dir2 to Dir4/Dir2copy---");
        Path copyPath = FileSystems.getDefault().getPath("FileTree" + File.separator + "Dir4" + File.separator + "Dir2Copy");
        // FileTree\Dir4\Dir2Copy
        try{
            Files.walkFileTree(dir2Path, new CopyFiles(dir2Path, copyPath));

        } catch (IOException e){
            System.out.println(e.getMessage());
        }

        System.out.println("\n\n");

        File file = new File("\\Examples\\file.txt");
        Path convertedPath = file.toPath();
        System.out.println("convertedPath = " + convertedPath);

        File parent = new File("\\Examples");
        File resolvedFile = new File(parent, "dir\\file.txt");
        System.out.println(resolvedFile.toPath());

        resolvedFile = new File("\\Examples", "dir\\file.txt");
        System.out.println(resolvedFile.toPath());

        Path parentPath = Paths.get("\\Examples");
        Path childRelativePath = Paths.get("dir\\file.txt");
        System.out.println(parentPath.resolve(childRelativePath));

        //when you pass empty string it converts it to your working directory
        File workingDirectory = new File("").getAbsoluteFile();
        System.out.println("Working directory = " + workingDirectory.getAbsolutePath());

        //TWO METHODS BELOW DONT WALK THROUGH FILE TREE
        System.out.println("\n\n PRINT DIR2 CONTENTS USING list()");
        File dir2File = new File(workingDirectory, "\\FileTree\\Dir2");
        String[] dir2Contents = dir2File.list();
        for(int i=0;i<dir2Contents.length; i++){
            System.out.println("i= " + i + ": " + dir2Contents[i]);
        }

        System.out.println("-- print Dir2 contents using listFiles() ---");
        File[] dir2Files = dir2File.listFiles();

        for(int i=0;i<dir2Files.length; i++){
            System.out.println("i= " + i + ": " + dir2Files[i].getName());
        }

    }
}
