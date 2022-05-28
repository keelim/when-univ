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


    public static MainMenu value(int menuNumber) { //menuNumber enum �������� ����
        if (menuNumber == END_OF_RUN) {
            return MainMenu.EndOfRun;

        } else if (menuNumber < DoesContain.ordinal() || menuNumber > ReplaceAt.ordinal()) { //original�� ���Ͽ� �迭�� �ε����� ��´�.
            return MainMenu.ERROR;

        } else {
            return MainMenu.values()[menuNumber]; //values �� ���Ͽ� �迭�� ����� �ش�.

        }
    }
}


