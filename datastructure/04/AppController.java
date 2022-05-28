import java.util.Random;

public class AppController {

    //private static final int LIST_CAPACITY = 5;

    //    public AppController(){ �뷮 ���ѽ� ����� �� ��
//        this.setList(new ArrayList<Student>(AppController.LIST_CAPACITY));
//    }

    private ArrayList<Student> _list;


    public AppController() { //constructor
        this.setList(new ArrayList<Student>());

    }

    public ArrayList<Student> list() { //list getter
        return _list;

    }

    public void setList(ArrayList<Student> newList) { //list setter
        this._list = newList;

    }

    public void run() {
        AppView.outputLine("<<< ����Ʈ ��� Ȯ�� ���α׷��� �����մϴ�. >>>");
        MainMenu selectedMenuValue = this.selectMenu();

        while (selectedMenuValue != MainMenu.EndOfRun) { //END_OF_RUN ����

            switch (selectedMenuValue) {
                case DoesContain:
                    this.doesContain();
                    break;
                case ElementAt:
                    this.elementAt();
                    break;
                case First:
                    this.first();
                    break;
                case Last:
                    this.last();
                    break;
                case OrderOf:
                    this.orderOf();
                    break;
                case AddTo:
                    this.addTo();
                    break;
                case AddToFirst:
                    this.addToFirst();
                    break;
                case AddToLast:
                    this.addToLast();
                    break;
                case Add:
                    this.add();
                    break;
                case RemoveFrom:
                    this.removeFrom();
                    break;
                case RemoveFirst:
                    this.removeFirst();
                    break;
                case RemoveLast:
                    this.removeLast();
                    break;
                case RemoveAny:
                    this.removeAny();
                    break;
                case ReplaceAt:
                    this.replaceAt();
                    break;

                default:
                    break;
            }
            selectedMenuValue = this.selectMenu(); //���Է�

        }
        this.showStatics();
        AppView.outputLine("");
        AppView.outputLine("<<< ����Ʈ ��� Ȯ�� ���α׷��� �����մϴ�. >>> ");

    }


    private void replaceAt() { //������Ʈ ��ü
        AppView.outputLine("");
        AppView.outputLine("! replaceAt �۾��� �����մϴ�. : ");

        int order = this.inputOrder();

        if (order < 0 || order >= this.list().size()) {
            AppView.outputLine("!  �Էµ� ���� [" + order + "] �� ���� ����[0.." + (this.list().size() - 1) + "] �� ���� �ʽ��ϴ�. ");
            return;
        }
        int score = this.inputScore();

        this.list().replaceAt(new Student(score), order);

        AppView.outputLine("�־��� ���� [" + order + "] �� �л��� ������ (" + score + ") �ٲ�����ϴ�. ");
    }

    private void removeAny() { //���� ������ ����Ʈ�� �ִ� ������Ʈ ����
        AppView.outputLine("");
        AppView.outputLine("! RemoveAny �۾��� �����մϴ�. ");

        if (this.list().isEmpty()) {
            AppView.outputLine("����Ʈ�� ��� �־ ���� �۾��� �� �� �� �����ϴ�.  ");

        } else {


            Student student = this.list().removeAny();

            if (student != null) {
                AppView.outputLine("! �Էµ� ���� [���� ����] ���� ������ �л��� ������ [" + student.score() + "] �Դϴ�. ");

            } else {
                AppView.outputLine("! �Էµ� ���� [���� ����] ���� �л��� �����ϴ� �۾��� �����Ͽ����ϴ�. ");

            }

        }
    }

    private void removeLast() { //����Ʈ �� �� ������Ʈ ����
        AppView.outputLine("");
        AppView.outputLine("! RemoveLast �۾��� �����մϴ�. ");

        if (this.list().isEmpty()) {
            AppView.outputLine("����Ʈ�� ��� �־ ���� �۾��� �� �� �� �����ϴ�.  ");

        } else {


            Student student = this.list().removeLast();
            if (student != null) {
                AppView.outputLine("! �Էµ� ���� [�� ��] ���� ������ �л��� ������ [" + student.score() + "] �Դϴ�. ");

            } else {
                AppView.outputLine("! �Էµ� ���� [�� ��] ���� �л��� �����ϴ� �۾��� �����Ͽ����ϴ�. ");

            }
        }
    }

    private void removeFirst() { //����Ʈ �� �� ������Ʈ ����
        AppView.outputLine("");
        AppView.outputLine("! RemoveFirst �۾��� �����մϴ�. ");
        if (this.list().isEmpty()) {
            AppView.outputLine("����Ʈ�� ��� �־ ���� �۾��� �� �� �� �����ϴ�.  ");

        } else {

            Student student = this.list().removeFirst();
            if (student != null) {
                AppView.outputLine("! �Էµ� ���� [�� ��] ���� ������ �л��� ������ [" + student.score() + "] �Դϴ�. ");

            } else {
                AppView.outputLine("! �Էµ� ���� [�� ��] ���� �л��� �����ϴ� �۾��� �����Ͽ����ϴ�. ");

            }
        }
    }

