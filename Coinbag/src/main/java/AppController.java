public class AppController {
    private static final int MENU_ADD = 1;
    private static final int MENU_REMOVE = 2;
    private static final int MENU_SEARCH = 3;
    private static final int MENU_FREQUENCY = 4;
    private static final int MENU_END_OF_RUN = 9;

    private ArrayBag<Coin> _coinBag;

    public ArrayBag<Coin> coinBag() { //getter

        return _coinBag;
    }

    public void setCoinBag(ArrayBag<Coin> newCoinBag) { //setter

        this._coinBag = newCoinBag;
    }

    public AppController() { //생성자

    }


    public void run() {
        AppView.outputLine("<<< 동전 가방 프로그램을 시작합니다. >>>"); //시작 메시지 출력
        AppView.outputLine("");

        int coinBagSize = AppView.inputCapacityOfCoinBag();//CoingBagSize의 입력 받기
        this.setCoinBag(new ArrayBag<Coin>(coinBagSize)); //ArrayBag을 set한다.


        int menuNumber = AppView.inputMenuNumber(); //menuNumber 입력

        while (menuNumber != MENU_END_OF_RUN) {
            switch (menuNumber) {
                case MENU_ADD:       //입력 값의 따라 다르게 실행도록 한다.
                    this.addCoin(); // 코인을 추가한다. .
                    break;

                case MENU_REMOVE:
                    this.removeCoin(); //코인을 제거한다.
                    break;

                case MENU_SEARCH:
                    this.searchForCoin(); //코인을 탐색한다.
                    break;

                case MENU_FREQUENCY:
                    this.frequencyOfCoin(); //코인의 빈도를 확인한다.
                    break;

                default:
                    this.undefinedMenuNumber(menuNumber);
            }
            menuNumber = AppView.inputMenuNumber(); //재입력을 받아 실행 여부를 확인한다.
        }
        this.showStatistics(); //통게를 확인한다.
        AppView.outputLine("<<< 동전 가방 프로그램을 종료합니다. >>>");
    }

    private int sumOfValues() { //showStatics 사용 되며 합을 출력
        int sum = 0;
        for (int i = 0; i < this.coinBag().size(); i++) {
            sum += this.coinBag().elementAt(i).value();
        }
        return sum;

    }

    private int maxCoinValue() { //showStatics 사용 되면 제일 높은 값을 출력
        int maxValue = 0;
        for (int i = 0; i < this.coinBag().size(); i++) {
            if (maxValue < this.coinBag().elementAt(i).value()) {
                maxValue = this.coinBag().elementAt(i).value();
            }
        }
        return maxValue;
    }


    private void showStatistics() { //통계 값을 출력
        AppView.outputLine("가방에 들어 있는 동전의 개수: " + this.coinBag().size());
        AppView.outputLine("동전 중 가장 큰 값: " + this.maxCoinValue());
        AppView.outputLine("모든 동전 값의 합: " + this.sumOfValues());
    }

    private void undefinedMenuNumber(int aMenuNumber) { //입력 값의 번호가 잘못되어 있는지를 확인한다.
        AppView.outputLine("~선택된 메뉴 번호" + aMenuNumber + "는 잘못된 번호 입니다. ");
    }

    private void frequencyOfCoin() {
        int coinValue = AppView.inputCoinValue(); //코인 값 확인
        int frequency = this.coinBag().frequencyOf((new Coin(coinValue))); //코인의 빈도를 저장
        AppView.outputLine("~주어진 값을 갖는 동전의 개수는 " + frequency + "개 입니다. "); //코인의 빈도 출력
    }

    private void searchForCoin() { //코인 값을 탐색
        int coinValue = AppView.inputCoinValue(); //코인 값 확인
        if (this.coinBag().doesContain(new Coin(coinValue))) { //코인이 안에 존재 하는지를 확인
            AppView.outputLine("~ 주어진 값을 갖는 동전이 가방 안에 존재 합니다. ");
        } else {
            AppView.outputLine("~ 주어진 값을 갖는 동전은 가방 안에 존재하지 않습니다. ");
        }
    }

    private void removeCoin() { // 코인을 제거한다.
        int coinValue = AppView.inputCoinValue(); //코인 값 확인
        if (!(this.coinBag().remove(new Coin(coinValue)))) { //코인을 제거한다.
            AppView.outputLine("~ 주어진 값을 갖는 동전을 가방 안에 존재하지 않습니다.  ");
        } else {
            AppView.outputLine("~ 주어진 값을 갖는 동전 하나가 가방에서 정상적으로 삭제되었습니다.  ");
        }
    }

    private void addCoin() { //코인 값으 추가
        if (this.coinBag().isFull()) { //꽉 차있는지를 확인한다.
            AppView.outputLine("~동전 가방이 꽉 차서 동전을 넣을 수 없습니다.");
        } else {
            int coinValue = AppView.inputCoinValue();
            if (this.coinBag().add(new Coin(coinValue))) {
                AppView.outputLine("~ 주어진 값을 갖는 동전을 가방에 성공적으로 넣었습니다. ");
            } else {
                AppView.outputLine("~ 주어진 값을 갖는 동전을 가방에 넣는데 실패하였습니다. ");
            }
        }
    }
}
