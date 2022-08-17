package com.example.productdiscountcalculator;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "DiscountServlet", value = "/discount")
public class DiscountServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String productName = req.getParameter("Product Description");
        float price = Float.parseFloat(req.getParameter("List Price"));
        float discount = Float.parseFloat(req.getParameter("Discount Percent"));
        float discountAmount = price * discount * 0.01f;
        float priceEnd = price - discountAmount;

        PrintWriter writer = resp.getWriter();
        writer.println("<html>");
        writer.println("<h3>  San pham:" + productName + "</h3>");
        writer.println("<h3> Co chiet khau la: " + discountAmount + "</h3>" );
        writer.println("<h3> Co gia sau khi chiet khau la: " + priceEnd + "</h3>");
        writer.println("</html>");
    }

    public void destroy() {
    }
}