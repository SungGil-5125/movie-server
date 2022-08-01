package com.project.watcha.domain.movie.service;

import org.springframework.web.multipart.MultipartFile;

public interface S3Service {

    String upload(MultipartFile file, String dirName);
    void deleteFile(String fileName);
    String createFileName(String fileName);
    String getFileExtension(String fileName);
}
