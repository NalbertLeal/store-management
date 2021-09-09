import '../../domain/repositories/sell_repository.dart';
import '../../domain/entities/sell.dart';

abstract class SellRepositoryImpl implements SellRepositoryInter {
  Future<Sell> create(Sell sell) async {}
}
