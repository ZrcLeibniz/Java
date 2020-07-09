package zrc.test.linear;

import zrc.linear.OrderSymbolTable;
import zrc.linear.SymbolTable;

public class OrderSymbolTableTest {
    public static void main(String[] args) {
        OrderSymbolTable<Integer, String> symbolTable = new OrderSymbolTable<>();
        symbolTable.put(1,"妞妞");
        symbolTable.put(2,"乖宝");
        System.out.println(symbolTable.get(1));
        symbolTable.delete(2);
        symbolTable.put(2, "臭宝");
        System.out.println(symbolTable.get(2));
    }
}
