package com.cad.carlink.weixin.test.SocketDemo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *服务器端在启动后，首先需要等待客户端的连接请求（第一次阻塞），如果没有客户端连接，服务端将一直阻塞等待，然后当客户端连接后，服务器会等待客户端发送数据（第二次阻塞），如果客户端没有发送数据，那么服务端将会一直阻塞等待客户端发送数据。
 服务端从启动到收到客户端数据的这个过程，将会有两次阻塞的过程。这就是BIO的非常重要的一个特点，BIO会产生两次阻塞，第一次在等待连接时阻塞，第二次在等待数据时阻塞。
 *
 */
public class SocketServer {

    private static final Integer SERVER_PORT=8080;
    public static void main(String[] args) {
        byte[] buffer=new byte[1024];
        try {
            ServerSocket serverSocket=new ServerSocket(SERVER_PORT);
            System.out.println("服务器已启动并监听"+SERVER_PORT);
            while (true){
                //阻塞1：等待连接时阻塞
                System.out.println("服务器正在等待连接....");
                Socket socket=serverSocket.accept();
                System.out.println("服务器已接收到连接请求");
                //阻塞2：等待数据时阻塞
                socket.getInputStream().read(buffer);
                System.out.println("服务器已经接收到数据");
                String content=new String(buffer);
                System.out.println("接收到数据--》"+content);
            }
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
