package com.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseData {
	
	private String fileName;
	private String downloadURL;
	private String fileType;
	private long fileSize;
	
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getDownloadURL() {
		return downloadURL;
	}
	public void setDownloadURL(String downloadURL) {
		this.downloadURL = downloadURL;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public long getFileSize() {
		return fileSize;
	}
	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}
	
	public ResponseData(String fileName, String downloadURL, String fileType, long fileSize) {
		this.fileName = fileName;
		this.downloadURL = downloadURL;
		this.fileType = fileType;
		this.fileSize = fileSize;
	}
	
	
	public ResponseData() {
	
	}
	
	
	@Override
	public String toString() {
		return "ResponseData [fileName=" + fileName + ", downloadURL=" + downloadURL + ", fileType=" + fileType
				+ ", fileSize=" + fileSize + "]";
	}
}
