package controller;

import dao.CabsDao;
import dao.DestinationDao;
import dao.HotelDao;
import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Delete", urlPatterns = {"/Delete"})
public class Delete extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if ("hotelDelete".equals(action)) {

            int hId = Integer.parseInt(request.getParameter("hotelID").trim());
            String imageLoc = request.getParameter("imageLocation").replace("images/", "\\");
            String contextPath = request.getServletContext().getRealPath("/") + "\\web\\images" + imageLoc;
            String imagePath = contextPath.replace("\\build\\web\\", "");

            System.out.println(imagePath);
           System.out.println(hId);
            File imageFile = new File(imagePath);

            if (imageFile.exists() && imageFile.isFile()) {

                //delete operation done here
                if (imageFile.delete()) {

                    boolean result = new HotelDao().deleteDataFromHotelsTable(hId);
                    if (result) {

                        request.setAttribute("redirectUrl", "Fetch?action=adminHotel");
                        request.setAttribute("messageTitle", "Deleted successfully!");
                        request.getRequestDispatcher("success.jsp").forward(request, response);

                    } else {

                        request.setAttribute("redirectUrl", "Fetch?action=adminHotel.jsp");
                        request.setAttribute("message", "Something error Failed to delete data");
                        request.getRequestDispatcher("error.jsp").forward(request, response);
                    }
                } else {
                    request.setAttribute("redirectUrl", "Fetch?action=adminHotel.jsp");
                    request.setAttribute("message", "Something error Failed to delete image");
                    request.getRequestDispatcher("error.jsp").forward(request, response);
                }
            } else {

                request.setAttribute("redirectUrl", "Fetch?action=adminHotel.jsp");
                request.setAttribute("message", "The specified image does not exist or is not a file.");
                request.getRequestDispatcher("error.jsp").forward(request, response);

            }
        } else if ("cabDelete".equals(action)) {
            int id = Integer.parseInt(request.getParameter("cabId").trim());
            String imageLoc = request.getParameter("imageLocation").replace("images/", "\\");
            String contextPath = request.getServletContext().getRealPath("/") + "\\web\\images" + imageLoc;
            String imagePath = contextPath.replace("\\build\\web\\", "");

//            System.out.println(imagePath);
//            System.out.println(id);
            File imageFile = new File(imagePath);

            if (imageFile.exists() && imageFile.isFile()) {

                //delete operation done here
                if (imageFile.delete()) {

                    boolean result = new CabsDao().deleteDataFromCabsTable(id);
                    if (result) {

                        request.setAttribute("redirectUrl", "Fetch?action=adminCab");
                        request.setAttribute("messageTitle", "Deleted successfully!");
                        request.getRequestDispatcher("success.jsp").forward(request, response);

                    } else {

                        request.setAttribute("redirectUrl", "Fetch?action=adminCab.jsp");
                        request.setAttribute("message", "Something error Failed to delete data.");
                        request.getRequestDispatcher("error.jsp").forward(request, response);

                        System.out.println("");
                    }
                } else {

                    request.setAttribute("redirectUrl", "Fetch?action=adminCab.jsp");
                    request.setAttribute("message", "Something error Failed to delete the image");
                    request.getRequestDispatcher("error.jsp").forward(request, response);

                }
            } else {

                request.setAttribute("redirectUrl", "Fetch?action=adminCab.jsp");
                request.setAttribute("message", "Something error The specified image does not exist or is not a file.");
                request.getRequestDispatcher("error.jsp").forward(request, response);

            }

        } else if ("destinationDelete".equals(action)) {

            int Id = Integer.parseInt(request.getParameter("destId").trim());
            String imageLoc = request.getParameter("imageLocation").replace("images/", "\\");
            String contextPath = request.getServletContext().getRealPath("/") + "\\web\\images" + imageLoc;
            String imagePath = contextPath.replace("\\build\\web\\", "");

            System.out.println(imagePath);
            System.out.println(Id);
            
            
            File imageFile = new File(imagePath);

            if (imageFile.exists() && imageFile.isFile()) {

                //delete operation done here
                if (imageFile.delete()) {

                    boolean result = new DestinationDao().deleteDataFromDestTable(Id);
                    
                    if (result) {

                        request.setAttribute("redirectUrl", "Fetch?action=adminDest");
                        request.setAttribute("messageTitle", "Deleted successfully!");
                        request.getRequestDispatcher("success.jsp").forward(request, response);

                    } else {

                        request.setAttribute("redirectUrl", "Fetch?action=adminDest.jsp");
                        request.setAttribute("message", "Something error Failed to delete data.");
                        request.getRequestDispatcher("error.jsp").forward(request, response);

                    }
                } else {

                    request.setAttribute("redirectUrl", "Fetch?action=adminDest.jsp");
                    request.setAttribute("message", "Something error Failed to delete the image.");
                    request.getRequestDispatcher("error.jsp").forward(request, response);

                }
            } else {

                request.setAttribute("redirectUrl", "Fetch?action=adminDest.jsp");
                request.setAttribute("message", "Something error The specified image does not exist or is not a file.");
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
