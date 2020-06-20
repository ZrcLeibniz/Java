package zrc.test.sort;

import zrc.sort.Shell;
import zrc.sort.pratice.shell.Shell01;
import zrc.sort.pratice.shell.Shell02;

import java.util.Arrays;

public class ShellTest {
    public static void main(String[] args) {
        Integer[] arr = {3, 2, 4, 5, 7, 6, 5, 9, 8, 1};
        Shell02.sort(arr);
        System.out.println(Arrays.asList(arr));
    }
}
