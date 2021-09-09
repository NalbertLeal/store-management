import 'dart:convert';

import 'package:http/http.dart';
import '../../exceptions/http_create_seller_error.dart';
import '../models/seller_serializer.dart';
import '../../domain/entities/seller.dart';

class SellerDataSource {
  static Future<Seller> createSeller(Seller seller) async {
    Uri url = Uri.parse('http://localhost:8081/seller');
    Response response = await post(
      url,
      body: SellerSerializer.toMap(seller),
    );
    if (response.statusCode != 200) throw HttpCreateSellerError();
    var data = response.body;
    Map m = jsonDecode(data);
    return SellerSerializer.fromMap(m);
  }
}
