
package green.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;

import green.util.DBConnectionPool;
import green.vo.Person;

@SuppressWarnings("unused")
public class PersonDao {
   DBConnectionPool connPool;
   
   public void setConnection(DBConnectionPool connPool) {// 호출하는 메서드 / 세터
	   System.out.println("PersonDao_setConnection ok");
      this.connPool = connPool;
   }
   
   public List<Person> selectlist() throws Exception{ // arraylist반납하는 selectlist{
	  System.out.println("PsersonDao_selectlist ok");
	  Connection connection  =null;
	  Statement stmt = null;
      ResultSet rs = null;
      try {
         connection = connPool.getConnection();
         stmt = connection.createStatement();
         rs = stmt.executeQuery(
               "select * from jumindb.person;");
         ArrayList<Person> persons = new ArrayList<Person>();
         while(rs.next()) {
            persons.add(new Person()
                     .setNum(rs.getInt("num"))
                     .setName(rs.getString("name"))
                     .setPersonId(rs.getString("personId"))
                     .setJuso(rs.getString("Juso"))
                     .setPhone(rs.getString("phone"))
                     .setSibling(rs.getInt("sibling"))
                     .setDadName(rs.getString("dadName"))
            		);
         }
         return persons;
      } catch (Exception e) {
         throw e;
      } finally {
         try {if (rs != null) rs.close();} catch(Exception e) {}
         try {if (stmt != null) stmt.close();} catch(Exception e) {}
      }
   }
   
   public int insert (Person Person) throws Exception {
	   System.out.println("PersonDao_insert ok");
	   PreparedStatement stmt = null;	
	   Connection connection  =null;
	      try {
	    	  	connection = connPool.getConnection();
	    	  	stmt = connection.prepareStatement("insert into person(name,personId,juso,phone,sibling,dadName) values(?,?,?,?,?,?);");
	         	stmt.setString(1, Person.getName());
				stmt.setString(2, Person.getPersonId());
				stmt.setString(3, Person.getJuso());
				stmt.setString(4, Person.getPhone());
				stmt.setInt(5, Person.getSibling());
				stmt.setString(6, Person.getDadName());
				return stmt.executeUpdate();
	      } catch (Exception e) {
	         throw e;
	      } finally {
	          try {if (stmt != null) stmt.close();} catch(Exception e) {}
	      }
   }
   
   public int update(Person Person) throws Exception {
	   System.out.println("PersonDao_update ok");
	   Connection connection  =null;
		PreparedStatement stmt = null;
		//DB와 연결
		try {
			connection = connPool.getConnection();
			stmt =connection.prepareStatement(
				"update person set name=?,personId=?,juso=?,phone=?,sibling=?,dadName=?"
					+ " where num=? "
			);
			
			stmt.setString(1, Person.getName());
			stmt.setString(2, Person.getPersonId());
			stmt.setString(3, Person.getJuso());
			stmt.setString(4, Person.getPhone());
			stmt.setInt(5, Person.getSibling());
			stmt.setString(6, Person.getDadName());
			stmt.setInt(7, Person.getNum());
			System.out.println("stmt : " + stmt);
			return stmt.executeUpdate();
		
		} catch(Exception e) {
			throw new ServletException(); //예외를 던짐
		} finally {
			 try {if (stmt != null) stmt.close();} catch(Exception e) {}
		}
	}
	   
   public int delete (int num) throws Exception {
	   System.out.println("PersonDao_delete ok");
	   Connection connection  =null;
	   Statement stmt = null;
	   try {
		   connection = connPool.getConnection();
		   stmt =connection.createStatement();
		   return stmt.executeUpdate("delete from person where num=" + num);
		   
	   }catch(Exception e) {
		   throw e;		   
	   }finally {
		   try {if (stmt != null) stmt.close();} catch(Exception e) {}
	   }
   }

   public List<Person> search(String name) throws Exception{ // arraylist반납하는 selectlist{
		  System.out.println("PsersonDao_search ok");
		  Connection connection  =null;
		  Statement stmt = null;
	      ResultSet rs = null;
	      try {
	         connection = connPool.getConnection();
	         stmt = connection.createStatement();
	         rs = stmt.executeQuery(
	               "select * from jumindb.person where name= '" + name + "';");
	         ArrayList<Person> Persons = new ArrayList<Person>();
	         int age;
	         String personId;
	         while(rs.next()) {
	        	personId = rs.getString("personId");
	        	if((personId.substring(0,1)).equals("0") || (personId.substring(0,1)).equals("1")) {
	        		personId = "20" + personId.substring(0,2);
	        	}
	        	else {
	        		personId = "19" + personId.substring(0,2);
	        	}
	        	age = Integer.valueOf(personId);
	        	Calendar cal = Calendar.getInstance();
	        	int year = cal.get(Calendar.YEAR);
	        	age = year - age + 1;
	        	
	            Persons.add(new Person()
	                     .setNum(rs.getInt("num"))
	                     .setName(rs.getString("name"))
	                     .setPersonId(rs.getString("personId"))
	                     .setJuso(rs.getString("Juso"))
	                     .setPhone(rs.getString("phone"))
	                     .setSibling(rs.getInt("sibling"))
	                     .setDadName(rs.getString("dadName"))
	                     .setAge(age)
	            		);
	         }
	         return Persons;
	      } catch (Exception e) {
	         throw e;
	      } finally {
	         try {if (rs != null) rs.close();} catch(Exception e) {}
	         try {if (stmt != null) stmt.close();} catch(Exception e) {}
	      }
	   }
   
   public Person selectOne(int num) throws Exception {
	   System.out.println("PersonDao_selectOne ok");
	   Connection connection  =null;
	   Statement stmt = null;
	   ResultSet rs = null;
	   
	   try {
		   connection = connPool.getConnection();
		   stmt = connection.createStatement();
		   rs = stmt.executeQuery("select * from person where num="+ num);
		   
		   if(rs.next()) {
			   return new Person()
					   .setNum(rs.getInt("num"))
					   .setName(rs.getString("name"))
					   .setPersonId(rs.getString("personId"))
					   .setJuso(rs.getString("Juso"))
					   .setPhone(rs.getString("phone"))
					   .setSibling(rs.getInt("sibling"))
					   .setDadName(rs.getString("dadName"));
			   
		   }else {
			   throw new Exception("해당 번호를 찾을 수 없습니다.");
		   }
		   
	   }catch(Exception e) {
		   throw e;
		   
	   }finally {
		   try {if(stmt!=null) stmt.close();} catch(Exception e) {}
		   try {if(rs!=null) rs.close();} catch(Exception e) {}
	   }
   }
}