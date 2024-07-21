import showplaces.Showplace;
import showplaces.ShowplaceCalculator;
import showplaces.ShowplacesCell;

public class Main {
    public static void main(String[] args) {
        Showplace westminsterAbbey = new Showplace("Вестминстерское аббатство", 0.5, 7);
        Showplace globusTheatre = new Showplace("Театр Глобус", 0.5, 6);
        Showplace nationalGallery = new Showplace("Национальная Галерея", 1, 9);
        Showplace britishMuseum = new Showplace("Британский Музей", 2, 9);
        Showplace stPaulsCathedral = new Showplace("Собор Святого Павла", 0.5, 8);

        ShowplaceCalculator showplaceCalculator = new ShowplaceCalculator
                (2, westminsterAbbey, globusTheatre, nationalGallery , britishMuseum, stPaulsCathedral);

        showplaceCalculator.printTable();

    }
}