package org.eclipse.jetty.demo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/send-error/*")
public class SendErrorServlet extends HttpServlet
{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        String pathInfo = req.getPathInfo();
        int statusCode = HttpServletResponse.SC_BAD_REQUEST;
        if (pathInfo != null)
        {
            statusCode = Integer.parseInt(pathInfo.substring(1));
        }

        resp.sendError(statusCode);
    }
}
