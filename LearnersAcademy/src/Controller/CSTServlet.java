package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.hibernateConnector;
import pojo.classsubjectteacher;
import pojo.teachers;

/**
 * Servlet implementation class CSTServlet
 */
@WebServlet("/CSTServlet")
public class CSTServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CSTServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<classsubjectteacher> obj = hibernateConnector.getClasssubjectteacher();
		// get response writer
		PrintWriter writer = response.getWriter();

		// build HTML code
		String htmlRespone = "<html>";
		htmlRespone += "<body>";

		htmlRespone += "<style>"; // start style
		htmlRespone += "div {"; // note leading brace
		htmlRespone += "height: 200px;";
		htmlRespone += "bwidth: 400px;";
		htmlRespone += "position: fixed;";
		htmlRespone += "top: 50%;";
		htmlRespone += "left: 60%;";
		htmlRespone += "margin-top: -100px;";
		htmlRespone += "margin-left: -200px;";

		htmlRespone += "};";
		htmlRespone += "</style>";

		htmlRespone += "<div> ";
		htmlRespone += "<b>Class Having Subjects teaching Teachers:</b><br/>";

		for (classsubjectteacher cls : obj) {
			htmlRespone += cls.getClass_number().getClass_title()+ "&nbsp;&nbsp;&nbsp;&nbsp;" ;
			htmlRespone += cls.getSubject_id().getSubject_title()+ "&nbsp;&nbsp;&nbsp;&nbsp;";
			htmlRespone += cls.getTeacher_id().getTeacher_name() + "<br/>";
		}

		htmlRespone += "</div>";
		htmlRespone += "</body>";
		htmlRespone += "</html>";

		// return response
		writer.println(htmlRespone);

		RequestDispatcher dispatcher = request.getRequestDispatcher("index2.html");
		dispatcher.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String classes = request.getParameter("class");
		String subject = request.getParameter("subject");
		String teacher = request.getParameter("teacher");
		
		hibernateConnector.insertClasssubjectteacher(classes,subject,teacher);
		
		doGet(request, response);
		
		
	}

}
