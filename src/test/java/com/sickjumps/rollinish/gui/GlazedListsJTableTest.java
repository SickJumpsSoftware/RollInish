package com.sickjumps.rollinish.gui;

import ca.odell.glazedlists.BasicEventList;
import ca.odell.glazedlists.EventList;
import ca.odell.glazedlists.GlazedLists;
import ca.odell.glazedlists.gui.TableFormat;
import ca.odell.glazedlists.swing.DefaultEventTableModel;
import ca.odell.glazedlists.swing.GlazedListsSwing;
import java.util.List;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Nathan
 */
public class GlazedListsJTableTest {

    public static class Person {

        private String name;
        private int age;
        private String favoriteFood;

        public Person(String name, int age, String favoriteFood) {
            this.name = name;
            this.age = age;
            this.favoriteFood = favoriteFood;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getFavoriteFood() {
            return favoriteFood;
        }

        public void setFavoriteFood(String favoriteFood) {
            this.favoriteFood = favoriteFood;
        }
    }

    public static class PersonTableModel extends AbstractTableModel {

        private final List<Person> persons;

        public PersonTableModel(List<Person> persons) {
            this.persons = persons;
        }

        @Override
        public int getRowCount() {
            return persons.size();
        }

        @Override
        public int getColumnCount() {
            return 3;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Person p = this.persons.get(rowIndex);

            switch (columnIndex) {
                case 0:
                    return p.name;
                case 1:
                    return p.age;
                case 2:
                    return p.favoriteFood;
                default:
                    throw new RuntimeException();
            }
        }
    }

    private final static String[] names = new String[]{"nathan", "jay", "eddie", "john", "andy", "jake"};
    private final static int[] ages = new int[]{29, 28, 30, 32, 0, 28};
    private final static String[] foods = new String[]{"pizza", "turkey burger", "chinese food", "meatloaf", "unknown", "cheesesteak"};

    public static void main(String[] args) throws Exception {
        EventList<Person> persons = GlazedListsSwing.swingThreadProxyList(new BasicEventList<>());

        TableFormat<Person> format = GlazedLists.tableFormat(Person.class, new String[]{"name", "age", "favoriteFood"}, new String[]{"Name", "Age", "Favorite Food"});

        JFrame frame = new JFrame("model test");
        JTable table = new JTable(new DefaultEventTableModel(persons, format));
        JScrollPane pane = new JScrollPane(table);
        table.setFillsViewportHeight(true);

        frame.add(pane);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        for (int i = 0; i < names.length; i++) {
            persons.add(new Person(names[i], ages[i], foods[i]));
            Thread.sleep(1000);
        }

        Thread.sleep(1000);

        Random dice = new Random();
        while (persons.size() > 0) {
            int index = dice.nextInt(persons.size());
            persons.remove(index);
            Thread.sleep(1000);
        }
    }
}
