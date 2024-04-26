package com.enviro.assessment.grad001.shireeshachittireddy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.enviro.assessment.grad001.shireeshachittireddy.entity.FileEntity;
import com.enviro.assessment.grad001.shireeshachittireddy.service.FileService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class FileController {
	
	@Autowired
	private FileService fileService;
	
	@PostMapping("/upload")
	public FileEntity uploadFile(@RequestParam("file") MultipartFile file) throws Exception{
		
		 log.info("controller class upload method executing ...{}");
		return fileService.uploadFile(file);
	}	
		@GetMapping("/data/{id}")
		public FileEntity getFileData(@PathVariable Integer id) throws Exception{
			log.info("controller class getting data from database... {}");
			return fileService.getFileData(id);
		}
		
		
	}
