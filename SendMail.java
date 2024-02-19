package com.vk.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import com.vk.Helper.Helper;

@WebServlet("/sendemail")
public class SendMail extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String to = req.getParameter("to");
		String subject = req.getParameter("subject");
		String message = req.getParameter("message");
        
		Helper.sendMail(subject, message, to);
		PrintWriter pw = res.getWriter() ;
		pw.println("<h1 style=color:green> Mail sent successfully </h1>") ;
		RequestDispatcher rd = req.getRequestDispatcher("EmailSender.html") ;
		rd.include(req, res) ;

	}

}