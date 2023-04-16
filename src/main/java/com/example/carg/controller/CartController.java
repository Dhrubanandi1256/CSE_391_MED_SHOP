package com.example.carg.controller;
import com.example.carg.global.GlobalData;
import com.example.carg.model.Product;
import com.example.carg.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CartController {

    @Autowired
    ProductService productService;
    @GetMapping("/addToCart/{id}")
    public String addToCart(@PathVariable String id){
        GlobalData.cart.add(productService.getProductById(Integer.parseInt(id)).get());
        System.out.println(GlobalData.cart.get(0));
        return "redirect:/cart";
    }
    @GetMapping("/cart")
    public String cartGet(Model model) {
        model.addAttribute("cartCount", GlobalData.cart.size());
        model.addAttribute("total", GlobalData.cart.stream().mapToDouble(Product::getPrice).sum());
        model.addAttribute("cart",GlobalData.cart);
        return "cart";
    }
    @GetMapping("/cart/removeitem/{index}")
    public String cartItemRemove(@PathVariable String index){
        for (int i=0;i<GlobalData.cart.size();i++){
            if (GlobalData.cart.get(i).getId()==Integer.parseInt(index )){
                GlobalData.cart.remove(i);
            }
        }
        //GlobalData.cart.remove(Integer.parseInt(index));
        return "redirect:/cart";
    }
    @GetMapping("/checkout")
    public String checkoutItem(Model model){
//       model.addAttribute("total", GlobalData.cart.stream().mapToDouble(Product::getPrice).sum());
        model.addAttribute("total",GlobalData.cart.stream().mapToDouble(Product::getPrice).sum());
        return "checkout";
    }

}
