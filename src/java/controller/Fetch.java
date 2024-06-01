package controller;

import dao.CabsDao;
import dao.DestinationDao;
import dao.HotelDao;
import entity.Cab;
import entity.Dest;
import entity.Hotel;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Fetch", urlPatterns = {"/Fetch"})
public class Fetch extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        switch(action){
            case "indexHotel":
                showIndexHotel(request, response);
                break;
                
            case "adminHotel":
            showAdminHotel(request,response);
            break;
            
            case "indexCab":
            showIndexCab(request,response);
            break;
            
            case "adminCab":
            showAdminCab(request,response);
            break;
            
            case "indexDest":
            showIndexDest(request,response);
            break;
            
            case "adminDest":
            showAdminDest(request,response);
            break;
        }

    }
    
    private void showIndexHotel(HttpServletRequest request,HttpServletResponse response)
            throws ServletException,IOException{
        
        List<Hotel>list=new HotelDao().getDataFromHotelsTable();
        request.setAttribute("listOfHotel", list);
        request.getRequestDispatcher("index.jsp").forward(request, response);
        
    }
     private void showAdminHotel(HttpServletRequest request,HttpServletResponse response)
            throws ServletException,IOException{
        
        List<Hotel>list=new HotelDao().getDataFromHotelsTable();
        request.setAttribute("listOfHotel", list);
        request.setAttribute("dataTarget", "hotels");
        request.getRequestDispatcher("admin-home.jsp").forward(request, response);
        
    }
     private void showIndexCab(HttpServletRequest request,HttpServletResponse response)
            throws ServletException,IOException{
        
        List<Cab>list=new CabsDao().getDataFromDestTable();
        request.setAttribute("listOfCab", list);
        request.getRequestDispatcher("cabs.jsp").forward(request, response);
        
    }
     private void showAdminCab(HttpServletRequest request,HttpServletResponse response)
            throws ServletException,IOException{
        
        List<Cab>list=new CabsDao().getDataFromDestTable();
        request.setAttribute("listOfCab", list);
        request.setAttribute("dataTarget", "cabs");
        request.getRequestDispatcher("admin-home.jsp").forward(request, response);
        
    }
      private void showIndexDest(HttpServletRequest request,HttpServletResponse response)
            throws ServletException,IOException{
        
        List<Dest>list=new DestinationDao().getDataFromDestTable();
        request.setAttribute("listOfDest", list);
        request.getRequestDispatcher("top-destination.jsp").forward(request, response);
        
    }
     private void showAdminDest(HttpServletRequest request,HttpServletResponse response)
            throws ServletException,IOException{
        
        List<Dest>list=new DestinationDao().getDataFromDestTable();
        request.setAttribute("listOfDest", list);
        request.setAttribute("dataTarget", "destination");
        request.getRequestDispatcher("admin-home.jsp").forward(request, response);
        
    }

}
