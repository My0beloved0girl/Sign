package com.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dao.BaseDao;
import com.dao.DengLu;
import com.entity.Easybuy_Order;
import com.entity.Easybuy_User;
import com.entity.Grade;
import com.entity.Ls_Butten;
import com.entity.Ls_Menu;
import com.entity.Ls_Role;
import com.entity.Students;
import com.entity.User_Menu;
import com.entity.User_Role;
import com.utils.DataBaseUtil;

public class DengLuImpl extends BaseDao implements DengLu {

	@Override
	public int Dl(String loginName2, String password2) {
		Connection conn=getConnection();
		// TODO Auto-generated method stub
		List<Easybuy_User> list = null;
		ResultSet rs = null;
		PreparedStatement ps=null;
		String sql="SELECT * FROM easybuy_user where loginName=? and password=?";	
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, loginName2);
			ps.setString(2, password2);
			rs=ps.executeQuery();
			if (rs != null) {
				list = new ArrayList<Easybuy_User>();
				while (rs.next()) {
					int id = rs.getInt("id");
					String userName= rs.getString("userName");
					String loginName= rs.getString("loginName");
					String password= rs.getString("password");
					int sex= rs.getInt("sex");
					String identityCode= rs.getString("identityCode");
					String email= rs.getString("email");
					String mobile= rs.getString("mobile");
					int type= rs.getInt("type");
					int role= rs.getInt("role");
					String clas= rs.getString("clas");
					list.add(new Easybuy_User(id, userName, loginName, password, sex, identityCode, email, mobile, type, role, clas));
					return rs.getInt("role");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataBaseUtil.closeAll(rs, ps, conn);
		}

		return 0;
	}
	@Override
	public int Dlm(String loginName2, String password2) {
		Connection conn=getConnection();
		// TODO Auto-generated method stub
		List<Easybuy_User> list = null;
		ResultSet rs = null;
		PreparedStatement ps=null;
		String sql="SELECT * FROM easybuy_user where loginName=? and password=?";	
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, loginName2);
			ps.setString(2, password2);
			rs=ps.executeQuery();
			if (rs != null) {
				list = new ArrayList<Easybuy_User>();
				while (rs.next()) {
					int id = rs.getInt("id");
					String userName= rs.getString("userName");
					String loginName= rs.getString("loginName");
					String password= rs.getString("password");
					int sex= rs.getInt("sex");
					String identityCode= rs.getString("identityCode");
					String email= rs.getString("email");
					String mobile= rs.getString("mobile");
					int type= rs.getInt("type");
					int role= rs.getInt("role");
					String clas= rs.getString("clas");
					list.add(new Easybuy_User(id, userName, loginName, password, sex, identityCode, email, mobile, type, role, clas));
					return rs.getInt("id");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataBaseUtil.closeAll(rs, ps, conn);
		}

		return 0;
	}
	
