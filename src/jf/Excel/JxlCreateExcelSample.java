package jf.Excel;

import jxl.CellType;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.format.VerticalAlignment;
import jxl.write.*;
import jxl.write.Number;

import java.io.File;
import java.util.Date;

public class JxlCreateExcelSample{
public static void main(String args[]){
	try{/* 打开文件  */
		WritableWorkbook book=Workbook.createWorkbook(new File("test.xls"));/* 生成名为“sheet1”的工作表，参数0表示这是第一页  */
		WritableSheet sheet=book.createSheet("sheet1",0);/* 在Label对象的构造子中指名单元格位置是第一列第一行(0,0),单元格内容为string  */
		Label label=new Label(0,0,"string",getDataCellFormat(CellType.LABEL));/* 将定义好的单元格添加到工作表中  */
		sheet.addCell(label);/* 生成一个保存数字的单元格,单元格位置是第二列，第一行，单元格的内容为1234.5  */
		Number number=new Number(1,0,1234.5,getDataCellFormat(CellType.NUMBER));
		sheet.addCell(number);/* 生成一个保存日期的单元格，单元格位置是第三列，第一行，单元格的内容为当前日期  */
		DateTime dtime=new DateTime(2,0,new Date(),getDataCellFormat(CellType.DATE));
		sheet.addCell(dtime);/* 写入数据并关闭文件  */
		book.write();
		book.close();
	}catch(Exception e){
		System.out.println(e);
	}
}

public static WritableCellFormat getDataCellFormat(CellType type){
	WritableCellFormat wcf=null;
	try{/* 字体样式  */
		if(type==CellType.NUMBER || type==CellType.NUMBER_FORMULA) {/* 数字  */
			NumberFormat nf=new NumberFormat("#.00");
			wcf=new WritableCellFormat(nf);
		}else if(type==CellType.DATE) {/* 日期  */
			DateFormat df=new DateFormat("yyyy-MM-dd hh:mm:ss");
			wcf=new WritableCellFormat(df);
		}else {
			WritableFont wf=new WritableFont(WritableFont.TIMES,10,WritableFont.NO_BOLD,false);/* 字体颜色  */
			wf.setColour(Colour.RED);
			wcf=new WritableCellFormat(wf);
		}/* 对齐方式  */
		wcf.setAlignment(Alignment.CENTRE);
		wcf.setVerticalAlignment(VerticalAlignment.CENTRE);/* 设置上边框  */
		wcf.setBorder(Border.TOP,BorderLineStyle.THIN);/* 设置下边框  */
		wcf.setBorder(Border.BOTTOM,BorderLineStyle.THIN);/* 设置左边框  */
		wcf.setBorder(Border.LEFT,BorderLineStyle.THIN);/* 设置右边框  */
		wcf.setBorder(Border.RIGHT,BorderLineStyle.THIN);/* 设置背景色  */
		wcf.setBackground(Colour.YELLOW);/* 自动换行  */
		wcf.setWrap(true);
	}catch(WriteException e){
		e.printStackTrace();
	}
	return wcf;
}
}