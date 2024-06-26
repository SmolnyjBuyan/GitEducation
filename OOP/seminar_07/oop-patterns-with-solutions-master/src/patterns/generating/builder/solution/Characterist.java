package patterns.generating.builder.solution;


public class Characterist {
    private String brand;
    private String color;
    private String ram;
    private String cpu;
    private String os;
    private String weight;
    private String memory;
    private String memoryType;
    private String battery;
    private String body;
    private String wheel;

    private Characterist(Builder builder) {
        this.ram = builder.ram;
    }

    public String getBrand() {
        return brand;
    }

    public String getColor() {
        return color;
    }

    public String getRam() {
        return ram;
    }

    public String getCpu() {
        return cpu;
    }

    public String getOs() {
        return os;
    }

    public String getWeight() {
        return weight;
    }

    public String getMemory() {
        return memory;
    }

    public String getMemoryType() {
        return memoryType;
    }

    public String getBattery() {
        return battery;
    }

    public String getBody() {
        return body;
    }

    public String getWheel() {
        return wheel;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String ram;


        public Builder ram(String ram) {
            this.ram = ram;
            return this;
        }

        public Characterist build() {
            return new Characterist(this);
        }
    }
}
