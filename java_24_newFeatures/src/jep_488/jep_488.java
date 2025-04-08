void main() {

    println("====JEP 488 demonstration using the Instanceof default====");

    // Before
    Object obj = 42;
    if (obj instanceof Integer) {
        Integer i = (Integer) obj;
        System.out.println("The value is an integer: " + i);
    }

    // now
    Object obj2 = 42;
    if (obj instanceof Integer i) {
        System.out.println("The value is an integer: " + i);
    }


    println("====JEP 488 demonstration using the switch default====");

    // Before
    Object vehicle = "Car"; // Could be "Motorcycle", "Truck", or something else
    String category = categoryVehicle(vehicle);
    println("Vehicle category: " +category);

    // After
    Object vehicle_v2 = "Car"; // Could be "Motorcycle", "Truck", or something else
    String category_v2 = categorizeVehicle_v2(vehicle_v2);
    println("Vehicle category: " + category_v2);
}


// Method Using the Old Standard
    private String categoryVehicle(Object vehicle) {
        String result;
        if (vehicle == null) {
            result = "Vehicle not specified";
        } else if (vehicle instanceof String) {
            String s  = (String) vehicle; // Manual cast
            switch (s) {
                case "Car":
                    result = "Light vehicle";
                    break;
                case "Motorcycle":
                    result = "Two-wheeled vehicle";
                    break;
                case "Truck":
                    result = "Heavy vehicle";
                    break;
                default:
                    result = "Unknown category";
                    break;
            }
        } else if (vehicle instanceof Integer) {
            Integer i = (Integer) vehicle;  // Manual cast
            result = "Numeric code: " + i;
        } else {
            result = "Unknown category";
        }
        return result;
    }

    // Method Using the New Standard
    public static String categorizeVehicle_v2(Object vehicle_v2) {
        return switch (vehicle_v2) {
            case String s when s.equals("Car") -> "Light vehicle";
            case String s when s.equals("Motorcycle") -> "Two-wheeled vehicle";
            case String s when s.equals("Truck") -> "Heavy vehicle";
            case Integer i -> "Numeric code: " + i;
            case null -> "Vehicle not specified";
            default -> "Unknown category";
        };
    }


