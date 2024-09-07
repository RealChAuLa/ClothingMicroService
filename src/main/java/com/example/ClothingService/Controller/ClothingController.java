package com.example.ClothingService.Controller;


import com.example.ClothingService.Data.Clothe;
import com.example.ClothingService.Service.ClothingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
public class ClothingController {

        @Autowired
        private ClothingService clothingService;

        @ApiIgnore
        @RequestMapping(value = "/")
        public void redirect(HttpServletResponse response) throws IOException {
            response.sendRedirect("/swagger-ui.html");
        }

        @GetMapping(path = "/clothes")
        public List<Clothe> getAllClothes(){
            return  clothingService.getAllClothes();
        }

        @PostMapping("/Clothesave")
        public Clothe SaveClothe(@RequestBody Clothe clothingProduct){
            return clothingService.SaveClothe(clothingProduct);
        }
        @GetMapping("/clothes/{id}")
        public Optional<Clothe> getClothById(@PathVariable("id") int id) {
            return clothingService.getClotheById(id);
        }
        @GetMapping("/max-id")
        public int getMaxid() {
            return clothingService.getMaxid();
        }

        @GetMapping("/sortedByPriceHighToLow")
        public List<Clothe> getAllClothesOrderedByPriceHighToLow() {
            return clothingService.getAllClothesOrderedByPriceHighToLow();
        }

        @GetMapping("/sortedByPriceLowToHigh")
        public List<Clothe> getAllClothesOrderedByPriceLowTooHigh() {
            return clothingService.getAllClothesOrderedByPriceLowTooHigh();
        }

        @GetMapping("/OutOfStock")
        public List<Clothe> getAllClothesOutOfStock() {
            return clothingService.getAllClothesOutOfStock();
        }

        @GetMapping("/last-four")
        public List<Clothe> getLastFourClothes() {
            return clothingService.getLastFourClothes();
        }

        @GetMapping("/LastestClothe")
        public List<Clothe> getLatestClothe() {
            return clothingService.getLatestClothe();
        }

        //reducing current clothe quantity by user input
        @PutMapping("/reduceQuantity/{id}")
        public Clothe reduceClotheQuantity(@PathVariable("id") int id, @RequestParam("quantity") int quantity) {
            return clothingService.reduceClotheQuantity(id, quantity);
        }

}
