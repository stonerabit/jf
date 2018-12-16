package jf.Excel;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import java.io.*;
import java.util.List;

public class Jxl{
public static void xls2txt(String fileName){
	File file=new java.io.File(fileName);
	xls2txt(file);
}

public static void xls2txt(File file){
	FileWriter fw=null;
	PrintWriter out=null;
	try{/* 指定生成txt的文件路径*/
		String fileName=file.getAbsolutePath();
		int off=fileName.lastIndexOf(".");
		fileName=fileName.substring(0,off)+".txt";
		fw=new FileWriter(fileName);
		out=new PrintWriter(fw);/* 创建输入流，读取Excel*/
		InputStream is=new FileInputStream(file.getAbsolutePath());
		Workbook wb=Workbook.getWorkbook(is);
		int sheet_size=wb.getNumberOfSheets();
		for(int index=0;index<sheet_size;index++){
			Sheet sheet=wb.getSheet(index);/* sheet.getRows()返回该页的总行数*/
			for(int i=0;i<sheet.getRows();i++){/* sheet.getColumns()返回该页的总列数*/
				for(int j=0;j<sheet.getColumns();j++){
					String cellinfo=sheet.getCell(j,i).getContents();/* 将从Excel中读取的数据写入到txt中*/
					out.println(cellinfo);
				}
			}
		}
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		try{
			if(null!=out) {
				out.flush();
				out.close();
				out=null;
			}
			fw.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}


public static void lllist2xls(File file,List<List<List<String>>> contents){
	WritableWorkbook wwb=null;
	WritableSheet sheet=null;

	try{
		wwb=Workbook.createWorkbook(file);
		for(int s=0;s<=contents.size();s++){
			sheet=(null==wwb.getSheet(s)) ? wwb.createSheet("",s) : wwb.getSheet(s);
			List<List<String>> sheetl=contents.get(s);
			for(int r=0;r<sheetl.size();r++){
				List<String> rowl=sheetl.get(r);
				for(int c=0;c<rowl.size();c++){
					Label cell=new Label(c,r,rowl.get(c));
					sheet.addCell(cell);
				}
			}
		}

	}catch(Exception e){
		System.out.println(e);
	}finally{
		try{
			if(null!=wwb) {
				wwb.write();
				wwb.close();
				wwb=null;
			}
		}catch(java.io.IOException e){
			e.printStackTrace();
		}catch(jxl.write.WriteException e){
			e.printStackTrace();
		}

	}
}

public static void list2sheet(File file,Workbook wb,final int maxc,List<String> content){
	WritableWorkbook wwb=null;
	WritableSheet sheet=null;

	try{
		int r=0, c=0, s=0, index=0;
		wwb=Workbook.createWorkbook(file,wb);
		sheet=(null==wwb.getSheet(s)) ? wwb.createSheet("",s) : wwb.getSheet(s);
		for(;index<=content.size();index++){
			c=index/maxc;
			r=index%maxc;
			Label label=new Label(c,r,content.get(index));
			sheet.addCell(label);
		}

	}catch(Exception e){
		System.out.println(e);
	}finally{
		wwbclose(wwb);

	}
}

public static void llist2xls(File file,List<List<String>> content){
	llist2xls(file,null,content);
}

public static void llist2xls(File file,Workbook wb,List<List<String>> content){

	WritableSheet sheet=null;
	WritableWorkbook wwb=null;
	try{
		int s=0, r=0, c=0;
		wwb=(null==wb) ? jxl.Workbook.createWorkbook(file) : jxl.Workbook.createWorkbook(file,wb);
		sheet=(null==wwb.getSheet(s)) ? wwb.createSheet("",s) : wwb.getSheet(s);
		List<String> row=content.get(s);
		Label cell=new Label(c,r,row.get(c));
		sheet.addCell(cell);

	}catch(Exception e){
		System.out.println(e);
	}finally{
		wwbclose(wwb);

	}
}

public static void wwbclose(WritableWorkbook wwb){
	try{
		if(null!=wwb) {
			wwb.write();
			wwb.close();
			wwb=null;
		}
	}catch(Exception e){
		e.printStackTrace();
	}
}

public static List<List<List>> wb2lllist(jxl.Workbook wb){
	List<List<List>> lllist=null;
	List<List> llist=null;
	List list=null;
	Sheet sheet=null;
	Cell[] row=null;
	Cell cell=null;
	for(int s=0;s<wb.getSheets().length;s++){
		sheet=wb.getSheet(s);
		for(int r=0;r<sheet.getRows();r++){
			row=sheet.getRow(r);
			for(int c=0;c<row.length;c++){
				cell=row[c];
				list.add(cell.getContents());
			}
			llist.add(list);
		}
		lllist.add(llist);
	}
	return lllist;
}

public static void xlswrite(File file,Workbook wb,int s,int r,int c,String content){
	try{
		WritableWorkbook wwb=Workbook.createWorkbook(file,wb);
		WritableSheet sheet=(null==wwb.getSheet(s)) ? wwb.createSheet("",s) : wwb.getSheet(s);
		Label label=new Label(c,r,content);
		sheet.addCell(label);
		wwb.write();
		wwb.close();
	}catch(Exception e){
		System.out.println(e);
	}
}

public static void xlswrite(String filePath,int s,int r,int c,String content){
	File file=new java.io.File(filePath);
	xlswrite(file,s,r,c,content);
}

public static void xlswrite(File file,int s,int r,int c,String content){
	Workbook wb=null;
	WritableWorkbook wwb=null;
	try{
		wb=Workbook.getWorkbook(file);
		wwb=Workbook.createWorkbook(file,wb);
		WritableSheet sheet=(null==wwb.getSheet(s)) ? wwb.createSheet("",s) : wwb.getSheet(s);
		Label label=new Label(c,r,content);
		sheet.addCell(label);
		wwb.write();
		wwb.close();
	}catch(Exception e){
		System.out.println(e);
	}finally{

		if(null!=wwb) try{
			wwb.close();
		}catch(java.io.IOException e){
			e.printStackTrace();
		}catch(jxl.write.WriteException e){
			e.printStackTrace();
		}
		if(null!=wb) wb.close();
	}
}


public static void main(String[] args) throws Exception{
	try{
		xls2txt("/ram/hb.xls");
		jf.Util.main(args);
	}catch(Exception e){
		e.printStackTrace();
	}
}
}

