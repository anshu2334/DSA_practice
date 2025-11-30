package collection;

public class LongestPalindrome {
    public static String largePalindrome(String str){
        int n = str.length();
        int start = 0;
        int end =0;

        for(int i=0; i<n; i++){

            int len1 = expandFromCenter(str,i,i); //odd number palindrome
            int len2 = expandFromCenter(str,i,i+1); //even center palindrome
            int len = Math.max(len1,len2);
            //System.out.printf("Start1:%s len:%d subString length:%d",str,len,end+start+1);
           // System.out.println();
            //System.out.printf("Start1:%s index:%d  len:%d start:%d end:%d",str,i,len, start,end);
            //System.out.println();
            if(len > end-start){
                start = i -(len -1)/2;
                end = i+len/2;

            }
            if(len == n){
                break;
            }


        }
        return str.substring(start,end+1);
    }

    public static int expandFromCenter(String str, int left, int right){
        while(left >=0 && right < str.length() && str.charAt(left)==str.charAt(right)){
            left--;
            right++;

        }
        return right-left-1;
    }

    public static void main(String[] args) {
        System.out.println(largePalindrome("babad")); // "bab" or "aba"
        System.out.println(largePalindrome("cbbd"));  // "bb"
        System.out.println(largePalindrome("bbabb"));
    }
}
