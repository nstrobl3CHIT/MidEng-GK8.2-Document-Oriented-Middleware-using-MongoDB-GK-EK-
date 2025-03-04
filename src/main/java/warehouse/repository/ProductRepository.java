package warehouse.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import warehouse.model.ProductData;

import java.util.List;

public interface ProductRepository extends MongoRepository<ProductData, String> {

    ProductData findByProductID(String productID);
    List<ProductData> findByWarehouseID(String warehouseID);

    // Neue Methode, um Produkte nach Produktkategorie zu finden
    List<ProductData> findByProductCategory(String productCategory);
}
