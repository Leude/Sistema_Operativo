package util;

import javax.swing.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Reloj extends Thread{
    private JLabel label;
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");


    public Reloj(JLabel label){
        super();
        this.label=label;
    }

    @Override
    public void run() {
        while (true) {
            LocalTime time = LocalTime.now();
            label.setText(dtf.format(time));
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
