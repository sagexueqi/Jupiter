package org.jupiter.transport.http.servlet;

import org.jupiter.transport.http.handler.HttpHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Service Dispatcher Servlet
 * org.jupiter.transport.http.servlet
 *
 * @author qi.xue
 */
public class DispatcherServlet extends HttpServlet {

    // <uri, handler>
    private static final Map<String, HttpHandler> handlers = new ConcurrentHashMap<>();

    public static void addHttpHandler(String uri, HttpHandler handler) {
        handlers.put(uri, handler);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        super.service(req, resp);
    }
}
