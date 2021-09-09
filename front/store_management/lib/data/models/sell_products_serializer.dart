import '../../domain/entities/sell_products.dart';

class SellProductsSerializer {
  static SellProducts fromMap(Map m) {
    return SellProducts(
      int.parse(m['sellId']),
      int.parse(m['productId']),
      id: int.parse(m['id']),
    );
  }

  static Map toMap(SellProducts sellProducts) {
    final m = {
      'sellId': sellProducts.sellId,
      'productId': sellProducts.productId,
    };
    if (sellProducts.id > -1) m['id'] = sellProducts.id;
    return m;
  }
}
