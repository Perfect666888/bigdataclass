package Day7_7;


import java.io.*;

import java.net.Socket;

public class Demo03 {
    public static void main(String[] args) throws IOException {
        FileReader fr =new FileReader("F:\\BigData\\IDEA\\bigdataclass\\src\\Day7_7\\User.json");

        char[] cbuf = new char[1024];
        int len =fr.read(cbuf);
        String fstr=new String(cbuf,0,len);

        System.out.println(fstr);

        //通过tcp去发送读取到的数据
        Socket client =new Socket("192.168.1.24",8888);
        OutputStream outputStream = client.getOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        dataOutputStream.writeUTF(fstr);

        //接收回馈
        DataInputStream dataInputStream = new DataInputStream(client.getInputStream());
        System.out.println(dataInputStream.readUTF());


        //释放资源
        client.close();

    }
}
