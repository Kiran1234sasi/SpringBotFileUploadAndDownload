package com.example.entity;

import java.util.Arrays;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Attachment {
	
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name="uuid",strategy="uuid2")
	private String id;
	private String fileName;
	private String typeName;
	@Lob
	private byte[] data;

	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public byte[] getData() {
		return data;
	}
	public void setData(byte[] data) {
		this.data = data;
	}
	
	public Attachment(String fileName, String typeName, byte[] data) {
		this.fileName = fileName;
		this.typeName = typeName;
		this.data = data;
	}
	
	
	public Attachment() {
		
	}
	
	@Override
	public String toString() {
		return "Attachment [id=" + id + ", fileName=" + fileName + ", typeName=" + typeName + ", data="
				+ Arrays.toString(data) + "]";
	}
	

}
