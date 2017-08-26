package bitset;

import java.util.BitSet;

public class BitSetTest {
	public static void main(String[] args) {
		BitSet bs1 = new BitSet();
		bs1.set(10);
		BitSet bs2 = new BitSet();
		bs2.set(10);
		bs2.set(9);
		System.out.println(bs2);// {9, 10}
		System.out.println(bs1.get(0));// false
		System.out.println(bs1.get(10));// true

		bs2.xor(bs1);// 异或自己为空
		System.out.println(bs2);

		// long arrLong[] = { 1l, 5l, 6l, 7l };
		long arrLong[] = { 6l };
		BitSet bs3 = BitSet.valueOf(arrLong);
		System.out.println(bs3);// {0, 64, 66, 129, 130, 192, 193, 194}
	}
}
