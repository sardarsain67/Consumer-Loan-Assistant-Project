import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseMotionAdapter;

public class ConsumerLoanAssistant extends JFrame {
    private JTextField amounttxt;
    private JTextField ratetxt;
    private JTextField numbertxt;
    private JTextField monthtxt;
    private JTextArea loanArea;
    private JLabel amount;
    private JLabel rate;
    private JLabel numberofpay;
    private JLabel monthly;
    private JButton compute;
    private JButton computenew;
    private JButton exit;
    private JLabel analysis;
    private JButton X;
    private JPanel Main;

    public static void main(String[] args) {

        JFrame frame = new JFrame("ConsumerLoanAssistant");
        frame.setContentPane(new ConsumerLoanAssistant().Main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public ConsumerLoanAssistant() {
        computenew.setEnabled(false);
        compute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    int amount = Integer.parseInt(amounttxt.getText());
                    double rate = Integer.parseInt(ratetxt.getText());
                    int totemi = Integer.parseInt(numbertxt.getText());
                    double emi = (amount + (amount * rate * totemi) / 100)/totemi;
                if(amounttxt.getText().equals("")) {
                    JOptionPane.showMessageDialog(null,"please enter loan amount ,rate of intereset and total emi","loan system" ,JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    monthtxt.setText(String.valueOf(emi));
                    compute.setEnabled(false);
                    computenew.setEnabled(true);
                    loanArea.setText("");
                    loanArea.append("Loan amount is :\t\t " +amount + "\n rate of interest : \t\t" +rate  +"\n  total emi :\t\t\t " +totemi +"\nmonthly payment :\t\t" +emi +" \ntotal payment : \t\t" +(amount+(amount*rate*totemi)/100));
                }
            }
        });

        computenew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                amounttxt.setText(null);
                ratetxt.setText(null);
                numbertxt.setText(null);
                monthtxt.setText(null);
              compute.setEnabled(true);
            }
        });
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        X.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                compute.setEnabled(true);
            }
        });
    }
}
