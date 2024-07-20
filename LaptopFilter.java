import java.util.*;
import java.util.stream.Collectors;

public class LaptopFilter {

    public static void main(String[] args) {
        List<Laptop> laptops = new ArrayList<>();
        laptops.add(new Laptop("1 Hp", 8, 512, "Windows 11", "Silver"));
        laptops.add(new Laptop("2 Apple", 16, 1024, "MacOS", "Gold"));
        laptops.add(new Laptop("3 Dell", 32, 2000, "Linux", "Black"));

        for (Laptop laptop : laptops) {
            System.out.println(laptop);
        }

        filterLaptops(laptops);
    }

    public static void filterLaptops(List<Laptop> laptops) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> filterCriteria = new HashMap<>();
        filterCriteria.put("RAM", " ");
        filterCriteria.put("HDD", " ");
        filterCriteria.put("OS", " ");
        filterCriteria.put("Color", " ");

        System.out.println("Введите минимальные значения критерии: ");
        for (String key : filterCriteria.keySet()) {
            System.out.print(key + ": ");
            String value = scanner.nextLine();
            if (!value.isEmpty()) {
                filterCriteria.put(key, value);
            }
        }

        List<Laptop> filteredLaptops = applyFilter(laptops, filterCriteria);
        if (filteredLaptops.isEmpty()) {
            System.out.println("Ноутбуки, соответствующие фильтру, не найдены.");
        } else {
            System.out.println("Найденные ноутбуки:");
            filteredLaptops.forEach(System.out::println);
        }
    }

    public static List<Laptop> applyFilter(List<Laptop> laptops, Map<String, String> filterCriteria) {
        return laptops.stream()
                .filter(laptop -> matchesCriteria(laptop, filterCriteria))
                .collect(Collectors.toList());
    }

    public static boolean matchesCriteria(Laptop laptop, Map<String, String> filterCriteria) {
        return (filterCriteria.get("RAM").isEmpty() || laptop.getRam() >= Integer.parseInt(filterCriteria.get("RAM")))
                && (filterCriteria.get("HDD").isEmpty() || laptop.getHdd() >= Integer.parseInt(filterCriteria.get("HDD")))
                && (filterCriteria.get("OS").isEmpty() || laptop.getOs().equalsIgnoreCase(filterCriteria.get("OS")))
                && (filterCriteria.get("Color").isEmpty() || laptop.getColor().equalsIgnoreCase(filterCriteria.get("Color")));
    }
}
