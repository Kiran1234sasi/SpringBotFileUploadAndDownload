package com.example.controller;


import org.springframework.core.io.ByteArrayResource;

import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.ResponseData;
import com.example.entity.Attachment;
import com.example.service.AttachmentService;

@RestController
public class AttachmentController {
	
	private AttachmentService service;
	
	public AttachmentController(AttachmentService service) {
		this.service = service;
	}
	
	@PostMapping("/upload")
	public ResponseData uploadFile(@RequestParam("file")MultipartFile file) throws Exception {
		Attachment attachment = null;
		String downloadURI = "";
		attachment = service.saveAttachment(file);
		downloadURI = ServletUriComponentsBuilder.fromCurrentContextPath()
				.path("/download/")
				.path(attachment.getId())
				.toUriString();
		return new ResponseData(attachment.getFileName(),
				downloadURI,file.getContentType(),file.getSize());
	}
	
	@GetMapping("/download/{field}")
	public ResponseEntity<Resource> downloadFile(@PathVariable String field) throws Exception{
		Attachment attachment = null;
		attachment = service.getAttachment(field);
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(attachment.getTypeName()))
				.header(HttpHeaders.CONTENT_DISPOSITION, 
						"attachment; filename=\""+attachment.getFileName()+"\"")
				.body(new ByteArrayResource(attachment.getData()));
	}

}
