public class HeapArgs {
//· -XX：+PrintFlagsInitial —— 查看所有参数的默认初始值
//· -XX：+PrintFlagsFinal —— 查看所有参数的最终值
//· -Xms：—— 初始堆空间内存（默认为物理内存的1/64）
//· -Xmx：—— 最大堆空间内存（默认为物理内存的1/4）
//· -Xmn：—— 设置新生代的大小（初始值及最大值）
//· -XX：NewRatio —— 配置新生代和老年代的堆结构占比
//· -XX：SurvivorRatio —— 设置新生代中Eden和S0/S1空间的比例
//· -XX：MaxTenuringThreshold —— 设置新生代垃圾的最大年龄
//· -XX：PrintGCDetails —— 输出详细的GC处理日志
//· -XX：HandlePromotionFailure —— 是否设置空间分配担保
    public static void main(String[] args) {
    }
}
