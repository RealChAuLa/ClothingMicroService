package com.example.ClothingService.Data;

import javax.persistence.*;

@Entity
@Table(name="clothes_stock")
public class Clothe {

        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        private  int id;

        @Column( name= "clothe_Name")
        private  String Clothe_Name;

        @Column (name = "clothe_Description")
        private  String  Clothe_Description;

        @Column (name = "clothe_Quantity")
        private  int Clothe_Quantity;

        @Column (name = "clothe_Price")
        private  int Clothe_Price;

        public int getId() {
            return id;
        }

        public String getClothe_Name() {
            return Clothe_Name;
        }

        public String getClothe_Description() {
            return Clothe_Description;
        }

        public int getClothe_Quantity() {
            return Clothe_Quantity;
        }

        public int getClothe_Price() {
            return Clothe_Price;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setClothe_Name(String clothe_Name) {
            Clothe_Name = clothe_Name;
        }

        public void setClothe_Description(String clothe_Description) {
            Clothe_Description = clothe_Description;
        }

        public void setClothe_Quantity(int clothe_Quantity) {
            Clothe_Quantity = clothe_Quantity;
        }

        public void setClothe_Price(int clothe_Price) {
            Clothe_Price = clothe_Price;
        }

        public Clothe() {

        }
}
