package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import config.Config;
import log.Logger;

public abstract class DBConn {
	protected Connection con;
	protected Statement stmt;
	protected ResultSet rs;
	protected String sql;
	protected SimpleDateFormat format;
	//10.22.87.157
	public DBConn(){
		format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	}
	
	protected void connect()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://"+Config.HOST+":"+Config.PORT+"/"+Config.DB,Config.USER,Config.PASSWORD);
			Logger.xDD().info("DBConn -> " + "Conexion establecida con la base de datos.");
			stmt = con.createStatement();
			sql = "";
		} catch (Exception e) {
			Logger.xDD().error("DBConn -> " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Cierra la conexion
	 * 
	 * @throws SQLException Excepcion sql
	 */
	protected void close() throws SQLException {
		stmt.close();
		if(rs != null) rs.close();
		con.close();
		sql = "";
		Logger.xDD().info("DBConn -> " + "Todo lo que hay en DBConn cerrado.");
	}
}
