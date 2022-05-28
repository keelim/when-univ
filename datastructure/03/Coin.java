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
        if (otherCoin.getClass() != Coin.class) { //�Ķ���ͷ� ���޵Ǵ� ��ü�� Ŭ������ Conin Ŭ������ �������� Ȯ��
            return false;
        } else {
            return (this.value() == ((Coin) otherCoin).value()); // �׸��� ���� Ȯ��
        }

    }
}
