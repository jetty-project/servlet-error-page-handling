package org.eclipse.jetty.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/error")
public class ErrorServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        resp.setContentType("text/plain");
        PrintWriter out = resp.getWriter();

        out.printf("Method = %s%n", req.getMethod());
        out.printf("URI = %s%n", req.getRequestURI());
        out.printf("URL = %s%n", req.getRequestURL());
        out.printf("DispatchType = %s%n", req.getDispatcherType());

        Collections.list(req.getAttributeNames()).stream()
                .sorted(String.CASE_INSENSITIVE_ORDER)
                .forEach((name) ->
                {
                    Object value = req.getAttribute(name);
                    String valueType = value != null ? value.getClass().getName() : "<null>";
                    out.printf("request.attribute[%s] = (%s) %s%n", name, valueType, value);
                });
    }
}
