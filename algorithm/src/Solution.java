import java.util.*;

class Solution {
    public static int myAtoi(String s) {
        s = s.replaceAll(" ", "");

        int begin = 0, end = 0, n = s.length();
        if(n == 0 || (s.charAt(0) != '+' && s.charAt(0) != '-' && (s.charAt(0) - '0' < 0) ||
                (s.charAt(0) - '0' >= 10))) {
            return 0;
        }
        char[] array = s.toCharArray();
        int i = 0, flag = 0;//flag代表是不是有符号
        if(array[i] == '+') {
            flag = 1;
        }
        if(array[i] == '-') {
            flag = -1;
        }
        i++;
        while(i < n && (array[i]-'0' >= 0  && array[i] - '0' <= 9)) {
            i++;
        }
        end = i;
        if(end - begin == 1 && (array[begin] == '+' || array[begin] == '-')) {
            return 0;
        }

        //StringBuilder temp = new StringBuilder();
        while(begin < end && (array[begin] - '0' <=0) || (array[begin] - '0' > 9)) {
            begin++;
        }
        if(begin == end) {
            return 0;
        }
        String ans = s.substring(begin, end);
        if(flag == -1 && s.equals("2147483648")) {
            return Integer.MIN_VALUE;
        }
        //String maxInt = "2147483647";
        //String minInt = "2147483648";

        if(compare(ans) > 0) {
            if(flag >= 0) {
                return Integer.MAX_VALUE;
            } else {
                return Integer.MIN_VALUE;
            }
        }
        if(flag == 0) {
            flag++;
        }
        int ansNum = flag * Integer.parseInt(ans);

        return ansNum;



    }

    public static int compare(String s1) {
        String s2 = "2147483647";

        if(s1.length() != s2.length()) {
            return s1.length() - s2.length();
        }
        int l = s1.length();
        for(int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)) {
                return s1.charAt(i) - s2.charAt(i);
            }
        }//a
        return 0;
    }

    public static void main(String[] args) {
        List<String> lst = new ArrayList<String>();
        lst.add("aaa");
        lst.add("bbb");
        lst.add("ccc");
        lst.add("ddd");
        lst.add("eee");
        lst.add("fff");
        Iterator<String> iterator = lst.iterator();
        //iterator.hasNext()如果存在元素的话返回true
        int n = 4;
        while(n-- > 0) {
            //iterator.next()返回迭代的下一个元素
            System.out.println(iterator.next());
        }
    }

}