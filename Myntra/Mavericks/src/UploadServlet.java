import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/UploadServlet")
@MultipartConfig
public class UploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
	try{
            //Retrieve all images one by one and convert to inputstream object
            Part front1= request.getPart("front1");
            InputStream f1 = front1.getInputStream();
            Part front2= request.getPart("front2");
            InputStream f2 = front2.getInputStream();
            Part front3= request.getPart("front3");
            InputStream f3 = front3.getInputStream();
            Part back1= request.getPart("back1");
            InputStream b1 = back1.getInputStream();
            Part back2= request.getPart("back2");
            InputStream b2 = back2.getInputStream();
            Part back3= request.getPart("back3");
            InputStream b3 = back3.getInputStream();
            Part left1= request.getPart("left1");
            InputStream l1 = left1.getInputStream();
            Part left2= request.getPart("left2");
            InputStream l2 = left2.getInputStream();
            Part left3= request.getPart("left3");
            InputStream l3 = left3.getInputStream();
            Part right1= request.getPart("right1");
            InputStream r1 = right1.getInputStream();
            Part right2= request.getPart("right2");
            InputStream r2 = right2.getInputStream();
            Part right3= request.getPart("riight3");
            InputStream r3 = right3.getInputStream();
            Part background= request.getPart("background");
            InputStream bg = background.getInputStream();
            
            Connection con= dbconn.initializeDatabase();//connect to database
            Statement stmt =con.createStatement();
            PreparedStatement ps= con.prepareStatement("insert into photos values(?,?,?,?,?,?,?,?,?,?,?,?,?");
            //insert photos into database
            ps.setBlob(1,f1);
            ps.setBlob(2,f2);
            ps.setBlob(3,f3);
            ps.setBlob(4,b1);
            ps.setBlob(5,b2);
            ps.setBlob(6,b3);
            ps.setBlob(7,l1);
            ps.setBlob(8,l2);
            ps.setBlob(9,l3);
            ps.setBlob(10,r1);
            ps.setBlob(11,r2);
            ps.setBlob(12,r3);
            ps.setBlob(13,bg);
            
            ps.executeUpdate();
        }catch(IOException | ClassNotFoundException | SQLException | ServletException e){}
    }
}