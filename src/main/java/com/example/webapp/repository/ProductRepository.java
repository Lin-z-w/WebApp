package com.example.webapp.repository;

import com.example.webapp.model.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProductRepository {

    @Select("SELECT * FROM products")
    List<Product> getAllProducts();

    @Select("SELECT * FROM products WHERE id = #{productId}")
    Product getProductById(@Param("productId") String productId);

    @Insert("INSERT INTO products (id, price, category, quantity, name, stock, img) " +
            "VALUES (#{id}, #{price}, #{category}, #{quantity}, #{name}, #{stock}, #{img})")
    void addProduct(Product product);

    @Update("UPDATE products SET quantity = #{quantity} WHERE id = #{id}")
    void updateProductQuantity(Product product);

    @Select("SELECT * FROM products WHERE name LIKE CONCAT('%', #{name}, '%')")
    List<Product> findByNameContaining(@Param("name") String name);

//    @Select("<script>" +
//            "SELECT * FROM products WHERE id IN " +
//            "<foreach item='item' index='index' collection='productIds' open='(' separator=',' close=')'>" +
//            "#{item}" +
//            "</foreach>" +
//            "for update" +
//            "</script>")
//    List<Product> getProductByIds(List<String> productIds);


    @Select("SELECT * FROM products WHERE category = #{categoryName}")
    List<Product> getProductsByCategory(String categoryName);

}
