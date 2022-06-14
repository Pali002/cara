package controllers;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JOptionPane;
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
        this.mainFrame.trackPanel.car1.setNewSpeed();
        this.mainFrame.trackPanel.car2.go();
        this.mainFrame.trackPanel.car3.go();

        if(this.mainFrame.trackPanel.car1.speedVisible) {
            Integer actSpeed = this.mainFrame.trackPanel.car1.actSpeed;
            this.mainFrame.trackPanel.car1.setText(actSpeed.toString());
            this.mainFrame.trackPanel.car1.setForeground(Color.white);
        }else {
            this.mainFrame.trackPanel.car1.setText("");
        }
    }
    private void setEvents() {
        JButton startButton = this.mainFrame.buttonPanel.startButton;
        startButton.addActionListener(e -> onCLickStartButton());
        JButton stopButton = this.mainFrame.buttonPanel.stopButton;
        stopButton.addActionListener(e -> onCLickStopButton());
        JButton resetButton = this.mainFrame.buttonPanel.resetButton;
        resetButton.addActionListener(e -> onCLickResetButton());
        JButton speedButton = this.mainFrame.buttonPanel.speedButton;
        speedButton.addActionListener(e -> onCLickSpeedButton());
        JButton aboutButton = this.mainFrame.buttonPanel.aboutButton;
        aboutButton.addActionListener(e -> onCLickAboutButton());
        JButton exitButton = this.mainFrame.buttonPanel.exitButton;
        exitButton.addActionListener(e -> onCLickExitButton());
    }
    private void onCLickStartButton() {
        this.timer.start();
    }
    private void onCLickStopButton() {
        this.timer.stop();
    }
    private void onCLickResetButton() {
        this.timer.stop();
        this.mainFrame.trackPanel.car1.setLocation(5, 10);
        this.mainFrame.trackPanel.car2.setLocation(5, 60);
        this.mainFrame.trackPanel.car3.setLocation(5, 110);
    }
    private void onCLickSpeedButton() {
        this.mainFrame.trackPanel.car1.toggleSpeedVisible();
        this.mainFrame.trackPanel.car2.toggleSpeedVisible();
        this.mainFrame.trackPanel.car3.toggleSpeedVisible();
    }
    private void onCLickAboutButton() {
        JOptionPane.showMessageDialog(this.mainFrame, "Zentai Pál, 2022-06-14");
    }
    private void onCLickExitButton() {
        System.exit(0);
    }
}