	@Override
	public List<Easybuy_User> Hqzh(int uid) {
		// TODO Auto-generated method stub
				
				Connection conn=getConnection();
				// TODO Auto-generated method stub
				List<Easybuy_User> list = null;
				ResultSet rs = null;
				PreparedStatement ps=null;
				String sql="SELECT * FROM easybuy_user WHERE id='"+uid+"'";
				try {
					ps=conn.prepareStatement(sql);
					rs=ps.executeQuery();
					if (rs != null) {
						list = new ArrayList<Easybuy_User>();
						while (rs.next()) {
							int id = rs.getInt("id");
							String userName= rs.getString("userName");
							String loginName= rs.getString("loginName");
							String password= rs.getString("password");
							int sex= rs.getInt("sex");
							String identityCode= rs.getString("identityCode");
							String email= rs.getString("email");
							String mobile= rs.getString("mobile");
							int type= rs.getInt("type");
							int role= rs.getInt("role");
							String clas= rs.getString("clas");
							list.add(new Easybuy_User(id, userName, loginName, password, sex, identityCode, email, mobile, type, role, clas));
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					DataBaseUtil.closeAll(rs, ps, conn);
				}

				return list;
	}
	
	@Override
	public int Pd(int userid2) {
		
		Connection conn=getConnection();
		// TODO Auto-generated method stub
		List<User_Role> list = null;
		ResultSet rs = null;
		PreparedStatement ps=null;
		String sql="SELECT userid,roleid FROM user_role WHERE userid='"+userid2+"'";
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			if (rs != null) {
				list = new ArrayList<User_Role>();
				while (rs.next()) {
					int userid = rs.getInt("userid");
					int roleid= rs.getInt("roleid");
					list.add(new User_Role(userid, roleid));
					return rs.getInt(roleid);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataBaseUtil.closeAll(rs, ps, conn);
		}

		return 0;
	}

	@Override
	public List<Ls_Menu> Zx(int roleid) {
		Connection conn=getConnection();
		List<Ls_Menu> list = null;
		ResultSet rs = null;
		PreparedStatement ps=null;
		String sql="SELECT * FROM ls_menu WHERE id IN(SELECT menuid FROM user_menu WHERE userid='"+roleid+"')";
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			if (rs != null) {
				list = new ArrayList<Ls_Menu>();
				while (rs.next()) {	
					int id = rs.getInt("id");
					String mname= rs.getString("mname");
					int mfatherid= rs.getInt("mfatherid");
					int type= rs.getInt("type");
					String url=rs.getString("url");
					String buttom=rs.getString("buttom");
					list.add(new Ls_Menu(id, mname, mfatherid, type, url, buttom));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataBaseUtil.closeAll(rs, ps, conn);
		}

		return list;
	}

	@Override
	public List<Ls_Menu> An(int mfid,int uid) {
		Connection conn=getConnection();
		PreparedStatement ps=null;
		String sql="SELECT * FROM ls_menu WHERE mfatherid='"+mfid+"' AND TYPE=3 AND id IN(SELECT menuid FROM user_menu WHERE userid='"+uid+"')";
		List<Ls_Menu> list = null;
		ResultSet rs = null;
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			if (rs != null) {
				list = new ArrayList<Ls_Menu>();
				while (rs.next()) {	
					int id = rs.getInt("id");
					String mname= rs.getString("mname");
					int mfatherid= rs.getInt("mfatherid");
					int type= rs.getInt("type");
					String url=rs.getString("url");
					String buttom=rs.getString("buttom");
					list.add(new Ls_Menu(id, mname, mfatherid, type, url, buttom));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataBaseUtil.closeAll(rs, ps, conn);
		}

		return list;
	}
	
	
	
	//所有用户
		@Override
		public List<Easybuy_User> FhJson() {
			Connection conn=getConnection();
			PreparedStatement ps=null;
			String sql="SELECT eu.id,eu.userName,eu.loginName,eu.password,eu.sex,eu.identityCode,eu.email,eu.mobile,eu.type,lr.rname,eu.clas FROM easybuy_user AS eu,`ls_role` AS lr WHERE eu.role=lr.id ";
			List<Easybuy_User> list = null;
			ResultSet rs = null;
			try {
				ps=conn.prepareStatement(sql);
				rs=ps.executeQuery();
				if (rs != null) {
					list = new ArrayList<Easybuy_User>();
					while (rs.next()) {
						int id = rs.getInt("id");
						String userName= rs.getString("userName");
						String loginName= rs.getString("loginName");
						String password= rs.getString("password");
						int sex= rs.getInt("sex");
						String identityCode= rs.getString("identityCode");
						String email= rs.getString("email");
						String mobile= rs.getString("mobile");
						int type= rs.getInt("type");
						String rname= rs.getString("rname");
						String clas= rs.getString("clas");
						list.add(new Easybuy_User(id, userName, loginName, password, sex, identityCode, email, mobile, type, rname, clas));
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DataBaseUtil.closeAll(rs, ps, conn);
			}

			return list;
		}

	//总数据
	@Override
	public int SjZs() {
		Connection conn=getConnection();
		PreparedStatement ps=null;
		String sql="SELECT COUNT(1) FROM easybuy_user ";
		ResultSet rs = null;
		int num=0;
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					num=rs.getInt("COUNT(1)");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataBaseUtil.closeAll(rs, ps, conn);
		}

		return num;
	}

	
	//搜索框查询
	@Override
	public List<Easybuy_User> SsCx(String name) {
		Connection conn=getConnection();
		PreparedStatement ps=null;
		String sql="SELECT * FROM easybuy_user WHERE loginName LIKE '%"+name+"%' ";
		List<Easybuy_User> list = null;
		ResultSet rs = null;
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			if (rs != null) {
				list = new ArrayList<Easybuy_User>();
				while (rs.next()) {
					int id = rs.getInt("id");
					String userName= rs.getString("userName");
					String loginName= rs.getString("loginName");
					String password= rs.getString("password");
					int sex= rs.getInt("sex");
					String identityCode= rs.getString("identityCode");
					String email= rs.getString("email");
					String mobile= rs.getString("mobile");
					int type= rs.getInt("type");
					int role= rs.getInt("role");
					String clas= rs.getString("clas");
					list.add(new Easybuy_User(id, userName, loginName, password, sex, identityCode, email, mobile, type, role, clas));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataBaseUtil.closeAll(rs, ps, conn);
		}

		return list;
	}


	@Override
	public List<Ls_Menu> QxZs() {
		Connection conn=getConnection();
		PreparedStatement ps=null;
		String sql="SELECT * FROM ls_menu";
		List<Ls_Menu> list = null;
		ResultSet rs = null;
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			if (rs != null) {
				list = new ArrayList<Ls_Menu>();
				while (rs.next()) {
					int id = rs.getInt("id");
					String mname= rs.getString("mname");
					int mfatherid= rs.getInt("mfatherid");
					int type= rs.getInt("type");
					String url= rs.getString("url");
					String buttom= rs.getString("buttom");
					list.add(new Ls_Menu(id, mname, mfatherid, type, url, buttom));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataBaseUtil.closeAll(rs, ps, conn);
		}

		return list;
	}


	@Override
	public List<Easybuy_Order> QbDd() {
		Connection conn=getConnection();
		PreparedStatement ps=null;
		String sql="SELECT * FROM easybuy_order";
		List<Easybuy_Order> list = null;
		ResultSet rs = null;
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			if (rs != null) {
				list = new ArrayList<Easybuy_Order>();
				while (rs.next()) {
					int id = rs.getInt("id");
					int userId= rs.getInt("userId");
					String loginName= rs.getString("loginName");
					String userAddress= rs.getString("userAddress");
					Date createTime= rs.getDate("createTime");
					int cost= rs.getInt("cost");
					int status= rs.getInt("status");
					int type= rs.getInt("type");
					String serialNumber= rs.getString("serialNumber");
					list.add(new Easybuy_Order(id, userId, loginName, userAddress, createTime, cost, status, type, serialNumber));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataBaseUtil.closeAll(rs, ps, conn);
		}

		return list;
	}


	@Override
	public List<Ls_Role> QbJs() {
		Connection conn=getConnection();
		PreparedStatement ps=null;
		String sql="SELECT * FROM ls_role";
		List<Ls_Role> list = null;
		ResultSet rs = null;
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			if (rs != null) {
				list = new ArrayList<Ls_Role>();
				while (rs.next()) {
					int id = rs.getInt("id");
					String rname= rs.getString("rname");
					list.add(new Ls_Role(id, rname));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataBaseUtil.closeAll(rs, ps, conn);
		}

		return list;
	}


	@Override
	public int PdLn(String logname) {
		Connection conn=getConnection();
		PreparedStatement ps=null;
		String sql="SELECT * FROM easybuy_user WHERE loginName='"+logname+"'";
		ResultSet rs = null;
		int num=0;
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					num=1;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataBaseUtil.closeAll(rs, ps, conn);
		}

		return num;
	}

	
	@Override
	public int InZh(Easybuy_User eUser) {
		String sql="INSERT INTO `easybuy_user`(userName,`loginName`,`password`,`sex`,`identityCode`,`email`,`mobile`,`type`,role,clas) VALUES(?,?,?,?,?,?,?,?,?,?)";
		int num=executeUpdate(sql,eUser.getUserName(),eUser.getLoginName(),eUser.getPassword(),eUser.getSex(),eUser.getIdentityCode(),eUser.getEmail(),eUser.getMobile(),eUser.getType(),eUser.getRole(),eUser.getClas());
		return num;
	}


	@Override
	public int DlZh(int uid) {
		String sql="delete from easybuy_user where id=?";
		int num=executeUpdate(sql,uid);
		return num;
	}


	@Override
	public List<Easybuy_User> SeZh(int uid) {
		Connection conn=getConnection();
		PreparedStatement ps=null;
		String sql="SELECT * FROM easybuy_user WHERE id='"+uid+"'  ";
		List<Easybuy_User> list = null;
		ResultSet rs = null;
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			if (rs != null) {
				list = new ArrayList<Easybuy_User>();
				while (rs.next()) {
					int id = rs.getInt("id");
					String userName= rs.getString("userName");
					String loginName= rs.getString("loginName");
					String password= rs.getString("password");
					int sex= rs.getInt("sex");
					String identityCode= rs.getString("identityCode");
					String email= rs.getString("email");
					String mobile= rs.getString("mobile");
					int type= rs.getInt("type");
					int role= rs.getInt("role");
					String clas= rs.getString("clas");
					list.add(new Easybuy_User(id, userName, loginName, password, sex, identityCode, email, mobile, type, role, clas));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataBaseUtil.closeAll(rs, ps, conn);
		}

		return list;
	}
	
	
	@Override
	public int UpZh(Easybuy_User eUser) {
		String sql="update easybuy_user set userName=?,loginName=?,password=?,sex=?,identityCode=?,email=?,mobile=?,type=?,role=?,clas=?  where id=? ";
		int num=executeUpdate(sql,eUser.getUserName(),eUser.getLoginName(),eUser.getPassword(),eUser.getSex(),eUser.getIdentityCode(),eUser.getEmail(),eUser.getMobile(),eUser.getType(),eUser.getRole(),eUser.getClas(),eUser.getId());
		return num;
	}


	@Override
	public int PdJs(int uid) {
		Connection conn=getConnection();
		PreparedStatement ps=null;
		String sql="SELECT role FROM easybuy_user WHERE id='"+uid+"'";
		ResultSet rs = null;
		int num=0;
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			if (rs != null) {
				
				while (rs.next()) {
					num=rs.getInt("role");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataBaseUtil.closeAll(rs, ps, conn);
		}

		return num;
	}


	@Override
	public  int FzJs(int uid) {
		Connection conn=getConnection();
		PreparedStatement ps=null;
		String sql="SELECT role FROM easybuy_user WHERE id='"+uid+"'";
		ResultSet rs = null;
		 int num=0;
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					num=rs.getInt("role");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataBaseUtil.closeAll(rs, ps, conn);
		}

		return num;
	}


	@Override
	public int YhJs(User_Role ur,int uid) {
		String sql="update user_role set roleid=?  where userid=? ";
		int num=executeUpdate(sql,ur.getRoleid(),uid);
		return num;
	}


	@Override
	public List<Ls_Role> JzJs() {
		Connection conn=getConnection();
		PreparedStatement ps=null;
		String sql="SELECT * FROM ls_role";
		List<Ls_Role> list = null;
		ResultSet rs = null;
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			if (rs != null) {
				list = new ArrayList<Ls_Role>();
				while (rs.next()) {
					int id = rs.getInt("id");
					String rname= rs.getString("rname");
					list.add(new Ls_Role(id, rname));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataBaseUtil.closeAll(rs, ps, conn);
		}

		return list;
	}


	@Override
	public int Pdjs(String name) {
		Connection conn=getConnection();
		PreparedStatement ps=null;
		String sql="SELECT * FROM ls_role WHERE rname='"+name+"'";
		ResultSet rs = null;
		int num=0;
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					num=1;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataBaseUtil.closeAll(rs, ps, conn);
		}

		return num;
	}


	@Override
	public int InJs(Ls_Role lr) {
		String sql="INSERT INTO `ls_role`(rname) VALUES(?)";
		int num=executeUpdate(sql,lr.getRname());
		return num;
	}


	@Override
	public int DlJs(int idd) {
		String sql="delete from ls_role where id=?";
		int num=executeUpdate(sql,idd);
		return num;
	}


	@Override
	public List<Ls_Role> idjs(int idd) {
		Connection conn=getConnection();
		PreparedStatement ps=null;
		String sql="SELECT * FROM ls_role WHERE id='"+idd+"'  ";
		List<Ls_Role> list = null;
		ResultSet rs = null;
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			if (rs != null) {
				list = new ArrayList<Ls_Role>();
				while (rs.next()) {
					int id = rs.getInt("id");
					String rname= rs.getString("rname");
					list.add(new Ls_Role(id, rname));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataBaseUtil.closeAll(rs, ps, conn);
		}

		return list;
	}


	@Override
	public int uapjs(Ls_Role lr,int idd) {
		String sql="update ls_role set rname=?  where id=? ";
		int num=executeUpdate(sql,lr.getRname(),idd);
		return num;
	}


	@Override
	public int QxName(String name) {
		Connection conn=getConnection();
		PreparedStatement ps=null;
		String sql="SELECT * FROM ls_menu WHERE mname='"+name+"'  ";
		ResultSet rs = null;
		int num=0;
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					num=1;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataBaseUtil.closeAll(rs, ps, conn);
		}

		return num;
	}


	@Override
	public int InsQx(Ls_Menu lm) {
		String sql="INSERT INTO `ls_menu`(mname,`mfatherid`,`type`,`url`,`buttom`) VALUES(?,?,?,?,?)";
		int num=executeUpdate(sql,lm.getMname(),lm.getMfatherid(),lm.getType(),lm.getUrl(),lm.getButtom());
		return num;
	}


	@Override
	public List<Ls_Butten> SeAn() {
		Connection conn=getConnection();
		PreparedStatement ps=null;
		String sql="SELECT * FROM ls_butten";
		List<Ls_Butten> list = null;
		ResultSet rs = null;
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			if (rs != null) {
				list = new ArrayList<Ls_Butten>();
				while (rs.next()) {
					int id = rs.getInt("id");
					String btntype= rs.getString("btntype");
					list.add(new Ls_Butten(id, btntype));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataBaseUtil.closeAll(rs, ps, conn);
		}

		return list;
	}


	@Override
	public List<Ls_Menu> QxPd(int idd) {
		Connection conn=getConnection();
		PreparedStatement ps=null;
		String sql=null;
		if(idd==2) {
			idd--;
			sql="select * from ls_menu where type='"+idd+"'";
		}else if(idd==3) {
			idd--;
			sql="select * from ls_menu where type='"+idd+"'";
		}else {
			sql="select * from ls_menu where type='"+idd+"'";
		}
		
		List<Ls_Menu> list = null;
		ResultSet rs = null;
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			if (rs != null) {
				list = new ArrayList<Ls_Menu>();
				while (rs.next()) {
					int id = rs.getInt("id");
					String mname= rs.getString("mname");
					int mfatherid= rs.getInt("mfatherid");
					int type= rs.getInt("type");
					String url= rs.getString("url");
					String buttom= rs.getString("buttom");
					list.add(new Ls_Menu(id, mname, mfatherid, type, url, buttom));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataBaseUtil.closeAll(rs, ps, conn);
		}

		return list;
	}


	@Override
	public int DlQx(int idd) {
		String sql="delete from ls_menu where id=?";
		int num=executeUpdate(sql,idd);
		return num;
	}


	@Override
	public List<Ls_Menu> QxHx(int idd) {
		Connection conn=getConnection();
		PreparedStatement ps=null;
		String sql="select * from ls_menu where id='"+idd+"'";
		List<Ls_Menu> list = null;
		ResultSet rs = null;
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			if (rs != null) {
				list = new ArrayList<Ls_Menu>();
				while (rs.next()) {
					int id = rs.getInt("id");
					String mname= rs.getString("mname");
					int mfatherid= rs.getInt("mfatherid");
					int type= rs.getInt("type");
					String url= rs.getString("url");
					String buttom= rs.getString("buttom");
					list.add(new Ls_Menu(id, mname, mfatherid, type, url, buttom));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataBaseUtil.closeAll(rs, ps, conn);
		}

		return list;
	}


	@Override
	public List<Ls_Menu> XgQxPd(int idd) {
		Connection conn=getConnection();
		PreparedStatement ps=null;
		String sql="select * from ls_menu where id='"+idd+"'";
		
		List<Ls_Menu> list = null;
		ResultSet rs = null;
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			if (rs != null) {
				list = new ArrayList<Ls_Menu>();
				while (rs.next()) {
					int id = rs.getInt("id");
					String mname= rs.getString("mname");
					int mfatherid= rs.getInt("mfatherid");
					int type= rs.getInt("type");
					String url= rs.getString("url");
					String buttom= rs.getString("buttom");
					list.add(new Ls_Menu(id, mname, mfatherid, type, url, buttom));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataBaseUtil.closeAll(rs, ps, conn);
		}

		return list;
	}


	@Override
	public int XgQx(Ls_Menu lm,int idd) {
		String sql="update Ls_Menu set mname=?,mfatherid=?,type=?,url=?,buttom=?  where id=? ";
		int num=executeUpdate(sql,lm.getMname(),lm.getMfatherid(),lm.getType(),lm.getUrl(),lm.getButtom(),idd);
		return num;
	}


	@Override
	public List<Ls_Menu> FpQx() {
		Connection conn=getConnection();
		PreparedStatement ps=null;
		String sql="SELECT * FROM ls_menu";
		List<Ls_Menu> list = null;
		ResultSet rs = null;
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			if (rs != null) {
				list = new ArrayList<Ls_Menu>();
				while (rs.next()) {
					int id = rs.getInt("id");
					String mname= rs.getString("mname");
					int mfatherid= rs.getInt("mfatherid");
					int type= rs.getInt("type");
					String url= rs.getString("url");
					String buttom= rs.getString("buttom");
					list.add(new Ls_Menu(id, mname, mfatherid, type, url, buttom));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataBaseUtil.closeAll(rs, ps, conn);
		}

		return list;
	}


	@Override
	public List<User_Menu> Fphx(int id) {
		Connection conn=getConnection();
		PreparedStatement ps=null;
		String sql="SELECT * FROM user_menu WHERE userid='"+id+"'";
		List<User_Menu> list = null;
		ResultSet rs = null;
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			if (rs != null) {
				list = new ArrayList<User_Menu>();
				while (rs.next()) {
					int userid = rs.getInt("userid");
					int menuid= rs.getInt("menuid");
					list.add(new User_Menu(userid, menuid));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataBaseUtil.closeAll(rs, ps, conn);
		}

		return list;
	}


	@Override
	public int FpSc(int id) {
		String sql="delete from user_menu where userid=?";
		int num=executeUpdate(sql,id);
		return num;
	}


	@Override
	public int FpTj(int id,int qid) {
		String sql="INSERT INTO user_menu(userid,menuid) VALUES(?,?)";
		int num=executeUpdate(sql,id,qid);
		return num;
	}


	@Override
	public List<Students> selAllList() {
		Connection conn=getConnection();
		// TODO Auto-generated method stub
		List<Students> list = null;
		ResultSet rs = null;
		PreparedStatement ps=null;
		String sql="SELECT stu.id,stu.name,stu.logname,stu.signTime,stu.sex,stu.clas,lr.rname,ip FROM students AS stu,`ls_role` AS lr  WHERE stu.role=lr.id";	
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			if (rs != null) {
				list = new ArrayList<Students>();
				while (rs.next()) {
					int id = rs.getInt("id");
					String name= rs.getString("name");
					String logname= rs.getString("logname");
					String signTime= rs.getString("signTime");
					int sex= rs.getInt("sex");
					String clas= rs.getString("clas");
					String rname= rs.getString("rname");
					String ip= rs.getString("ip");
					list.add(new Students(id, name, logname, signTime, sex, clas,rname,ip));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataBaseUtil.closeAll(rs, ps, conn);
		}

		return list;
	}


	@Override
	public List<Students> selStuList(String lognames) {
		Connection conn=getConnection();
		// TODO Auto-generated method stub
		List<Students> list = null;
		ResultSet rs = null;
		PreparedStatement ps=null;
		String sql="SELECT stu.id,stu.name,stu.logname,stu.signTime,stu.sex,stu.clas,lr.rname,ip FROM students AS stu,`ls_role` AS lr  WHERE stu.role=lr.id and logname='"+lognames+"'";	
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			if (rs != null) {
				list = new ArrayList<Students>();
				while (rs.next()) {
					int id = rs.getInt("id");
					String name= rs.getString("name");
					String logname= rs.getString("logname");
					String signTime= rs.getString("signTime");
					int sex= rs.getInt("sex");
					String clas= rs.getString("clas");
					String rname= rs.getString("rname");
					String ip= rs.getString("ip");
					list.add(new Students(id, name, logname, signTime, sex, clas,rname,ip));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataBaseUtil.closeAll(rs, ps, conn);
		}

		return list;
	}


	@Override
	public List<Students> selTeaList(String clasb) {
		Connection conn=getConnection();
		// TODO Auto-generated method stub
		List<Students> list = null;
		ResultSet rs = null;
		PreparedStatement ps=null;
		String sql="SELECT stu.id,stu.name,stu.logname,stu.signTime,stu.sex,stu.clas,lr.rname,ip FROM students AS stu,`ls_role` AS lr  WHERE stu.role=lr.id and clas='"+clasb+"'";	
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			if (rs != null) {
				list = new ArrayList<Students>();
				while (rs.next()) {
					int id = rs.getInt("id");
					String name= rs.getString("name");
					String logname= rs.getString("logname");
					String signTime= rs.getString("signTime");
					int sex= rs.getInt("sex");
					String clas= rs.getString("clas");
					String rname= rs.getString("rname");
					String ip= rs.getString("ip");
					list.add(new Students(id, name, logname, signTime, sex, clas,rname,ip));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataBaseUtil.closeAll(rs, ps, conn);
		}

		return list;
	}
	@Override
	public Easybuy_User dxzh(int uid) {
		Connection conn=getConnection();
		PreparedStatement ps=null;
		String sql="SELECT * FROM  easybuy_user WHERE id='"+uid+"'";
		Easybuy_User easybuy_User= null;
		ResultSet rs = null;
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			if (rs != null) {		
				while (rs.next()) {
					int id = rs.getInt("id");
					String userName = rs.getString("userName");
					String loginName = rs.getString("loginName");
					String password = rs.getString("password");
					int sex = rs.getInt("sex");
					String identityCode = rs.getString("identityCode");
					String email = rs.getString("email");
					String mobile = rs.getString("mobile");
					int type = rs.getInt("type");
					int role = rs.getInt("role");
					String clas = rs.getString("clas");
					easybuy_User=new Easybuy_User(id, userName, loginName, password, sex, identityCode, email, mobile, type, role, clas);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataBaseUtil.closeAll(rs, ps, conn);
		}

		return easybuy_User;
	}
	@Override
	public int insqd(Students stu) {
		String sql="INSERT INTO `students`(name,`logname`,`signTime`,`sex`,clas,role,ip) VALUES(?,?,?,?,?,?,?)";
		int num=executeUpdate(sql,stu.getName(),stu.getLogname(),stu.getSignTime(),stu.getSex(),stu.getClas(),stu.getRole(),stu.getIp());
		return num;
	}
	@Override
	public int selqd(String logname, String time) {
		Connection conn=getConnection();
		// TODO Auto-generated method stub
		int num=0;
		ResultSet rs = null;
		PreparedStatement ps=null;
		String sql="SELECT * FROM students  WHERE logname = '"+logname+"' AND signTime LIKE '%"+time+"%'";	
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					num=1;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataBaseUtil.closeAll(rs, ps, conn);
		}
		//System.out.println(num);
		return num;
	}
	@Override
	public List<Easybuy_User> selbj() {
		Connection conn=getConnection();
		// TODO Auto-generated method stub
		List<Easybuy_User> list = null;
		ResultSet rs = null;
		PreparedStatement ps=null;
		String sql="SELECT eu.id,eu.clas,eu.userName,eu.loginName,eu.password,eu.sex,eu.identityCode,eu.email,eu.mobile,eu.type,lr.rname FROM easybuy_user AS eu,`ls_role` AS lr WHERE eu.role=lr.id ORDER BY clas";	
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			if (rs != null) {
				list = new ArrayList<Easybuy_User>();
				while (rs.next()) {
					int id = rs.getInt("id");
					String userName= rs.getString("userName");
					String loginName= rs.getString("loginName");
					String password= rs.getString("password");
					int sex= rs.getInt("sex");
					String identityCode= rs.getString("identityCode");
					String email= rs.getString("email");
					String mobile= rs.getString("mobile");
					int type= rs.getInt("type");
					String rname= rs.getString("rname");
					String clas= rs.getString("clas");
					list.add(new Easybuy_User(id, userName, loginName, password, sex, identityCode, email, mobile, type, rname, clas));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataBaseUtil.closeAll(rs, ps, conn);
		}

		return list;
	}
	@Override
	public List<Easybuy_User> selUser(String bj) {
		Connection conn=getConnection();
		// TODO Auto-generated method stub
		List<Easybuy_User> list = null;
		ResultSet rs = null;
		PreparedStatement ps=null;
		String sql="SELECT eu.id,eu.clas,eu.userName,eu.loginName,eu.password,eu.sex,eu.identityCode,eu.email,eu.mobile,eu.type,lr.rname FROM easybuy_user AS eu,`ls_role` AS lr WHERE eu.role=lr.id and clas='"+bj+"' ORDER BY clas";	
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			if (rs != null) {
				list = new ArrayList<Easybuy_User>();
				while (rs.next()) {
					int id = rs.getInt("id");
					String userName= rs.getString("userName");
					String loginName= rs.getString("loginName");
					String password= rs.getString("password");
					int sex= rs.getInt("sex");
					String identityCode= rs.getString("identityCode");
					String email= rs.getString("email");
					String mobile= rs.getString("mobile");
					int type= rs.getInt("type");
					String rname= rs.getString("rname");
					String clas= rs.getString("clas");
					list.add(new Easybuy_User(id, userName, loginName, password, sex, identityCode, email, mobile, type, rname, clas));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DataBaseUtil.closeAll(rs, ps, conn);
		}

		return list;
	}



	


	

	

}
