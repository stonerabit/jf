package jf;

public class xls{
public static void xls2txt(String fileName){
	java.io.File file=new java.io.File(fileName);
	xls2txt(file);
}

public static void xls2txt(java.io.File file){
	java.io.FileWriter fw=null;
	java.io.PrintWriter out=null;
	try{/* 指定生成txt的文件路径*/
		String fileName=file.getAbsolutePath();
		int off=fileName.lastIndexOf(".");
		fileName=fileName.substring(0,off)+".txt";
		fw=new java.io.FileWriter(fileName);
		out=new java.io.PrintWriter(fw);/* 创建输入流，读取Excel*/
		java.io.InputStream is=new java.io.FileInputStream(file.getAbsolutePath());
		jxl.Workbook wb=jxl.Workbook.getWorkbook(is);
		int sheet_size=wb.getNumberOfSheets();
		for(int index=0;index<sheet_size;index++){
			jxl.Sheet sheet=wb.getSheet(index);/* sheet.getRows()返回该页的总行数*/
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
		}catch(java.io.IOException e){
			e.printStackTrace();
		}
	}


}

public static void main(String[] args) throws Exception{

	try{
		xls2txt("/ram/hb.xlss");

		Util.main(args);
	}catch(Exception e){
		e.printStackTrace();
	}
}
}