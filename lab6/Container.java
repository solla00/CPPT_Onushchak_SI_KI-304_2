package lab6;

import java.util.ArrayList;
import java.util.List;

public class Container<T> {
    private List<T> items;

    public Container() {
        items = new ArrayList<>();
    }

    public void addItem(T item) {
        items.add(item);
    }

    public void printItems() {
        for (T item : items) {
            System.out.println(item);
        }
    }

    
    public LandPlot findMax() {
        if (items.isEmpty()) return null;
        LandPlot max = (LandPlot) items.get(0);
        for (T item : items) {
            LandPlot landPlot = (LandPlot) item;
            if (landPlot.getArea() > max.getArea()) {
                max = landPlot;
            }
        }
        return max;
    }

    
    public double calculateAverageArea() {
        if (items.isEmpty()) return 0;
        double totalArea = 0;
        for (T item : items) {
            LandPlot landPlot = (LandPlot) item;
            totalArea += landPlot.getArea();
        }
        return totalArea / items.size();
    }
}
