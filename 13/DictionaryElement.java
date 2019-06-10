public class DictionaryElement<Key extends Comparable<Key>, Obj> { //Dictionary를 위한 클래스 Comparable을 extend를 하여
    //인스턴스 사이 값 비교 가능
    private Key _key;
    private Obj _object;

    public DictionaryElement(Key givenKey, Obj givenObject) { //constructor
        this._key = givenKey;
        this._object = givenObject;
    }

    public Key key() {
        return _key;
    } //getter

    public void setKey(Key _key) { //setter
        this._key = _key;
    }

    public Obj object() { //getter
        return _object;
    }

    public void setObject(Obj _object) {
        this._object = _object;
    } //setter
}
