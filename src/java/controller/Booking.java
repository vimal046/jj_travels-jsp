package controller;

import dao.BookDao;
import entity.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Booking", urlPatterns = {"/Booking"})
public class Booking extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action").trim();

        if ("hotelBook".equals(action)) {

            String name = request.getParameter("name").trim();
            String mobile = request.getParameter("mobile").trim();
            String hotelName = request.getParameter("hotelName").trim();
            String checkInDate = request.getParameter("checkInDate").trim();
            String checkOutDate = request.getParameter("checkOutDate").trim();
            int noOfRooms = Integer.parseInt(request.getParameter("noOfRooms").trim());

            BookHotel bookHotel = new BookHotel(name, mobile, hotelName, checkInDate, checkOutDate, noOfRooms);

            boolean result = new BookDao().insertIntoHotelBookingTable(bookHotel);

            if (result) {
                request.setAttribute("redirectUrl", "Fetch?action=indexHotel");
                request.setAttribute("messageTitle", "Booking successfull !");
                request.setAttribute("message", "Thanku");
                request.getRequestDispatcher("success.jsp").forward(request, response);
            } else {
                request.setAttribute("redirectUrl", "Fetch?action=indexHotel.jsp");
                request.setAttribute("message", "Booking faild please try later");
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }

        } else if ("cabBook".equals(action)) {

            String location = request.getParameter("location").trim();
            String name = request.getParameter("name").trim();
            String emailId = request.getParameter("emailId").trim();
            String mobileNo = request.getParameter("mobileNo").trim();

            BookCab bookCab = new BookCab(location, name, emailId, mobileNo);

            boolean result = new BookDao().insertIntoCabBookingTable(bookCab);

            if (result) {
                request.setAttribute("redirectUrl", "Fetch?action=indexCab");
                request.setAttribute("messageTitle", "Booking successfull !");
                request.setAttribute("message", "Thanku");
                request.getRequestDispatcher("success.jsp").forward(request, response);
            } else {
                request.setAttribute("redirectUrl", "Fetch?action=indexCab.jsp");
                request.setAttribute("message", "Booking faild please try later");
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }

        } else if ("destBook".equals(action)) {

            String name = request.getParameter("name").trim();
            String emailId = request.getParameter("emailId").trim();
            String mobileNo = request.getParameter("mobileNo").trim();
            String travelDate = request.getParameter("travelDate").trim();
            String travellerCount = request.getParameter("travellerCount").trim();
            String message = request.getParameter("message").trim();

            BookDest bookDest = new BookDest(name, emailId, mobileNo, travelDate, travellerCount, message);

            boolean result = new BookDao().insertIntoDestEnquiryTable(bookDest);

            if (result) {
                request.setAttribute("redirectUrl", "Fetch?action=indexDest");
                request.setAttribute("messageTitle", "Booking successfull !");
                request.setAttribute("message", "Thanku");
                request.getRequestDispatcher("success.jsp").forward(request, response);
            } else {
                request.setAttribute("redirectUrl", "Fetch?action=indexDest.jsp");
                request.setAttribute("message", "Booking faild please try later");
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }

        } else if ("newsLetter".equals(action)) {

            String email = request.getParameter("email");

            boolean result = new BookDao().insertIntoNewsLetterTable(email);

            if (result) {
                request.setAttribute("redirectUrl", "Fetch?action=indexHotel");
                request.setAttribute("messageTitle", "Thanku !");
                request.setAttribute("message", "You are Subscribed");
                request.getRequestDispatcher("success.jsp").forward(request, response);
            } else {
                request.setAttribute("redirectUrl", "Fetch?action=indexHotel.jsp");
                request.setAttribute("message", "please try later");
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
