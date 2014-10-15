package web;

import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.bcel.internal.generic.NEW;

import java.sql.*;
import java.util.*;
import web.Book;
import javax.servlet.http.HttpServletRequest;
import web.Book;
import org.apache.struts2.ServletActionContext;

public class delete extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private static Connection connection = null;
	private static Statement statement ;
	private static ResultSet resultSet;
	private String name;
	public  List<Book> list = new ArrayList<Book>(); 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;  
	}
public String execute() throws Exception{
		
		
		int id=-1;
	    String sql = String.format("select * from Book where Title = '%s'",name);
	    System.out.println(sql);
		
		Class.forName("com.mysql.jdbc.Driver");// 修改驱动器
		connection = DriverManager.getConnection("jdbc:mysql://w.rdc.sae.sina.com.cn:3307/app_xgbjbook","z30n11m435","50hiwji31mx4443hmmwkjw32x133h3z00i0141z2");//修改
		//connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookdb","root","www8312711");//修改
		statement = connection.createStatement();
		
		resultSet = statement.executeQuery(sql);
		
        if(resultSet.next())id=resultSet.getInt(3);
        
        sql = String.format("delete from Book where Title = '%s'",name);
	    System.out.println(statement.executeUpdate(sql));
        
        sql = String.format("select * from Book where AuthorID = %d",id);
        System.out.println(sql);
        
        resultSet = statement.executeQuery(sql);
        while(resultSet.next()){
	    	Book book = new Book();
			book.setTitle(resultSet.getString(2));
	    	book.setPrice(resultSet.getFloat(6));
	    	list.add(book);
	     }
	     HttpServletRequest request = ServletActionContext.getRequest();
		 request.setAttribute("list", list);
        
       
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
