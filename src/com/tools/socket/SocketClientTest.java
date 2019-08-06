package com.tools.socket;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class SocketClientTest {

    public static void main(String [] args){

//        try {
//            //初始化一个socket
//            Socket socket = new Socket("127.0.0.1", 9999);
//            //通过socket获取字符流
//            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
//            //通过标准输入流获取字符流
//            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in,"UTF-8"));
//            while (true){
//                String str=bufferedReader.readLine();
//                bufferedWriter.write(str);
//                bufferedWriter.write("\n");
//                bufferedWriter.flush();
//            }
//
//
////            String str = "你好，这是我的第一个socket";
////            bufferedWriter.write(str);
////            //关闭socket的输出流--不关闭会阻塞
////            socket.shutdownOutput();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        try{
            Socket socket = new Socket("127.0.0.1", 9999);
            OutputStream outputStream=socket.getOutputStream();
            DataOutputStream dataOutputStream=new DataOutputStream(outputStream);
            Scanner scanner=new Scanner(System.in);
            if(scanner.hasNext()){
                String str=scanner.next();
                int type=1;
                byte[] data=str.getBytes();
                int len=data.length+5;
                dataOutputStream.writeByte(type);
                dataOutputStream.writeInt(len);
                dataOutputStream.write(data);
                dataOutputStream.flush();
            }
        }catch (IOException e){
            e.printStackTrace();
        }





    }




}
