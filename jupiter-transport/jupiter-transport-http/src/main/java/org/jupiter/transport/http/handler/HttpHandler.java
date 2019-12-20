package org.jupiter.transport.http.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * HTTP Invoke Handler
 * org.jupiter.transport.http
 *
 * @author qi.xue
 */
public interface HttpHandler {

    /**
     * invoke
     *
     * @param request
     * @param response
     */
    void handler(HttpServletRequest request, HttpServletResponse response);

}
