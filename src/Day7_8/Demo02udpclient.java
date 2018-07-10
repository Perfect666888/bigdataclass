package Day7_8;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;

public class Demo02udpclient {
    public static void main(String[] args) throws Exception{
        DatagramSocket client = new DatagramSocket();

        //打包数据
        byte[] data = "hello IDEA udp".getBytes();
        DatagramPacket dgp = new DatagramPacket(data,0,data.length,InetAddress.getByName("192.168.1.24"), 8888);

        //发送数据
        client.send(dgp);




        //释放资源
        client.close();


    }
}
