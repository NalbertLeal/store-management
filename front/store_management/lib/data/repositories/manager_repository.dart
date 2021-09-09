import '../data_sources/manager_data_source.dart';
import '../../domain/repositories/manager_repository.dart';
import '../../domain/entities/manager.dart';

class ManagerRepositoryImpl implements ManagerRepositoryInter {
  Future<Manager> create(Manager manager) async {
    return ManagerDataSource.createManager(manager);
  }
}
