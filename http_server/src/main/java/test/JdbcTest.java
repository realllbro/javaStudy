package test;

import java.awt.im.spi.InputMethod;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

import oracle.sql.TIMESTAMPTZ;

public class JdbcTest {
	
	
	public static void main(String args[])throws Exception{
		
		Connection conn = null;
		PreparedStatement pstmt = null;		
		ResultSet rs = null;
		
		BufferedReader br = null;
		
		HashMap<String, Object> map = new HashMap();
		List<String> data_header = new ArrayList();
		List<String> data_type = new ArrayList();
		List<HashMap<String, Object>> data_list = new ArrayList();
		
		int limit = 1000;
		String driver = "oracle.jdbc.OracleDriver";		
        String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";     
        String user = "j2ee8_demo";                                   
        String pw = "j2ee8_demo"; 
        String sql = " SELECT sql_statement FROM NJFT_SQL_STATEMENT";
        
        sql = "SELECT TABLE_NAME FROM ALL_TABLES WHERE TABLE_NAME LIKE 'NJF%' ORDER BY TABLE_NAME ASC";
		
		try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, pw);        //데이터베이스 연결
			pstmt = conn.prepareStatement(sql);
			
			System.out.println("conn.getCatalog() >> "+conn.getCatalog());
			System.out.println("conn.getSchema() >> "+conn.getSchema());			
			
			Pattern p = Pattern.compile("^NJF.*[a-zA-Z0-9]");
			
			String regExpStr2 = "^NJF.*[a-zA-Z0-9]";
			regExpStr2 = "NJF%";
			String schemaPattern = "J2EE%";
			
			//nexadmin.sqlrunner.tablelist.schemaPattern=""
			//nexadmin.sqlrunner.tablelist.tableNamePattern=…			
			
			DatabaseMetaData d = conn.getMetaData();
			ResultSet rs2 = conn.getMetaData().getTables(null, regExpStr2, regExpStr2, new String[]{"TABLE"});
			ResultSetMetaData rsmd2 =  rs2.getMetaData();
					 
			while( rs2.next() ){
				
				System.out.println(rs2.getString(3));
				
				//System.out.println(Pattern.matches(regExpStr2, rs2.getString(3)));
				
				if(rs2.getString(3).matches(regExpStr2)) {
					//System.out.println("정규 > "+rs2.getString(3));
				}
				else if(rs2.getString(3).startsWith("NJF")) {
					//System.out.println(rs2.getString(3));
				}				
				
				
				//System.out.println("===============================================");
				for(int i =1; i <  rsmd2.getColumnCount(); i++) {
					//System.out.println("getColumnName : "+rsmd2.getColumnName(i)+" getString : "+rs2.getString(i));
					//System.out.println( "table names of database_name are " + rs2.getString(3) );
				}
				//System.out.println( "table names of database_name are " + rs2.getString(3) );
			}			
			
			long startTm = System.currentTimeMillis();
			
			rs = pstmt.executeQuery();
			
			long endTm = System.currentTimeMillis();
			
			//ResultSetMeta 정보로 Grid 헤더세팅
			ResultSetMetaData rsmd = rs.getMetaData();
			int dataHeaderCnt = rsmd.getColumnCount();
			
			for(int i=1; i <= dataHeaderCnt; i++) {
				data_header.add(rsmd.getColumnName(i));
				data_type.add(rsmd.getColumnTypeName(i));
				
			}
			
			//Grid Body 세팅 (row 단위)
			HashMap<String, Object> rowMap = new HashMap();
			
			//limit 시점이나 rs에 없을때 까지 꺼낸다 
			for(int row=1; row <= limit && rs.next(); row++) {
				rowMap = new HashMap();
				
				//row처리
				for(int index=1; index <= dataHeaderCnt; index++) {
					
					Object columnObj = rs.getObject(index) == null ? "" : rs.getObject(index);
					
//					System.out.println("columnObj > "+columnObj);
//					System.out.println("타입 "+rsmd.getColumnTypeName(index));					
					
					if(columnObj instanceof TIMESTAMPTZ) {
						rowMap.put(rsmd.getColumnName(index), new String((String) columnObj));						
					}
					else if(columnObj instanceof Clob) {
						
						Clob clob = null;
						try {
							clob = rs.getClob(index);
							br = new BufferedReader(clob.getCharacterStream());
							StringBuffer sb = new StringBuffer();
							String tmpStr = null;
							
							while((tmpStr = br.readLine())!=null) {
								sb.append(tmpStr+"\n");
							}
							
							while(br.ready()) {
								//System.out.println("원래방법 >>> "+br.readLine());
								
								sb.append(br.readLine());
							}
							//System.out.println("clob 한글깨짐 >> "+sb.toString());
							
							rowMap.put(rsmd.getColumnName(index), sb.toString());
						}catch(Exception e) {
							System.out.println("adminSQL"+e);
						}finally {
							if(clob != null) {
								clob.free();
							}
						}
						
					}
					else {
						rowMap.put(rsmd.getColumnName(index), columnObj);
					}

				}
				data_list.add(rowMap);				
			}
			
			for(HashMap<String, Object> rtnMap : data_list) {
				//System.out.println(rtnMap);
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();			
		}finally {
			try {if(rs != null) {rs.close();}}catch(Exception se) {}
			try {if(pstmt != null) {pstmt.close();}}catch(Exception se) {}
			try {if(conn != null) {conn.close();}}catch(Exception se) {}
		}
	}
		

}
