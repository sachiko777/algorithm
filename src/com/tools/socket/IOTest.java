package com.tools.socket;

import java.io.*;

public class IOTest {

    public static void main(String args[]){
        try {
            File f=new File("a.txt");
            FileOutputStream fop=new FileOutputStream(f);
            OutputStreamWriter writer=new OutputStreamWriter(fop,"UTF-8");
            writer.append("中文输入");
            writer.append("\r\n");
            writer.append("English");
            writer.close();
            fop.close();

            FileInputStream fip=new FileInputStream(f);
            InputStreamReader reader=new InputStreamReader(fip,"UTF-8");
            StringBuffer sb=new StringBuffer();
            //检测流是否准备好被读取
            while (reader.ready()){
                sb.append((char) reader.read());//读取单个字符，返回一个int型变量代表读取到的字符
            }
            System.out.println(sb.toString());
            reader.close();
            fip.close();

        }catch (IOException e){
            e.printStackTrace();
            System.out.print("Exception");
        }
    }

}
