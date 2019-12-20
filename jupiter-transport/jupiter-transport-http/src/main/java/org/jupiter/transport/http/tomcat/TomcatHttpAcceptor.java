package org.jupiter.transport.http.tomcat;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.jupiter.transport.http.HttpAcceptor;
import org.jupiter.transport.http.servlet.DispatcherServlet;

import java.io.File;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

/**
 * Jupiter
 * org.jupiter.transport.http.tomcat
 *
 * @author qi.xue
 */
public class TomcatHttpAcceptor extends HttpAcceptor {

    private final Tomcat tomcat = new Tomcat();

    public TomcatHttpAcceptor(int port) {
        super(new InetSocketAddress(port));
        init();
    }

    public TomcatHttpAcceptor(SocketAddress localAddress) {
        super(localAddress);
        init();
    }

    @Override
    protected void init() {
        String baseDir = new File(System.getProperty("java.io.tmpdir")).getAbsolutePath();
        tomcat.setBaseDir(baseDir);
        tomcat.setPort(boundPort());

        tomcat.getConnector().setProtocol("org.apache.coyote.http11.Http11NioProtocol");

        Context context = tomcat.addContext("/", baseDir);
        Tomcat.addServlet(context, "dispatcher", new DispatcherServlet());
        context.addServletMapping("/*", "dispatcher");
    }

    @Override
    public void start() throws InterruptedException {
        start(true);
    }

    @Override
    public void start(boolean sync) throws InterruptedException {
        try {
            tomcat.start();
            if (sync) {
                tomcat.getServer().await();
            }
        } catch (LifecycleException e) {
            // todo:
            e.printStackTrace();
        }
    }

    @Override
    public void shutdownGracefully() {

    }
}
