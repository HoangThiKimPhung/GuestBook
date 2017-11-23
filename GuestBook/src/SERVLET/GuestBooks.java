package SERVLET;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.GuestBook;
import MODEL.GuestBookEntry;

@WebServlet("/GuestBooks")
public class GuestBooks extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GuestBooks() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<GuestBookEntry> entries = GuestBook.SelectEntry();
		
		request.setAttribute("entries", entries);
		request.getRequestDispatcher("GuestBook.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
