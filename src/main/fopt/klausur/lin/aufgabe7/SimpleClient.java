package fopt.klausur.lin.aufgabe7;

import java.io.*;
import java.net.Socket;

public class SimpleClient {
    public static void main(String[] args) throws Exception {
        System.out.println("------client------");
        // 1. 建立连接: 使用ServerSocket 创建客户端, 因为要建立连接，所以需要指定服务的地址和端口
        Socket client = new Socket("localhost", 7777);
        // 2 客户端发送消息，通过输入输出流

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("please enter your username");
        String uname = console.readLine();
        System.out.println("please enter your password");
        String upwd = console.readLine();
//        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        writer.append("uname=" + uname + "&" + "upwd=" + upwd);
        writer.newLine();
        writer.flush();

        //3 获取消息
//        DataInputStream dis = new DataInputStream(client.getInputStream());
//        String datas = dis.readUTF(dis);
//        System.out.println("接受的数据 -->" + datas);

        BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
        String s = br.readLine();
        System.out.println("接受的数据 -->" + s);

        // 4. 释放资源, socket和连接
//        dis.close();
        br.close();
        writer.close();
        client.close();
    }
}
