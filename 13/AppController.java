public class AppController implements VisitDelegate<Integer, Integer> {
    private static final int DEFAULT_DATA_SIZE = 10;

    private Dictionary<Integer, Integer> _dictionary;
    private Integer[] _list;

    public Dictionary<Integer, Integer> dictionary() {
        return _dictionary;
    }
    //getter

    public void setDictionary(Dictionary<Integer, Integer> _dictionary) {
        this._dictionary = _dictionary;
    }
    //setter

    public Integer[] list() {
        return _list;
    }
    //getter

    public void setList(Integer[] _list) {
        this._list = _list;
    }
    //setter

    public void run() {
        this.setList(DataGenerator.randomList((DEFAULT_DATA_SIZE)));
        AppView.outputLine("<<< 이진검색트리로 구현된 사전에서의 삽입과 삭제 >>>");
        AppView.outputLine("");

        this.setDictionary(new DictionaryByBinarySearchTree<Integer, Integer>()); //Dictionary 설정
        this.dictionary().setVisitDelegate(this); //delegate 가 누구인지 알려주는 것 --> Dictionary (CallBack AppController <-> Dictionary)
        this.setList(DataGenerator.randomListWithoutDuplication(DEFAULT_DATA_SIZE)); //List set
        this.addToDictionaryAndShowShape(); //Dictionary 의 모양을 알려준다.
        this.showDictionaryInSortedOrderByCallBack();
        this.showDictionaryInSortedOrderByIterator();
        this.setList(DataGenerator.randomListWithoutDuplication(DEFAULT_DATA_SIZE)); //List set
        this.removeFromDictionaryAndShowShape(); //삭제된 모양을 알려준다.

        AppView.outputLine("<<< 종료 >>>");
    }

    private void showDictionary(String aTitlePrefix) {
        AppView.outputLine("> " + aTitlePrefix + "이진검색트리 사전:");
        if (this.dictionary().isEmpty()) {
            AppView.outputLine("  Empty");
        } else {
            this.dictionary().scanInReverseOfSortedOrder();
        }
        AppView.outputLine("");
    }

    private void addToDictionaryAndShowShape() {
        AppView.outputLine("[삽입 과정에서의 이진검색트리 사전의 변화]");
        this.showDictionary("삽입을 시작하기 전의");

        for (int i = 0; i < this.list().length; i++) {
            Integer currentKey = this.list()[i];
            Integer currentObj = Integer.valueOf(i); //굳이 i를 valueOf를 할 필요가 있는가? --> return Integer instance
            this.dictionary().addKeyAndObject(currentKey, currentObj);
            this.showDictionary(String.format("Key=%d (Object=%d) 원소를 삽입한 후의", currentKey, currentObj)); //format --> printf?
        }

    }

    private void removeFromDictionaryAndShowShape() {
        AppView.outputLine("[삭제 과정에서의 이진검색트리 사전의 변화]");
        this.showDictionary("삭제를 시작하기 전의");
        for (int i = 0; i < this.list().length; i++) {
            Integer currentKey = this.list()[i];
            Integer currentObj = this.dictionary().removeObjectForKey(currentKey);
            this.showDictionary(String.format("Key=%d (Object=%d) 원소를 삭제한 후의", currentKey, currentObj));
        }
    }

    @Override
    public void visitForSortedOrder(DictionaryElement<Integer, Integer> anElement, int aLevel) { //Element 를 출력을 하는 method
        AppView.outputLine(String.format("%3d (%2d)", anElement.key(), anElement.object()));
    }

    @Override
    public void visitForReverseOfSortedOrder(DictionaryElement<Integer, Integer> anElement, int aLevel) {
        if (aLevel == 1) { //Root 일 때
            AppView.output(String.format("%7s", "Root: "));
        } else {
            AppView.output(String.format("%7s", ""));
        }

        for (int i = 1; i < aLevel; i++) { //반복을 통하여 출력을 한다.
            AppView.output(String.format("%7s", ""));
        }

        AppView.outputLine(String.format("%3d (%2d)", anElement.key(), anElement.object()));

    }

    private void showDictionaryInSortedOrderByCallBack() { //Callback 을 통하여 출력을 준비를 한다.
        AppView.outputLine("[\"Call Back\" 을 사용하여 보여준 사전의 내용]");
        this.dictionary().scanInSortedOrder();
        AppView.outputLine("");
    }

    private void showDictionaryInSortedOrderByIterator() { //iterator 를 통하여 반복을 하고 원소를 출력을 한다.
        AppView.outputLine("[\"Iterator\" 를 사용하여 보여준 사전의 내용]");
        Iterator<DictionaryElement<Integer, Integer>> iterator = this.dictionary().iterator();
        while (iterator.hasNext()) { //iterator hasNext()
            DictionaryElement<Integer, Integer> dictionaryElement = iterator.next(); //next --> Node 하고 비슷하게 사용이 되는 것 같다.
            AppView.outputLine(String.format("%3d (%2d)", dictionaryElement.key(), dictionaryElement.object()));
        }
        AppView.outputLine("");
    }


}
