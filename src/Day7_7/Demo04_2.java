package Day7_7;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.Iterator;

public class Demo04_2 {
    public static void main(String[] args) throws DocumentException {

        //获得xml文件所在位置
        File file = new File("F:\\BigData\\IDEA\\bigdataclass\\src\\Day7_7\\Book.xml");
        SAXReader saxReader = new SAXReader();

        //获得xml的Document对象
        Document dc = saxReader.read(file);

        //获得xml的根节点
        Element gjd = dc.getRootElement();

        //通过根节点去获得子节点的集合
        Iterator zjdit = gjd.elementIterator();
        //遍历子节点集合
        while (zjdit.hasNext()){
            //因为知道获取的是节点对象，所以用element接收
            Element zjd =(Element) zjdit.next();
            //子节点可能有多个属性，获得子节点属性集合
            Iterator zjdsxit = zjd.attributeIterator();
            //遍历属性集合
            while(zjdsxit.hasNext()){
                //用属性对象去接收属性
                Attribute sx =(Attribute) zjdsxit.next();
                //输出属性包含的内容
                System.out.println(sx.getName()+"===="+sx.getValue());

            }

            //子节点可能还有多个子节点，获得子子节点集合
            Iterator zzjdit = zjd.elementIterator();
            //遍历子子节点集合
            while (zzjdit.hasNext()){
                //用节点对象去接收
                Element zzjd =(Element) zzjdit.next();
                //获得子子节点的Text
                System.out.println(zzjd.getText());
            }

        }

    }
}
