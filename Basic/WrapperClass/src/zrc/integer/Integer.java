package zrc.integer;

import javax.sound.midi.Soundbank;

public class Integer {
    public static void main(String[] args) {
        System.out.println("byte-------------java.lang.Byte");
        System.out.println("short-------------java.lang.Short");
        System.out.println("int-------------java.lang.Integer");
        System.out.println("long-------------java.lang.Long");
        System.out.println("float-------------java.lang.Float");
        System.out.println("double-------------java.lang.Double");
        System.out.println("boolean-------------java.lang.Boolean");
        System.out.println("char-------------java.lang.Character");
        java.lang.Integer i = new java.lang.Integer(1);
        // 将Integer转换为int
        int i2 = i.intValue();
        System.out.println(java.lang.Integer.MAX_VALUE);
        System.out.println(java.lang.Integer.MIN_VALUE);
    }
}
