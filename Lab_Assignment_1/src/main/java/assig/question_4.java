/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assig;

import java.awt.*;
import java.util.*;
import java.util.List;

public class question_4 {

    public static void main(String[] args) {
        try {
            DataTable table = new DataTable(3, 3);
            table.insertValue(0, 0, "A");
            table.insertValue(1, 1, "B");
            table.insertValue(2, 2, "C");
            System.out.println(table.getValue(0, 0)); // Output: A
            System.out.println(table.getValue(1, 1)); // Output: B
            System.out.println(table.getValue(2, 2)); // Output: C
            table.resizeColumns(5);
            table.resizeRows(5);
            table.insertValue(3, 3, "D");
            System.out.println(table.getValue(3, 3)); // Output: D
            table.deleteRow(0);
            table.deleteColumn(0);
            System.out.println(table.getValue(0, 0)); // Output: B
            table.insertRow(0);
            table.insertColumn(0);
            System.out.println(table.getValue(0, 0)); // Output: null
            Hashtable<Object, Object> tableData = new Hashtable<>();
            tableData.put(0, 1);
            tableData.put(1, 2);
            table.populateTable(tableData);
            System.out.println(table.getValue(0, 1)); // Output: 1
            System.out.println(table.getValue(1, 2)); // Output: 2
        } catch (TableException e) {
            System.out.println("Table Exception: " + e.getMessage());
        }
    }
}

interface Featurable {

    void setForeground(Color color);

    void setBackground(Color color);

    void setFont(Font font);
}

class TableException extends Exception {

    public TableException(String message) {
        super(message);
    }
}

class DataTable implements Featurable {

    private int numRows;
    private int numCols;
    private Object[][] data;
    private Color foregroundColor;
    private Color backgroundColor;
    private Font font;

    public DataTable(int numRows, int numCols) throws TableException {
        if (numRows > 200 || numCols > 200) {
            throw new TableException("Number of rows or columns exceeds the maximum limit of 200");
        }
        this.numRows = numRows;
        this.numCols = numCols;
        this.data = new Object[numRows][numCols];
    }

    public void insertValue(int row, int col, Object value) {
        data[row][col] = value;
    }

    public void resizeColumns(int newNumCols) throws TableException {
        if (newNumCols > 200) {
            throw new TableException("Number of columns exceeds the maximum limit of 200");
        }
        if (newNumCols > numCols) {
            Object[][] newData = new Object[numRows][newNumCols];
            for (int i = 0; i < numRows; i++) {
                System.arraycopy(data[i], 0, newData[i], 0, numCols);
            }
            this.data = newData;
        }
        this.numCols = newNumCols;
    }

    public void resizeRows(int newNumRows) throws TableException {
        if (newNumRows > 200) {
            throw new TableException("Number of rows exceeds the maximum limit of 200");
        }
        if (newNumRows > numRows) {
            Object[][] newData = new Object[newNumRows][numCols];
            System.arraycopy(data, 0, newData, 0, numRows);
            this.data = newData;
        }
        this.numRows = newNumRows;
    }

    public void deleteRow(int row) {
        if (row >= 0 && row < numRows) {
            System.arraycopy(data, row + 1, data, row, numRows - row - 1);
            data[numRows - 1] = new Object[numCols];
            numRows--;
        }
    }

    public void deleteColumn(int col) {
        if (col >= 0 && col < numCols) {
            for (int i = 0; i < numRows; i++) {
                System.arraycopy(data[i], col + 1, data[i], col, numCols - col - 1);
                data[i][numCols - 1] = null;
            }
            numCols--;
        }
    }

    public void insertRow(int row) throws TableException {
        if (row >= 0 && row <= numRows) {
            if (numRows + 1 > 200) {
                throw new TableException("Number of rows exceeds the maximum limit of 200");
            }
            Object[][] newData = new Object[numRows + 1][numCols];
            System.arraycopy(data, 0, newData, 0, row + 1);
            System.arraycopy(data, row, newData, row + 1, numRows - row);
            newData[row] = new Object[numCols];
            this.data = newData;
            numRows++;
        }
    }

    public void insertColumn(int col) throws TableException {
        if (col >= 0 && col <= numCols) {
            if (numCols + 1 > 200) {
                throw new TableException("Number of columns exceeds the maximum limit of 200");
            }
            for (int i = 0; i < numRows; i++) {
                Object[] newRow = new Object[numCols + 1];
                System.arraycopy(data[i], 0, newRow, 0, col);
                System.arraycopy(data[i], col, newRow, col + 1, numCols - col);
                newRow[col] = null;
                data[i] = newRow;
            }
            numCols++;
        }
    }

    public Object getValue(int row, int col) {
        return data[row][col];
    }

    public void setValue(int row, int col, Object value) {
        data[row][col] = value;
    }

    @Override
    public void setForeground(Color color) {
        this.foregroundColor = color;
    }

    @Override
    public void setBackground(Color color) {
        this.backgroundColor = color;
    }

    @Override
    public void setFont(Font font) {
        this.font = font;
    }

    public void populateTable(Hashtable<Object, Object> tableData) {
        Enumeration<Object> keys = tableData.keys();
        while (keys.hasMoreElements()) {
            Object key = keys.nextElement();
            Object value = tableData.get(key);
            int row = (int) key;
            int col = (int) value;
            data[row][col] = value;
        }
    }
}
