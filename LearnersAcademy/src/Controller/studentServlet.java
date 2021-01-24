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
import pojo.classes;
import pojo.students;

/**
 * Servlet implementation class studentServlet
 */
@WebServlet("/studentServlet")
public class studentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public studentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		List<students> obj = hibernateConnector.getStudents();
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
		htmlRespone += "<b>Students Titles are:</b><br/>";

		for (students cls : obj) {
			htmlRespone += cls.getStudent_name() + "<br/>";
		}

		htmlRespone += "</div>";
		htmlRespone += "</body>";
		htmlRespone += "</html>";

		// return response
		writer.println(htmlRespone);

		RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
		dispatcher.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
