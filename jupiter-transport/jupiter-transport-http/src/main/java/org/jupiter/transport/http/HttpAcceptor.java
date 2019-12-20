package org.jupiter.transport.http;

import org.jupiter.transport.JAcceptor;
import org.jupiter.transport.JConfigGroup;
import org.jupiter.transport.processor.ProviderProcessor;

import java.net.InetSocketAddress;
import java.net.SocketAddress;

/**
 * Jupiter
 * org.jupiter.transport.http
 *
 * @author qi.xue
 */
public abstract class HttpAcceptor implements JAcceptor {

    protected final SocketAddress localAddress;

    private ProviderProcessor processor;

    public HttpAcceptor(SocketAddress localAddress) {
        this.localAddress = localAddress;
    }

    protected void init() {

    }

    @Override
    public Protocol protocol() {
        return null;
    }

    @Override
    public SocketAddress localAddress() {
        return this.localAddress;
    }

    @Override
    public int boundPort() {
        if (!(localAddress instanceof InetSocketAddress)) {
            throw new UnsupportedOperationException("Unsupported address type to get port");
        }
        return ((InetSocketAddress) localAddress).getPort();
    }

    @Override
    public ProviderProcessor processor() {
        return this.processor;
    }

    @Override
    public void withProcessor(ProviderProcessor processor) {
        this.processor = processor;
    }

    @Override
    public JConfigGroup configGroup() {
        // todo:
        return null;
    }

}
