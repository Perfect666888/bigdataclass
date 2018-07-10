package Day7_9.util;

import java.util.List;

public class ForeUtil {
    public static <T> void ForList (List<T> arr,Class<T> clazz ){
        for (T t: arr){
            System.out.println(t);
        }
    }

}
