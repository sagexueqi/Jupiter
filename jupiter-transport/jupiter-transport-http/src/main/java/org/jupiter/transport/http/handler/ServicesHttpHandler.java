package org.jupiter.transport.http.handler;

import org.jupiter.transport.http.channel.HttpChannel;
import org.jupiter.transport.processor.ProviderProcessor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * /service endpoint handler
 * org.jupiter.transport.http.handler
 *
 * @author qi.xue
 */
public class ServicesHttpHandler implements HttpHandler {

    private ProviderProcessor processor;

    @Override
    public void handler(HttpServletRequest request, HttpServletResponse response) {
        HttpChannel channel = new HttpChannel(request, response);

    }

    public void setProcessor(ProviderProcessor processor) {
        this.processor = processor;
    }
}
