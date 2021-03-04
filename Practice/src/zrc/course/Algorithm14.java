package zrc.course;

public class Algorithm14 {
    /*给定两个有符号的32位整数a和b，返回a和b中较大的
     要求：不做任何比较判断
     */
    public int getMax(int a, int b) {
        int c = a - b;
        int sA = sign(a);
        int sB = sign(b);
        int sC = sign(c);
        int difSab = sA ^ sB; //a和b的符号是否相同，相同为0，不同为1
        int sameSab = flip(difSab); // a和b的符号一样为1，不一样为0
        int returnA = difSab * sA + sameSab * sC;
        int returnB = flip(returnA);
        return a * returnA + b * returnB;
    }

    // 1->0 0->1
    public int flip(int n) {
        return n ^ 1;
    }

    // n是非负数，请返回1
    // n是负数，请返回0
    public int sign(int n) {
        return flip((n >> 31) & 1);
    }

    /* 判断一个32位整数是不是2的幂、4的幂
    2的幂：所有位上，只有一位是1
    4的幂：所有位上，只有一位是1，且1在奇数位上
     */
    public boolean is2Pow(int n) {
        return (n & (n - 1)) == 0;
    }

    public boolean is4Pow(int n) {
        return (n * (n - 1)) == 0 && (n & 0x55555555) != 0;
    }

    /*
    给定两个有符号32位整数，不能使用算术运算符，分别实现a和b的加、减、乘、除
    加法：
        将a和b做异或运算，得到无进位相加结果
        将a和b做与运算，并且左移一位，得到进位信息
        将这两个信息继续这样操作，直到进位信息为0，即得到最终结果
     */
    public int add(int a, int b) {
        int sum = a;
        while (b != 0) {
            sum = a ^ b;
            b = (a & b) << 1;
            a = sum;
        }
        return sum;
    }

    public int negNum(int n) {
        return add(~n, 1);
    }

    public int minus(int a, int b) {
        return add(a, negNum(b));
    }

    public int multi(int a, int b) {
        int res = 0;
        while (b != 0) {
            if ((b & 1) != 0) {
                res = add(res, a);
            }
            a <<= 1;
            b >>>= 1;
        }
        return res;
    }

    public int div(int a, int b) {
        int res = 0;
        for (int i = 31; i > -1; i = minus(i, 1)) {
            if ((a >> i) >= b) {
                res |= (1 << i);
                a = minus(a, b << i);
            }
        }
        return res;
    }
}
/*
先假设我们有一个文件，文件的内容是有符号整数，大约有10G大小，现需要将文件中的数排序，要求：只能使用1G内存
要明确的是，对于这个问题，应该还是使用堆来解决
大根堆来解决
    这个堆需要记录的数据是文件的数和这个数的词频统计，另外需要一个变量flag来记录一个数据（后面解释）
    一个整数所占用的内存是4个byte，而一个词频统计所占用的内存也是4个byte所以一条记录所占用的内存是8个byte
    另外除去堆中所需要的索引空间等，我们将一条数据的内存视为16byte
    那么1KB的内存就可以记录64条记录，1M的内存可以记录65536条数据，1G的内存可以记录67108864条数据
    在第一次遍历这些数据的时候，我们需要找到前67108864大的数据（相同的数字视为一条数据）
    在加入的过程中我们需要遵从下面两个原则：
        1.如果堆中存在这个数字，将该数字的词频统计加一
        2.如果堆中不存在这个数字
            (1)查看堆中元素的数量是否达到67108864
                如果达到，peek堆顶元素与此元素的大小，如果堆顶元素大于次元素，弹出堆顶元素，将此元素加入进去即可，并且重新排列堆
            (2)加入此元素，将词频设置为1
    第一遍统计结束后，堆中的数字，按照词频输入出来，并且，将之前的变量设置为此时最大的元素，第二次遍历这个文件
    当遍历的数字小于flag直接跳过，直到flag更新都整型的最大值，就排序完毕了
 */