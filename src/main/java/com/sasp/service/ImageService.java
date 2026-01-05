package com.sasp.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageService {

    public String processImageUrl(MultipartFile file) {

        try {
            String uploadDir = "D:/filesp/f/";

            Files.createDirectories(Paths.get(uploadDir));

            String originalName = file.getOriginalFilename();
            String safeName = originalName.replaceAll("[^a-zA-Z0-9\\.]", "_");

            String fileName = UUID.randomUUID() + "_" + safeName;

            Path filePath = Paths.get(uploadDir).resolve(fileName);

            Files.write(filePath, file.getBytes());

            return "http://localhost:8080/images/members/" + fileName;

        } catch (IOException e) {
            throw new RuntimeException("Failed to store file", e);
        }
    }

}
