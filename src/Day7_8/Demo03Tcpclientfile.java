package Day7_8;

import java.io.*;
import java.net.Socket;


//发送文件的TCP
public class Demo03Tcpclientfile {
    public static void main(String[] args) throws IOException {

        //创建客户端对象
        Socket client = new Socket("192.168.1.24", 8888);

        //包装输出流
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        //从文件中读取内容
        BufferedReader brfile = new BufferedReader(new FileReader("F:\\BigData\\IDEA\\bigdataclass\\src\\Day7_8\\Demo03Tcpfile.txt"));
        String sread = null;
        while ((sread = brfile.readLine()) != null) {
            bw.write(sread);
            bw.newLine();
            bw.flush();
        }

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
