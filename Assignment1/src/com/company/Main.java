package com.company;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    public static String workingDir;
    
    static{
        try {
            workingDir = System.getProperty("user.dir");
            Path path = Files.createDirectories(Paths.get(workingDir + "/TestProjectFolder"));
            workingDir = path.toString();
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to Windows File Viewer!");

        int option = 0;

        while (option != 4) {
            Scanner myObj = new Scanner(System.in);
            System.out.println("\n");
            System.out.println("Press 1 for viewing documents in sorted manner");
            System.out.println("Press 2 for creating document");
            System.out.println("Press 3 for deleting document");
            System.out.println("Press 4 for exit");

            try {
                option = Integer.parseInt(myObj.nextLine());
            } catch (NumberFormatException ex) {
                System.out.println(ex.getMessage());
            }
            switch (option) {
                case 1:
                    viewDocument();
                    break;
                case 2:
                    System.out.println("Enter full name of file.\n");
                    createDocument(myObj.nextLine());
                    break;
                case 3:
                    System.out.println("Enter full name of file.\n");
                    deleteDocument(myObj.nextLine());
                case 4:
                    break;
                default:
                    System.out.println("Enter correct option");
            }
        }
    }

    private static void deleteDocument(String fileName) {
        File targetFile = new File(workingDir+"/"+fileName);
        targetFile.delete();
    }

    private static void createDocument(String fileName) throws IOException {
        File newFile = new File(workingDir+"/"+fileName);
        boolean success = newFile.createNewFile();
        assert(success);
    }

    private static void viewDocument() {
        System.out.println("\n");
        System.out.println("Viewing Files in Current Project Directory = " + workingDir);
        try (Stream<Path> paths = Files.walk(Paths.get(workingDir))) {
                     paths
                    .filter(Files::isRegularFile)
                             .sorted()
                    .forEach(System.out::println);
            System.out.println("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
