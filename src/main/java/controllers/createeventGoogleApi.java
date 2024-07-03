package controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/createeventGoogleApi")
public class createeventGoogleApi extends HttpServlet {
  public void doGet(HttpServletRequest request, HttpServletResponse response)
  {
    RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/createEventInGoogle.jsp");

    try {
      rd.forward(request,response);
    } catch (ServletException e) {
      throw new RuntimeException(e);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
