package web;

import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.bcel.internal.generic.NEW;

import java.sql.*;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import web.Book;
import org.apache.struts2.ServletActionContext;
public class detail extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Connection connection = null;
	private static Statement statement ;
	private static ResultSet resultSet;
	private String name;
	public  List<Book> list = new ArrayList<Book>();  
	//public ArrayList list = new ArrayList();
	//private Action action;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String execute() throws Exception{
		
		
		String sql = String.format("select * from Book where Title = '%s'",name);
		System.out.println(name);
		name =null;
		//action = new Action("name");
		Class.forName("com.mysql.jdbc.Driver");// 修改驱动器
		connection = DriverManager.getConnection("jdbc:mysql://w.rdc.sae.sina.com.cn:3307/app_xgbjbook","z30n11m435","50hiwji31mx4443hmmwkjw32x133h3z00i0141z2");//修改
		//connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookdb","root","www8312711");//修改
		statement = connection.createStatement();
		// resultSet =  statement.executeQuery("select ISBN,Title,Publisher,PublishDate,Price from Book where AuthorID like 'YDL'");
		resultSet = statement.executeQuery(sql);
		Book book = new Book();
		     if(resultSet.next()){
		    	book.setISBN(resultSet.getString(1));
		    	book.setTitle(resultSet.getString(2));
		    	book.setAuthorID(resultSet.getInt(3));
		    	book.setPublisher(resultSet.getString(4));
		    	book.setPublishDate(resultSet.getString(5));
		    	book.setPrice(resultSet.getFloat(6));
		     }
		     sql = String.format("select * from Author where AuthorID = %d", book.getAuthorID()); 
		 	resultSet = statement.executeQuery(sql);
		 	while(resultSet.next()){
		 		book.setName(resultSet.getString(2));
		 		book.setAge(resultSet.getInt(3));
		 		book.setCountry(resultSet.getString(4));
		 	}
		     list.add(book);
		     HttpServletRequest request = ServletActionContext.getRequest();
			 request.setAttribute("list", list);
			 System.out.println("成功进入");
		  
		 this.closeConnection();
		System.out.println("一切正常");
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