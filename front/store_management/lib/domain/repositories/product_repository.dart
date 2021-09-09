import '../entities/product.dart';

abstract class ProductRepositoryInter {
  Future<Product> getAll();
  Future<Product> create(Product product);
}