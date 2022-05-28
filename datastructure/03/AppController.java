public class AppController {
    private static final int MENU_ADD = 1;
    private static final int MENU_REMOVE = 2;
    private static final int MENU_SEARCH = 3;
    private static final int MENU_FREQUENCY = 4;
    private static final int MENU_END_OF_RUN = 9;

    private LinkedBag<Coin> _coinBag;

    public LinkedBag<Coin> coinBag() { //getter

        return _coinBag;
    }

    public void setCoinBag(LinkedBag<Coin> newCoinBag) { //setter

        this._coinBag = newCoinBag;
    }

    public AppController() { //������

    }


    public void run() {
        AppView.outputLine("<<< ���� ���� ���α׷��� �����մϴ�. >>>"); //���� �޽��� ���
        AppView.outputLine("");


        this.setCoinBag(new LinkedBag<>()); //ArrayBag�� set�Ѵ�.


        int menuNumber = AppView.inputMenuNumber(); //menuNumber �Է�

        while (menuNumber != MENU_END_OF_RUN) {
            switch (menuNumber) {
                case MENU_ADD:       //�Է� ���� ���� �ٸ��� ���൵�� �Ѵ�.
                    this.addCoin(); // ������ �߰��ϳ�.
                    break;

                case MENU_REMOVE:
                    this.removeCoin(); //������ �����Ѵ�.
                    break;

                case MENU_SEARCH:
                    this.searchForCoin(); //������ Ž���Ѵ�.
                    break;

                case MENU_FREQUENCY:
                    this.frequencyOfCoin(); //������ �󵵸� Ȯ���Ѵ�.
                    break;

                default:
                    this.undefinedMenuNumber(menuNumber);
            }
            menuNumber = AppView.inputMenuNumber(); //���Է��� �޾� ���� ���θ� Ȯ���Ѵ�.
        }
        this.showStatistics(); //��Ը� Ȯ���Ѵ�.
        AppView.outputLine("<<< ���� ���� ���α׷��� �����մϴ�. >>>");
    }

    private int sumOfValues() { //showStatics ��� �Ǹ� ���� ���
        int sum = 0;
        for (int i = 0; i < this.coinBag().size(); i++) {
            sum += this.coinBag().elementAt(i).value();
        }
        return sum;

    }

    private int maxCoinValue() { //showStatics ��� �Ǹ� ���� ���� ���� ���
        int maxValue = 0;
        for (int i = 0; i < this.coinBag().size(); i++) {
            if (maxValue < this.coinBag().elementAt(i).value()) {
                maxValue = this.coinBag().elementAt(i).value();
            }
        }
        return maxValue;
    }


    private void showStatistics() { //��� ���� ���
        AppView.outputLine("���濡 ���� ������ �����մϴ�. ");
        AppView.outputLine(" ");
        AppView.outputLine("���濡 ��� �ִ� ������ ����: " + this.coinBag().size());
        AppView.outputLine("���� �� ���� ū ��: " + this.maxCoinValue());
        AppView.outputLine("��� ���� ���� ��: " + this.sumOfValues());
    }

    private void undefinedMenuNumber(int aMenuNumber) { //�Է� ���� ��ȣ�� �߸��Ǿ� �ִ����� Ȯ���Ѵ�.
        AppView.outputLine("~���õ� �޴� ��ȣ" + aMenuNumber + "�� �߸��� ��ȣ �Դϴ�. ");
        AppView.outputLine("");
    }

    private void frequencyOfCoin() {
        int coinValue = AppView.inputCoinValue(); //���� �� Ȯ��
        int frequency = this.coinBag().frequencyOf((new Coin(coinValue))); //������ �󵵸� ����
        AppView.outputLine("~�־��� ���� ���� ������ ������ " + frequency + "�� �Դϴ�. "); //������ �� ���
        AppView.outputLine("");
    }

    private void searchForCoin() { //���� ���� Ž��
        int coinValue = AppView.inputCoinValue(); //���� �� Ȯ��
        if (this.coinBag().doesContain(new Coin(coinValue))) { //������ �ȿ� ���� �ϴ����� Ȯ��
            AppView.outputLine("~ �־��� ���� ���� ������ ���� �ȿ� ���� �մϴ�. ");
            AppView.outputLine("");
        } else {
            AppView.outputLine("~ �־��� ���� ���� ������ ���� �ȿ� �������� �ʽ��ϴ�. ");
            AppView.outputLine("");
        }
    }

    private void removeCoin() { // ������ �����Ѵ�.
        int coinValue = AppView.inputCoinValue(); //���� �� Ȯ��
        if (!(this.coinBag().remove(new Coin(coinValue)))) { //������ �����Ѵ�.
            AppView.outputLine("~ �־��� ���� ���� ������ ���� �ȿ� �������� �ʽ��ϴ�.  ");
            AppView.outputLine("");
        } else {
            AppView.outputLine("~ �־��� ���� ���� ���� �ϳ��� ���濡�� ���������� �����Ǿ����ϴ�.  ");
            AppView.outputLine("");
        }
    }

    private void addCoin() { //���� ���� �߰�
        if (this.coinBag().isFull()) { //�� ���ִ����� Ȯ���Ѵ�.
            AppView.outputLine("~���� ������ �� ���� ������ ���� �� �����ϴ�.");
            AppView.outputLine("");
        } else {
            int coinValue = AppView.inputCoinValue();
            if (this.coinBag().add(new Coin(coinValue))) {
                AppView.outputLine("~ �־��� ���� ���� ������ ���濡 ���������� �־����ϴ�. ");
                AppView.outputLine("");
            } else {
                AppView.outputLine("~ �־��� ���� ���� ������ ���濡 �ִµ� �����Ͽ����ϴ�. ");
                AppView.outputLine("");
            }
        }
    }
}
