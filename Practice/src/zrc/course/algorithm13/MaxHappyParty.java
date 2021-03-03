package zrc.course.algorithm13;

import java.util.List;

// 派对的最大欢乐值
/*
员工的信息定义如下：
    class Employee {
        public int happy;
        List<Employee> subordinates;
    }
公司的每一个员工都符合Employee类的描述。
公司只有唯一的老板，除过老板之外每个员工都有唯一的直接上级
初基层员工外每个员工都有一个或多个直接下级

这个公司现在要办派对，你可以决定那些员工来，那些员工不来，但是要遵循如下规则：
    (1)如果某个员工来了，那么这个员工的所有直接下级都不能来
    (2)派对的整体快乐值是在场所有员工快乐值得累加
    (3)你的目标是让派对的整体欢乐值最大
 */
public class MaxHappyParty {
    private class Employee {
        int happy;
        List<Employee> subordinates;
    }

    private class Info {
        int joinMaxHappy;
        int unJoinHappy;

        public Info(int joinMaxHappy, int unJoinHappy) {
            this.joinMaxHappy = joinMaxHappy;
            this.unJoinHappy = unJoinHappy;
        }
    }

    public int solution(Employee boss) {
        Info process = process(boss);
        return Math.max(process.joinMaxHappy, process.unJoinHappy);
    }

    private Info process(Employee employee) {
        if (employee.subordinates.isEmpty()) {
            return new Info(employee.happy, 0);
        }
        int join = employee.happy;
        int unJoin = 0;
        for (Employee subordinate : employee.subordinates) {
            Info process = process(subordinate);
            join += process.unJoinHappy;
            unJoin += Math.max(process.joinMaxHappy, process.unJoinHappy);
        }
        return new Info(join, unJoin);
    }
}
