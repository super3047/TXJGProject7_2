import java.util.HashMap;
import java.util.Map;

public class ProductCacheProxy implements ProductDao {
    private ProductDao target;
    private Map<Integer, Product> cache;

    public ProductCacheProxy(ProductDao target) {
        this.target = target;
        this.cache = new HashMap<>();
    }

    @Override
    public Product findById(int id) {
        // 先检查缓存
        if (cache.containsKey(id)) {
            System.out.println("从缓存获取商品id=" + id);
            return cache.get(id);
        }

        // 缓存中没有，调用真实对象查询
        Product product = target.findById(id);

        // 将查询结果存入缓存
        if (product != null) {
            cache.put(id, product);
        }

        return product;
    }

    // 可选：清除缓存的方法
    public void clearCache() {
        cache.clear();
        System.out.println("缓存已清空");
    }
}