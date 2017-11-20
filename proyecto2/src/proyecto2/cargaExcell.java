package proyecto2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/**
 *
 * @author live
 */
public class cargaExcell 
{
    public void funcionExcel() throws IOException{
	FileInputStream file = new FileInputStream(new File("C:\\Users\\Usuario1\\Desktop\\Bases de datos 1\\Progra2(100)\\Jugadores.xlsx"));
	// Crear el objeto que tendra el libro de Excel
	XSSFWorkbook workbook = new XSSFWorkbook(file);
	XSSFSheet sheet = workbook.getSheetAt(0);
	Iterator<Row> rowIterator = sheet.iterator();
	Row row;
	// Recorremos todas las filas para mostrar el contenido de cada celda
	while (rowIterator.hasNext()){
	    row = rowIterator.next();
	    // Obtenemos el iterator que permite recorres todas las celdas de una fila
	    Iterator<Cell> cellIterator = row.cellIterator();
	    Cell celda;
            int cont = 0;
            ArrayList<String> newArray = new ArrayList<String>();
	    while (cellIterator.hasNext()){
		celda = cellIterator.next();
		// Dependiendo del formato de la celda el valor se debe mostrar como String, Fecha, boolean, entero...
                if(cont > 4){
                    cont = 0;
                    String Query = "INSERT INTO JUGADOR VALUES ("+newArray.get(0)+","+newArray.get(0)+","+newArray.get(0)+","+newArray.get(0)+")";
                }
                if(cont <= 4){
                    switch(celda.getCellType()) {
                    case Cell.CELL_TYPE_NUMERIC:
                        System.out.println(celda.getNumericCellValue());
                        newArray.add(Integer.toString((celda.getNumericCellValue())));
                        break;
                    case Cell.CELL_TYPE_STRING:
                        System.out.println(celda.getStringCellValue());
                        newArray.add(celda.getStringCellValue());
                        break;
                    case Cell.CELL_TYPE_BOOLEAN:
                        System.out.println(celda.getBooleanCellValue());
                        newArray.add(""+celda.getBooleanCellValue());
                        break;
                    }
                }
                cont++;
	    }
	}
	// cerramos el libro excel
	workbook.close();
    }
}
