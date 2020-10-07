package com.thewithel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ReadingIO {

    //    READING WITH BUFFEREDREADER
//    Using BufferedReader: This method reads text from a character-input
//    stream. It does buffering for efficient reading of characters, arrays, and lines.
//    The buffer size may be specified, or the default size may be used.
//    The default is large enough for most purposes. In general, each read request made
//    of a Reader causes a corresponding read request to be made of the underlying
//    character or byte stream. It is therefore advisable to wrap a BufferedReader around
//    any java.io.Reader whose read() operations may be costly, such as FileReaders and InputStreamReaders.

    //cant take path as a parameter
    public static void bufferedReading() throws Exception {
        System.out.println("Reading file with BufferedReader");
        Path path = FileSystems.getDefault().getPath("read.txt");

        BufferedReader br = new BufferedReader(new FileReader(path.toString()));
        LinkedList<String> lines = new LinkedList<>();

        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
            lines.add(line);
        }

        if (br != null) {
            br.close();
        }
    }

//    READING WITH FILEREADER
//    Using FileReader class: Convenience class for reading character files.
//    The constructors of this class assume that the default character encoding
//    and the default byte-buffer size are appropriate.

    public static void fileReading() throws Exception {
        System.out.println("Reading file with FileReader");
        //it reads chars and convert it to ints
        Path path = FileSystems.getDefault().getPath("readInt.txt");

        FileReader fr = new FileReader(path.toString());
        Integer x;
        LinkedList<Integer> ints = new LinkedList<>();

        while ((x = fr.read()) != -1) {
            System.out.println(x);
            ints.add(x);
        }

        if (fr != null) {
            fr.close();
        }
    }

//    READING WITH SCANNER
//    Using Scanner class: A simple text scanner which can parse primitive types
//    and strings using regular expressions. A Scanner breaks its input into tokens
//    using a delimiter pattern, which by default matches whitespace.The resulting
//    tokens may then be converted into values of different types using the various next methods.

    public static void scannerReading() throws Exception {
        System.out.println("Reading with Scanner");
        Path path = FileSystems.getDefault().getPath("read.txt");

        Scanner scanner = new Scanner(new FileReader(path.toString()));
        String line;
        LinkedList<String> lines = new LinkedList<>();
//        can be used for reading parts of lines
//        scanner.useDelimiter(" ");

        //can be also used without loops
        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
//            scanner.skip(scanner.delimiter());
            System.out.println(line);
            lines.add(line);
        }

        if (scanner != null) {
            scanner.close();
        }
    }

//    READING THE WHOLE FILE IN A LIST
//    Read all lines from a file. This method ensures that the file is closed
//    when all bytes have been read or an I/O error, or other runtime exception, is thrown.
//    Bytes from the file are decoded into characters using the specified charset.

    public static void readingWholeFileInAList() {
        System.out.println("Reading all lines");
        List<String> lines = Collections.emptyList();
        Path path = FileSystems.getDefault().getPath("read.txt");

        try {
            lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String s : lines) {
            System.out.println(s);
        }
    }

    //    READ A TEXT FILE AS STRING
    public static void readAsString() throws Exception {
        System.out.println("Reading file as a String");
        String data;
        Path path = FileSystems.getDefault().getPath("read.txt");

        data = new String(Files.readAllBytes(path));
        System.out.println(data);
    }
}
