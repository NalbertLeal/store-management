import '../entities/sell.dart';

abstract class SellRepositoryInter {
  Future<Sell> create(Sell sell);
}