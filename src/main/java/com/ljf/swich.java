package com.ljf;

/**
 * @author liujf05
 * @date 2019/7/19
 */
public class swich {
    public static void mahin(String[] args){
        String a = "ABCDEa123abc";
        switch (a){
            case "ABCDFB123abc":
                System.out.println("方案二");
                break;
            case "ABCDEa123abc":
                System.out.println("方案一");
                break;

        }
    }


        public static void main(String[] args)
        {
            String a = "ABCDEa123abc";
            String str1 = a;int i = -1;
            switch (str1.hashCode())
            {
                case 165374702:
                    if (str1.equals("ABCDFB123abc")) {
                        i = 1;
                    } else if (str1.equals("ABCDEa123abc")) {
                        i = 0;
                    }
                    break;
            }
            switch (i)
            {
                case 0:
                    System.out.println("方案一");
                case 1:
                    System.out.println("方案二");
            }
        }


}
