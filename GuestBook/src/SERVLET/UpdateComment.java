package SERVLET;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdateComment")
public class UpdateComment extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UpdateComment() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int ID = Integer.parseInt(request.getParameter("id"));
		String name = (String)request.getParameter("name");
		String message = (String)request.getParameter("message");
		
		DAO.UpdateEntryDB.UpdateEntry(ID, name, message);
		
		response.sendRedirect("GuestBooks");
	}

}
