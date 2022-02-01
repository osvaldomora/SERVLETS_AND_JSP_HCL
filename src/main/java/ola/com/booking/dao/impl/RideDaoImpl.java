package ola.com.booking.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ola.com.booking.ConectionManager;
import ola.com.booking.dao.RideDao;
import ola.com.booking.model.Ride;

public class RideDaoImpl implements RideDao {

	Connection conn= ConectionManager.getConnection();
	
	@Override
	public void saveRide(Ride ride) {
		try {
			PreparedStatement stmt = conn.prepareStatement("insert into ride (userId, routeId, dateTime) values (?,?,?)");
//			stmt.setInt(1, ride.getRideId());
			stmt.setInt(1, ride.getUserId());
			stmt.setInt(2,ride.getRouteId());
			stmt.setObject(3, ride.getDateTime());		
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	

}
