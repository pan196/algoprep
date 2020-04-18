package ds.hashtable;

public class App {
    public static void main(String[] args) {
        HashTable table = new HashTable(25);

        table.insert("Cat");
        table.insert("Paradise");
        table.insert("Elephant");
        table.insert("Ship");
        table.insert("Tractor");
        table.insert("Moon");
        table.insert("Stone");
        table.insert("January");
        table.insert("Frog");
        table.insert("Egg");
        table.insert("Gel");
        table.insert("Sunny");

        System.out.println("------FIND ELEMENTS-------");
        System.out.println(table.find("Tractor"));
        System.out.println(table.find("Hi"));
        System.out.println(table.find("EV"));
        System.out.println(table.find("Water"));
        System.out.println(table.find("Ship"));
        System.out.println(table.find("Stone"));
        System.out.println();

        table.render();
        table.render(false);
    }
}
