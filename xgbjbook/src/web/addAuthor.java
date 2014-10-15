package web;

import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.bcel.internal.generic.NEW;

import java.sql.*;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import web.Book;
import org.apache.struts2.ServletActionContext;
public class addAuthor extends ActionSupport{
	    private static final long serialVersionUID = 1L;
		private static Connection connection = null;
		private static Statement statement ;
		private static ResultSet resultSet;
	   
	    private  int AuthorID;
	    private  String Name;
	    private  int Age;
	    private  String Country;
	    public void setCountry(String Country){
	    	this.Country = Country;
	    }
	    public String getCountry(){
	    	return Country;
	    }
	    public void setAge(int Age){
	    	this.Age = Age;
	    }
	    public int getAge(){
	    	return Age;
	    }
	    public void setName(String Name){
	    	this.Name = Name;
	    }
	    public String getName(){
	    	return Name;
	    }
	    public void setAuthorID(int AuthorID){
	    	this.AuthorID = AuthorID;
	    }
	    public int getAuthorID(){
	    	return AuthorID;
	    }
	    public String execute() throws Exception{
			String sql = String.format("Insert into Author values(%d,'%s',%d,'%s')",
			AuthorID,Name,Age,Country);
			
			Class.forName("com.mysql.jdbc.Driver");// 修改驱动器
			connection = DriverManager.getConnection("jdbc:mysql://w.rdc.sae.sina.com.cn:3307/app_xgbjbook","z30n11m435","50hiwji31mx4443hmmwkjw32x133h3z00i0141z2");//修改
			//connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookdb","root","www8312711");//修改
			statement = connection.createStatement();
			
			System.out.println(sql);
			System.out.println(statement.executeUpdate(sql));
			 this.closeConnection();
				
				return SUCCESS;
			}


		public void closeConnection()
		{
		try{
			if(connection !=null){
				
				connection.close();
				connection = null;
			}
		}catch(Exception e)
		{
		e.printStackTrace();	
		}
		}
		}