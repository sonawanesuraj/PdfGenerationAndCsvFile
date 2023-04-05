package com.app.controller;

import java.io.ByteArrayInputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.serviceInterface.pdfServiceInterface;

@RestController
@RequestMapping("/pdf")
public class pdfController {

	@Autowired
	private pdfServiceInterface pdfServiceInterface;

	@GetMapping
	public ResponseEntity<?> createPdf() {
		ByteArrayInputStream pdf = this.pdfServiceInterface.createPdf();
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Content", "inline;file=abc.pdf");

		return ResponseEntity.ok().headers(httpHeaders).contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(pdf));
	}

	@GetMapping("/generate-pdf")
	public void generatePdf(Model model, HttpServletResponse response) throws Exception {

		model.addAttribute("image", "classpath:/templates/sppulogo1.jpg");
		model.addAttribute("fullName", "Suraj Sonawane");
		model.addAttribute("motherName", "Sunita");
		model.addAttribute("gender", "Male");
		model.addAttribute("contactNo", "9767851926");
		model.addAttribute("email", "sonawanesuraj@gmail.com");
		model.addAttribute("address", "Takali Lonar");
		model.addAttribute("pincode", "413701");
		model.addAttribute("collegeCode", "SCSMP019340");
		model.addAttribute("collegeName", "Shri Chhatrapati Shivaji College Shrigonda");
		model.addAttribute("collegeAddress", "Shrigonda Dist:Ahmednagar");
		model.addAttribute("examination", "MSC. (Computer Science)");
		model.addAttribute("examMonth", "May");
		model.addAttribute("examYear", "2022");
		model.addAttribute("seatNo", "B201152305");
		model.addAttribute("prn", "75032054H");
		model.addAttribute("classOrGradeObtained", "First Class with Distinction");

		String html = pdfServiceInterface.renderHtml(model);

		// generate PDF using Flying Saucer
		pdfServiceInterface.generatePdf(html, response);
	}

}
