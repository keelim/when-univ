package week14;

public enum OrderValidity {
    EndOfRun, // 음수는 종료
    Valid,  // 유효 값
    TooSmall, //유효 값보다 작음
    TooLarge, // 유효 값보다 큼
    NotOddNumber;// 짝수 이면 마방진 자체 실행이 안되

    public static OrderValidity validityOf(int order) { //enum class 로써 메소드 사용이 가능함

        if (order < 0) {
            return OrderValidity.EndOfRun;

        } else if (order < AppController.MIN_ORDER) {
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
