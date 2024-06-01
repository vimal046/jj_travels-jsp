package controller;

import dao.CabsDao;
import dao.DestinationDao;
import dao.HotelDao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Update", urlPatterns = {"/Update"})
public class Update extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if ("hotelUpdate".equals(action)) {

            int hId = Integer.parseInt(request.getParameter("hotelID").trim());
            String hName = request.getParameter("hotelName").trim();
            String hDescription = request.getParameter("hotelDescription").trim();

            boolean result = new HotelDao().updateHotelData(hId, hName, hDescription);

            if (result) {

                request.setAttribute("redirectUrl", "Fetch?action=adminHotel");
                request.setAttribute("messageTitle", "Updated successfully!");
                request.getRequestDispatcher("success.jsp").forward(request, response);

            } else {

                request.setAttribute("redirectUrl", "Fetch?action=adminHotel.jsp");
                request.setAttribute("message", "Something error Unable to Update please try later");
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }

        } else if ("cabUpdate".equals(action)) {    

            int id = Integer.parseInt(request.getParameter("cabId").trim());
            String name = request.getParameter("cabName").trim();
            String description = request.getParameter("cabDescr").trim();

            boolean result = new CabsDao().updateCabData(id, name, description);

            if (result) {

                request.setAttribute("redirectUrl", "Fetch?action=adminCab");
                 request.setAttribute("messageTitle", "Updated successfully!");
                request.getRequestDispatcher("success.jsp").forward(request, response);

            } else {

                request.setAttribute("redirectUrl", "Fetch?action=adminCab.jsp");
                request.setAttribute("message", "Something error Unable to Update please try later");
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }
        } else if ("destUpdate".equals(action)) {

            int id = Integer.parseInt(request.getParameter("destId").trim());
            String name = request.getParameter("destName").trim();
            String description = request.getParameter("destDescr").trim();

            boolean result = new DestinationDao().updateDestData(id, name, description);

            if (result) {

                request.setAttribute("redirectUrl", "Fetch?action=adminDest");
                 request.setAttribute("messageTitle", "Updated successfully!");
                request.getRequestDispatcher("success.jsp").forward(request, response);

            } else {

                request.setAttribute("redirectUrl", "Fetch?action=adminDest.jsp");
                request.setAttribute("message", "Something error Unable to Update please try later");
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
