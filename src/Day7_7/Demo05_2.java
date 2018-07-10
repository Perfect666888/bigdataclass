package Day7_7;


import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Demo05_2 {
    public static void main(String[] args) throws IOException {

        //创建Document对象，及xml文件
        Document doc = DocumentHelper.createDocument();
        //创建根节点
        Element gjd = doc.addElement("books");

        //创建子节点
        Element zjd =gjd.addElement("book");

        //添加子节点属性
        zjd.addAttribute("name", "红楼梦");
        zjd.addAttribute("author", "曹雪芹");

        //把Documen添加到目录中

        //创建文件输出流，制定文件编码
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("F:\\BigData\\IDEA\\bigdataclass\\src\\Day7_7\\newbook2.xml"),"UTF-8");

        //生成格式
       OutputFormat of=  OutputFormat.createPrettyPrint();

        //创建xml输出对象
        XMLWriter xmlWriter = new XMLWriter(osw,of);
        //把Document写入
        xmlWriter.write(doc);
        //释放资源
        xmlWriter.close();



    }
}
