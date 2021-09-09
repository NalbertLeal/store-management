import 'package:store_management/domain/entities/manager.dart';
import 'package:store_management/domain/repositories/manager_repository.dart';

class RegisterManager {
  final ManagerRepositoryInter managerRepository;

  RegisterManager(this.managerRepository);

  Future<Manager> execute(Manager manager) async {
    return managerRepository.create(manager);
  }
}
