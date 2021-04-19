package zrc.challenge;

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

    public UnionFindSet(List<V> list) {
        elementMap = new HashMap<>();
        fatherMap = new HashMap<>();
        sizeMap = new HashMap<>();
        for (V value : list) {
            Element<V> element = new Element<>(value);
            elementMap.put(value, element);
            fatherMap.put(element, element);
            sizeMap.put(element, 1);
        }
    }

    private Element<V> getHead(Element<V> element) {
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
            return getHead(elementMap.get(a)) == getHead(elementMap.get(b));
        }
        return false;
    }

    public void union(V a, V b) {
        if (elementMap.containsKey(a) && elementMap.containsKey(b)) {
            Element<V> fatherA = getHead(elementMap.get(a));
            Element<V> fatherB = getHead(elementMap.get(b));
            if (fatherA != fatherB) {
                Element<V> big = sizeMap.get(fatherA) > sizeMap.get(fatherB) ? fatherA : fatherB;
                Element<V> small = big == fatherA ? fatherB : fatherA;
                fatherMap.put(small, big);
                sizeMap.put(big, sizeMap.get(big) + sizeMap.get(small));
                sizeMap.remove(small);
            }
        }
    }
}
