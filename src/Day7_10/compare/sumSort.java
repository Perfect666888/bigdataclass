package Day7_10.compare;

import java.util.Comparator;

public class sumSort implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        String[] sp1 = o1.split("\t");
        String[] sp2 = o2.split("\t");
        //最后一位为成绩,取出
        int sum1 = Integer.valueOf(sp1[sp1.length - 1]);
        int sum2 = Integer.valueOf(sp2[sp2.length - 1]);

        //降序排列
        return sum2 - sum1;
    }
}

