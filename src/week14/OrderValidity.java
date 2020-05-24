package week14;

public enum OrderValidity {
    Valid,
    TooSmall,
    TooLarge,
    NotOddNumber;

    public static OrderValidity validityOf(int order) {
        if (order < AppController.MIN_ORDER) {
            return OrderValidity.TooSmall;

        } else if (order > AppController.MAX_ORDER) {
            return TooLarge;

        } else if ((order % 2) == 0) {
            return OrderValidity.NotOddNumber;

        } else {
            return OrderValidity.Valid;
        }
    }
}
