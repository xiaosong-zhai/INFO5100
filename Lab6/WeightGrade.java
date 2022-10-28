package com.zxsipromise.Lab6;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WeightGrade implements ActionListener {
    Windows windows = null;
    public WeightGrade(Windows windows){                //constructor
        this.windows = windows;
    }
    @Override
    public void actionPerformed(ActionEvent e) {     // actionlistener
        int tp = Integer.parseInt(windows.totalPoint.getText());
        double ea = Double.parseDouble(windows.earnedPoint.getText());
        double pre = Double.parseDouble(windows.precentage.getText());
        windows.finalPoint.setText(""+ ((ea / tp) * ( pre / 100) * 100));
    }
}
