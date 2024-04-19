package com.example.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.entity.Attachment;
import com.example.repository.AttachmentRepository;

@Service
public class AttachmentServiceImpl implements AttachmentService{
	
	private AttachmentRepository repo;
	
	public AttachmentServiceImpl(AttachmentRepository repo) {
		this.repo = repo;
	}

	@Override
	public Attachment saveAttachment(MultipartFile file)throws Exception {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		try {
			if(fileName.contains("..")) {
				throw new Exception("File Name COntains Invalid Path Sequence!!");
			}
			Attachment attachment = new Attachment(fileName,
										file.getContentType(),file.getBytes());
			return repo.save(attachment);
		}catch(Exception ex) {
			throw new Exception("could file not saved :"+fileName);
		}
	}

	@Override
	public Attachment getAttachment(String field)throws Exception{
		return repo.findById(field)
				.orElseThrow(() -> new Exception("File Not FOund With Id :"+field));
	}

}
