package com.example.ClothingService.Service;


import com.example.ClothingService.Data.Clothe;
import com.example.ClothingService.Data.ClothingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class ClothingService {

        @Autowired
        private ClothingRepository  clothingRepository;

        @GetMapping(path = "/clothe")

        public  List<Clothe> getAllClothes(){
            return clothingRepository.findAll();
        }

        public Clothe SaveClothe(Clothe ClotheProduct){
            return clothingRepository.save(ClotheProduct);
        }

        public  int getMaxid(){
            Integer maxid =clothingRepository.findMaxValue();
            return  maxid != null ?maxid :0;

        }

        public List<Clothe> getAllClothesOrderedByPriceHighToLow() {
        return clothingRepository.findAllClothesOrderedByPriceHightolow();
        }

        public List<Clothe> getAllClothesOrderedByPriceLowTooHigh() {
            return clothingRepository.findAllClothesOrderedByPriceLowtoHigh();
        }

        public List<Clothe> getAllClothesOutOfStock() {
            return clothingRepository.findAllClothesOrderedByq_o();
        }

        public List<Clothe> getLastFourClothes() {
            Pageable pageable = PageRequest.of(0, 4);
            Page<Clothe> page = clothingRepository.findLastFourClothes(pageable);
            return page.getContent();
        }

        public List<Clothe> getLatestClothe() {
            Pageable pageable = PageRequest.of(0, 1);
            Page<Clothe> page = clothingRepository.findLatestClothe(pageable);
            return page.getContent();
        }

    public Optional<Clothe> getClotheById(int id) {
            return clothingRepository.findById(id);

    }

    public Clothe reduceClotheQuantity(int id, int quantity) {
            Optional<Clothe> clothe = clothingRepository.findById(id);
            if (clothe.isPresent()) {
                Clothe clotheProduct = clothe.get();
                clotheProduct.setClothe_Quantity(clotheProduct.getClothe_Quantity() - quantity);
                return clothingRepository.save(clotheProduct);
            }
            return null;
    }
}
