package session_12_OOP_3.Homework.SmartHome;

import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class EnergyManager {
    private final String deviceName;
    private final double energyConsumption; // in watts
    private double totalEnergyConsumed; // total energy consumed over time in kWh
    private LocalDate lastGeneratedReport;
    private LocalDateTime usageStart;
    private LocalDateTime currentDate;

    public EnergyManager(String deviceName, double energyConsumption) {
        this.deviceName = deviceName;
        this.energyConsumption = energyConsumption;
        this.totalEnergyConsumed = 0;
        this.lastGeneratedReport = LocalDate.now();
        this.currentDate = LocalDateTime.now();
    }

    public void setLastGeneratedReport(LocalDate lastGeneratedReport) {
        this.lastGeneratedReport = lastGeneratedReport;
    }

    public void setCurrentDate(LocalDateTime currentDate) {
        this.currentDate = currentDate;
        checkAutoGenerateReport();
    }

    public void addEnergyConsumption(){
        totalEnergyConsumed += energyConsumption;
    }

    public void startUsage() {
        usageStart = LocalDateTime.now();
    }

    public void stopUsage() {
        if (usageStart != null) {
            LocalDateTime now = LocalDateTime.now();
            Duration duration = Duration.between(usageStart, now);
            long seconds = Math.max(1, duration.getSeconds());

            totalEnergyConsumed += energyConsumption * seconds;
            usageStart = null;
        }
    }

    private void checkAutoGenerateReport(){
        if (lastGeneratedReport.plusMonths(1).isBefore(LocalDate.now())){
            generateReport();
            reset();
        }
    }

    private void generateReport(){
        String filename = "Files/Homework_session_12/report_" + deviceName.replaceAll(" ", "_") + "_" + LocalDate.now() + ".csv";
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write("Device name, Total consumption (kWh)\n");
            writer.write(deviceName + "," + String.format("%.2f", totalEnergyConsumed) + "\n");
            System.out.println("Auto-generated report for " + deviceName + ": " + filename);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void reset(){
        totalEnergyConsumed = 0;
        lastGeneratedReport = LocalDate.now();
    }

    public double getTotalEnergyConsumed() {
        double total = totalEnergyConsumed / 1000.0;
        return (double) Math.round(total * 100) / 100;
    }
}
