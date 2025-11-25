package lab6;
public class LandPlot {
    private String name;
    private double area; 
    private double price;

    public LandPlot(String name, double area, double price) {
        this.name = name;
        this.area = area;
        this.price = price;
    }

    public double getArea() {
        return area;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void printInfo() {
        System.out.println("Name: " + name + ", Area: " + area + " m², Price: " + price);
    }

    @Override
    public String toString() {
        return name + " - Area: " + area + " m², Price: " + price;
    }
}
