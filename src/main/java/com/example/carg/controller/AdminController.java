//package com.example.carg.controller;
//
//import com.example.carg.dto.ProductDTO;
//import com.example.carg.model.Category;
//import com.example.carg.model.Product;
//import com.example.carg.service.CategoryService;
//import com.example.carg.service.ProductService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Optional;
//
//@Controller
//@RequestMapping("/admin")
//public class AdminController {
//    @Autowired
//    CategoryService categoryService;
//    @Autowired
//    ProductService productService;
//    @GetMapping("/")
//    public String home(){
//        return "admin/home";
//    }
//    @GetMapping("/admin/categories")
//    public String getCat(Model model){//retrive category in homepage
//        model.addAttribute("categories",categoryService.getAllCategory());
//        return "categories";
//    }
//
//    @GetMapping("/admin/categories/add")
//    public String getCatAdd(Model model) {
//        model.addAttribute("category",new Category());
//        return "categories";
//    }
//    @PostMapping("/admin/categories/add")
//    public String postCatAdd(@ModelAttribute("category")Category category) {
//        categoryService.addCategory(category);
//        return "redirect:/admin/home";
//    }
//    @GetMapping("/admin/categories/delete/{id}")
//    public String deleteCat(@PathVariable int id){
//        categoryService.removecategoryById(id);
//        return "redirect:/admin/categories";
//
//    }
//    @GetMapping("/admin/categories/update/{id}")
//    public String updateCat(@PathVariable int id, Model model) {
//        Optional<Category> category = categoryService.getCategoryById(id);
//        if (category.isPresent()) {
//            model.addAttribute("category", category.get());
//            return "categoriesAdd";
//        } else {
//            return "404";
//        }
//
//    }
//
//    //product section
//    @GetMapping("/admin/products")
//    public String products(Model model) {
//        model.addAttribute("products",productService.getAllProduct());
//        return "products";
//    }
//    @GetMapping("/admin/products/add")
//    public String productAddGet(Model model) {
//        model.addAttribute("productDTO",new ProductDTO());
//        model.addAttribute("categories",categoryService.getAllCategory());
//        return "productsAdd";
//    }
//    @PostMapping("/admin/products/add")
//    public String productAddPost(@ModelAttribute("productDTO") ProductDTO productDTO){
//        Product product=new Product();
//        product.setId(productDTO.getId());
//        product.setName1(productDTO.getName());
//        product.setCategory(categoryService.getCategoryById(productDTO.getCategoryId()).get());
//        product.setPrice(productDTO.getPrice());
//        productDTO.setDescription(productDTO.getDescription());
//        productService.addProduct( product);
//
//        return  "redirect:/admin/products";
//    }
//
//}
//
package com.example.carg.controller;

import com.example.carg.dto.ProductDTO;
import com.example.carg.model.Category;
import com.example.carg.model.Product;
import com.example.carg.service.CategoryService;
import com.example.carg.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class AdminController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;
    @GetMapping("/admin")
    public String adminHome(){
        return "admin/home";
    }
    @GetMapping("/admin/categories")
    public String getCat(Model model){//retrive category in homepage
        model.addAttribute("categories",categoryService.getAllCategory());
        return "categories";
    }

    @GetMapping("/admin/categories/add")
    public String getCatAdd(Model model) {
        model.addAttribute("category",new Category());
        return "categoriesADD";
    }
    @PostMapping("/admin/categories/add")
    public String postCatAdd(@ModelAttribute("category")Category category) {
        categoryService.addCategory(category);
        return "redirect:/admin/categories";
    }
    @GetMapping("/admin/categories/delete/{id}")
    public String deleteCat(@PathVariable int id){
        categoryService.removecategoryById(id);
        return "redirect:/admin/categories";

    }
    @GetMapping("/admin/categories/update/{id}")
    public String updateCat(@PathVariable int id, Model model) {
        Optional<Category> category = categoryService.getCategoryById(id);
        if (category.isPresent()) {
            model.addAttribute("category", category.get());
            return "categoriesADD";
        } else {
            return "404";
        }

    }

    //product section
    @GetMapping("/admin/products")
    public String products(Model model) {
        model.addAttribute("products",productService.getAllProduct());
        return "products";
    }
    @GetMapping("/admin/products/add")
    public String productAddGet(Model model) {
        model.addAttribute("productDTO",new ProductDTO());
        model.addAttribute("categories",categoryService.getAllCategory());
        return "productsAdd";
    }
    @PostMapping("/admin/products/add")
    public String productAddPost(@ModelAttribute("productDTO")ProductDTO productDTO){
        Product product=new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setCategory(categoryService.getCategoryById(productDTO.getCategoryId()).get());
        product.setPrice(productDTO.getPrice());
        productDTO.setDescription(productDTO.getDescription());
        productService.addProduct( product);

        return  "redirect:/admin/products";
    }
    @GetMapping("/admin/product/delete/{id}")
    public String deletePro(@PathVariable int id){
        productService.removeProductById(id);
        return "redirect:/admin/products";

    }
//    @GetMapping("/admin/product/update/{id}")
//    public String updatePro(@PathVariable int id, Model model) {
//        Optional<Product> product = productService.getProductById(id);
//        if (product.isPresent()) {
//            model.addAttribute("product", product.get());
//            return "productsAdd";
//        } else {
//            return "404";
//        }

//    }


}

