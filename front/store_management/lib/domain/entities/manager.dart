class Manager {
  final int id;
  final String fullname;
  final String email;
  final String password;
  final double salary;

  Manager(
    this.fullname,
    this.email,
    this.password,
    this.salary, {
    this.id = -1,
  });
}
