package ola.com.booking;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ola.com.booking.model.Ride;
import ola.com.booking.model.User;
import ola.com.booking.service.RideService;
import ola.com.booking.service.impl.RideServiceImpl;

/**
 * Servlet implementation class RideServlet
 */
@WebServlet("/rideServlet")
public class RideServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RideService rideService = new RideServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RideServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
        {
    	/*
    	HttpSession session= (HttpSession) request.getSession();
    	User user=(User) session.getAttribute("user");
    	*/
		
		Ride ride = new Ride();
		ride.setDateTime(LocalDateTime.now());
		ride.setRouteId(Integer.parseInt(request.getParameter("routeId")));
		ride.setUserId(Integer.parseInt(request.getParameter("userId")));
		rideService.saveRide(ride);
		
		PrintWriter output = response.getWriter();
		output.println("Data was recorded");

        }
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("RIDE SERVLET");
/*
//		if(request.getParameter("action").equals("book")) {
			System.out.println("BOOK:"+request.getParameter("routeId"));
			Ride ride = new Ride();
			ride.setDateTime(LocalDateTime.now());
			ride.setRouteId(1);
			ride.setUserId(1);
			rideService.saveRide(ride);
			
			PrintWriter output = response.getWriter();
			output.println("Data was recorded");

	*/		
//		}

			
		}
	

}
