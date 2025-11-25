package lab6;


public class main {
    public static void main(String[] args) {

        Container<LandPlot> landPlotContainer = new Container<>();

       
        landPlotContainer.addItem(new LandPlot("Ділянка 1", 500, 1000000));
        landPlotContainer.addItem(new LandPlot("Ділянка 2", 200, 500000));
        landPlotContainer.addItem(new LandPlot("Ділянка 3", 1000, 1500000));
        landPlotContainer.addItem(new LandPlot("Ділянка 4", 300, 800000));
        landPlotContainer.addItem(new LandPlot("Ділянка 5", 100, 1200000));
        
        
        double averageArea = landPlotContainer.calculateAverageArea();
        System.out.println("\nCередня площа земельних ділянок: " + averageArea + " м²");
    }
}
