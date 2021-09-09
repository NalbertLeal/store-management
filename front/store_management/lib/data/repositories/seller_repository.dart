import '../data_sources/seller_data_source.dart';
import '../../domain/repositories/seller_repository.dart';
import '../../domain/entities/seller.dart';

class SellerRepositoryImpl implements SellerRepositoryInter {
  Future<Seller> create(Seller seller) async {
    return SellerDataSource.createSeller(seller);
  }
}
