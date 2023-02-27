package implementation.easy;

public class ExcelSheetColumns {
    public static void main(String[] args) {
        ExcelSheetColumns excelSheetColumns = new ExcelSheetColumns();
        System.out.println(excelSheetColumns.convertToTitle(1000000000));
    }

    public String convertToTitle(int columnNumber) {
        if (columnNumber == 0) {
            return "";
        }

        String result = "";

        while (columnNumber > 0) {
            columnNumber--;

            result = (char) ('A' + (columnNumber % 26)) + result;
            columnNumber = columnNumber / 26;
        }
        return result;
    }
}
