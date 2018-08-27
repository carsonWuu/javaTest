package test.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class insert {
	public static void main(String args[]) throws SQLException{
		String tableName[] = {"app_usergroups"};
		Map<String,Object> map = new HashMap();
		map.put("UG_ID", 4);
		map.put("UG_Name","group4");
		map.put("UG_AdminID", "user4");
		List<Map<String,Object>> list=new ArrayList();
		list.add(map);
		insertCommit(tableName,list);
	}
	public static int insert(String tableName, Map fields) throws SQLException {
		Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","123456");
		PreparedStatement prep = null;
		int ret = 0;
		try {
			if (fields.size() < 1)
				return 0;
			StringBuffer sb = new StringBuffer("insert into ");
			sb.append(tableName).append("(");
			Iterator fds;
			for (fds = fields.keySet().iterator(); fds.hasNext();) {
				sb.append((String) fds.next());
				if (fds.hasNext())
					sb.append(",");
			}

			sb.append(") values (");
			for (int i = 0; i < fields.size(); i++) {
				sb.append("?");
				if (i < fields.size() - 1)
					sb.append(",");
			}

			sb.append(");");
			prep = connect.prepareStatement(sb.toString());
			fds = fields.keySet().iterator();
			int index = 1;
			Object v;
			for (; fds.hasNext(); prep.setObject(index++, v))
				v = fields.get(fds.next());

			ret = prep.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			prep.close();
			connect.close();
		}
		return ret;
	}
	public static void insertCommit(String tableName[],List<Map<String,Object>> list) throws SQLException {
		Connection connect =DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","123456");
		connect.setAutoCommit(false);
		PreparedStatement prep[] = new PreparedStatement[list.size()];
		
		try {
			for(int i_sql = 0; i_sql<tableName.length; i_sql++){
				if (list.get(i_sql).size() < 1)break;
				
				StringBuffer sb = new StringBuffer("insert into ");
				sb.append(tableName[i_sql]).append("(");
				Iterator fds;
				for (fds = list.get(i_sql).keySet().iterator(); fds.hasNext();) {
					sb.append((String) fds.next());
					if (fds.hasNext())
						sb.append(",");
				}

				sb.append(") values (");
				for (int i = 0; i < list.get(i_sql).size(); i++) {
					sb.append("?");
					if (i < list.get(i_sql).size() - 1)
						sb.append(",");
				}

				sb.append(");");
				System.out.println("sql_"+i_sql+": "+sb);
				connect.prepareStatement(sb.toString());
				prep[i_sql] = connect.prepareStatement(sb.toString());
				fds = list.get(i_sql).keySet().iterator();
				int index = 1;
				Object v;
				System.out.println(i_sql);
				for (; fds.hasNext(); prep[i_sql].setObject(index++, v)){
					
					v = list.get(i_sql).get(fds.next());
					System.out.println("i_sql:"+i_sql);
				}
					

				prep[i_sql].execute();

			}
		
			connect.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			for(int i_sql = 0; i_sql<tableName.length; i_sql++){
				prep[i_sql].close();
			}
			connect.close();
		}
		
	}
}
