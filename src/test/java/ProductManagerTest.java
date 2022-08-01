import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {
    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    Product book1 = new Book(1,"1984", 900, "Джодж Оруэлл");
    Product smartphone1 = new Smartphone(2, "iPhone 6s", 10_000, "Apple");
    Product book2 = new Book(3,"Убить пересмешника", 600, "Харпер Ли");
    Product book3 = new Book(4,"1984", 200,"Джордж Оруэлл");

    @Test
    public void shouldAddProduct() {

        manager.add(book1);
        manager.add(smartphone1);
        manager.add(book2);

        Product[] expected = {book1, smartphone1, book2};
        Product[] actual = repo.getProducts();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldShowMatches() {

        manager.add(book1);
        manager.add(smartphone1);
        manager.add(book2);
        manager.matches(book1,"1984");

        boolean expected = true;
        boolean actual = true;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldShowNotMatches() {

        manager.add(book1);
        manager.add(smartphone1);
        manager.add(book2);
        manager.matches(book1,"Убить пересмешника");

        boolean expected = false;
        boolean actual = false;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSearchBy() {

        manager.add(book1);
        manager.add(smartphone1);
        manager.add(book2);
        manager.add(book3);

        Product[] expected = {book1,book3};
        Product[] actual = manager.searchBy("1984");

        Assertions.assertArrayEquals(expected, actual);
    }
}
