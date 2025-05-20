package org.lld.creationalPatterns.builderPattern.Computer;
class Computer{
    private String cpu;
    private String ram;
    private String storage;
    private boolean hasGraphicsCard;
    private Computer(Builder builder){
        this.cpu = builder.cpu;
    }
    public void spec(){
        System.out.println("CPU: " + cpu);
        System.out.println("RAM: " + ram);
        System.out.println("Storage: " + storage);
        System.out.println("Graphics Card: " + hasGraphicsCard);
    }

    public static class Builder{
        private String cpu;
        private String ram;
        private String storage;
        private boolean hasGraphicsCard;

        public Builder setCpu(String cpu){
            this.cpu = cpu;
            return this;
        }
        public Builder setRam(String ram) {
            this.ram = ram;
            return this;
        }

        public Builder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        public Builder setHasGraphicsCard(boolean hasGraphicsCard) {
            this.hasGraphicsCard = hasGraphicsCard;
            return this;
        }

        public Computer build(){
            return new Computer(this);
        }
    }
}
public class Main
{
    public static void main(String[] args) {
            Computer gamingPC = new Computer.Builder()
                    .setCpu("Intel i9")
                    .setRam("32GB")
                    .setStorage("1TB SSD")
                    .setHasGraphicsCard(true)
                    .build();

            gamingPC.spec();
        System.out.println("------------------");
            Computer officePC = new Computer.Builder()
                    .setCpu("Intel i5")
                    .setRam("16GB")
                    .setStorage("512GB SSD")
                    .setHasGraphicsCard(false)
                    .build();
            officePC.spec();
    }
}
