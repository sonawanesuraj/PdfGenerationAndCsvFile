package com.app.serviceImpl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.app.serviceInterface.pdfServiceInterface;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

@Service
public class pdfServiceImpl implements pdfServiceInterface {

	@Override
	public ByteArrayInputStream createPdf() {

		String title = "Savitribai Phule Pune University";
		String content = "Application for Regular Convocation Degree Certificate";

		ByteArrayOutputStream out = new ByteArrayOutputStream();

		Document document = new Document();

		try {
			PdfWriter.getInstance(document, out);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		document.open();
		Font titleFont = FontFactory.getFont(FontFactory.TIMES_ROMAN, 20, BaseColor.BLACK);
		Paragraph titlePara = new Paragraph(title, titleFont);
		titlePara.setAlignment(Element.ALIGN_CENTER);

		Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN, 15, BaseColor.BLACK);
		Paragraph paragraph = new Paragraph(content, font);
		paragraph.setAlignment(Element.ALIGN_LEFT);

		try {
			document.add(titlePara);
			document.add(paragraph);
			document.add(new Paragraph("Application ID: 23047232"));
			document.add(new Paragraph("College / Institute Details"));
			document.add(new Paragraph("College Pun Code: CEGP019340"));
			document.add(new Paragraph("Name of College/Institute: Shri Chhatrapati Shivaji College Shrigonda"));
			document.add(new Paragraph("Addr: "));
			document.add(new Paragraph("Tal: Shrigonda Dist:Ahmednagar"));
			document.add(new Paragraph("Examination: MSC. (Computer Science) Faculty: Engineering"));
			document.add(new Paragraph("Month of Examination: May Year of Examination: 2022"));
			document.add(new Paragraph("Seat No.: B201152305 PRN ( If Any ): 75032054H"));
			document.add(new Paragraph("Special/Principle/Branch/Method: 0"));
			document.add(new Paragraph("Class or Grade Obtained: First Class with Distinction"));
			document.add(new Paragraph("Personal Information"));
			document.add(new Paragraph("Full Name:SONAWANE SURAJ RAJENDRA "));
			document.add(new Paragraph("Mother's Name:SONAWANE SUNITA RAJENDRA"));
			document.add(new Paragraph("Gender: Male"));
			document.add(new Paragraph("Contact No: 9767851926 E-mail: sonawanesuraj5552@gmail.com"));
			document.add(new Paragraph("Correspondence Address"));
			document.add(new Paragraph("Takali Lonar , Shrigonda ,ahmednagar Pincode 413701"));

		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		document.close();

		return new ByteArrayInputStream(out.toByteArray());
	}

	@Autowired
	private SpringTemplateEngine templateEngine;

	@Override
	public String renderHtml(Model model) {
		Context context = new Context();
		context.setVariables(model.asMap());
		return templateEngine.process("infotemplate", context);
	}

	@Override
	public void generatePdf(String html, HttpServletResponse response) throws Exception {
		ITextRenderer renderer = new ITextRenderer();
		renderer.setDocumentFromString(html);
		renderer.layout();
		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition", "attachment; filename=certificate.pdf");
		ServletOutputStream outputStream = response.getOutputStream();
		renderer.createPDF(outputStream);
		outputStream.close();
	}

}
