import '../../domain/entities/sell.dart';

class SellSerializer {
  static Sell fromMap(Map m) {
    return Sell(
      double.parse(m['amount']),
      m['sellerEmail'],
      id: int.parse(m['id']),
    );
  }

  static Map toMap(Sell sell) {
    final m = {
      'amount': sell.amount,
      'sellerEmail': sell.sellerEmail,
    };
    if (sell.id > -1) m['id'] = sell.id;
    return m;
  }
}
