import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BreakPanel extends JPanel {

    // define field name and the form components are binded to this.
    private JPanel showBreakPanel;

    // Auto generated by GUI designer, once you define field names to the form components
    private JLabel timerLabel;
    private JButton startBtn;
    private JButton stopBtn;

    //
    private Timer timer;
    private long endTime = -1;
    private long startTime = -1;
    private long duration = 20000;
    private long elapsed = duration;
    private AudioControl audioControl;

    BreakPanel() {

        audioControl = new AudioControl();

        add(showBreakPanel);

        // A method is needed, so I can trash and recreate a timer without having to worry about resetting it.
        timer = createNewTimer();

        // This is how much the timer waits before firing the first event
        timer.setInitialDelay(0);


        startBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (elapsed <= 0) {
                    duration = 20000;
                    elapsed = duration;
                    timer = createNewTimer();
                }
                timer.start();
            }
        });

        stopBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                duration = elapsed;
                endTime = -1;
                timer.stop();
                audioControl.stop();
            }
        });
    }

    private Timer createNewTimer() {

        // delays (first parameter) tells us how much we have to wait before each time the actionlistener is triggered --> its important to be ~10 miliseconds as 1 can be too harsh.

        return new Timer(10, (ActionListener) e -> {
            if (endTime < 0) {
                endTime = System.currentTimeMillis() + duration;
            }
            long now = System.currentTimeMillis();
            elapsed = endTime - now;
            if (elapsed <= 0) {
                audioControl.play();
                timer.stop();
            }
            long seconds = elapsed / 1000;
            long minutes = seconds / 60;
            this.timerLabel.setText(String.format("%d:%d", minutes, seconds % 60));
        });
    }

    // AUTO GENERATED BY INTELLIJ TO INJECT FORM COMPONENTS

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        showBreakPanel = new JPanel();
        showBreakPanel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(3, 1, new Insets(0, 0, 0, 0), -1, -1));
        timerLabel = new JLabel();
        timerLabel.setText("...");
        showBreakPanel.add(timerLabel, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        startBtn = new JButton();
        startBtn.setText("Start");
        showBreakPanel.add(startBtn, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        stopBtn = new JButton();
        stopBtn.setText("Pause");
        showBreakPanel.add(stopBtn, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return showBreakPanel;
    }
}