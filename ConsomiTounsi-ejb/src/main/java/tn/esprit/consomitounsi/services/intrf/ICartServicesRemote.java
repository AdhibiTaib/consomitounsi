package tn.esprit.consomitounsi.services.intrf;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.consomitounsi.entities.Cart;
import tn.esprit.consomitounsi.entities.Product;
import tn.esprit.consomitounsi.entities.User;


@Remote
public interface ICartServicesRemote {
	public int addCart(Cart cart);
	public void removeCart(int id);
	public void updateCart(Cart cart);
	public List<Cart> findCartByUserId(int id);
	public List<Cart> findAllCarts();
	public boolean isCartAvailaible(User user);
	public void addProdCart(User user,Product prod);
	public Cart findActiveCartByUserId(User user);
	public List<Product> getCurrUserProds(User user);
}
