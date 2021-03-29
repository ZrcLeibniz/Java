package zrc.course.algorithm18;

/*
小虎去附近的商店买苹果，有6个每袋和8个每袋，如果现在要购买n的苹果，请返回最少的袋子数
如果不能正好装下，返回-1
 */
public class BuyApple {
    public int solution(int apple) {
        if (apple < 0) {
            return -1;
        }
        int bag6 = -1;
        int bag8 = apple / 8;
        int rest = apple - bag8 * 8;
        while (bag8 >= 0 && rest < 24) {
            int resultUse6 = minGetUse6(rest);
            if (resultUse6 != -1) {
                bag6 = resultUse6;
                break;
            }
            rest = apple - 8 * (--bag8);
        }
        return bag6 == -1 ? -1 : bag6 + bag8;
    }

    private int minGetUse6(int rest) {
        return rest % 6 == 0 ? rest / 6 : -1;
    }
}
