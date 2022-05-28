public enum MainMenu {
    ERROR,
    DoesContain,
    ElementAt,
    First,
    Last,
    OrderOf,

    AddTo,
    AddToFirst,
    AddToLast,
    Add,

    RemoveFrom,
    RemoveFirst,
    RemoveLast,
    RemoveAny,

    ReplaceAt,

    Size,

    EndOfRun;

    public static final int END_OF_RUN = 99;


    public static MainMenu value(int menuNumber) { //menuNumber enum 값으로의 변경
        if (menuNumber == END_OF_RUN) {
            return MainMenu.EndOfRun;

        } else if (menuNumber < DoesContain.ordinal() || menuNumber > ReplaceAt.ordinal()) { //original를 통하여 배열의 인덱스를 얻는다.
            return MainMenu.ERROR;

        } else {
            return MainMenu.values()[menuNumber]; //values 를 통하여 배열을 만들어 준다.

        }
    }
}


