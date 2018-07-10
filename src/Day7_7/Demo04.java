package Day7_7;


import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.Iterator;

public class Demo04 {
    public static void main(String[] args) throws DocumentException {

        /*
        *
        *
        * xml编译
        *
        **/


        File file = new File("F:\\BigData\\IDEA\\bigdataclass\\src\\Day7_7\\Book.xml");
        //拿到
        SAXReader saxReader = new SAXReader();
        //拿到xml的Document对象 ------整个文档
        Document read = saxReader.read(file);
        //拿到Document的RootElement -------根节点
        Element rootElement = read.getRootElement();

        int count =1;

        //拿到子节点的迭代器
        Iterator iterator = rootElement.elementIterator();
        //遍历子节点的迭代器
        while (iterator.hasNext()){
            Element  zjd = (Element)iterator.next();
            System.out.println("================第"+count+"个子节点==================");
            //获得子节点的属性集合迭代器
            Iterator sxit = zjd.attributeIterator();
            //便利属性迭代器
            while (sxit.hasNext()){
                //用属性去接收获得到的
                Attribute sx = (Attribute) sxit.next();
                //属性有点类似于map
                System.out.println(sx.getName()+"===="+sx.getValue());
            }

            System.out.println("=================第"+count+"子子节点===================");
            //获得子节点的子节点，可能不止一个，所以用迭代器接收
            Iterator jd2it = zjd.elementIterator();
            //遍历子节点集合
            while (jd2it.hasNext()){
                //接受子子节点
                Element zzjd =(Element) jd2it.next();
                //获得子子节点的txt
                System.out.println(zzjd.getName()+"======="+zzjd.getText());
            }
            System.out.println("=================================================");
            count++;
        }

    }
}
