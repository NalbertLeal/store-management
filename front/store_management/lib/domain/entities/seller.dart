class Seller {
  final int id;
  final String fullname;
  final String email;
  final String password;
  final double salary;
  final String managerEmail;

  Seller(
    this.fullname,
    this.email,
    this.password,
    this.salary,
    this.managerEmail, {
    this.id = -1,
  });
}
