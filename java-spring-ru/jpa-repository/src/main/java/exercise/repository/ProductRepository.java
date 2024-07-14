package exercise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import exercise.model.Product;

import org.springframework.data.domain.Sort;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // BEGIN
    @Query("SELECT p FROM Product p WHERE p.price <= %:price%")
    List<Product> findByPriceLessThanEqualAndSort(@Param("price") int price, Sort sort);

    @Query("SELECT p FROM Product p WHERE p.price >= %:price%")
    List<Product> findByPriceGreaterThanEqualAndSort(@Param("price") int price, Sort sort);

    @Query("SELECT p FROM Product p WHERE p.price >= %:startPrice% AND p.price <= %:endPrice%")
    List<Product> findByPriceBetweenAndSort(@Param("startPrice") int startPrice,
                                            @Param("endPrice") int endPrice,
                                            Sort sort);
    // END
}
