//package chapter_17.v6;
//
//interface Employee{};
//static class RegularEmployee implements Employee{};
//enum CSuiteEmployee implements Employee {CEO, CFO}
//public record EmpId(String name, int id) { }
//
//static void handleId(Object empObject) {
//    if (empObject == null) {
//        System.out.println("Oops, the Id was null !");
//    } else if (empObject instanceof Integer idInt) {
//        if (idInt == -1 || idInt == 0) {
//            System.out.println("A reserved employee Id");
//        } else if (idInt < 0) {
//            System.out.println("A negative employee Id: " + idInt);
//        } else {
//            System.out.println("A positive employee Id: " + idInt);
//        }
//    } else if (empObject instanceof String s) {
//        System.out.println("A String Id: " + s);
//    } else if (empObject instanceof  EmpId eid) {
//        System.out.println("An Employee Id: [" +eid.id + ", " + eid.name + "]");
//    } else if (empObject instanceof Employee e) {
//        if(e instanceof CSuiteEmployee cse) {
//            switch (cse) {
//                case CEO -> System.out.println("It's the boss !");
//                case CFO -> System.out.println("There's the money !");
//            }
//        } else if (e instanceof  RegularEmployee) {
//            System.out.println("A regular employee.");
//        } else {
//            System.out.println("An irregular employee.");
//        }
//    } else {
//        System.out.println("Some other kind of employee: " + empObject.toString());
//    }
//}

// use patterns in switch to simplify processing
// the switch variable, here an object representing
// an id, depending on its type and value.
//static void handleId(Object empObject) {
//    switch (empObject) {
//        case null -> System.out.println("Oops, the Id was null !");
//        case Integer i -> {
//            switch (i) {
//                case -1, 0 -> System.out.println("A reserved employee Id");
//                case Integer idInt when idInt < 0 -> System.out.println("A negative employee Id: " + idInt);
//                case Integer idInt -> System.out.println("A positive employee Id: " + idInt);
//            }
//        }
//        case String s -> System.out.println("A String Id " + s);
//        case EmpId eid -> System.out.println("An Employee Id: [" + eid.id() + ", " + eid.name + "]");
//        case Employee e -> {
//            switch (e) {
//                case CSuiteEmployee.CEO -> System.out.println("It's the boss !");
//                case CSuiteEmployee.CFO -> System.out.println("There's the money !");
//                case RegularEmployee re -> System.out.println("A regular employee.");
//                default -> System.out.println("An irregular employee.");
//            }
//        }
//        default -> System.out.println("Some other kind of Id " + empObject.toString());
//    }
//}