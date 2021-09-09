import '../entities/seller.dart';

abstract class SellerRepositoryInter {
  Future<Seller> create(Seller seller);
}