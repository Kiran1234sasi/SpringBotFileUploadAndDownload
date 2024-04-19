package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Attachment;


@Repository
public interface AttachmentRepository extends JpaRepository<Attachment, String>{

}
