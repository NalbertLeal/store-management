import '../entities/manager.dart';

abstract class ManagerRepositoryInter {
  Future<Manager> create(Manager manager);
}
