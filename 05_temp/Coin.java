public class Coin implements Comparable<Coin> {
    private int _value;

    public int value() {
        return _value;
    } //value getter

    public void setValue(int newValue) {
        this._value = newValue;
    } //value setter

    public Coin(int randomCoinValue) {
        setValue(randomCoinValue);
    } //Coin constructor

    @Override
    public int compareTo(Coin aCoin) { //Comparable 을 구현을 위한 메소드
        if (this.value() < aCoin.value()) {
            return -1;
        } else if (this.value() > aCoin.value()) {
            return +1;
        } else {
            return 0;
        }
    }
}
