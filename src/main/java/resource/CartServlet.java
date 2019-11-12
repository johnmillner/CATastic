package resource;

import java.io.IOException;
import java.util.UUID;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Cart;
import service.CartService;

public class CartServlet extends HttpServlet {

  private static final CartService cartService = new CartService();

  @Override
  public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    resp.setContentType("text/plain");
    resp.getWriter().write(createCart().toString());
  }

  public UUID createCart() {
    return cartService.createService();
  }

  public Cart getCart(String cartId) throws IOException {
    return cartService.getCart(cartId);
  }
}
