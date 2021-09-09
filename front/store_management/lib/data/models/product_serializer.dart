import '../../domain/entities/product.dart';

class ProductSerializer {
  static Product fromMap(Map m) {
    return Product(
      m['name'],
      double.parse(m['price']),
      int.parse(m['stock']),
      m['description'],
      id: int.parse(m['id']),
    );
  }

  static Map toMap(Product product) {
    final m = {
      'name': product.name,
      'price': product.price,
      'stock': product.stock,
      'description': product.description,
    };
    if (product.id > -1) m['id'] = product.id;
    return m;
  }
}
