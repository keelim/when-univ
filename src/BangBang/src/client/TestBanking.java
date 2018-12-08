package BangBang.src.client; // 실질적인 클라이언트 조정 부분

import BangBang.src.bank.Bank;

import javax.swing.*;
import java.io.Serializable;
import java.util.Random;

public class TestBanking extends JFrame implements Serializable {
    private static final long serialVersionUID = 1L;
    private static Bank bank;
    private static BankClient bClnt;

    // GUI Components
    JLabel executeLabel, bankStatusLabel;
    JList executeList, bankStatusList;
    JButton withdrawTestBtn, depositTestBtn, transTestBtn, quitBtn;
    JScrollPane executeScroller, bankStatusScroller;
    DefaultListModel executeModel, bankStatusModel;

    public TestBanking() {
        // GUI
        super("Bank with Socket");

        executeLabel = new JLabel("����Ǵ� ���");
        executeModel = new DefaultListModel();
        executeList = new JList(executeModel);
        executeScroller = new JScrollPane(executeList);
        executeScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        bankStatusLabel = new JLabel("���� ����");
        bankStatusModel = new DefaultListModel();
        bankStatusList = new JList(bankStatusModel);
        bankStatusScroller = new JScrollPane(bankStatusList);
        bankStatusScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        withdrawTestBtn = new JButton("����׽�Ʈ");
        depositTestBtn = new JButton("�Ա��׽�Ʈ");
        transTestBtn = new JButton("��ü�׽�Ʈ");
        quitBtn = new JButton("����");

        JPanel ButtonsPanel = new JPanel();
        ButtonsPanel.add(withdrawTestBtn);
        ButtonsPanel.add(depositTestBtn);
        ButtonsPanel.add(transTestBtn);
        ButtonsPanel.add(quitBtn);

        setLayout(null);
        add(executeLabel);
        executeLabel.setBounds(40, -10, 100, 100);
        add(bankStatusLabel);
        bankStatusLabel.setBounds(420, -10, 100, 100);

        add(executeScroller);
        executeScroller.setBounds(40, 55, 350, 600);
        add(bankStatusScroller);
        bankStatusScroller.setBounds(420, 55, 550, 600);

        add(ButtonsPanel);
        ButtonsPanel.setBounds(200, 700, 500, 100);
        setSize(1000, 800);
        setVisible(true);

        // �Ա��׽�Ʈ
        depositTestBtn.addActionListener(event -> {
            // ��������ȣ�� ���¹�ȣ
            Random rand = new Random();
            int randCus = rand.nextInt(bank.getNumOfCustomers());
            int randAcct = rand.nextInt(bank.getCustomer(randCus).getNumOfAccounts());
            int randAmount = rand.nextInt(1000);

            bClnt.resultComm = bClnt.Deposit(randCus, randAcct, (double) randAmount);
            bank = bClnt.resultComm.getBank();
            showBankInfo();

            executeModel.addElement("[�Ա��׽�Ʈ]");
            executeModel.addElement("�̸� : " + bank.getCustomer(randCus).getFirstName()
                    + bank.getCustomer(randCus).getLastName() + "  ���¹�ȣ : "
                    + bank.getCustomer(randCus).getAccount(randAcct).getAcctNum() + "  �Աݾ� : " + randAmount);
            executeModel.addElement("\n");
        });

        // ����׽�Ʈ
        withdrawTestBtn.addActionListener(event -> {
            // ��������ȣ�� ���¹�ȣ
            Random rand = new Random();
            int randCus = rand.nextInt(bank.getNumOfCustomers());
            int randAcct = rand.nextInt(bank.getCustomer(randCus).getNumOfAccounts());
            int randAmount = rand.nextInt(1000);

            bClnt.resultComm = bClnt.Withdraw(randCus, randAcct, (double) randAmount);
            bank = bClnt.resultComm.getBank();
            showBankInfo();

            executeModel.addElement("[����׽�Ʈ]");
            executeModel.addElement("�̸� : " + bank.getCustomer(randCus).getFirstName()
                    + bank.getCustomer(randCus).getLastName() + "  ���¹�ȣ : "
                    + bank.getCustomer(randCus).getAccount(randAcct).getAcctNum() + "  ��ݾ� : " + randAmount);
            executeModel.addElement("\n");
        });

        // ��ü�׽�Ʈ
        transTestBtn.addActionListener(event -> {
            // ��������ȣ�� ���¹�ȣ
            Random rand = new Random();
            int randCus = rand.nextInt(bank.getNumOfCustomers());
            int randAcct = rand.nextInt(bank.getCustomer(randCus).getNumOfAccounts());
            int randCus2 = rand.nextInt(bank.getNumOfCustomers());
            int randAcct2 = rand.nextInt(bank.getCustomer(randCus).getNumOfAccounts());
            int randAmount = rand.nextInt(1000);

            while (true) {
                if (randCus == randCus2) {
                    randCus2 = rand.nextInt(bank.getNumOfCustomers());
                    continue;
                } else if (randAcct == randAcct2) {
                    randAcct2 = rand.nextInt(bank.getCustomer(randCus).getNumOfAccounts());
                    continue;
                } else
                    break;
            }

            bClnt.resultComm = bClnt.Transfer(randCus, randAcct, randCus2, randAcct2, (double) randAmount);
            bank = bClnt.resultComm.getBank();
            showBankInfo();
            executeModel.addElement("[������ü�׽�Ʈ]");
            executeModel.addElement("�̸� : " + bank.getCustomer(randCus).getFirstName()
                    + bank.getCustomer(randCus).getLastName() + "��  " + bank.getCustomer(randCus2).getFirstName()
                    + bank.getCustomer(randCus2).getLastName() + "���� ");
            executeModel.addElement("���¹�ȣ : " + bank.getCustomer(randCus).getAccount(randAcct).getAcctNum() + "���� "
                    + bank.getCustomer(randCus2).getAccount(randAcct2).getAcctNum());
            executeModel.addElement("  �ݾ� : " + randAmount + "�� ��ü�Ͽ����ϴ�");
            executeModel.addElement("\n");
        });

        // ����
        quitBtn.addActionListener(arg0 -> {
            setVisible(false);
            bClnt.close();
            System.exit(0);
        });

        // ó���� ������ �����ϸ� ������ ���� �����ͼ� �Ѹ���
        bClnt.resultComm = bClnt.getBankInfo();
        bank = bClnt.resultComm.getBank();
        showBankInfo();
    }

    public static void main(String[] args) {
        bClnt = new BankClient("localhost", 12345);
        new TestBanking();
    }

    public void showBankInfo() {
        bankStatusModel.clear();

        for (int i = 0; i < bank.getNumOfCustomers(); i++) {
            for (int j = 0; j < bank.getCustomer(i).getNumOfAccounts(); j++) {
                String temp;
                temp = "�̸� : " + bank.getCustomer(i).getFirstName() + bank.getCustomer(i).getLastName() + ",  ���� ���� : "
                        + bank.getCustomer(i).getAccount(j).getAcctType() + ",  ���� ��ȣ : "
                        + bank.getCustomer(i).getAccount(j).getAcctNum() + ",  �ܾ� : "
                        + bank.getCustomer(i).getAccount(j).getBalance();
                bankStatusModel.addElement(temp);
            }
            bankStatusModel.addElement("\n");
        }
    }
}
