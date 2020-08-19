package bsu.chatbot.usermanagement.dao;



/**
 * @author Mohamed Gawad
 *
 *         SBM-API
 */
//@RequestScoped
public class AppDaoImpl {


//	private String GET_APPS_STMT = "select * from app";
//
//	@Override
//	public List<App> getAllApps() {
//		Connection conn = null;
//		PreparedStatement stmt = null;
//		App app = null;
//		ResultSet rs = null;
//		List<App> apps = new ArrayList<>();
//		try {
//			conn = dataSource.getConnection();
//			stmt = conn.prepareStatement(GET_APPS_STMT);
//			System.out.println("GET_APPS_STMT >>> " + GET_APPS_STMT);
//			rs = stmt.executeQuery();
//			while (rs.next()) {
//				app = new App();
//				app.setId(rs.getLong("ID"));
//				app.setAppName(rs.getString("AppName"));
//				app.setAccessToken(rs.getString("AccessToken"));
//				app.setLogoUrl(rs.getString("LogoUrl"));
//				apps.add(app);
//			}
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//			throw new RuntimeException("Failed to get subscriber due to the following error: " + e.getMessage());
//		} finally {
//			JDBCUtil.getInstance().closeResources(conn, stmt, rs);
//		}
//		return apps;
//	}
}
