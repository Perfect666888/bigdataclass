package Day7_8;

import java.io.*;
import java.net.Socket;

public class Demo03Tcpclient {
    public static void main(String[] args) throws IOException {

        //创建客户端对象
        Socket client = new Socket("192.168.1.24", 8888);

        //包装输出流
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        bw.write("IDEA send");
        bw.flush();
        //释放资源，提示没有数据要发送了
        client.shutdownOutput();


        //接收回馈
        //包装输入流
        BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
        System.out.println(br.readLine());

        //释放资源
        client.shutdownInput();
        client.close();


    }
}
