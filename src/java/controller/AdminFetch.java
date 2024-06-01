
package controller;

import dao.CabsDao;
import dao.*;
import entity.*;
import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "AdminFetch", urlPatterns = {"/AdminFetch"})
public class AdminFetch extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
      
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
          String action=request.getParameter("action");
        
        
        
        if("Booking".equals(action)){
            
        List<BookHotel> bookList=new FetchAdminDao().getBookHotelData();
        request.setAttribute("bookedHotel", bookList);
        List<BookCab> cabList=new FetchAdminDao().getBookCabData();
        request.setAttribute("bookedCab", cabList);
        List<BookDest> destList=new FetchAdminDao().getDestData();
        request.setAttribute("bookedDest", destList);
        request.setAttribute("dataTarget", "booking");
        request.getRequestDispatcher("admin-home.jsp").forward(request, response);
            
        }
        
        
        else if("newsLetter".equals(action)){
            
            
        List<NewsLetter> list=new FetchAdminDao().getNewsLetterData();
        request.setAttribute("listOfSub", list);
        request.setAttribute("dataTarget", "newsLetter");
        request.getRequestDispatcher("admin-home.jsp").forward(request, response);
            
        }
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
