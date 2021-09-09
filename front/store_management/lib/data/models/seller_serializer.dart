import '../../domain/entities/seller.dart';

class SellerSerializer {
  static Seller fromMap(Map m) {
    return Seller(
      m['fullname'],
      m['email'],
      m['password'],
      double.parse(m['salary']),
      m['managerEmail'],
      id: int.parse(m['id']),
    );
  }

  static Map toMap(Seller seller) {
    final m = {
      'fullname': seller.fullname,
      'email': seller.email,
      'password': seller.password,
      'salary': seller.salary,
      'managerEmail': seller.managerEmail,
    };
    if (seller.id > -1) m['id'] = seller.id;
    return m;
  }
}
