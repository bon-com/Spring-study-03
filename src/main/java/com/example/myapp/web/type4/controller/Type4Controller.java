
package com.example.myapp.web.type4.controller;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.example.myapp.form.type4.FileUploadForm;

@Controller

@RequestMapping("type4/fileupload")
public class Type4Controller {
	/**
	 * PDFファイルアップロード画面の表示
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "form", method = GET)
	public String showUploadForm(Model model) {
		model.addAttribute("uploadForm", new FileUploadForm());
		return "type4/upload";
	}

	/**
	 * PDFファイルアップロード
	 * 
	 * @param form
	 * @return
	 */
	@RequestMapping(value = "form", method = POST)
	public String uploadFile(@ModelAttribute("uploadForm") FileUploadForm form) {
		MultipartFile pdfFile = form.getPdfFile();
		// ファイル名
		String fileName = pdfFile.getOriginalFilename();
		// サイズ
		long size = pdfFile.getSize();
		// コンテンツタイプ
		String contentType = pdfFile.getContentType();
		try {
			// 内容（byte配列）
			byte[] fileContent = pdfFile.getBytes();
		} catch(IOException e) {
			e.printStackTrace();
		}
		// アップロードファイルを保存
		File dest = new File("C:\\var\\tmp\\" + fileName);
		try {
			pdfFile.transferTo(dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "type4/upload";
	}

}
