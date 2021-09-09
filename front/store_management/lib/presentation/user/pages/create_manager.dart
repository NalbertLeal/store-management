import 'package:flutter/material.dart';
import 'package:store_management/data/repositories/manager_repository.dart';
import 'package:store_management/domain/entities/manager.dart';
import 'package:store_management/domain/use_cases/register_manager.dart';

class CreateManager extends StatelessWidget {
  static final String route = '/create-manager';

  const CreateManager({Key? key}) : super(key: key);

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
        child: FutureBuilder(
          future: registerManager.execute(manager),
          builder: (BuildContext ctx, AsyncSnapshot<Manager> snapshot) {
            if (snapshot.connectionState != ConnectionState.done) {
              return Container(
                width: width / 2,
                height: width / 2,
                child: CircularProgressIndicator(),
              );
            }

            print(snapshot.data);

            if (!snapshot.hasData) {
              return Center(
                child: SelectableText('Ocorreu um erro!!!'),
              );
            }

            Manager managerFromAPI = snapshot.data!;

            return Center(
              child: SelectableText(
                  '${managerFromAPI.fullname}\n ${managerFromAPI.email}'),
            );
          },
        ),
      ),
    );
  }
}
