package org.jupiter.transport.http.channel;

import org.jupiter.serialization.io.OutputBuf;
import org.jupiter.transport.channel.JChannel;
import org.jupiter.transport.channel.JFutureListener;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

/**
 * 对Http处理Channel的包装，重写输出方法
 * <p>
 * Jupiter
 * org.jupiter.transport.http.channel
 *
 * @author qi.xue
 */
public class HttpChannel implements JChannel {

    private HttpServletRequest  request;
    private HttpServletResponse response;

    public HttpChannel(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    @Override
    public String id() {
        //todo:
        return request.getSession().getId();
    }

    @Override
    public boolean isActive() {
        return false;
    }

    @Override
    public boolean inIoThread() {
        return false;
    }

    @Override
    public SocketAddress localAddress() {
        return new InetSocketAddress(request.getLocalPort());
    }

    @Override
    public SocketAddress remoteAddress() {
        return null;
    }

    @Override
    public boolean isWritable() {
        return false;
    }

    @Override
    public boolean isMarkedReconnect() {
        return false;
    }

    @Override
    public boolean isAutoRead() {
        return false;
    }

    @Override
    public void setAutoRead(boolean autoRead) {

    }

    @Override
    public JChannel close() {
        return null;
    }

    @Override
    public JChannel close(JFutureListener<JChannel> listener) {
        return null;
    }

    @Override
    public JChannel write(Object msg) {
        return null;
    }

    @Override
    public JChannel write(Object msg, JFutureListener<JChannel> listener) {
        return null;
    }

    @Override
    public void addTask(Runnable task) {

    }

    @Override
    public OutputBuf allocOutputBuf() {
        return null;
    }
}
