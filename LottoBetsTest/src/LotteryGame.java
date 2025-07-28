public enum LotteryGame {
    MEGA_SENA("Mega-Sena", 6, 1, 60, 0, "none"),
    LOTOFACIL("Lotofácil", 15, 1, 25, 0, "none"),
    QUINA("Quina", 5, 1, 80, 0, "none"),
    DUPLA_SENA("Dupla-Sena", 6, 1, 50, 0, "2 sorteios"),
    MILIONARIA("Milionária", 6, 1, 50, 2, "2 trevos (1-6)"),
    SUPER_SETE("Super Sete", 7, 0, 9, 1, "Um número por coluna"),
    LOTOMANIA("Lotomania", 50, 0, 99, 0, "none"),
    DIA_DE_SORTE("Dia de Sorte", 7, 1, 31, 1, "1 mês (1-12)"),
    TIMEMANIA("Timemania", 7, 1, 80, 1, "1 time (índice 1-80, lista estática)");

    private final String gameName;
    private final int numbersCount;
    private final int minNumber;
    private final int maxNumber;
    private final int extraCount;
    private final String extraType;

    // Construtor
    private LotteryGame(String gameName, int numbersCount, int minNumber, int maxNumber, int extraCount, String extraType) {
        this.gameName = gameName;
        this.numbersCount = numbersCount;
        this.minNumber = minNumber;
        this.maxNumber = maxNumber;
        this.extraCount = extraCount;
        this.extraType = extraType;
    }

    // Getters
    public String getGameName() {
        return gameName;
    }

    public int getNumbersCount() {
        return numbersCount;
    }

    public int getMinNumber() {
        return minNumber;
    }

    public int getMaxNumber() {
        return maxNumber;
    }

    public int getExtraCount() {
        return extraCount;
    }

    public String getExtraType() {
        return extraType;
    }
}