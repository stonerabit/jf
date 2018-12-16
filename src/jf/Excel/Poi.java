package jf.Excel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Poi{
private final static String excel2003L=".xls";    /*2003- 版本的excel*/
private final static String excel2007U=".xlsx";   /*2007+ 版本的excel*/

public static List getExcelList(String filePath) throws Exception{
	FileInputStream fins=new FileInputStream(new File(filePath));
	return getBankListByExcel(fins,filePath);
}

/**
 * 描述：获取IO流中的数据，组装成List<List<Object>>对象 @param in,fileName @return @throws IOException
 */
public static List<List<Object>> getBankListByExcel(InputStream in,String fileName) throws Exception{
	List<List<Object>> list=null;/*创建Excel工作薄*/
	Workbook work=getWorkbook(in,fileName);
	if(null==work) throw new Exception("创建Excel工作薄为空！");
	Sheet sheet=null;
	Row row=null;
	Cell cell=null;
	list=new ArrayList<List<Object>>();/*遍历Excel中所有的sheet*/
	for(int i=0;i<work.getNumberOfSheets();i++){
		sheet=work.getSheetAt(i);
		if(sheet==null) continue;
		for(int j=sheet.getFirstRowNum();j<=sheet.getLastRowNum();j++){
			row=sheet.getRow(j);
			if(row==null) continue;/*do not want tiltle row , get out*/
			List<Object> li=new ArrayList<Object>();
			for(int y=row.getFirstCellNum();y<=row.getLastCellNum();y++){
				cell=row.getCell(y);
				li.add(getCellValue(cell));
			}
			list.add(li);
		}
	}
	work.close();
	return list;
}

/**
 * 描述：根据文件后缀，自适应文件的版本 @param in,fileName @return @throws Exception
 */
public static Workbook getWorkbook(InputStream in,String fileName) throws Exception{
	Workbook wb=null;
	String fileType=fileName.substring(fileName.lastIndexOf("."));
	if(excel2003L.equals(fileType)) wb=new org.apache.poi.hssf.usermodel.HSSFWorkbook(in);  /*2003-*/
	else if(excel2007U.equals(fileType)) wb=new org.apache.poi.xssf.usermodel.XSSFWorkbook(in);  /*2007+*/
	else throw new Exception("file type err！");
	return wb;
}

public static Workbook getWorkbook(InputStream in) throws Exception{
	Workbook wb=null;
	try{
		wb=new org.apache.poi.hssf.usermodel.HSSFWorkbook(in);  /*2003-*/
	}catch(java.io.IOException e){
		e.printStackTrace();
		throw new Exception("file type err！");
	}
	return wb;
}

/**
 * 描述：对表格中数值进行格式化 @param cell @return
 */
public static Object getCellValue(Cell cell){
	Object value=null;
	if(null==cell) return null;
	switch(cell.getCellTypeEnum()){
		case STRING:
			value=cell.getRichStringCellValue().getString();
			break;
		case NUMERIC:
			cell2num(cell);
			break;
		case BOOLEAN:
			value=cell.getBooleanCellValue();
			break;
		case BLANK:
			value="";
			break;
		default:
			break;
	}
	return value;
}

public static Object cell2num(org.apache.poi.ss.usermodel.Cell cell){
	Object value;
	DecimalFormat df=new DecimalFormat("0");  /*格式化number String字符*/
	SimpleDateFormat sdf=new SimpleDateFormat("yyy-MM-dd");  /*日期格式化*/
	DecimalFormat df2=new DecimalFormat("0.00");  /*格式化数字*/
	if("General".equals(cell.getCellStyle().getDataFormatString())) value=df.format(cell.getNumericCellValue());
	else if("m/d/yy".equals(cell.getCellStyle().getDataFormatString())) value=sdf.format(cell.getDateCellValue());
	else value=df2.format(cell.getNumericCellValue());
	return value;
}

/**
 * 创建Excel.xls @param lists     需要写入xls的数据 @param titles    列标题 @param sheetname 文件名 @return @throws IOException
 */
public static Workbook creatExcel(List<List<String>> lists,String[] titles,String sheetname) throws IOException{
	System.out.println(lists);/*创建新的工作薄*/
	Workbook wb=new HSSFWorkbook();/* 创建第一个sheet（页），并命名*/
	Sheet sheet=wb.createSheet(sheetname);/* 手动设置列宽。第一个参数表示要为第几列设；，第二个参数表示列的宽度，n为列高的像素数。*/
	for(int i=0;i<titles.length;i++) sheet.setColumnWidth((short) i,(short) (35.7*150));/* 创建第一行*/
	Row row=sheet.createRow((short) 0);/* 创建两种单元格格式*/
	CellStyle cs=wb.createCellStyle();
	CellStyle cs2=wb.createCellStyle();/* 创建两种字体*/
	Font f=wb.createFont();
	Font f2=wb.createFont();/* 创建第一种字体样式（用于列名）*/
	f.setFontHeightInPoints((short) 10);
	f.setColor(IndexedColors.BLACK.getIndex());
	f.setBoldweight(Font.BOLDWEIGHT_BOLD);/* 创建第二种字体样式（用于值）*/
	f2.setFontHeightInPoints((short) 10);
	f2.setColor(IndexedColors.BLACK.getIndex());/* 设置第一种单元格的样式（用于列名）*/
	cs.setFont(f);
	cs.setBorderLeft(CellStyle.BORDER_THIN);
	cs.setBorderRight(CellStyle.BORDER_THIN);
	cs.setBorderTop(CellStyle.BORDER_THIN);
	cs.setBorderBottom(CellStyle.BORDER_THIN);
	cs.setAlignment(CellStyle.ALIGN_CENTER);/* 设置第二种单元格的样式（用于值）*/
	cs2.setFont(f2);
	cs2.setBorderLeft(CellStyle.BORDER_THIN);
	cs2.setBorderRight(CellStyle.BORDER_THIN);
	cs2.setBorderTop(CellStyle.BORDER_THIN);
	cs2.setBorderBottom(CellStyle.BORDER_THIN);
	cs2.setAlignment(CellStyle.ALIGN_CENTER);/*设置列名*/
	for(int i=0;i<titles.length;i++){
		Cell cell=row.createCell(i);
		cell.setCellValue(titles[i]);
		cell.setCellStyle(cs);
	}
	if(lists==null || lists.size()==0) return wb;/*设置每行每列的值*/
	for(short i=1;i<=lists.size();i++){/* Row 行,Cell 方格 , Row 和 Cell 都是从0开始计数的 创建一行，在页sheet上*/
		Row row1=sheet.createRow((short) i);
		for(short j=0;j<titles.length;j++){/* 在row行上创建一个方格*/
			Cell cell=row1.createCell(j);
			if(j<lists.size()) cell.setCellValue(lists.get(i-1).get(j));
			cell.setCellStyle(cs2);
		}
	}
	return wb;
}

public static void main(String[] args) throws Exception{
	try{
		List excellist=getExcelList("/ram/hb.xls");
		Workbook wb=creatExcel(excellist,new String[15],"name");
		wb.write(new java.io.FileOutputStream("/ram/tmp.xls"));/*		jf.Util.printsln(excellist.size()); jf.Util.printIter(excellist);*/
		jf.Util.main(args);
	}catch(Exception e){
		e.printStackTrace();
	}
}
}