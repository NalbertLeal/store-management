import 'package:flutter/material.dart';

import 'package:store_management/data/repositories/manager_repository.dart';
import 'package:store_management/domain/entities/manager.dart';
import 'package:store_management/domain/use_cases/register_manager.dart';
import 'package:store_management/presentation/user/pages/create_manager.dart';

class MainPage extends StatelessWidget {
  const MainPage({Key? key}) : super(key: key);

  void goToCreateManager(BuildContext context) {
    Navigator.of(context).pushNamed(CreateManager.route);
  }

  void goToCreateSeller(BuildContext context) {
    Navigator.of(context).pushNamed(CreateManager.route);
  }

  @override
  Widget build(BuildContext context) {
    final width = MediaQuery.of(context).size.width;
    final height = MediaQuery.of(context).size.height;

    ManagerRepositoryImpl managerRepositoryImpl = ManagerRepositoryImpl();
    RegisterManager registerManager = RegisterManager(managerRepositoryImpl);

    Manager manager = Manager(
      "Nalbert gabriel Melo Leal",
      "nalbertrn@yahoo.com",
      "123456",
      4000,
    );

    return Scaffold(
      appBar: AppBar(),
      body: Container(
          width: width,
          height: height,
          child: Column(
            children: [
              SizedBox(
                width: width,
                height: height * .07,
              ),
              ElevatedButton(
                onPressed: () => goToCreateManager(context),
                child: Text('Create manager'),
              ),
              SizedBox(
                width: width,
                height: height * .07,
              ),
              ElevatedButton(
                onPressed: () => goToCreateSeller(context),
                child: Text('Create seller'),
              ),
            ],
          )),
    );
  }
}
