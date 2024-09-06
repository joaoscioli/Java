package chapter_17.v2;

record Employee(String name, int idNum) {
    // Use a canonical constructor to remove any leading and trailing spaces
    // that might be in the name string. This ensures that names are stored
    // in a consistent manner.
    public Employee(String name, int idNum) {
        // Remove any leading and trailing spaces.
        this.name = name.trim();
        this.idNum = idNum;
    }

    // Use a compact canonical constructor to remove any leading and
    // trailing spaces from the name String.
//    public Employee {
//        // Remove any leading and trailing spaces.
//        name = name.trim();
//    }


}
