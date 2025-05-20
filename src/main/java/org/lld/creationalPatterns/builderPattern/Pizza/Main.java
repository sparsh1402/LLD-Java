package org.lld.creationalPatterns.builderPattern.Pizza;
class Pizza{
    private String size;
    private String crustType;
    private boolean cheese;
    private boolean pepperoni;
    private boolean mushrooms;
    private boolean isVeg;

    private Pizza(Builder builder){
        this.size = builder.size;
        this.size = builder.size;
        this.crustType = builder.crustType;
        this.cheese = builder.cheese;
        this.pepperoni = builder.pepperoni;
        this.mushrooms = builder.mushrooms;
        this.isVeg = builder.isVeg;

    }
    public void displayPizza() {
        System.out.println("Size: " + size);
        System.out.println("Crust: " + crustType);
        System.out.println("Cheese: " + cheese);
        System.out.println("Pepperoni: " + pepperoni);
        System.out.println("Mushrooms: " + mushrooms);
        System.out.println("Vegetarian: " + isVeg);
    }
    public static class Builder{
        private String size;
        private String crustType;
        private boolean cheese;
        private boolean pepperoni;
        private boolean mushrooms;
        private boolean isVeg;

        public Builder setSize(String size) {
            this.size = size;
            return this;
        }

        public Builder setCrustType(String crustType) {
            this.crustType = crustType;
            return this;
        }

        public Builder addCheese(boolean cheese) {
            this.cheese = cheese;
            return this;
        }

        public Builder addPepperoni(boolean pepperoni) {
            this.pepperoni = pepperoni;
            return this;
        }

        public Builder addMushrooms(boolean mushrooms) {
            this.mushrooms = mushrooms;
            return this;
        }

        public Builder setIsVeg(boolean isVeg) {
            this.isVeg = isVeg;
            return this;
        }

        public Pizza build() {
            return new Pizza(this);
        }

    }
}
public class Main {
    public static void main(String[] args) {
        Pizza vegPizza = new Pizza.Builder()
                .setSize("Medium")
                .setCrustType("Thin")
                .addCheese(true)
                .addMushrooms(true)
                .setIsVeg(true)
                .build();
        vegPizza.displayPizza();
        System.out.println("-------------------------------------------------");
        Pizza nonVegPizza = new Pizza.Builder()
                .setSize("Medium")
                .setCrustType("Thik")
                .addCheese(true)
                .addMushrooms(true)
                .addPepperoni(true)
                .setIsVeg(false)
                .build();
        nonVegPizza.displayPizza();
    }
}
