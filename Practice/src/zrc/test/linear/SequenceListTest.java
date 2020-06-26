package zrc.test.linear;

import zrc.linear.SequenceList;

public class SequenceListTest {
    public static void main(String[] args) {
        SequenceList<String> sequenceList = new SequenceList<String>(3);
        sequenceList.insert("科比");
        sequenceList.insert("麦迪");
        sequenceList.insert("欧文");
        sequenceList.insert("詹姆斯");
//        System.out.println(sequenceList.get(0));
//        System.out.println(sequenceList.get(1));
//        System.out.println(sequenceList.get(2));
//        System.out.println(sequenceList.get(3));
//        String remove = sequenceList.remove(0);
//        System.out.println(remove);
//        System.out.println(sequenceList.get(1));
        for (String s: sequenceList){
            System.out.println(s);
        }
    }
}
