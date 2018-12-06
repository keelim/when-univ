package MainTest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MemberGui extends JFrame implements ActionListener {
    JPanel p;
    JTextField IDField;
    JPasswordField PWField; //비밀번호
    JButton btnInsert, btnCancel, btnUpdate,btnDelete; //가입, 취소, 수정 , 탈퇴 버튼
    GridBagLayout gb;
    GridBagConstraints gbc;
    Member_List mList ;
   
    public MemberGui(){ //가입용 생성자
        createUI(); // UI작성해주는 메소드
        btnUpdate.setEnabled(false);
        btnUpdate.setVisible(false);
        btnDelete.setEnabled(false);
        btnDelete.setVisible(false);
    }//생성자
   
    public MemberGui(Member_List mList){ //가입용 생성자
        createUI(); // UI작성해주는 메소드
        btnUpdate.setEnabled(false);
        btnUpdate.setVisible(false);
        btnDelete.setEnabled(false);
        btnDelete.setVisible(false);
        this.mList = mList;
    }//생성자

    public MemberGui(String id, Member_List mList){ // 수정/삭제용 생성자
        createUI();
        btnInsert.setEnabled(false);
        btnInsert.setVisible(false);
        this.mList = mList;
        System.out.println("id="+id);
        MemberDB dao = new MemberDB();
        MemberSave vMem = dao.getMemberDB(id);
        viewData(vMem);
    }//id를 가지고 생성
 
       
    //ServerMemberSave 의 회원 정보를 가지고 화면에 셋팅해주는 메소드
    private void viewData(MemberSave vMem){
        String id = vMem.getID();
        String pwd = vMem.getPW();
        //화면에 세팅
        IDField.setText(id);
        IDField.setEditable(false); //편집 안되게
        PWField.setText(""); //
    }//viewData
   
   
   
    private void createUI(){
        this.setTitle("회원정보");
        gb = new GridBagLayout();
        setLayout(gb);
        gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;

        //아이디
        JLabel bId = new JLabel("아이디 : ");
        IDField = new JTextField(20);
        //그리드백에 붙이기
        gbAdd(bId, 0, 0, 1, 1);
        gbAdd(IDField, 1, 0, 3, 1);
       
        //비밀번호
        JLabel bPwd = new JLabel("비밀번호 : ");
        PWField = new JPasswordField(20);
        gbAdd(bPwd, 0, 1, 1, 1);
        gbAdd(PWField, 1, 1, 3, 1);
       
        //버튼
        JPanel pButton = new JPanel();
        btnInsert = new JButton("가입");
        btnUpdate = new JButton("수정"); 
        btnDelete = new JButton("탈퇴");
        btnCancel = new JButton("취소");     
        pButton.add(btnInsert);
        pButton.add(btnUpdate);
        pButton.add(btnDelete);
        pButton.add(btnCancel);    
        gbAdd(pButton, 0, 10, 4, 1);
       
        //버튼에 감지기를 붙이자
        btnInsert.addActionListener(this);
        btnUpdate.addActionListener(this);
        btnCancel.addActionListener(this);
        btnDelete.addActionListener(this);
       
        setSize(350,500);
        setVisible(true);
        //setDefaultCloseOperation(EXIT_ON_CLOSE); //System.exit(0) //프로그램종료
        setDefaultCloseOperation(DISPOSE_ON_CLOSE); //dispose(); //현재창만 닫는다.
    }//createUI
   
    //그리드백레이아웃에 붙이는 메소드
    private void gbAdd(JComponent c, int x, int y, int w, int h){
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = w;
        gbc.gridheight = h;
        gb.setConstraints(c, gbc);
        gbc.insets = new Insets(2, 2, 2, 2);
        add(c, gbc);
    }//gbAdd
   
    @Override
    public void actionPerformed(ActionEvent ae) {

        if(ae.getSource() == btnInsert){
            insertMember();
            System.out.println("insertMember() 호출 종료");

        }else if(ae.getSource() == btnCancel){
            this.dispose(); //창닫기 (현재창만 닫힘)
            //system.exit(0)=> 내가 띄운 모든 창이 다 닫힘

        }else if(ae.getSource() == btnUpdate){
            UpdateMember();

        }else if(ae.getSource() == btnDelete){
            //int x = JOptionPane.showConfirmDialog(this,"정말 삭제하시겠습니까?");
            int x = JOptionPane.showConfirmDialog(this,"정말 삭제하시겠습니까?","삭제",JOptionPane.YES_NO_OPTION);
           
            if (x == JOptionPane.OK_OPTION){
                deleteMember();
            }else{
                JOptionPane.showMessageDialog(this, "삭제를 취소하였습니다.");
            }
        }
       
        //jTable내용 갱신 메소드 호출
        mList.jTableRefresh();
       
    }//actionPerformed 
   
   
    private void deleteMember() {
        String id = IDField.getText();
        String pwd = PWField.getText();

        if(pwd.length()==0){ //길이가 0이면
            JOptionPane.showMessageDialog(this, "비밀번호를 꼭 입력하세요!");
            return; //메소드 끝
        }
        //System.out.println(mList);
        MemberDB db = new MemberDB();
        boolean ok = db.deleteMember(id, pwd);
       
        if(ok){
            JOptionPane.showMessageDialog(this, "삭제완료");
            dispose();         
           
        }else{
            JOptionPane.showMessageDialog(this, "삭제실패");
        }
       
    }//deleteMember
   
    private void UpdateMember() {
        //1. 화면의 정보를 얻는다.
        MemberSave save = getViewData();
        //2. 그정보로 DB를 수정
        MemberDB db = new MemberDB();
        boolean ok = db.updateMember(save);
       
        if(ok){
            JOptionPane.showMessageDialog(this, "수정되었습니다.");
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(this, "수정실패: 값을 확인하세요");   
        }
    }
 
    private void insertMember(){
        //화면에서 사용자가 입력한 내용을 얻는다.
        MemberSave dto = getViewData();
        MemberDB dao = new MemberDB();
        boolean ok = dao.insertMember(dto);
       
        if(ok){
            JOptionPane.showMessageDialog(this, "가입이 완료되었습니다.");
            dispose();
           
        }else{
            JOptionPane.showMessageDialog(this, "가입이 정상적으로 처리되지 않았습니다.");
        }
    }//insertMember
   
    public MemberSave getViewData(){
        //화면에서 사용자가 입력한 내용을 얻는다.
        MemberSave save = new MemberSave();
        String id = IDField.getText();
        String pwd = PWField.getText();
        //dto에 담는다.
        save.setID(id);
        save.setPW(pwd);
        return save;
    }
   
}//end