public class Test {
    public static void main(String[] args) {
        int[] height = {4, 2, 3};
        int trap = trap(height);
        System.out.println(trap);
    }

    public static int trap(int[] height) {
        int rain = 0;
        int limitWeight = 0;
        boolean flag = false;
        for (int i = 0; i < height.length; i = flag ? limitWeight : i + 1) {
            int limitHeight = 0;
            int pooled = 0;
            flag = false;
            if (height[i] > 0) {
                for (int j = i + 1; j < height.length; j++) {
                    if (height[j] >= height[i]) {
                        limitWeight = j;
                        flag = true;
                        break;
                    } else {
                        pooled = pooled < height[j] ? pooled : height[j];
                    }
                }
                if (!flag) {
                    for (int j = i + 1; j < height.length; j++) {
                        if (height[j] > pooled) {
                            limitWeight = j;
                            pooled = height[j];
                            flag = true;
                        }
                    }
                }
                for (int j = i + 1; j < limitWeight; j++) {
                    limitHeight = height[i] < height[limitWeight] ? height[i] : height[limitWeight];
                    rain += limitHeight - height[j];
                }
            }
        }
        return rain;
    }
}
