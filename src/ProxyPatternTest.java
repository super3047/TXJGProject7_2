public class ProxyPatternTest {
    public static void main(String[] args) {
        // 创建真实对象
        ProductDao productDao = new ProductDaoImpl();

        // 创建代理对象
        ProductCacheProxy proxy = new ProductCacheProxy(productDao);

        System.out.println("第一次查询id=1（应该查数据库）");
        System.out.println(proxy.findById(1));

        System.out.println("\n第二次查询id=1（应该从缓存获取）");
        System.out.println(proxy.findById(1));

        System.out.println("\n查询id=2（应该查数据库）");
        System.out.println(proxy.findById(2));

        System.out.println("\n再次查询id=2（应该从缓存获取）");
        System.out.println(proxy.findById(2));

        System.out.println("\n查询不存在的id=4");
        System.out.println(proxy.findById(4));

        // 测试清空缓存
        proxy.clearCache();

        System.out.println("\n清空缓存后查询id=1（应该查数据库）");
        System.out.println(proxy.findById(1));
    }
}

