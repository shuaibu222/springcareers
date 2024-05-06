package com.shuaibu;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import jakarta.annotation.PreDestroy;

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
        File directory = new File(directoryPath);

        if (!directory.exists()) {
            if (directory.mkdirs()) {
                System.out.println("Directory created successfully.");
            } else {
                System.err.println("Failed to create directory!");
            }
        }
    }

    @PreDestroy
    public void deleteDirectory() {
        // Delete the directory and its content when the application is shutting down
        if (directory != null && directory.exists()) {
            if (directory.delete()) {
                System.out.println("Directory deleted successfully.");
            } else {
                System.err.println("Failed to delete directory!");
            }
        }
    }
}

