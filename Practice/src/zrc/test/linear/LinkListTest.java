package zrc.test.linear;

import zrc.linear.LinkList;

public class LinkListTest {
    public static void main(String[] args) {
        LinkList<String> linkList = new LinkList<String>();
        linkList.insert("科比");
        linkList.insert("麦迪");
        linkList.insert("欧文");
        linkList.insert("詹姆斯");
//        for (String s: linkList){
//            System.out.println(s);
//        }
//        System.out.println(linkList.get(1));
        String remove = linkList.remove(0);
//        System.out.println(remove);
//        for (String s: linkList){
//            System.out.println(s);
//        }
        linkList.insert(1, "乔治");
        for (String s : linkList) {
            System.out.println(s);
        }
    }
}
