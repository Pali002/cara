package controllers;

import javax.swing.Timer;

import models.MainModel;
import views.MainFrame;

public class MainController {
    MainFrame mainFrame;
    MainModel mainModel;
    Timer timer;
    public MainController() {
        this.mainFrame = new MainFrame();
        this.mainModel = new MainModel();
        this.timer = new Timer(400, e -> onTime());
        this.setEvents();
    }
    private void onTime() {
        //System.out.println("Mukodik");
        this.mainFrame.trackPanel.car1.go();
        this.mainFrame.trackPanel.car2.go();
        this.mainFrame.trackPanel.car3.go();
    }
    private void setEvents() {
        this.mainFrame.buttonPanel.startButton.addActionListener(e -> onCLickStartButton());
    }
    private void onCLickStartButton() {
        this.timer.start();
    }
}
