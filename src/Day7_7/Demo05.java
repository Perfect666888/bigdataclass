package Day7_7;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.*;

public class Demo05 {
    public static void main(String[] args) throws IOException {
        /*
        *生成xml文件
        **/
       //创建一个Document对象，等于创建一个xml
        Document document = DocumentHelper.createDocument();

        //创建根节点
        Element gjd = document.addElement("books");
        //创建子节点
        Element zjd = gjd.addElement("book");

        //添加子节点属性
        zjd.addAttribute("name", "三国演义");
        zjd.addAttribute("author", "罗贯中");

        //添加子子节点
        Element zzjd = zjd.addElement("name");
        Element zzjd2 = zjd.addElement("author");

        //添加子子节点Text
        zzjd.addText("三国演义");
        zzjd2.addText("罗贯中");


        //把document保存到目录

        //创建文件输出流
        FileOutputStream fileout = new FileOutputStream("F:\\BigData\\IDEA\\bigdataclass\\src\\Day7_7\\newbook.xml");

        //包装文件输出流，需要指定问文本格式
        OutputStreamWriter osw = new OutputStreamWriter(fileout, "UTF-8");

        //创建打印格式
        OutputFormat of = OutputFormat.createPrettyPrint();

        //创建xml输出流                     输出流，打印输出格式
        XMLWriter xmlWriter = new XMLWriter(osw, of);

        //调用方法写入Document
        xmlWriter.write(document);

        //释放资源
        xmlWriter.close();





    }
}
