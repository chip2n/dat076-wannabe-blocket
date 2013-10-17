/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wannabeblocket.ah;

import com.wannabeblocket.core.ServletBase;
import com.wannabeblocket.model.Shop;
import com.wannabeblocket.model.AuctionHouse;
import com.wannabeblocket.model.Listing;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import org.omg.PortableServer.REQUEST_PROCESSING_POLICY_ID;

/**
 *
 * @author Sebastian Lagerman
 */
@WebServlet(name = "SearchServlet", urlPatterns = {"/search"})
public class SearchServlet extends ServletBase {
    
    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    /*
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. 
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SearchServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SearchServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }
    }*/
    
    @Override
    protected void doGet() throws ServletException, IOException {
        this.getRequest().getRequestDispatcher("/search.jsp").forward(this.getRequest(), this.getResponse());
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost() throws ServletException, IOException {
        String searchQuery = this.getRequest().getParameter("searchfield");
        long searchCatagory = Long.parseLong(this.getRequest().getParameter("categories"));
        AuctionHouse auctionHouse = Shop.getInstance().getAuctionHouse();
        
        List<Listing> found = auctionHouse.searchDescription(searchQuery);
        this.getRequest().setAttribute("PRODUCT_LIST", found);
        
        //AuctionHouse.searchDescription(searchQuery);
        // TODO : Limit the database output to the searchQuery.
        
        //nt searchCatagory = Integer.parseInt(this.getRequest().getParameter("catagories"));
        //this.getRequest().getRequestDispatcher("/search.jsp").forward(this.getRequest(), this.getResponse());
        getResponse().sendRedirect("/ah/search");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Search Servlet.";
    }

}
