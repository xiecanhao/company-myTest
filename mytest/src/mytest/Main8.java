package mytest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//import org.nutz.lang.Strings;

//import com.wabao.module.fight.Unit;

public class Main8 {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 5; i++) {
			list.add(i);
		}
		List<Integer> l = Collections.unmodifiableList(list);
	}

	public static void sdfa(String... strings) {
		System.out.println(strings);
	}
}

// public static String unit2String(Set<Unit> army) {
// StringBuffer sb = new StringBuffer();
// String wid = "";
// if (army != null) {
// for (Unit unit : army) {
// int pos = unit.getPos();
// int pid = unit.getPid();
// int num = unit.getNum();
// String hid = unit.getHid() == null ? "" : unit.getHid();
// wid = unit.getWid() == null ? "" : unit.getWid();
// sb.append(pos).append(",").append(pid).append(",").append(num)
// .append(",").append(hid).append(";");
// }
// if (!Strings.isBlank(wid)) {
// sb.append("0").append(",").append("wid=").append(wid)
// .append(";");
// }
// }
// return sb.toString();
// }
//
// // u:格式[pos,pid,num,hid;pos,pid,num,hid]
// public Set<Unit> parseUnit(String u) {
// Set<Unit> units = new HashSet<>();
// String[] blocks = u.split(";");
// // 武器设置位置为0号位，但武器作用于六个位置,
// String wid = null;
// for (String block : blocks) {
// String[] params = block.split(",");
// if (Integer.parseInt(params[0]) == 0) {
// String[] split = params[1].split("=");
// switch (split[0]) {
// case "wid":
// wid = split[1];
// }
// }
// }
// for (String block : blocks) {
// String[] params = block.split(",");
// if (Integer.parseInt(params[0]) == 0)
// continue;
// int pos = Integer.parseInt(params[0]);
// int pid = Integer.parseInt(params[1]);
// int num = Integer.parseInt(params[2]);
// if (num < 1) {
// continue;
// }
// String hid = null;
// if (params.length == 4)
// hid = params[3];
// units.add(new Unit(pos, pid, num, hid, wid));
// }
// return units;
// }
