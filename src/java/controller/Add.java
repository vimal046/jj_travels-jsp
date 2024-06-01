package controller;

import dao.CabsDao;
import dao.DestinationDao;
import dao.HotelDao;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author VIMAL SUKU
 */
@WebServlet(name = "Add", urlPatterns = {"/Add"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, //2MB
        maxFileSize = 1024 * 1024 * 10, //10MB
        maxRequestSize = 1024 * 1024 * 50) //50MB
public class Add extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if ("addHotel".equals(action)) {

            //Retriving String data
            String hName = request.getParameter("hotelName").trim();
            String hDescription = request.getParameter("hotelDescription").trim();

//        System.out.println("Hotel Name :" + hotelName);
//        System.out.println("Description :" + hotelDescription);
            Part filePart = request.getPart("hotelImage");
            String fileName = getSubmittedFileName(filePart);
            String uploadPath = "C:\\Users\\VIMAL SUKU\\Documents\\NetBeansProjects\\" + getServletContext().getContextPath() + "\\web\\images\\" + fileName;
            String imageLocation = "images/" + fileName.trim();

            //    System.out.println("Web Directory :" + uploadPath);
            OutputStream out = null;
            InputStream fileContent = null;

            try {
                out = new FileOutputStream(new File(uploadPath));
                fileContent = filePart.getInputStream();
                int read = 0;
                final byte[] bytes = new byte[1024];
                while ((read = fileContent.read(bytes)) != -1) {
                    out.write(bytes, 0, read);
                }

                boolean result = new HotelDao().insertHotelData(hName, hDescription, imageLocation);

                if (result) {

                    request.setAttribute("redirectUrl", "Fetch?action=adminHotel");
                    request.setAttribute("messageTitle", "Added successfully!");
                    request.setAttribute("messageTitle", "Thanku");
                    request.getRequestDispatcher("success.jsp").forward(request, response);

                } else {

                    request.setAttribute("redirectUrl", "Fetch?action=adminHotel.jsp");
                    request.setAttribute("message", "Something error please try later");
                    request.getRequestDispatcher("error.jsp").forward(request, response);
                }

//                System.out.println("File uploaded successfully Location :" + imageLocation);
            } catch (FileNotFoundException fne) {

                System.out.println("File upload failed :" + fne.getMessage());

                request.setAttribute("redirectUrl", "Fetch?action=adminHotel.jsp");
                request.setAttribute("message", "File upload failed: ");
                request.getRequestDispatcher("error.jsp").forward(request, response);

            } finally {
                if (out != null) {
                    out.close();
                }
                if (fileContent != null) {
                    fileContent.close();
                }
            }

        } else if ("addCab".equals(action)) {
            //Retriving String data
            String name = request.getParameter("cabName").trim();
            String description = request.getParameter("cabDescription").trim();

//            System.out.println("Hotel Name :" + cName);
//            System.out.println("Description :" + cDescription);
            Part filePart = request.getPart("cabImage");
            String fileName = getSubmittedFileName(filePart);
            String uploadPath = "C:\\Users\\VIMAL SUKU\\Documents\\NetBeansProjects\\" + getServletContext().getContextPath() + "\\web\\images\\" + fileName;
            String imageLocation = "images/" + fileName.trim();

//            System.out.println("Web Directory :" + uploadPath);
            OutputStream out = null;
            InputStream fileContent = null;

            try {
                out = new FileOutputStream(new File(uploadPath));
                fileContent = filePart.getInputStream();
                int read = 0;
                final byte[] bytes = new byte[1024];
                while ((read = fileContent.read(bytes)) != -1) {
                    out.write(bytes, 0, read);
                }

                boolean result = new CabsDao().insertCabData(name, description, imageLocation);

                if (result) {

                    request.setAttribute("redirectUrl", "Fetch?action=adminCab");
                    request.setAttribute("messageTitle", "Added successfully!");
                    request.setAttribute("messageTitle", "Thanku");
                    request.getRequestDispatcher("success.jsp").forward(request, response);

                } else {

                    request.setAttribute("redirectUrl", "Fetch?action=adminCab.jsp");
                    request.setAttribute("message", "Something error please try later");
                    request.getRequestDispatcher("error.jsp").forward(request, response);
                }

//                System.out.println("File uploaded successfully Location :" + imageLocation);
            } catch (FileNotFoundException fne) {

                request.setAttribute("redirectUrl", "Fetch?action=adminCab.jsp");
                request.setAttribute("message", "File upload failed.. please try later");
                request.getRequestDispatcher("error.jsp").forward(request, response);

                System.out.println("File upload failed :" + fne.getMessage());
            } finally {
                if (out != null) {
                    out.close();
                }
                if (fileContent != null) {
                    fileContent.close();
                }
            }

        } else if ("addDestination".equals(action)) {

            String name = request.getParameter("destName").trim();
            String description = request.getParameter("destDiscr").trim();
            System.out.println(name);

//            System.out.println("Hotel Name :" + name);
//            System.out.println("Description :" + description);
            Part filePart = request.getPart("destImage");
            String fileName = getSubmittedFileName(filePart);
            String uploadPath = "C:\\Users\\VIMAL SUKU\\Documents\\NetBeansProjects\\" + getServletContext().getContextPath() + "\\web\\images\\" + fileName;
            String imageLocation = "images/" + fileName.trim();

//            System.out.println("Web Directory :" + uploadPath);
            OutputStream out = null;
            InputStream fileContent = null;

            try {
                out = new FileOutputStream(new File(uploadPath));
                fileContent = filePart.getInputStream();
                int read = 0;
                final byte[] bytes = new byte[1024];
                while ((read = fileContent.read(bytes)) != -1) {
                    out.write(bytes, 0, read);
                }

                boolean result = new DestinationDao().insertDestData(name, description, imageLocation);

                if (result) {
                    
                    request.setAttribute("redirectUrl", "Fetch?action=adminDest");
                    request.setAttribute("messageTitle", "Added successfully!");
                    request.setAttribute("messageTitle", "Thanku");
                    request.getRequestDispatcher("success.jsp").forward(request, response);
                    
                    
                }else {

                    request.setAttribute("redirectUrl", "Fetch?action=adminDest.jsp");
                    request.setAttribute("message", "Something error please try later");
                    request.getRequestDispatcher("error.jsp").forward(request, response);
                }

//                System.out.println("File uploaded successfully Location :" + imageLocation);
            } catch (FileNotFoundException fne) {
                
                request.setAttribute("redirectUrl", "Fetch?action=adminDest.jsp");
                request.setAttribute("message", "File upload failed.. please try later");
                request.getRequestDispatcher("error.jsp").forward(request, response);
                
                System.out.println("File upload failed :" + fne.getMessage());
            } finally {
                if (out != null) {
                    out.close();
                }
                if (fileContent != null) {
                    fileContent.close();
                }
            }
        }
    }

    private String getSubmittedFileName(Part part) {

        for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                String fileName = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
                return fileName.substring(fileName.lastIndexOf('/') + 1).substring(fileName.lastIndexOf('\\') + 1);
            }
        }
        return null;
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
