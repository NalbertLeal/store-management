import '../../domain/repositories/product_repository.dart';
import '../../domain/entities/product.dart';

abstract class ProductRepositoryImpl implements ProductRepositoryInter {
  Future<Product> getAll() async {}
  Future<Product> create(Product product) async {}
}
