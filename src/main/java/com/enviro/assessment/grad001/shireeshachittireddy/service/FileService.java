package com.enviro.assessment.grad001.shireeshachittireddy.service;

import java.nio.charset.StandardCharsets;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.enviro.assessment.grad001.shireeshachittireddy.entity.FileEntity;
import com.enviro.assessment.grad001.shireeshachittireddy.repository.FileRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FileService {

	@Autowired
	private FileRepository fileRepository;

	public FileEntity uploadFile(MultipartFile file) throws Exception {

		String fileData = new String(file.getBytes());
		if (fileData != null && !file.isEmpty()) {
			if (!file.getContentType().equals("text/plain")) {
				log.error("Upload only Text files.....{}");
	            throw new IllegalArgumentException("Only text files are allowed.");
	        }		
			FileEntity fileEntity = new FileEntity();
			fileEntity.setFileName(file.getOriginalFilename());
			log.info("service cls upload file method ");
			fileEntity.setFileData(fileData);
			return fileRepository.save(fileEntity);
		} else {
			log.error("file data is null or empty.....{}");
			throw new IllegalArgumentException("File data is null or file is empty.");
		}
		
	}

	public FileEntity getFileData(Integer id) throws Exception {
		Optional<FileEntity> fileDataOptional = fileRepository.findById(id);
		if(fileDataOptional.isPresent()) 
		log.info("service class get file data method executing.........{}");
		return fileDataOptional.orElseThrow();
	}

}