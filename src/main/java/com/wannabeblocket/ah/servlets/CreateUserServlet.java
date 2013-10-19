package com.wannabeblocket.ah.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import com.wannabeblocket.core.ServletBase;

@WebServlet(urlPatterns = {"/createuser"})
public class CreateUserServlet extends ServletBase {
    @Override
    protected void doGet() throws ServletException, IOException {
        this.getRequest().getRequestDispatcher("/create_user.jsp").forward(this.getRequest(), this.getResponse());
    }

    @Override
    protected void doPost() throws ServletException, IOException {
        String username = this.getRequest().getParameter("username");
        String password = this.getRequest().getParameter("password");
        // TODO: Create the user, and add it to the database
        getResponse().sendRedirect("");
    }
}
