/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sickjumps.rollinish.gui.table;

import java.util.List;

/**
 *
 * @author Nathan
 */
public interface RowObjectTableModel<T> {

    public T getRow(int rowIndex);

    public List<T> getRows(int... rows);

    public void addRow(T t);

    public void insertRow(T t, int rowIndex);

    public void removeRow(int rowIndex);

    public void removeAllRows();
}
