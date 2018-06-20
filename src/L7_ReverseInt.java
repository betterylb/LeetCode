/**
 *
 给定一个 32 位有符号整数，将整数中的数字进行反转。

 示例 1:

 输入: 123
 输出: 321
 示例 2:

 输入: -123
 输出: -321
 示例 3:

 输入: 120
 输出: 21
 注意:
 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2^31,  2^31 − 1]。
 根据这个假设，如果反转后的整数溢出，则返回 0。
 */

public class L7_ReverseInt {
    public static int solution(int x){
        long rev = 0;
        while (x !=0){
            long pop = x%10;
            x /= 10;
            rev = rev*10 + pop;
        }

        return rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE ? 0: (int) rev;
    }

    /**
     * 为了便于解释，我们假设 \text{rev}rev 是正数。

     如果 temp = \text{rev} \cdot 10 + \text{pop}temp=rev⋅10+pop 导致溢出，那么一定有 \text{rev} \geq \frac{INTMAX}{10}rev≥
     ​10
     ​
     ​INTMAX
     ​​ 。
     如果 \text{rev} > \frac{INTMAX}{10}rev>
     ​10
     ​
     ​INTMAX
     ​​ ，那么 temp = \text{rev} \cdot 10 + \text{pop}temp=rev⋅10+pop 一定会溢出。
     如果 \text{rev} == \frac{INTMAX}{10}rev==
     ​10
     ​
     ​INTMAX
     ​​ ，那么只要 \text{pop} > 7pop>7，temp = \text{rev} \cdot 10 + \text{pop}temp=rev⋅10+pop 就会溢出。
     * @param x
     * @return
     */
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

    /**
     * 别人的快速解法，溢出的话肯定跟原来数值不同，判断比上面快
     * @param x
     * @return
     */
    public int reverse1(int x) {
        int result = 0;
        while(x!=0){
            int temp = result*10+x%10;
            if(temp/10 != result)
                return 0;
            result = temp;
            x /= 10;
        }
        return result;
    }

    /**
     * 目前最快的，虽然用了类型转换，但是他完全以正值运算，是不是因为这个原因所以快了
     * @param x
     * @return
     */
    public int reverse2(int x) {
        boolean negative = x < 0;
        if (negative) x = -x;
        long r = 0;
        while (x>0) {
            r = r * 10 + x % 10;
            x /= 10;
        }
        if (negative) r = -r;
        if (r > Integer.MAX_VALUE || r < Integer.MIN_VALUE) return 0;
        return (int)r;
    }

    /**
     * 前面两种方法结合起来，但是没有变快，是因为leetcode不同时间预算速度不同？
     *
     * @param x
     * @return
     */
    public int reverse3(int x) {
        boolean negative = x < 0;
        if (negative) x = -x;
        int r = 0;
        while (x>0) {
            int temp = r*10+x%10;
            if(temp/10!=r)
                return 0;
            r = temp;
            x /= 10;
        }
        if (negative) r = -r;
        return r;
    }

}