    private void removeFrom() { //����Ʈ Ư�� �ε��� ������Ʈ ����
        AppView.outputLine("");
        AppView.outputLine("! RemoveFrom �۾��� �����մϴ�. : ");
        if (this.list().isEmpty()) {
            AppView.outputLine("����Ʈ�� ��� �־ ���� �۾��� �� �� �� �����ϴ�.  ");
        } else {
            int order = this.inputOrder();
            if (order < 0 || order >= this.list().size()) {
                AppView.outputLine("!  �Էµ� ���� [" + order + "] �� ���� ����[0.." + (this.list().size() - 1) + "] �� ���� �ʽ��ϴ�. ");
                AppView.outputLine("! �Էµ� ���� [" + order + "] ���� �л��� �����ϴ� �۾��� �����Ͽ����ϴ�. ");
                return;

            }
            Student student = this.list().removeFrom(order);
            if (student != null) {
                AppView.outputLine("! �Էµ� ���� [" + order + "] ���� ������ �л��� ������ [" + student.score() + "] �Դϴ�. ");

            } else {
                AppView.outputLine("! �Էµ� ���� [" + order + "] ���� �л��� �����ϴ� �۾��� �����Ͽ����ϴ�. ");

            }
        }
    }

    private void addToLast() { //����Ʈ �� �� ������Ʈ �߰�
        AppView.outputLine("");
        AppView.outputLine("! AddToLast �۾��� �����մϴ�. ");
        if (this.list().isFull()) {
            AppView.outputLine("����Ʈ�� ������ �۾��� ������ �� �����ϴ�. ");
        } else {
            int score = this.inputScore();
            if (this.list().addToLast(new Student(score))) {
                AppView.outputLine("�Էµ� ������ (" + score + ")�� �л��� [�� ��]�� �����ϴ� �۾��� �����Ͽ����ϴ�. ");

            } else {
                AppView.outputLine("�Էµ� ������ (" + score + ")�� �л��� [�� ��]�� �����ϴ� �۾��� �����Ͽ����ϴ�. ");

            }
        }
    }

    private void add() { //����Ʈ ���� ���� ������Ʈ �߰�

        AppView.outputLine("");
        AppView.outputLine("! add �۾��� �����մϴ�. : ");
        int random_num = new Random().nextInt(2);
        if (this.list().isFull()) {
            AppView.outputLine("����Ʈ�� ������ �۾��� ������ �� �����ϴ�. ");

        } else {
            int score = this.inputScore();
            if (random_num == 0) {
                if (this.list().add(new Student(score))) {
                    AppView.outputLine("�Էµ� ������ (" + score + ")�� �л��� [���� ����]�� �����ϴ� �۾��� �����Ͽ����ϴ�. ");

                } else {
                    AppView.outputLine("�Էµ� ������ (" + score + ")�� �л��� ����Ʈ�� �����ϴ� �۾��� �����Ͽ����ϴ�. ");

                }
            } else {
                if (this.list().add(new Student(score))) {
                    AppView.outputLine("�Էµ� ������ (" + score + ")�� �л��� [���� ����]�� �����ϴ� �۾��� �����Ͽ����ϴ�. ");

                } else {
                    AppView.outputLine("�Էµ� ������ (" + score + ")�� �л��� ����Ʈ�� �����ϴ� �۾��� �����Ͽ����ϴ�. ");

                }
            }

        }
    }


    private void addToFirst() { //����Ʈ �� �� ������Ʈ �߰�
        AppView.outputLine("");
        AppView.outputLine("! addToFirst �۾��� �����մϴ�.: ");

        if (this.list().isFull()) {
            AppView.outputLine("����Ʈ�� ������ �۾��� ������ �� �����ϴ�. ");
        } else {
            int score = this.inputScore();
            if (this.list().addToFirst(new Student(score))) {
                AppView.outputLine("�Էµ� ������ (" + score + ")�� �л��� [�� ��]�� �����ϴ� �۾��� �����Ͽ����ϴ�. ");

            } else {
                AppView.outputLine("�Էµ� ������ (" + score + ")�� �л��� [�� ��]�� �����ϴ� �۾��� �����Ͽ����ϴ�. ");

            }
        }
    }

    private void addTo() { //����Ʈ Ư�� �ε��� ������Ʈ �߰�
        AppView.outputLine("");
        AppView.outputLine("! addTo  �۾��� �����մϴ�. ");

        int order = this.inputOrder();

        if (order < 0 || order > this.list().size()) {
            AppView.outputLine("!  �Էµ� ���� [" + order + "] �� ���� ����[0.." + (this.list().size() - 1) + "] �� ���� �ʽ��ϴ�. ");
            return;
        }

        int score = this.inputScore();
        Student student = new Student(score);
        this.list().addTo(student, order);

        AppView.outputLine("! �Էµ� ���� [" + order + "] �� �Էµ� ������ (" + student.score() + ")�� �л��� �����ϴµ� �����Ͽ����ϴ�.  ");


    }

