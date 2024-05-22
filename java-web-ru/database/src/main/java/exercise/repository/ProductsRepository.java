package exercise.repository;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import exercise.model.Product;

import java.sql.SQLException;
import java.sql.Statement;

public class ProductsRepository extends BaseRepository {

    // BEGIN
    public static void save(Product product) throws SQLException {
        //Пишем шаблон SQL-запроса
        String sql = "INSERT INTO products (title, price) VALUES (?, ?)";
        //Создаем соединение, формируем стейтмент
        try (var conn = dataSource.getConnection();
                var stmt = conn.prepareStatement(sql,
                        Statement.RETURN_GENERATED_KEYS)) {
            //Делаем подстановки в запрос
            stmt.setString(1, product.getTitle());
            stmt.setInt(2, product.getPrice());
            //Выполняем запрос по добавлению нового автомобиля в базу
            stmt.executeUpdate();

            //Достаем auto generated keys, в нашем случае это поле id
            var generatedKeys = stmt.getGeneratedKeys();
            //Итерируемся по строчкам результата SQL-запроса
            if (generatedKeys.next()) {
                //База сгенерировала ID, достаем его из базы и сохраняем в объекте
                product.setId(generatedKeys.getLong(1));
            } else {
                throw new SQLException("DB have not returned an id after saving an entity");
            }
        }
    }

        public static Optional<Product> find(Long id) throws SQLException {
            String sql = "SELECT * FROM products WHERE id = ?";
            try (var conn = dataSource.getConnection();
                 var stmt = conn.prepareStatement(sql)) {
                stmt.setLong(1, id);
                //Выполняем SQL-запрос и сохраняем ответ в переменную
                var resultSet = stmt.executeQuery();
                //Итерируемся по ответу базы
                if (resultSet.next()) {
                    //Получаем параметры объекта из базы
                    String title = resultSet.getString("title");
                    int price = resultSet.getInt("price");
                    //Сохраняем их в объект приложения
                    Product product = new Product(title, price);
                    product.setId(id);
                    return Optional.of(product);
                }
            }
            return Optional.empty();
        }

        public static List<Product> getEntities() throws SQLException {
            String sql = "SELECT * FROM products";
            try (var conn = dataSource.getConnection();
                 var stmt = conn.prepareStatement(sql)) {
                var resultSet = stmt.executeQuery();

                List<Product> result = new ArrayList<>();

                if (resultSet.next()) {
                    Long id = resultSet.getLong("id");
                    String title = resultSet.getString("title");
                    int price = resultSet.getInt("price");
                    Product product = new Product(title, price);
                    product.setId(id);
                    result.add(product);
                }
                return result;
            }
        }
    // END
}
