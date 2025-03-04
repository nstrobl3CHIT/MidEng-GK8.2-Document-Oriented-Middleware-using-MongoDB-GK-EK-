package warehouse.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import warehouse.model.ProductData;
import warehouse.model.WarehouseData;

import java.util.List;

public interface WarehouseRepository extends MongoRepository<ProductData, String> {
    public ProductData findByProductID(String productID);
    public List<ProductData> findByWarehouseID(String warehouseID);
}
