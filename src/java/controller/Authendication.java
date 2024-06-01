package controller;

import dao.AuthendicationDao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Authendication", urlPatterns = {"/Authendication"})
public class Authendication extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if ("logout".equals(action)) {

            HttpSession session = request.getSession(false);

            if (session != null) {
                session.invalidate();
            }

            response.sendRedirect("Fetch?action=indexHotel");

        } else if ("login".equals(action)) {

            String name = request.getParameter("name");
            String password = request.getParameter("password");

            boolean result = new AuthendicationDao().loginVerification(name, password);

            if (result) {
                response.sendRedirect("Fetch?action=adminHotel");
            } else {
                request.setAttribute("redirectUrl", "Fetch?action=indexHotel");
                request.setAttribute("message", "Wrong User Name (or) Password");

                request.getRequestDispatcher("error.jsp").forward(request, response);
            }

        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
