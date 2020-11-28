package tests;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestData  {
	private static XSSFSheet ExcelWSheet;

	private static XSSFWorkbook ExcelWBook;

	private static XSSFCell Cell;



	

	public static void OpenExcelFile(String Path, String SheetName) throws Exception {

		try {

			// Open the Excel file
			FileInputStream ExcelFile = new FileInputStream(Path);

			// Access the required test data sheet
			ExcelWBook = new XSSFWorkbook(ExcelFile);

			ExcelWSheet = ExcelWBook.getSheet(SheetName);
			// ExcelWSheet = ExcelWBook.getSheetAt(0);

		} catch (Exception e) {
			throw (e);
		}
	}


	public static String getCellData(int RowNum, int ColNum) throws Exception {

		try {

			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

			String CellData = Cell.getStringCellValue();

			return CellData;

		} catch (Exception e) {

			return "";

		}
	}
	
	// DataProvider TCS
	public static Object[][] fetchData(String sTestCaseName) throws Exception

	{
		int iTestCaseRow;
		TestData.OpenExcelFile("E:\\AUTOMATION\\WorkSpace\\Task\\TestData.xlsx", "Sheet1");
		iTestCaseRow = TestData.getRowContains(sTestCaseName, 0);

		Object[][] testObjArray = TestData.getTableArray(
				  "E:\\AUTOMATION\\WorkSpace\\Task\\TestData.xlsx", "Sheet1", iTestCaseRow);
		
		return (testObjArray);

	}

	public static Object[][] getTableArray(String FilePath, String SheetName, int iTestCaseRow) throws Exception

	{

		String[][] tabArray = null;

		try {

			FileInputStream ExcelFile = new FileInputStream(FilePath);

			ExcelWBook = new XSSFWorkbook(ExcelFile);

			ExcelWSheet = ExcelWBook.getSheet(SheetName);

			int startCol = 1;

			int ci = 0, cj = 0;

			int totalRows = 1;

			int totalCols = ExcelWSheet.getRow(iTestCaseRow).getLastCellNum() - 1;

			tabArray = new String[totalRows][totalCols];

			for (int j = startCol; j <= totalCols; j++, cj++)

			{

				tabArray[ci][cj] = getCellData(iTestCaseRow, j);
				System.out.println("TableArray " +tabArray[ci][cj]);

			}

		}

		catch (FileNotFoundException e)

		{

			System.out.println("Could not read the Excel sheet");

			e.printStackTrace();

		}

		catch (IOException e)

		{

			System.out.println("Could not read the Excel sheet");

			e.printStackTrace();

		}

		return (tabArray);
	}
	public static int getRowContains(String sTestCaseName, int colNum) throws Exception {

		int i;

		try {

			int rowCount = TestData.getRowUsed();

			for (i = 0; i < rowCount; i++) {

				if (TestData.getCellData(i, colNum).equalsIgnoreCase(sTestCaseName)) {

					break;

				}

			}

			return i;

		} catch (Exception e) {

			throw (e);

		}

	}

	public static int getRowUsed() throws Exception {

		try {

			int RowCount = ExcelWSheet.getLastRowNum();

			return RowCount;

		} catch (Exception e) {

			System.out.println(e.getMessage());

			throw (e);

		}

	}
}
