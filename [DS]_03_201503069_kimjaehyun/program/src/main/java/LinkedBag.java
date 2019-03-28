public class LinkedBag<E> {
    private int _size;
    private LinkedNode<E> _head;


    public LinkedBag() { //LinkedBag constructor
        this._size = 0;
        this._head = null;

    }

    public int size() { //size getter
        return this._size;
    }

    private void setSize(int _size) { //size setter 
        this._size = _size;
    }

    private LinkedNode<E> head() { //head getter
        return _head;
    }

    private void setHead(LinkedNode<E> _head) { //head setter
        this._head = _head;
    }

    public boolean isEmpty() {//비어 있는지를 확인
        return (this.size() == 0); //size 가 0인지를 확인
    }

    public boolean isFull() { // 꽉차 있는지 확인 메모리만틈 추가 할 수 있다. 
        return false;
    }


    public boolean doesContain(E anElement) { //들어 있는지를 확인
        LinkedNode<E> currentNode = this.head(); //node 를 정의
        while (currentNode != null) {			//node 가 null 이 아닐 때 돈다.
            if (currentNode.element().equals(anElement)) { 
                return true; //찾으면 true 리턴
            }

            currentNode = currentNode.next();// 없으면 다음 노드
        }
        return false; //최종 없으면 false 리턴
    }


    public int frequencyOf(E anElement) { //빈도수를 확인
        int frequencyCount = 0;			 //  변수 생성
        LinkedNode<E> currentNode = this.head(); //임시 노드를 head로 받는다. 
        while (currentNode != null) { //임시 노드가 null이 아니면  loop in
            if (currentNode.element().equals(anElement)) { //같으면
                frequencyCount++; // 변수 카운트를 올린다. 
            }
            currentNode = currentNode.next(); //없으면 다음 노드
        }
        return frequencyCount; //카운트 값을 리턴한다. 

    }

    public boolean add(E anElement) { //가득차면 false 를 리턴하고 가능하면 추가 한다.

        if (this.isFull()) { //가득 차 있는지를 확인 isFull() --> 무조건 false
            return false;
        } else {
            LinkedNode<E> newNode = new LinkedNode<>(); //노드 생성
            newNode.setElement(anElement); //엘리먼트 값을 지정
            newNode.setNext(this.head()); // 다음을 head로 지정
            this.setHead(newNode);       // head를 newNode로 지정
            this._size++;				// 사이즈의 크기를 늘린다. 
            return true;
        }

    }

    public boolean remove(E anElement) { //제거
        if (this.isEmpty()) { 			//가득 차 있는지를 확인 isFull() --> 무조건 false
            return false;
        } else {
            LinkedNode<E> previousNode = null; 		 //임시 노드 생성1
            LinkedNode<E> currentNode = this.head();//임시 노드 생성 2 를 제일 앞에 head 로 지정
            boolean found = false;                 //임시 플래그 생성

            while (currentNode != null && !found) {             //현재 노드가 null이 아니거나 플래그가 true
                if (currentNode.element().equals(anElement)) { //엘리먼트와 노드의 엘리먼트 확인
                    found = true; 							  // 찾으면 true	
                } else {
                    previousNode = currentNode;        //이전 노드를 현재 노드로 참조한다. 
                    currentNode = currentNode.next(); //현재 노드의 next를 현재 노드로 참조
                }
            }


            if (!found) { 	   //플래그에 따라
                return false; // 못찾으면 false
            } else {
                if (currentNode == this.head()) {
                    this._head = this.head().next(); //boundary condition
                } else {
                    previousNode.setNext(currentNode.next()); //preViousNode 의 next() currentNode의 next() 
                    this._size--; 							 // 사이즈를 줄인다. 

                }
                return true;
            }
        }
    }

    public E removeAny() {     //어떤 부분을 제거를 하는가?
        if (this.isEmpty()) { //비어있는지를 확인
            return null;	 //비어 있으면 null값 리턴
        } else {
            E removedElement = this.head().element(); //임시 엘리먼트를 헤드의 엘리먼트로 지정
            this._head = this.head().next();	     //head의 next를 head로 지정  		
            this._size--;							//size를 줄인다. 
            return removedElement;				   //삭제 되는 엘리먼트를 return 
        }
    }

    public void clear() { 	  //전부 초기화 null로 초기L화 하고 size를 0으로 맞춘다.
        this.setSize(0);   	 //전부 사이즈를 0으로 한다. 
        this.setHead(null); //head를 null 값으로 한다. 나머지는 garbage collection
    }

    E elementAt(int anOrder) { //인덱스 위치의 객체를 반환한다.
        if ((anOrder < 0) || (anOrder >= this.size())) {
            return null;
        } else {
            LinkedNode<E> currentNode = this.head();
            for (int i = 0; i < anOrder; i++) {
                currentNode = currentNode.next();
            }
            return currentNode.element();
        }
    }

    public E any() { 		   //어떠한 엘리먼트의 출력을 받는다. 
        if (this.isEmpty()) { //비어 있느지를 확인
            return null;	 //null return 
        } else {
            return this.head().element(); //비어 있지 않으면 head의 엘리먼트를 출력을 한다. 
        }

    }

}
