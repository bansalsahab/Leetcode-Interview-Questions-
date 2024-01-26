//a^2+b^2=c
// Two pointer Approach 0<=a,b<sqrtc
class Solution {
    public boolean judgeSquareSum(int c) {
        long Left =0;
        long Right =(long) Math.sqrt(c);
        while(Left<=Right){
            long sum = Left*Left+Right*Right;
            if(sum==c)
            return true;
            else if(sum<c)
            Left++;
            else
            Right--;
        }
        return false;
    }
}
