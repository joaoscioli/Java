void main() {
    int size = 10;
    char charToPrint = 'X';
    for (int i = 1; i < size; i++) {
        for (int j = 1; j < size; j++) {
            if (j == 0 || (j == 0 || i == size / 2) &&  j == size / 2) {
                print(charToPrint + " ");
            } else {
                print(" ");
            }
        }
        println();
    }
}