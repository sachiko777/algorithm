package com.tools.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * socket服务端，创建线程池实现线程的复用
 */
public class SocketServerTest2 {

    public static void main(String[] args)throws IOException{
//        // 初始化服务端socket并且绑定9999端口 
//        ServerSocket serverSocket = new ServerSocket(9999);
//        //创建一个线程池
//        ExecutorService executorService= Executors.newFixedThreadPool(100);
//        while (true){
//            //等待客户端的链接
//            Socket socket=serverSocket.accept();
//            Runnable runnable=()->{
//                BufferedReader bufferedReader=null;
//                try{
//                    bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8"));
//                    //读取一行数据
//                    String str;
//                    //通过while循环不断读取信息，
//                    while ((str=bufferedReader.readLine())!=null){
//                        //输出打印
//                        System.out.println("客户端说："+str);
//                    }
//                }catch (IOException e){
//                    e.printStackTrace();
//                }
//            };
//            executorService.submit(runnable);
//        }

        ServerSocket serverSocket=new ServerSocket(9999);
        Socket client=serverSocket.accept();
        InputStream inputStream=client.getInputStream();
        DataInputStream dataInputStream=new DataInputStream(inputStream);
        while (true){//包类型+包长度+消息内容  数据类型为byte类型，包长度为int类型，消息内容为byte类型。
            byte b=dataInputStream.readByte();
            int len=dataInputStream.readInt();
            byte[] data=new byte[len-5];
            dataInputStream.readFully(data);
            String str=new String(data);
            System.out.println("获取的数据类型为："+b);
            System.out.println("获取的数据长度为："+len);
            System.out.println("获取的数据内容为："+str);

        }



    }

}
