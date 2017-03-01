package ie.gmit.sw.Timetable;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ie.gmit.sw.Connections.MongoConnection;

@WebServlet("/TimetableServlet")
public class TimetableServlet extends HttpServlet implements Servlet {

	
	private MongoConnection mongo = new MongoConnection();

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String code = (String)session.getAttribute("code");
		String title = request.getParameter("title");
		int timeStarting = Integer.parseInt(request.getParameter("starttime"));
		int timeEnding = Integer.parseInt(request.getParameter("endtime"));
		String[] days = request.getParameterValues("day");
		String roomNumber = request.getParameter("room");

		
		Timetable timetable = (Timetable)request.getSession(true).getAttribute("timetable");
		
		if(timetable == null)
		{
			//create a new timetable if one does not exist
			timetable = new Timetable();
		}
		if(days != null)
		{
			for(int i = 0; i < days.length; i++)
			{
				String dayString = days[i];
				int day;
				if(dayString.equalsIgnoreCase("SUN")) day = 0;
				else if(dayString.equalsIgnoreCase("MON")) day = 1;
				else if(dayString.equalsIgnoreCase("TUE")) day = 2;
				else if(dayString.equalsIgnoreCase("WED")) day = 3;
				else if(dayString.equalsIgnoreCase("THU")) day = 4;
				else if(dayString.equalsIgnoreCase("FRI")) day = 5;
				else day = 6;
		
				Module module = new Module(title, timeStarting, timeEnding, day, roomNumber);
				mongo.setTimetable(code, module);
				timetable.addClass(module);
			}
			
		}
		request.getSession().setAttribute("timetable", timetable);
		System.out.println(timetable.getClasses().toString().replace("[", "").replace("]", ""));
		getServletContext().getRequestDispatcher("/Timetable.jsp").forward(request, response);
	}
	
	

}
