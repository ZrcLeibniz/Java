package zrc.course.algorithm11;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class UnionFindSet<V> {
    private class Element<V> {
        V value;

        public Element(V value) {
            this.value = value;
        }
    }

    private HashMap<V, Element<V>> elementMap;
    private HashMap<Element<V>, Element<V>> fatherMap;
    private HashMap<Element<V>, Integer> sizeMap;

    public UnionFindSet(List<V> lists) {
        elementMap = new HashMap<>();
        fatherMap = new HashMap<>();
        sizeMap = new HashMap<>();
        for (V value : lists) {
            Element<V> element = new Element<>(value);
            elementMap.put(value, element);
            fatherMap.put(element, element);
            sizeMap.put(element, 0);
        }
    }

    private Element<V> findHead(Element<V> element) {
        Stack<Element<V>> stack = new Stack<>();
        while (element != fatherMap.get(element)) {
            stack.push(element);
            element = fatherMap.get(element);
        }
        while (!stack.isEmpty()) {
            fatherMap.put(stack.pop(), element);
        }
        return element;
    }

    public boolean isSameUnion(V a, V b) {
        if (elementMap.containsKey(a) && elementMap.containsKey(b)) {
            return findHead(elementMap.get(a)) == findHead(elementMap.get(b));
        }
        return false;
    }

    public void union(V a, V b) {
        if (elementMap.containsKey(a) && elementMap.containsKey(b)) {
            Element<V> aFather = findHead(elementMap.get(a));
            Element<V> bFather = findHead(elementMap.get(b));
            if (aFather != bFather) {
                Element<V> big = sizeMap.get(aFather) > sizeMap.get(bFather) ? aFather : bFather;
                Element<V> small = big == aFather ? bFather : aFather;
                fatherMap.put(small, big);
                sizeMap.put(big, sizeMap.get(aFather) + sizeMap.get(bFather));
                sizeMap.remove(small);
            }
        }
    }
}


