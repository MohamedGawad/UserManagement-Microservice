package bsu.chatbot.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

/**
 * @author Mohamed Gawad
 *
 *         SBM-API
 */
public class JDBCUtil {

	private static JDBCUtil instance;

	private JDBCUtil() {
	}

	public static JDBCUtil getInstance() {
		if (instance == null)
			instance = new JDBCUtil();
		return instance;
	}

	public void closeResources(Connection conn, Statement statement, ResultSet rs) {
		if (rs != null)
			try {
				rs.close();
			} catch (SQLException e1) {
			}
		if (statement != null)
			try {
				statement.close();
			} catch (SQLException e) {
			}
		if (conn != null)
			try {
				conn.close();
			} catch (SQLException e) {
			}
	}

	public String getSequenceValue(DataSource tadawulDS, String sequenceName) throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sequenceValue = null;

		try {
			conn = tadawulDS.getConnection();
			stmt = conn.prepareStatement("select " + sequenceName + ".nextval from dual");
			rs = stmt.executeQuery();
			if (rs.next())
				sequenceValue = rs.getString(1);
			rs.close();
			stmt.close();
		}

		finally {
			closeResources(conn, stmt, rs);
		}
		return sequenceValue;
	}
}
