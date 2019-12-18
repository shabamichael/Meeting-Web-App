package com.tech.mobile.innovative;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;


import com.tech.mobile.innovative.dbconnection.HibernateUtil;
import com.tech.mobile.innovative.dbconnection.dbConnection;

/**
 * Servlet implementation class EmailListServlet
 * @param <User>
 */
@WebServlet(name = "EmailListServlet", urlPatterns={"/EmailListServlet","/email-list"})
public class EmailListServlet<User> extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger log = null;
	
 MeetingLogic meetingLogic = new MeetingLogic();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmailListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log = Logger.getLogger(EmailListServlet.class);
		
		log.info("A new user " + request.getParameter("firstName") + " is using the email servlet class");
		
		String url = null ;
		
		String action = request.getParameter("action");
		if (action == null){
			action = "join"; //default action
		}
		
		if (action.equalsIgnoreCase("join")) {
			url = "subscription.jsp"; //Subscription page
		}
		
		 if (action.equals("add")) {
			String meetType =  request.getParameter("meetingType");
			String meetingType = meetingLogic.GetTypeOfMeeting(meetType);
			
			String meetingDate = request.getParameter("meetingDate");
			Date date = meetingLogic.meetingDateFormat(meetingDate);
			
			String meetingDay = meetingLogic.meetingDay(date);
			String attnd = request.getParameter("attendance");
			String soundOperatorName = request.getParameter("soundOperatorName");
			String soundOperatorSurname = request.getParameter("soundOperatorSurname");
			String attendantName = request.getParameter("attendantName");
			String attendantSurname = request.getParameter("attendantSurname");
			String announcement = request.getParameter("announcement");
					
			int attendance = Integer.parseInt(attnd);
			
			String message;
			//Validate the parameters
			if (meetType == null || meetType.isBlank()||meetType.isEmpty()||
					meetingDate == null || meetingDate.isBlank() || meetingDate.isEmpty()||
					attnd == null || attnd.isEmpty() ||attnd.isBlank()||
					soundOperatorName == null|| soundOperatorName.isEmpty() || soundOperatorName.isBlank()||
					 attendantName == null || attendantName.isBlank()|| attendantName.isEmpty())
			{
				message = "Please fill out all the required information!";
				url = "/subscription.jsp";
			}
			else
			{
			log.info("A new meeting information have just been posted to the rest API is ::");
									
		
			try {
			
			log.info("Trying to establish and open connection to the rest API ");

			
			//Store data in Meeting Object
			Meeting meeting = new Meeting(date, meetingDay, meetingType, attendance,
			soundOperatorName, soundOperatorSurname, attendantName, attendantSurname, announcement);
			//Call the Rest web services
			URL uri = new URL("http://localhost:7070/api/v1/save");
				
			 	HttpURLConnection conn = (HttpURLConnection) uri.openConnection();
				conn.setDoOutput(true);
				conn.setRequestMethod("POST");
				conn.setRequestProperty("Content-Type", "application/json");

				log.info("Successfully connected to the rest API ");

				String input = 
						"{\"meetingDate\":" + "\""+ meetingDate + "\""+ ","
						+ "\"meetingDay\":" + "\""+ meetingDay + "\""+ "," 
						+ "\"meetingType\":" + "\""+ meetingType + "\""+","
						+ "\"attendance\":" + attendance + ","
						+ "\"soundOperatorFirstName\":" + "\""+  soundOperatorName +  "\""+ ","
						+ "\"soundOperatorLastName\":" + "\""+ soundOperatorSurname +  "\""+","
						+ "\"attendantFirstName\":" + "\""+ attendantName + "\""+","
						+ "\"attendantLastName\":" + "\""+ attendantSurname + "\""+ ","
						+ "\"announcement\":" + "\""+ announcement + "\"" +", "
						+ "\"emailTo\":null }";
				
				OutputStream os = conn.getOutputStream();
				os.write(input.getBytes());
				os.flush();

				if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
					throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
				}

				BufferedReader br = new BufferedReader(new InputStreamReader(
						(conn.getInputStream())));

				String output;
				System.out.println("Output from Server .... \n");
				while ((output = br.readLine()) != null) {
					System.out.println(output);
				}

				conn.disconnect();

			  } catch (MalformedURLException e) {

				e.printStackTrace();

			  } catch (IOException e) {

				e.printStackTrace();

			 }
			
			
			url = "/successful.jsp";
			}	

		
			
		
					
			String meet_type = null, meeting_date = null,  attndce = null, sound_operator_name = null,
			sound_operator_surname = null, attendant_name = null, attendant_surname = null,ann = null;
			
			request.setAttribute(meet_type, meetingType);
			request.setAttribute(meeting_date, meetingDate);
			request.setAttribute(attndce, attnd);
			request.setAttribute(sound_operator_name, soundOperatorName);
			request.setAttribute(sound_operator_surname, soundOperatorSurname);
			request.setAttribute(attendant_name, attendantName);
			request.setAttribute(attendant_surname, attendantSurname);
			request.setAttribute(ann, announcement);
		}
		//response.sendRedirect(url);
		getServletContext().getRequestDispatcher(url).forward(request, response);
		//doGet(request, response);
	}
	
	

}
