import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class ProductStockTest {
    ProductStock productStock;

    @Before
    public void init() {
        this.productStock = new Instock();
    }

    @Test
    public void addOneProductShouldIncreaseSize() {
        int count = 1;
        List<Product> products = createProducts(count);

        for (Product product : products) {
            productStock.add(product);
        }

        Assert.assertEquals(count, this.productStock.getCount());
    }

    @Test
    public void addTenProductsShouldIncreaseSize() {
        int count = 10;
        List<Product> products = createProducts(count);

        for (Product product : products) {
            productStock.add(product);
        }

        Assert.assertEquals(products.size(), this.productStock.getCount());
    }

    @Test
    public void addShouldContainsCorrectReference() {
        Product product = createProducts(1).get(0);
        productStock.add(product);

        Assert.assertTrue(this.productStock.contains(product));
    }

    @Test
    public void containsShouldReturnTrueIfProductExist() {
        int count = 10;
        List<Product> products = createProducts(count);

        for (Product product : products) {
            productStock.add(product);
        }

        Product lastProduct = products.get(products.size() - 1);
        Assert.assertTrue(this.productStock.contains(lastProduct));
    }

    @Test
    public void containsShouldReturnFalseIfProductNotExist() {
        Product product = createProducts(1).get(0);

        Assert.assertFalse(this.productStock.contains(product));
    }

    @Test
    public void getCountShouldReturnZeroIfCollectionIsEmpty() {
        Assert.assertEquals(0, productStock.getCount());
    }

    @Test
    public void changeQuantityShouldChangeTheQuantityCorrectlyOfTheGivenProduct() {
        Product product = createProducts(1).get(0);
        this.productStock.add(product);
        this.productStock.changeQuantity(product.getLabel(), 0);
        Assert.assertEquals(0, product.getQuantity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void changeQuantityShouldThrowExceptionIfGivenProductNotExist() {
        Product product = createProducts(1).get(0);

        this.productStock.changeQuantity(product.getLabel(), 0);
        Assert.assertEquals(0, product.getQuantity());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void findShouldThrowException() {
        this.productStock.find(this.productStock.getCount());
    }

    @Test
    public void findShouldReturnCorrectProductByIndex() {
        Product product = this.createProducts(1).get(0);
        this.productStock.add(product);

        Assert.assertEquals(product, this.productStock.find(0));
    }

    @Test
    public void findByLabelShouldReturnCorrectReference() {
        Product product = this.createProducts(1).get(0);
        this.productStock.add(product);

        Assert.assertEquals(product, this.productStock.findByLabel(product.getLabel()));
    }

    @Test(expected = IllegalArgumentException.class)
    public void findByLabelShouldThrowExceptionIfNotExist() {
        Product product = this.createProducts(1).get(0);

        Assert.assertEquals(product, this.productStock.findByLabel(product.getLabel()));
    }

    @Test
    public void findFirstByAlphabeticalOrderShouldReturnCorrectOrder() {
        List<Product> products = this.createProducts(3);
        products.get(0).setLabel("A");
        products.get(1).setLabel("B");
        products.get(2).setLabel("C");

        products.forEach(p -> this.productStock.add(p));

        Iterable<Product> firstByAlphabeticalOrder = this.productStock.findFirstByAlphabeticalOrder(3);

        List<Product> foundProductStock = new ArrayList<>();
        firstByAlphabeticalOrder.forEach(foundProductStock::add);

        Assert.assertArrayEquals(products.toArray(), foundProductStock.toArray());
    }

    @Test
    public void findFirstByAlphabeticalOrderShouldReturnEmptyCollectionWithIllegalArgument() {
        List<Product> products = this.createProducts(3);
        products.get(0).setLabel("A");
        products.get(1).setLabel("B");
        products.get(2).setLabel("C");

        products.forEach(p -> this.productStock.add(p));

        Iterable<Product> firstByAlphabeticalOrder = this.productStock.findFirstByAlphabeticalOrder(6);
        List<Product> foundProductStock = new ArrayList<>();
        firstByAlphabeticalOrder.forEach(foundProductStock::add);


        Product[] expected = new Product[0];

        Assert.assertArrayEquals(expected, foundProductStock.toArray());
    }

    @Test
    public void findFirstByAlphabeticalOrderShouldReturnEmptyCollection() {
        Product[] expected = new Product[0];

        Iterable<Product> firstByAlphabeticalOrder = this.productStock.findFirstByAlphabeticalOrder(3);
        List<Product> foundProductStock = new ArrayList<>();
        firstByAlphabeticalOrder.forEach(foundProductStock::add);

        Assert.assertArrayEquals(expected, foundProductStock.toArray());
    }

    @Test
    public void getIterableShouldReturnAllProducts() {
        List<Product> products = this.createProducts(20);
        products.forEach(p -> this.productStock.add(p));

        final Iterator<Product> productIterator = this.productStock.iterator();
        Iterable<Product> productIterable = () -> productIterator;

        List<Product> allProducts = new ArrayList<>();
        productIterable.forEach(allProducts::add);

        Assert.assertArrayEquals(products.toArray(), allProducts.toArray());
    }

    @Test
    public void findAllByQuantity() {
        List<Product> products = this.createProducts(3);
        products.get(0).setQuantity(10);
        products.get(1).setQuantity(10);
        products.get(2).setQuantity(10);

        products.forEach(p -> this.productStock.add(p));

        Iterable<Product> allByQuantity = this.productStock.findAllByQuantity(10);
        List<Product> foundAllByQuantity = new ArrayList<>();
        allByQuantity.forEach(foundAllByQuantity::add);

        Assert.assertArrayEquals(products.toArray(), foundAllByQuantity.toArray());
    }

    @Test
    public void findAllByQuantityShouldReturnEmptyCollection() {
        List<Product> products = this.createProducts(3);
        products.get(0).setQuantity(10);
        products.get(1).setQuantity(10);
        products.get(2).setQuantity(10);

        products.forEach(p -> this.productStock.add(p));

        Iterable<Product> allByQuantity = this.productStock.findAllByQuantity(20);
        List<Product> foundAllByQuantity = new ArrayList<>();
        allByQuantity.forEach(foundAllByQuantity::add);

        Product[] expected = new Product[0];

        Assert.assertArrayEquals(expected, foundAllByQuantity.toArray());
    }

    @Test
    public void findFirstMostExpensiveProducts() {
        int count = 10;
        final List<Product> products = createProducts(count);

        for (Product product : products) {
            productStock.add(product);
        }

        List<Product> treeProductWithHighestPrice = products.stream()
                .sorted((p1, p2) -> Double.compare(p2.getPrice(), p1.getPrice()))
                .limit(3)
                .collect(Collectors.toList());

        Iterable<Product> firstMostExpensiveProducts = productStock.findFirstMostExpensiveProducts(3);
        List<Product> findFirstMostExpensiveToArray = new ArrayList<>();
        firstMostExpensiveProducts.forEach(findFirstMostExpensiveToArray::add);

        Assert.assertEquals(treeProductWithHighestPrice, findFirstMostExpensiveToArray);
    }

    @Test(expected = IllegalArgumentException.class)
    public void findFirstMostExpensiveProductsThrowExceptionIfCountIsLess() {
        Iterable<Product> firstMostExpensiveProducts = productStock.findFirstMostExpensiveProducts(1);
    }

    @Test
    public void findAllByPriceShouldReturnAllProductByGivenPrice() {
        List<Product> products = this.createProducts(3);
        products.get(0).setPrice(10);
        products.get(1).setPrice(10);
        products.get(2).setPrice(10);

        products.forEach(p -> this.productStock.add(p));

        Iterable<Product> allByPrice = this.productStock.findAllByPrice(10);
        List<Product> foundAllByPrice = new ArrayList<>();
        allByPrice.forEach(foundAllByPrice::add);

        Assert.assertArrayEquals(products.toArray(), foundAllByPrice.toArray());
    }

    @Test
    public void findAllByPriceShouldReturnEmptyCollection() {
        List<Product> products = this.createProducts(3);
        products.get(0).setPrice(10);
        products.get(1).setPrice(10);
        products.get(2).setPrice(10);

        products.forEach(p -> this.productStock.add(p));

        Iterable<Product> allByPrice = this.productStock.findAllByPrice(20);
        List<Product> foundAllByPrice = new ArrayList<>();
        allByPrice.forEach(foundAllByPrice::add);

        Product[] expected = new Product[0];

        Assert.assertArrayEquals(expected, foundAllByPrice.toArray());
    }

    @Test
    public void findAllInPriceRangeShouldReturnAllProductCorrectly() {
        List<Product> products = this.createProducts(3);
        products.get(0).setPrice(6);
        products.get(1).setPrice(13);
        products.get(2).setPrice(15);

        products.forEach(p -> this.productStock.add(p));

        Iterable<Product> allInPriceRange = this.productStock.findAllInPriceRange(5, 15);
        List<Product> foundAllInPriceRange = new ArrayList<>();
        allInPriceRange.forEach(foundAllInPriceRange::add);

        Assert.assertArrayEquals(foundAllInPriceRange.toArray(), foundAllInPriceRange.toArray());
    }

    @Test
    public void findAllInPriceRangeShouldReturnEmptyCollection() {
        List<Product> products = this.createProducts(3);
        products.get(0).setPrice(6);
        products.get(1).setPrice(13);
        products.get(2).setPrice(15);

        products.forEach(p -> this.productStock.add(p));

        Iterable<Product> allInPriceRange = this.productStock.findAllInPriceRange(20, 22);
        List<Product> foundAllInPriceRange = new ArrayList<>();
        allInPriceRange.forEach(foundAllInPriceRange::add);

        Product[] expected = new Product[0];

        Assert.assertArrayEquals(expected, foundAllInPriceRange.toArray());
    }

    private List<Product> createProducts(int count) {
        List<Product> products = new ArrayList<>();

        while (count > 0) {
            Product product = new Product(UUID.randomUUID().toString(), 12.5 * count, 10 * count);
            products.add(product);
            count--;
        }
        return products;
    }
}