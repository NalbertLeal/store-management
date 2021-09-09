class Sell {
  final int id;
  final double amount;
  final String sellerEmail;

  Sell(
    this.amount,
    this.sellerEmail, {
    this.id = -1,
  });
}
