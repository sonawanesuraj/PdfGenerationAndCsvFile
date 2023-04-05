package com.app.serviceInterface;

import java.io.ByteArrayInputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;

public interface pdfServiceInterface {

	ByteArrayInputStream createPdf();

	String renderHtml(Model model);

	void generatePdf(String html, HttpServletResponse response) throws Exception;
}
