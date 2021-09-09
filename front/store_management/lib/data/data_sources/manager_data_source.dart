import 'dart:convert';

import 'package:http/http.dart';
import '../../exceptions/http_create_manager_error.dart';
import '../models/manager_serializer.dart';
import '../../domain/entities/manager.dart';

class ManagerDataSource {
  static Future<Manager> createManager(Manager manager) async {
    Uri url = Uri.parse('http://localhost:8081/manager');
    Response response = await post(
      url,
      headers: <String, String>{
        'Content-Type': 'application/json; charset=UTF-8',
      },
      body: ManagerSerializer.toMap(manager),
    );
    print(response.body);
    if (response.statusCode != 200) throw HttpCreateManagerError();
    var data = response.body;
    Map m = jsonDecode(data);
    return ManagerSerializer.fromMap(m);
  }
}
