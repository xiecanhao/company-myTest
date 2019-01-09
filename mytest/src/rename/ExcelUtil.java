package rename;

import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFComment;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;

/**
 * Excel读取工具
 * 
 * @author yaowenhao
 * @date 2014年8月6日 下午1:21:10
 */
public class ExcelUtil {

	/**
	 * 读取Excel有效内容
	 * 
	 * @param sheet
	 * @return
	 * @throws Exception
	 */
	public static List<List<Object>> readExcel(Sheet sheet) throws Exception {
		int rowNum = sheet.getLastRowNum(); // 总行数
		int startLine = sheet.getFirstRowNum();
		Row firstRow = sheet.getRow(startLine); // 表示数据类型的行
		if (firstRow == null) {
			return null;
		}
		List<List<Object>> content = new ArrayList<List<Object>>();
		Set<Integer> ignoreSet = new HashSet<>();
		List<Object> first = new ArrayList<Object>();
		int cellSize = firstRow.getLastCellNum();
		for (int i = 0; i < cellSize; i++) {
			Object data = getCellValue(firstRow.getCell(i));
			if (data == null || "".equals(data.toString().trim())) {
				ignoreSet.add(i);
				continue;
			}
			first.add(data);
		}
		content.add(first);

		for (int i = 1; i <= rowNum; i++) {
			List<Object> rowData = new ArrayList<Object>();
			Row row = sheet.getRow(i);
			if (row == null) {
				continue;
			}
			int dataNull = 0;
			for (int j = 0; j < cellSize; j++) {
				if (ignoreSet.contains(j))
					continue;
				Object data = getCellValue(row.getCell(j));
				rowData.add(data);

				if (data == null || data.toString().trim().isEmpty()) {
					dataNull++;
				}
			}
			if (dataNull != rowData.size()) {
				content.add(rowData);
			}
		}
		return content;
	}

	/**
	 * 获取单元格数据内容
	 * 
	 * @param cell
	 *            HSSFCell Excel单元格
	 * @return Object
	 */
	public static Object getCellValue(Cell cell) {
		Object strCell = null;
		if (cell == null) {
			return strCell;
		}
		cell.setCellType(XSSFCell.CELL_TYPE_STRING); // TODO a magic!!!
		switch (cell.getCellType()) {
		case XSSFCell.CELL_TYPE_BLANK: // blank类型
			break;
		case XSSFCell.CELL_TYPE_STRING: // String类型
			strCell = cell.getStringCellValue();
			break;
		case XSSFCell.CELL_TYPE_BOOLEAN: // booelan类型
			strCell = cell.getBooleanCellValue();
			break;
		case XSSFCell.CELL_TYPE_NUMERIC: // numeric类型(包含了日期类型)
			boolean isDate = HSSFDateUtil.isCellDateFormatted(cell);
			if (isDate) {
				strCell = cell.getDateCellValue();
			} else {
				strCell = cell.getNumericCellValue();
				if (String.valueOf(strCell).indexOf("E") != -1) {
					strCell = new DecimalFormat("0")
							.format(cell.getNumericCellValue());
				}
			}
			break;
		case XSSFCell.CELL_TYPE_FORMULA: // 公式类型
			try {
				strCell = (int) cell.getNumericCellValue();
			} catch (Exception e) {
				strCell = cell.getStringCellValue();
			}
			break;
		}
		return strCell;
	}

