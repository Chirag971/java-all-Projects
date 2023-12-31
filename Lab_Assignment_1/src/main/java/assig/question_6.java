/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

class Category {

    int categoryId;
    String categoryName;
    int parentCategoryId;

    Category(int categoryId, String categoryName, int parentCategoryId) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.parentCategoryId = parentCategoryId;
    }
}

public class question_6 {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/records";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "root";

    public static void main(String[] args) {
        List<Category> categories = fetchCategoriesFromDatabase();
        printCategoryTree(categories, 0, "");
    }

    public static List<Category> fetchCategoriesFromDatabase() {
        List<Category> categories = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME,
                    DB_PASSWORD);
            Statement statement = connection.createStatement();
            String query = "SELECT Category_id, Category_Name, parent_category_id FROM Category_Master";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int categoryId = resultSet.getInt("Category_id");
                String categoryName = resultSet.getString("Category_Name");
                int parentCategoryId = resultSet.getInt("parent_category_id");
                categories.add(new Category(categoryId, categoryName, parentCategoryId));
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

    public static void printCategoryTree(List<Category> categories, int parentId, String indent) {
        for (Category category : categories) {
            if (category.parentCategoryId == parentId) {
                System.out.println(indent + category.categoryName);
                printCategoryTree(categories, category.categoryId, indent + " ");
            }
        }
    }
}
