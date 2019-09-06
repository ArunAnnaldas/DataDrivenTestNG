//package com.ordercreation.util;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//
////@SuppressWarnings("unused")
//class TS2DMP
//{
//	public static String username = "dmadm";
//	public static String i_Database = "TS2DMP";
//	public static String password = "Cm5I5p8S";
//	public static String sid = "TS2DMP.telka.com";
//	public static String HostName = "(DESCRIPTION_LIST=(LOAD_BALANCE=off)(FAILOVER=on)(DESCRIPTION=(ADDRESS_LIST=(LOAD_BALANCE=on)(FAILOVER=ON)(ADDRESS=(PROTOCOL=TCP)(HOST=173.38.3.170)(PORT=1541))(ADDRESS=(PROTOCOL=TCP)(HOST=173.38.3.171)(PORT=1541)))(CONNECT_DATA=(SERVICE_NAME=TS2DMP.telka.com)))(DESCRIPTION=(ADDRESS_LIST=(LOAD_BALANCE=on)(FAILOVER=ON)(ADDRESS=(PROTOCOL=TCP)(HOST=173.38.50.104)(PORT=1541))(ADDRESS=(PROTOCOL=TCP)(HOST=173.38.50.105)(PORT=1541)))(CONNECT_DATA=(SERVICE_NAME=TS2DMP.telka.com))))";
//	public static String portNumber = "1541";
//	public String url = "jdbc:oracle:thin:@" + HostName ;
//}
//
//class TS1QTC
//{
//	public static String username = "APPSRO";
//	public static String i_Database = "TS2DMP";
//	public static String password = "Dz0Z3m9E";
//	public static String sid = "TS1QTC.telka.com";
//	public static String HostName = "(DESCRIPTION=(ADDRESS_LIST=(LOAD_BALANCE=ON)(FAILOVER=ON)(ADDRESS=(PROTOCOL=TCP)(HOST=lnxdb-pts-501-vip.telka.com)(PORT=1537))(ADDRESS=(PROTOCOL=TCP)(HOST=lnxdb-pts-502-vip.telka.com)(PORT=1537)))(CONNECT_DATA=(SERVICE_NAME=TS1QTC.telka.com)(SERVER=DEDICATED)))";
//	public static String portNumber = "1537";
//	public String url = "jdbc:oracle:thin:@" + HostName ;	
//}
//
//class ESALESPD
//{
//	public static String username = "CCWSEF";
//	public static String i_Database = "TS2DMP";
//	public static String password = "Dz0Z3m9E";
//	public static String sid = "TS1QTC.telka.com";
//	public static String HostName = "(DESCRIPTION=(ADDRESS_LIST=(LOAD_BALANCE=ON)(FAILOVER=ON)(ADDRESS=(PROTOCOL=TCP)(HOST=lnxdb-pts-501-vip.telka.com)(PORT=1537))(ADDRESS=(PROTOCOL=TCP)(HOST=lnxdb-pts-502-vip.telka.com)(PORT=1537)))(CONNECT_DATA=(SERVICE_NAME=TS1QTC.telka.com)(SERVER=DEDICATED)))";
//	public static String portNumber = "1537";
//	public String url = "jdbc:oracle:thin:@" + HostName ;	
//}
//
//class IPCAccessDB
//{
//	public static String username = "CCWSEF";
//	public static String i_Database = "TS2DMP";
//	public static String password = "Dz0Z3m9E";
//	public static String sid = "TS1QTC.telka.com";
//	public static String HostName = "(DESCRIPTION=(ADDRESS_LIST=(LOAD_BALANCE=ON)(FAILOVER=ON)(ADDRESS=(PROTOCOL=TCP)(HOST=lnxdb-pts-501-vip.telka.com)(PORT=1537))(ADDRESS=(PROTOCOL=TCP)(HOST=lnxdb-pts-502-vip.telka.com)(PORT=1537)))(CONNECT_DATA=(SERVICE_NAME=TS1QTC.telka.com)(SERVER=DEDICATED)))";
//	public static String portNumber = "1537";
//	public String url = "jdbc:oracle:thin:@" + HostName ;	
//}
//
//
//public class DbDeclarations {
//
//	public String HostName ;
//	public String portNumber;
//	public String sid;
//	public String url;
//	public String username;
//	public String password;
//
//	public Connection dbConnect(String db) throws Exception
//	{
//			if(db.equals("TS2DMP"))
//			{
//				TS2DMP ops=new TS2DMP();
//				this.HostName=TS2DMP.HostName ;
//				this.password=TS2DMP.password;
//				this.portNumber=TS2DMP.portNumber;
//				this.sid=TS2DMP.sid;
//				this.url=ops.url;
//				this.username=TS2DMP.username;
//			}
//			
//			else if(db.equals("TS1QTC"))
//				{
//				TS1QTC ops=new TS1QTC();
//				this.HostName=TS1QTC.HostName ;
//				this.password=TS1QTC.password;
//				this.portNumber=TS1QTC.portNumber;
//				this.sid=TS1QTC.sid;
//				this.url=ops.url;
//				this.username=TS1QTC.username;
//				}
//			else
//			{
//				throw new Exception("Db not present");
//			}
//			
//		Connection con = null; 
//		String driverName = "oracle.jdbc.driver.OracleDriver"; 
//		Class.forName(driverName); 
//		con = DriverManager.getConnection(url,username,password);
//		System.out.println("successfully connected");
//		return con;	
//	}
//}
