package com.example.service;

import org.springframework.web.multipart.MultipartFile;

import com.example.entity.Attachment;

public interface AttachmentService {

	Attachment saveAttachment(MultipartFile file)throws Exception;

	Attachment getAttachment(String field)throws Exception;

}
