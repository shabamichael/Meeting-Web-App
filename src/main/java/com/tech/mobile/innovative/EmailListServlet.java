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
public class EmailListServlet<User> extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger log = null;
	
       
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
			action = "join";
		}
		
		if (action.equals("add")) {
			String meetingType =  request.getParameter("meetingType");
			String meetingDate = request.getParameter("meetingDate");
			String meetingDay = request.getParameter("meetingDay");
			/*
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			
			try {
			Date meeting_date = dateFormat.parse(meetingDate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			*/
			String attnd = request.getParameter("attendance");
			String soundOperatorName = request.getParameter("soundOperatorName");
			String soundOperatorSurname = request.getParameter("soundOperatorSurname");
			String attendantName = request.getParameter("attendantName");
			String attendantSurname = request.getParameter("attendantSurname");
			String announcement = request.getParameter("announcement");
			
			
			int attendance = Integer.parseInt(attnd);
			//System.out.println("THE ATTENDANCE IS :: " + attendance);
			
			log.info("A new meeting information have just been posted to the rest API is ::");
									
		
			try {
			
			log.info("Trying to establish and open connection to the rest API ");

				URL uri = new URL("http://localhost:7070/api/v1/save");//your url i.e fetch data from .
				
			 	HttpURLConnection conn = (HttpURLConnection) uri.openConnection();
				conn.setDoOutput(true);
				conn.setRequestMethod("POST");
				conn.setRequestProperty("Content-Type", "application/json");

				log.info("Successfully connected to the rest API ");

				//String input = "{\"qty\":100,\"name\":\"iPad 4\"}";

				String input = 
						"{\"meetingDate\": \"2021-10-17\" , "
						+ "\"meetingDay\": \"Monday\" , "
						+ "\"meetingType\": \"Weekend meeting\","
						+ "\"attendance\":" + attendance + ","
						+ "\"soundOperatorFirstName\":" +  soundOperatorName + ","
						+ "\"soundOperatorLastName\":" +soundOperatorSurname +","
						+ "\"attendantFirstName\":" + attendantName +","
						+ "\"attendantLastName\":" + attendantSurname + ","
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
			
			
			url = "/thanks.jsp";
		
		}
		
		getServletContext().getRequestDispatcher(url).forward(request, response);
		doGet(request, response);
	}
	
	

}
