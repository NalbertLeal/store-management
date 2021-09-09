import '../../domain/entities/manager.dart';

class ManagerSerializer {
  static Manager fromMap(Map m) {
    return Manager(
      m['fullname'],
      m['email'],
      m['password'],
      double.parse(m['salary']),
      id: int.parse(m['id']),
    );
  }

  static Map toMap(Manager manager) {
    final m = {
      'fullname': manager.fullname,
      'email': manager.email,
      'password': manager.password,
      'salary': manager.salary.toString(),
    };
    if (manager.id > -1) m['id'] = manager.id.toString();
    return m;
  }
}
