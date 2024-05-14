package com.shuaibu;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class FolderCreator implements ApplicationRunner {

    private static final String DIRECTORY_NAME = "springimages";
    private File directory;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // Get the user's home directory
        String userHome = System.getProperty("user.home");

        // Create the directory path using the file separator
        String directoryPath = userHome + File.separator + DIRECTORY_NAME;

        // Create the directory if it does not exist
        directory = new File(directoryPath);

        if (!directory.exists()) {
            if (directory.mkdirs()) {
                System.out.println("Directory created successfully.");
            } else {
                System.err.println("Failed to create directory!");
            }
        } else {
            System.out.println("Directory already exists.");
        }


        // Add shutdown hook to delete the directory when application stops
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            if (directory.exists()) {
                deleteDirectory(directory);
            }
        }));
    }

    // Recursive function to delete directory and its contents
    private void deleteDirectory(File dir) {
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    deleteDirectory(file);
                } else {
                    file.delete();
                }
            }
        }
        // if the dir is empty, then delete
        dir.delete();
        System.out.println("Directory deleted successfully.");
    }
}

