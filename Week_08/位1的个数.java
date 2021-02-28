/**
* �Լ��ⷨ
*/
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int cnt = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                cnt++;
            }
            n >>>= 1;
        }

        return cnt;
    }
}

/**
* λ���㼼��
*/
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int cnt = 0;
        while (n != 0) {
            cnt++;
            n &= n - 1;
        }

        return cnt;
    }
}