    private void orderOf() { //������ ���Ͽ� ����Ʈ�� �ε��� ���
        AppView.outputLine("");
        AppView.outputLine("! OrderOf �۾��� �����մϴ�. : ");
        AppView.output("�л��� ������ �Է��Ͽ� �ּ���: ");

        int score = this.inputScore();
        int orderIndex = this.list().orderOf(new Student(score));

        if (orderIndex == -1) {
            AppView.outputLine("�Էµ� ���� (" + score + ") �� �л��� ����Ʈ�� �����ϴ�. ");

        } else {
            AppView.outputLine("�Էµ� ���� (" + score + ") �� �л��� ������[" + orderIndex + "] �Դϴ�. ");

        }
    }

    private void last() { //����Ʈ �� �� ������Ʈ ���
        AppView.outputLine("");
        AppView.outputLine("! Last �۾��� ���� �մϴ�. : ");
        Student student = this.list().last();

        if (student == null) {
            AppView.outputLine("�迭�� ��� �ֽ��ϴ�. ");

        } else {
            AppView.outputLine("[�� ��] �л��� ������ (" + student.score() + ") �Դϴ�. ");

        }
    }

    private void first() { //����Ʈ �� �� ������Ʈ ���
        AppView.outputLine("");
        AppView.outputLine("! First �۾��� �����մϴ�. : ");

        Student student = this.list().first();

        if (student == null) {
            AppView.outputLine("�迭�� ��� �ֽ��ϴ�. ");

        } else {
            AppView.outputLine("[�� ��] �л��� ������ (" + student.score() + ") �Դϴ�. ");

        }
    }

    private void elementAt() { //�Է� ������ ���Ͽ� ������Ʈ ���
        AppView.outputLine("");
        AppView.outputLine("! ElementAt �۾��� �����մϴ�. : ");
        int order = this.inputOrder();
        Student student = this.list().elementAt(order);
        if (student == null) {
            AppView.outputLine("�Էµ� ���� [" + order + "] �� �����ϴ� �л��� �����ϴ�. ");

        } else {
            AppView.outputLine("�Էµ� ���� [" + order + "] �� �����ϴ� �л��� ������ (" + student.score() + ") �Դϴ�. ");

        }
    }

    private void doesContain() { //����Ʈ�� ���� ���� Ȯ��
        AppView.outputLine("");
        AppView.outputLine("! DoesContain �۾��� �����մϴ�. ");
        AppView.output("������ �Է��� �ּ���: ");

        int score = this.inputScore();
        boolean flag = this.list().doesContain(new Student(score));

        if (flag) {
            AppView.outputLine(" �Էµ� ����(" + score + ") �� �л� ����Ʈ�� �����մϴ�. ");
        } else {
            AppView.outputLine(" �Էµ� ����(" + score + ") �� �л� ����Ʈ�� �������� �ʽ��ϴ�. . ");

        }
    }

    private void showMenu() { //�޴� ���
        AppView.outputLine("> �ؾ� �� �۾��� ��ȣ�� �����ؾ� �մϴ�. ");
        AppView.outputLine("DoesContain = 1, ElementAt = 2, First = 3, Last = 4, OrderOf = 5 ");
        AppView.outputLine("AddTo = 6, AddFirst = 7, AddToLast = 8, Add = 9, ");
        AppView.outputLine("RemoveFrom = 10, RemoveFirst = 11, RemoveLast = 12, RemoveAny = 13, ReplaceAt = 14, END_OF_RUN = 99 ");
        AppView.output("? �۾� ��ȣ�� �Է��Ͽ� �ּ���: ");

    }


    private void showStatics() { //��� �Լ� ���
        AppView.output("");
        AppView.outputLine("> ����Ʈ ���� �Դϴ�. ");
        AppView.outputLine("! �л� �� : " + this.list().size());
        this.showList();

    }


    private MainMenu selectMenu() {//�޴��� �����մϴ�.
        AppView.outputLine("");

        this.showList();
        this.showMenu();
        int selectedMenuNumber = AppView.inputInteger();

        MainMenu selectedMenuValue = MainMenu.value(selectedMenuNumber);
        return selectedMenuValue;

    }

    private void showList() { //���� ����Ʈ�� ������ �ִ� ������Ʈ ���
        AppView.output("! ���� ����Ʈ ���ҵ� [");
        Student student = null;
        Iterator<Student> iterator = this.list().iterator(); //iterator ����

        while (iterator.hasNext()) {
            student = iterator.next();
            AppView.output(" " + student.score() + " ");

        }
        AppView.outputLine("] ");

    }

    private int inputScore() { //���� �Է�
        int score;

        while (true) {
            try {
                AppView.output("������ �Է��Ͻÿ�: ");
                score = AppView.inputInteger();
                return score;
            } catch (NumberFormatException e) {
                AppView.outputLine("[����] �Էµ� ���� ������ �ƴմϴ�. ");
            }
        }
    }

    private int inputOrder() { //���� �Է�
        int score;
        while (true) {
            try {
                AppView.output("? ����Ʈ������ ���� ��ȣ�� �Է��ϼ���: ");
                score = AppView.inputInteger();
                return score;

            } catch (NumberFormatException e) {
                AppView.outputLine("[����]: �Էµ� ���� ��ȣ�� ������ �ƴմϴ�. ");

            }
        }
    }


}

