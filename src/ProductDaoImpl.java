public class ProductDaoImpl implements ProductDao {
    @Override
    public Product findById(int id) {
        // 模拟数据库查询
        System.out.println("查询数据库获取商品id=" + id);

        // 这里应该是真实的数据库查询，我们模拟返回结果
        switch(id) {
            case 1: return new Product(1, "iPhone", 9999.0);
            case 2: return new Product(2, "MacBook", 12999.0);
            case 3: return new Product(3, "iPad", 4999.0);
            default: return null;
        }
    }
}