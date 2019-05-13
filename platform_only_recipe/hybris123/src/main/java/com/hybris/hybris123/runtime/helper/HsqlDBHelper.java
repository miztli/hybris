package com.hybris.hybris123.runtime.helper;
/*
 * © 2017 SAP SE or an SAP affiliate company.
 * All rights reserved.
 * Please see http://www.sap.com/corporate-en/legal/copyright/index.epx for additional trademark information and
 * notices.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A helper to allow users to directly invoke HSQL queries from hybris123
 */
public class HsqlDBHelper {
	private Connection conn;	
	private static final String HSQLDB = "jdbc:hsqldb:file:./../hybris/data/hsqldb/mydb";
	private static final Logger LOG = LoggerFactory.getLogger(HsqlDBHelper.class);
	
	public HsqlDBHelper() throws ClassNotFoundException, SQLException {
       Class.forName("org.hsqldb.jdbcDriver");        // Loads the HSQL Database Engine JDBC driver       
       // !!Note that leaving your default password as the empty string in production would be a major security risk!!
       conn = DriverManager.getConnection(HSQLDB,  "sa",   "");	 
	}

    public void shutdown() throws SQLException {
        Statement st = conn.createStatement();
        st.execute("SHUTDOWN");
        conn.close();  
    }

    public synchronized String select(String expression) throws SQLException {
        Statement st = null;
        ResultSet rs = null;
        st = conn.createStatement(); 
        rs = st.executeQuery(expression);  
        String res = dump(rs);
        st.close();   
        return res;
    }

    public String dump(ResultSet rs) throws SQLException {
        ResultSetMetaData meta = rs.getMetaData();
        int colmax = meta.getColumnCount();
        int i;
        String o;
        String result = "";     
        while(rs.next()) {
            for (i = 1; i <= colmax; i++) {
            	if (i > 1)
            		result = result.concat(" ");
                o = (rs.getObject(i) == null) ? "NULL": rs.getObject(i).toString();    
                result = result.concat(o);
            }
            result = result.concat("\n");
        }
        return result;
    }                                         	
}  