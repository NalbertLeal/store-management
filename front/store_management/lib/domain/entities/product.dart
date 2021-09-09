class Product {
  final int id;
  final String name;
  final double price;
  final int stock;
  final String description;

  Product(
    this.name,
    this.price,
    this.stock,
    this.description, {
    this.id = -1,
  });
}