	/**
	 * 导出一个Excel表格
	 * 
	 * @param sheetTitle
	 * @param modelHeader
	 * @param dataset
	 * @param out
	 * @throws Exception
	 */
	public static <T> HSSFWorkbook exportExcel(String sheetTitle,
			LinkedHashMap<String, String> modelHeader, Collection<T> dataset) {
		try {
			// 声明一个工作薄
			HSSFWorkbook workbook = new HSSFWorkbook();

			// 生成一个表格
			HSSFSheet sheet = workbook.createSheet(sheetTitle);

			// 生成一个样式
			HSSFCellStyle style = workbook.createCellStyle();

			// 设置这些样式
			style.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
			style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			style.setBorderRight(HSSFCellStyle.BORDER_THIN);
			style.setBorderTop(HSSFCellStyle.BORDER_THIN);
			style.setAlignment(HSSFCellStyle.ALIGN_CENTER);

			// 生成字体
			HSSFFont font = workbook.createFont();
			font.setColor(HSSFColor.VIOLET.index);
			font.setFontHeightInPoints((short) 12);
			font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

			HSSFFont font2 = workbook.createFont();
			font2.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);

			HSSFFont font3 = workbook.createFont();
			font3.setColor(HSSFColor.BLUE.index);

			// 把字体应用到当前的样式
			style.setFont(font);

			// 生成并设置另一个样式
			HSSFCellStyle style2 = workbook.createCellStyle();
			style2.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);
			style2.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			style2.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			style2.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			style2.setBorderRight(HSSFCellStyle.BORDER_THIN);
			style2.setBorderTop(HSSFCellStyle.BORDER_THIN);
			style2.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			style2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);

			// 把字体应用到当前的样式
			style2.setFont(font2);

			// 声明一个画图的顶级管理器
			HSSFPatriarch patriarch = sheet.createDrawingPatriarch();

			// 定义注释的大小和位置,详见文档
			HSSFComment comment = patriarch.createComment(new HSSFClientAnchor(
					0, 0, 0, 0, (short) 4, 2, (short) 6, 5));

			// 设置注释内容
			comment.setString(new HSSFRichTextString("可以在POI中添加注释！"));

			// 设置注释作者，当鼠标移动到单元格上是可以在状态栏中看到该内容.
			comment.setAuthor("wabao");

			// 产生表格标题行
			HSSFRow row = sheet.createRow(0);
			Set<String> headerNameSet = modelHeader.keySet(); // 存放实际数据的属性名的Set
			int rowIndex = 0;// 列号
			for (Entry<String, String> entry : modelHeader.entrySet()) {
				HSSFCell cell = row.createCell(rowIndex);
				cell.setCellStyle(style);
				cell.setCellValue(new HSSFRichTextString(entry.getValue()));

				sheet.setColumnWidth(rowIndex++,
						entry.getValue().getBytes().length * 2 * 192);// 设置列宽度
			}

			// 遍历集合数据，产生数据行
			Iterator<T> dataIt = dataset.iterator();
			int rowIndex2 = 1;// 数据行的列号
			while (dataIt.hasNext()) {

				int sheelIndex = rowIndex2 / 65535 + 1;
				if (rowIndex2 % 65535 == 0) {
					// 重新建一个sheel表格 1：需要插入一个标题行
					rowIndex2 = 1;// 数据行的列号

					// 生成一个表格
					sheet = workbook.createSheet(sheetTitle + sheelIndex);

					// 声明一个画图的顶级管理器
					patriarch = sheet.createDrawingPatriarch();

					// 定义注释的大小和位置,详见文档
					comment = patriarch.createComment(new HSSFClientAnchor(0, 0,
							0, 0, (short) 4, 2, (short) 6, 5));

					// 设置注释内容
					comment.setString(new HSSFRichTextString("可以在POI中添加注释！"));

					// 设置注释作者，当鼠标移动到单元格上是可以在状态栏中看到该内容.
					comment.setAuthor("wabao");

					// 产生表格标题行
					row = sheet.createRow(0);
					rowIndex = 0;// 列号
					for (Entry<String, String> entry : modelHeader.entrySet()) {
						HSSFCell cell = row.createCell(rowIndex);
						cell.setCellStyle(style);
						cell.setCellValue(
								new HSSFRichTextString(entry.getValue()));

						sheet.setColumnWidth(rowIndex++,
								entry.getValue().getBytes().length * 2 * 192);// 设置列宽度
					}
				}
				row = sheet.createRow(rowIndex2++); // 每条数据创建一行
				T t = dataIt.next();

				// 利用反射，根据javabean属性的先后顺序，动态调用getXxx()方法得到属性值
				final Method[] methods = t.getClass().getMethods(); // 方法数组
				int cellIndex = 0;
				HashMap<String, String> valueMap = new HashMap<String, String>();
				for (Method method : methods) {
					String methodName = method.getName();
					// 方法名操作的属性名
					String fieldName = "";
					if (methodName.startsWith("get")) {
						fieldName = methodName.substring(3);
					} else if (methodName.startsWith("is")) {
						fieldName = methodName.substring(2);
					}
					if (fieldName.length() > 0
							&& method.getParameterTypes().length == 0) {
						if (fieldName.length() == 1) {
							fieldName = fieldName.toLowerCase();
						} else if (!Character
								.isUpperCase(fieldName.charAt(1))) {
							fieldName = fieldName.substring(0, 1).toLowerCase()
									+ fieldName.substring(1);
						}
					}
					if (!headerNameSet.contains(fieldName)) {// 如果某个属性，不在headNameSet中，那么就丢弃它。
						continue;
					}
					Object elementObj = method.invoke(t);// get方法取得的元素
					String cellContent = "";// 每格显示的内容
					if (elementObj != null) {
						if (elementObj instanceof Date) {
							cellContent = DateUtils.format((Date) elementObj,
									"yyyy-MM-dd HH:mm:ss");
						} else {
							cellContent = elementObj.toString();
						}
					}
					valueMap.put(fieldName, cellContent);

				}
				// 创建一行
				for (String key : headerNameSet) {
					// 创建一格
					HSSFCell cell = row.createCell(cellIndex++);
					cell.setCellStyle(style2);
					HSSFRichTextString richString = new HSSFRichTextString(
							valueMap.get(key));
					richString.applyFont(font3);
					cell.setCellValue(richString);
				}

			}
			return workbook;
		} catch (Exception e) {
			System.err.println("生成Excel表格失败!" + e.getMessage());
		}
		return null;
	}
}
