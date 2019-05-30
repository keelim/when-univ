public class DictionaryElement<Key extends Comparable<Key>, Obj> {
    private Key _key;
    private Obj _object;

    public DictionaryElement() {
    }

    public DictionaryElement(Key givenKey, Obj givenObject) {
        this._key = givenKey;
        this._object = givenObject;
    }

    public Key key() {
        return _key;
    }

    public void setKey(Key _key) {
        this._key = _key;
    }

    public Obj object() {
        return _object;
    }

    public void setObject(Obj _object) {
        this._object = _object;
    }
}
