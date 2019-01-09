package rename;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.util.List;

import org.apache.poi.POIXMLDocument;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	public static void main(String[] args) throws Exception {
		File excelFile = new File("D:\\ejfile\\gz.xlsx");
		InputStream is = new FileInputStream(excelFile);
		XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
		if (xssfWorkbook == null) {
			System.out.println("未读取到内容,请检查路径！");
			return;
		}
		Sheet sheet = xssfWorkbook.getSheetAt(0);
		// InputStream in = new FileInputStream("D:\\ejfile\\gz.xlsx");
		// Workbook workbook = create(in);
		// Sheet sheet = workbook.getSheetAt(0);
		List<List<Object>> cellList = ExcelUtil.readExcel(sheet);
		System.out.println(cellList);
	}

	public static Workbook create(InputStream in)
			throws IOException, InvalidFormatException {
		if (!in.markSupported()) {
			in = new PushbackInputStream(in, 8);
		}
		if (POIFSFileSystem.hasPOIFSHeader(in)) {
			return new HSSFWorkbook(in);
		}
		if (POIXMLDocument.hasOOXMLHeader(in)) {
		}
		return new XSSFWorkbook(OPCPackage.open(in));
		// throw new IllegalArgumentException("你的excel版本目前poi解析不了");

	}
}
