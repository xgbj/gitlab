package web;

import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.bcel.internal.generic.NEW;

import java.sql.*;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import web.Book;
import org.apache.struts2.ServletActionContext;
//wangjiawei
public class add extends ActionSupport{
	    private  String ISBN;
	    private  String Titl;
	    private  String Publisher;
	    private  String PublishDate;
	    private  float  Price;
	    private  int AuthorID;
	    
	    private static final long serialVersionUID = 1L;
		private static Connection connection = null;
		private static Statement statement ;
		private static ResultSet resultSet;
		private String name;
	    
	    public void setAuthorID(int AuthorID){
	    	this.AuthorID = AuthorID;
	    }
	    public int getAuthorID(){
	    	return AuthorID;
	    }
	    public void setISBN(String ISBN){
	    	this.ISBN = ISBN;
	    }
	    public String getISBN(){
	    	return ISBN;
	    }
	    public void setTitle(String Title){
	    	this.Title = Title;
	    }
	    public String getTitle(){
	    	return Title;
	    }
	  
	  
	    public void setPublisher(String Publisher){
	    	this.Publisher = Publisher;
	    }
	    public String getPublisher(){
	    	return Publisher;
	    }
	    public void setPublishDate(String PublishDate){
	    	this.PublishDate = PublishDate;
	    }
	    public String getPublishDate(){
	    	return PublishDate;
	    }
	    public void setPrice(float Price){
	    	this.Price = Price;
	    }
	    public float getPrice(){

	    	return Price;
	    }
		public String execute() throws Exception{
			String sql = String.format("select * from Book where ISBN = '%s'",ISBN);
			
			Class.forName("com.mysql.jdbc.Driver");// 修改驱动器
			//connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookdb","root","www8312711");//修改
			connection = DriverManager.getConnection("jdbc:mysql://w.rdc.sae.sina.com.cn:3307/app_xgbjbook","z30n11m435","50hiwji31mx4443hmmwkjw32x133h3z00i0141z2");//修改
			statement = connection.createStatement();
			
			 resultSet = statement.executeQuery(sql);
			 if(resultSet.next()){
			      return "exist";
			    }
			 
			sql = String.format("Insert into Book values('%s','%s',%d,'%s','%s',%f)",
					ISBN,Title,AuthorID,Publisher,PublishDate,Price);
			System.out.println(statement.executeUpdate(sql));
			
			
		    sql = String.format("select * from Author where AuthorID = %d",AuthorID);
		    resultSet = statement.executeQuery(sql);
		    if(!resultSet.next()){
		      return "not";
		    }
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