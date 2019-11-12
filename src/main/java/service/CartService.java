package service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import models.Cart;

public class CartService {

  private static final Map<UUID, Cart> carts = new HashMap<>();

  public UUID createService() {
    UUID uuid = UUID.randomUUID();
    carts.put(uuid, new Cart());
    System.out.println("carts"+carts);
    return uuid;
  }

  public Cart getCart(String cartId) throws IOException {
    System.out.println("carts"+carts);

    return carts.get(UUID.fromString(cartId));
  }
}
