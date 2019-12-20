package org.jupiter.transport.http.tomcat;

/**
 * Jupiter
 * org.jupiter.transport.http.tomcat
 *
 * @author qi.xue
 */
public class TomcatHttpAcceptorTest {

    public static void main(String[] args) throws InterruptedException {
        TomcatHttpAcceptor acceptor = new TomcatHttpAcceptor(8999);
        acceptor.start();
    }

}
