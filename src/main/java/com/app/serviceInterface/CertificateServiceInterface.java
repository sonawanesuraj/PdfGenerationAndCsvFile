package com.app.serviceInterface;

import javax.servlet.http.HttpServletResponse;

public interface CertificateServiceInterface {

	void generatePdf(Long certificateId, HttpServletResponse response) throws Exception;

}
