package SERVLET;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.GuestBook;

@WebServlet("/AddEntryGuestBook")
public class AddEntryGuestBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddEntryGuestBook() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8"); 
		
		//Lấy name từ Session Scope
		String name=(String)request.getSession().getAttribute("name");
		
		//Nếu như name không nằm trong Session Scope thì ta lấy name từ input filed và setSession 
		if(name==null)
		{
			name=request.getParameter("name");
			request.getSession().setAttribute("name", name); 
		}	
		
		String message=request.getParameter("message");	
		
		int kq = GuestBook.InsertEntryGuestBook(name, message);
		
		if(kq>0) {
			request.getRequestDispatcher("GuestBooks").forward(request, response);
		}
		else {
			request.getRequestDispatcher("/WEB-INF/500.html").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
