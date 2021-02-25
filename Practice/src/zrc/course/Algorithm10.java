package zrc.course;

import java.util.HashMap;

public class Algorithm10 {
}

/*
哈希函数
    输入：无穷大 输出：有穷个值（MD5【0~2^64-1】sHal【0~2^128-1】）
    一样的输入必须获得一样的输出(哈希函数没有随机因子)
    不同的输入可能会有相同的输出(哈希碰撞)
    哈希函数在其映射域内是均匀的
 */

/*
给定1G内存与42亿个数，求出现次数最多的
无法直接通过HashMap来解决，因为一条记录有Key和Value，在极端情况下如果42亿个数并不相同，一定会内存溢出
可以通过哈希函数来对这42亿个数进行映射，之后对100取模
这样42亿个数就会被分为100份
根据哈希函数的性质，相同的数字或者出现哈希碰撞的数字必然在一组
之后通过对这100组数字使用HashMap来记录，来解决这个问题
 */

/*
哈希表在增加元素的过程中会有扩容过程，这个过程可以看作是O(logN)
每次扩容会将哈希表中所有的元素重新计算其索引，这个过程可以认为是O(N)
所以整个扩容代价是O(N*logN)
在每次查询的过程中其扩容代价是O(logN)
但是我们可以通过链的长度来继续控制这个扩容代价
假设我们将扩容阈值设置为链的长度为10的时候进行扩容，这个时候在查询的过程中还可以认为是O(1)
因为我们通过这种方式在单次扩容的的代价中乘了一个很大的数作为分母
另外如Java这个由虚拟机托管的语言，我们可以离线对哈希表进行扩容，这样不会影响用户的使用时间
所以理论上哈希表的使用是O(logN)，但是在实际的使用过程中哈希表时间复杂度可以被优化为O(1)
这个常数级别可能很大
 */

// 设计RandomPool结构
/*
insert(key):将某个key加入到该结构，做到不重复加入
delete(key):将原本在结构中的某个key移除
getRandom():等概率随机返回结构中的任何一个key
 */
// 要求:所有方法的时间复杂度都是O(1)
class RandomPool<K> {
    private HashMap<K, Integer> keyIndexMap;
    private HashMap<Integer, K> indexKeyMap;
    private int size;

    public RandomPool(int size) {
        this.keyIndexMap = new HashMap<>();
        this.indexKeyMap = new HashMap<>();
        this.size = size;
    }

    public void insert(K key) {
        if (!this.keyIndexMap.containsKey(key)) {
            this.keyIndexMap.put(key, this.size);
            this.indexKeyMap.put(this.size++, key);
        }
    }

    public void delete(K key) {
        if (this.keyIndexMap.containsKey(key)) {
            K value = this.indexKeyMap.get(size - 1);
            Integer index = this.keyIndexMap.get(key);
            keyIndexMap.put(value, index);
            indexKeyMap.put(index, value);
            keyIndexMap.remove(key);
            indexKeyMap.remove(size - 1);
            size--;
        }
    }

    public K getRandom () {
        if (this.size == 0) {
            return null;
        }
        int randomIndex = (int)(Math.random() * this.size);
        return indexKeyMap.get(randomIndex);
    }
}

/*
布隆过滤器
    例如：我们有100亿条url记录，这100亿条记录是访问的黑名单，我们不能允许用户访问
    当用户访问一个url时，我们需要与黑名单中的记录进行比对，如果存在于黑名单就禁止访问
    假设一条url占用64字节，那么如果直接使用哈希表，那么需要640G的内存
    这个时候我们就可以使用布隆过滤器 (注：不需要支持删除操作)
    -------------------------分割线-------------------------------
    布隆过滤器所适合的业务是，我们允许在查询中存在一些失误：
    (1)我们将黑名单中的url当作正常url允许用户访问
    (2)我们将正常url仿作黑名单中的url不允许用户访问
    布隆过滤器不会出现第一种失误，而允许第二种失误
    我们需要申请一个长度为m的位图，之后对第一个url使用f1得到第一个哈希值并对m取模
    将位图上f1(url)%m位标为1，然后将f2(url)%m位标为1， 然后fk(url)%m位标为1
    （f2是第二个哈希函数）...
    之后标记第二个url以此类推
    假设我们我们需要一个320位的位图
    int[] arr = new int[10];
    需要得到178位的状态
    int numIndex = 178 / 32;
    int bitIndex = 178 % 32;
    int s = (arr[numIndex] >> bitIndex) & 1;
    将178位置为1
    arr[numIndex] = arr[numIndex] | (1 << (bitIndex));
    将178位置为0
    arr[numIndex] = arr[numIndex] & (~(1 << (bitIndex)));
    这个过程结束后，布隆过滤器版本的黑名单就已经完成
    查询过程：
        1.某一个url通过k个哈希函数对m取模得到k个位置
        2.将布隆过滤器这k个位置上的信息取出来
            (1)全是1认为在这个黑名单中
            (2)不在这个黑名单中

    细节问题：
        (1)k个哈希函数，k的值是多少
        (2)需要长度为m的位图，m的值是多少

    参数设定：n=样本量 p=失误率 与单样本的内存占用大小无关
        m = -((n * lnp) / 2ln2)
        k = ln2 * (m / n) (向上取整)
        p(真实) = (1 - e ^ (-(n * k(真实)) / m(真实))) ^ k(真实)
 */

/*
一致性哈希：
    在部署业务层的时候，每一个业务都是等效的所以可以直接部署
    但是在数据层，我们需要决定的数据的归属问题
    例如我们在业务层有15台机器，数据层有3台机器
    当处理完一个数据时，我们对这个数据求哈希值之后对3取模就可以的得到这个数据的归属
    使用这种方式来决定数据的归属本身没有问题，但是当数据量进一步增大，
    我们需要扩充数据层的机器数量时，需要对这些数据重新计算哈希，这种代价是相当大的
    所以我们引入一致性哈希
    -----------------------------分割线-----------------------------
    假设我们使用MD5哈希算法，我们在数据层有3台机器
    我们将MD5哈希算法计算出的哈希值想象成一个环
    我们根据这三台机器上的某个特征计算出这三台机器在这个哈希环上的位置
    当有数据时，我们将这条数据的哈希值计算出来，然后选择以顺时针方式向前寻找到的第一个机器作为归属
    在增加数据层机器时：
        假如我们将4号机器加入了3号和2号机器的中间
        这个时候，我们只需要将m2和m4之间的数据迁移到m4即可

    存在的问题：
        (1)哈希函数的性质是，当数据量到达一定程度时，哈希值是均匀的
            但是机器数量较少，如何将这个环均分
        (2)即使在机器较少的时候，均分了这个环
            但是，当增加机器之后，这个环立刻又变得不均匀了，也就是说负载不均衡了

    解决方法：
        虚拟节点技术.
        m1（a1,a2,a3...a1000）
        m2（b1,b2,b2...b1000）
        m3（c1,c2,c3...c1000）
        我们给每台机器分配1000个节点，所以在环上必然较为均匀，在添加机器的过程中也就解决了这个问题
 */