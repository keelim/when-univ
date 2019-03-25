public class Coin {
    private static final int DEFAULT_VALUE = 0;
    private int _value;

    public Coin() { //Coin constructor
        this._value = DEFAULT_VALUE;
    }

    public Coin(int givenValue) { //Coin constructor
        this._value = givenValue;

    }


    public int value() {//vlaue getter
        return _value;
    }

    public void setValue(int _value) {//value setter
        this._value = _value;
    }

    @Override
    public boolean equals(Object otherCoin) { //equals override
        if (otherCoin.getClass() != Coin.class) { //파라미터로 전달되는 객체의 클래스와 Conin 클래스가 같은지를 확인
            return false;
        } else {
            return (this.value() == ((Coin) otherCoin).value()); // 그리고 값을 확인
        }

    }
}
