public abstract class Dictionary<Key extends Comparable<Key>, Obj> {
    private int _size;

    public int size() {
        return _size;
    } //getter

    protected void setSize(int newSize) {
        this._size = newSize;
    } //setter

    // setSize() 는 사전의 크기를 변경시킨다. 삽입과 삭제의 행위가 실행될 때 변경된다.
    // 따라서 "public" 함수가 아니어야 한다. 외부에 공개되면 안 된다.
    // "private" 이 아니고 "protected" 인 것은, 상속 받는 class 에서만은 사용할 수 있게 하기 위함이다.
    // 상속 받는 class 에서는, 인스턴스 변수 "_size"를 직접 사용할 수 없게 설계하는 것이 적절한 방법이다.

    public Dictionary() {
        this.setSize(0);
    } //constructor

    // 상속받는 class 의 생성자는 암묵적으로 상위 class 의 생성자를 call 한다는 것을 잊지 말 것!
    // Public non-abstract method: 이 class 에서 구현되어야 한다.
    public boolean isEmpty() {
        return (_size == 0);
    }

    public abstract boolean isFull();

    public abstract boolean keyDoesExist(Key aKey);

    public abstract Obj objectForKey(Key aKey);

    public abstract boolean addKeyAndObject(Key aKey, Obj anObject);

    public abstract Obj removeObjectForKey(Key aKey);

    public abstract void clear();

    public abstract Iterator<DictionaryElement<Key, Obj>> iterator();
}
