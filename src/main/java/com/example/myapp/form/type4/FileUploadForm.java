package com.example.myapp.form.type4;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class FileUploadForm {
	private MultipartFile pdfFile;
}
