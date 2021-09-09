import 'package:flutter/material.dart';
import 'package:store_management/presentation/core/page/main_page.dart';
import 'package:store_management/presentation/user/pages/create_manager.dart';

class MainWidget extends StatelessWidget {
  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Store Manager',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: MainPage(),
      routes: {
        CreateManager.route: (_) => CreateManager(),
      },
    );
  }
}
