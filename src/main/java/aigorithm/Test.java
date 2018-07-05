package aigorithm;

import java.util.HashMap;
import java.util.Map;

public class Test {
     public static void main(String[] args){
         Test test = new Test();
         test.aiforithm("a");
     }

    private void aiforithm(String s) {
        int length = s.length();
        Map<Character,Integer> map = new HashMap();
        //返回结果坐标
        int start = 0;int end = 0;
        //过程坐标
        int start_temp = 0;int end_temp = 0;

        for(int i=0; i<length;i++){
            //当前定位的char
            Character a= s.charAt(i);
            //查询是否查询到重复的
            if(map.get(a) == null){
                //没有重复的
                //塞进缓存
                map.put(a,i);
                //如果大于已有数据，已有数据被替换
                if(end-start < i+1-start_temp){
                    start = start_temp;
                    end =i+1;
                }
            }else {
                //有重复的
                int start1 = map.get(a);

                if(end-start < i-1-start_temp){
                    end = i;
                }
                start_temp = start1+1;
                i= start1+1;
                //清空缓存
                map.clear();
            }
        }
        System.out.println(s.substring(start,end));
    }
}
