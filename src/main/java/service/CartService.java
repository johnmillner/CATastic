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
    return uuid;
  }

  public Cart getCart(String cartId) throws IOException {
    if(!carts.containsKey(cartId)) {
      throw new IOException("cart Id was not found: "+cartId);
    }
    return carts.get(cartId);
  }
}
