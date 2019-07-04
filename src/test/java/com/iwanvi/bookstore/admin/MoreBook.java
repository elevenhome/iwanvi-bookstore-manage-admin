package com.iwanvi.bookstore.admin;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author YDF
 * @Description
 * @Date 2019/4/15 0015 上午 10:08
 * @Version 1.0
 */
public class MoreBook {

  public static void main(String[] args) {
      //声明Connection对象
      Connection con;
      //驱动程序名
      String driver = "com.mysql.jdbc.Driver";
      //URL指向要访问的数据库名mydata
      String url = "jdbc:mysql://db.bookstore:3306/freebook_admin?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8";
      //MySQL配置时的用户名
      String user = "APP_01";
      //MySQL配置时的密码
      String password = "Iwanvi@123";
      //遍历查询结果集
      try {
          //加载驱动程序
          Class.forName(driver);
          //1.getConnection()方法，连接MySQL数据库！！
          con = DriverManager.getConnection(url,user,password);
          if(!con.isClosed())
              System.out.println("Succeeded connecting to the Database!");
          //2.创建statement类对象，用来执行SQL语句！！
          //Statement statement = con.createStatement();
          //要执行的SQL语句
          //String sql = "SELECT * FROM (SELECT book_id, count(book_id) num FROM book_center GROUP BY book_id) t WHERE t.num >1";
          String sql = "SELECT book_id, count(book_id) num FROM book_center GROUP BY book_id";
          PreparedStatement prepareStatement = con.prepareStatement(sql);
          //3.ResultSet类，用来存放获取的结果集！！
          //ResultSet rs = statement.executeQuery(sql);
          ResultSet rs = prepareStatement.executeQuery();
          List list = convertList(rs);
            System.out.println(list.size());

          rs.last();// 移动到最后
          int count = rs.getRow();
          System.out.println("-----------------");
          System.out.println("执行结果如下所示:"+count);
          System.out.println("-----------------");
          System.out.println("BookId" + "\t" + "Num");
          System.out.println("-----------------");
        
          String book_id = null;
          String num = null;
          rs.beforeFirst();// 返回第一个（记住不是rs.frist()）,不写的话下面的循环里面没值
          while(rs.next()){
              //获取stuname这列数据
              book_id = rs.getString("book_id");
              //获取stuid这列数据
              num = rs.getString("num");
            
              //输出结果
              System.out.println(book_id + "\t" + num);
          }
          rs.close();
          con.close();
      } catch(ClassNotFoundException e) {
          //数据库驱动类异常处理
          System.out.println("Sorry,can`t find the Driver!");
          e.printStackTrace();
      } catch(SQLException e) {
          //数据库连接失败异常处理
          e.printStackTrace();
      }catch (Exception e) {
          // TODO: handle exception
          e.printStackTrace();
      }finally{
          System.out.println("数据库数据成功获取！！");
      }
  }
    private static List convertList(ResultSet rs) throws SQLException{
        List list = new ArrayList();
        ResultSetMetaData md = rs.getMetaData();//获取键名
        int columnCount = md.getColumnCount();//获取行的数量
        while (rs.next()) {
            Map rowData = new HashMap();//声明Map
            for (int i = 1; i <= columnCount; i++) {
                rowData.put(md.getColumnName(i), rs.getObject(i));//获取键名及值
            }
            list.add(rowData);
        }
        return list;
    }
}
