package session_12_OOP_3.Homework.SmartHome;

import session_12_OOP_3.Homework.SmartHome.Automation.Trigger;
import session_12_OOP_3.Homework.SmartHome.Devices.*;
import session_12_OOP_3.Homework.SmartHome.Types.Colour;
import session_12_OOP_3.Homework.SmartHome.Types.ControlType;
import session_12_OOP_3.Homework.SmartHome.Types.TriggerType;
import session_12_OOP_3.Homework.SmartHome.UserProfile.Guest;
import session_12_OOP_3.Homework.SmartHome.UserProfile.Member;
import session_12_OOP_3.Homework.SmartHome.UserProfile.Owner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SmartHome {
    static Owner jane = new Owner("Jane");
    static Member alice = new Member("Alice");
    static Guest maria = new Guest("Maria");

    static Room outdoor = new Room("Main entrance");
    static Room hallway = new Room("Main hallway");
    static Room livingRoom = new Room("Living room");
    static Room bedRoom = new Room("Bedroom");
    static Room kitchen = new Room("Kitchen");
    static Room bathroom = new Room("Bathroom", true);

    static Door frontDoor = new Door("Front door", 20d);
    static Window livingRoomWindow = new Window("Living room window", 20d);
    static Window kitchenWindow = new Window("Kitchen window", 60d);
    static Door backdoor = new Door("Back door", 60d);
    static Camera entranceCamera = new Camera("Entrance camera", 75d);
    static TV livingRoomTv = new TV ("Livingroom tv", 80d);
    static Thermostat bedRoomThermostat = new Thermostat("Bedroom thermostat", 30d);
    static Door doorToDelete = new Door("Door to delete", 30d);
    static SmokeDetector smokeDetector = new SmokeDetector("Kitchen smoke detector", 15d);
    static Lights livingRoomLights = new Lights("Living room lights", 15d);

    static List<Room> rooms = new ArrayList<>(List.of(outdoor, hallway, livingRoom, bedRoom, bathroom, kitchen));
    static Map<Device, Room> devices = Map.of(
            frontDoor, hallway,
            livingRoomWindow, livingRoom,
            kitchenWindow, kitchen,
            backdoor, kitchen,
            entranceCamera, outdoor,
            livingRoomTv, livingRoom,
            bedRoomThermostat, bedRoom,
            doorToDelete, livingRoom,
            smokeDetector, kitchen,
            livingRoomLights, livingRoom
    );

    public static void main(String[] args) {
        System.out.println("User profile:\n");
        userProfile();

        System.out.println("\nDevice management:\n");
        deviceManagement();

        System.out.println("\nScenes:\n");
        scenes();

        System.out.println("\nAutomations:\n");
        automations();

        System.out.println("\nVoice commands:\n");
        voiceCommands();

        System.out.println("\nEnergy management:\n");
        energyManagement();

        System.out.println("\nSecurity and alerts:\n");
        securityAndAlerts();
    }

    public static void securityAndAlerts(){
        jane.controlDevice("Open the front door");
        System.out.println();

        entranceCamera.setMovement(true);
        entranceCamera.setMovement(false);
        System.out.println();

        smokeDetector.setSmoke(true);
    }

    public static void energyManagement(){
        // Energy-saving
        jane.controlDevice(livingRoomLights, ControlType.TURN_ON);
        jane.controlDevice(livingRoomWindow, ControlType.OPEN);
        jane.controlDevice(livingRoomTv, ControlType.TURN_ON);
        System.out.println();

        livingRoom.setLastOccupiedTime(LocalDateTime.of(2025, 4, 5, 20, 0));
        livingRoom.setRoomEmpty();

        // Energy reports
        frontDoor.getEnergyManager().setLastGeneratedReport(LocalDate.of(2025, 3, 5));
        frontDoor.getEnergyManager().setCurrentDate(LocalDateTime.now());

        try {
            alice.controlDevice(livingRoomLights, ControlType.TURN_ON);
            Thread.sleep(10000);
            alice.controlDevice(livingRoomLights, ControlType.TURN_OFF);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        livingRoomLights.getEnergyManager().setLastGeneratedReport(LocalDate.of(2025, 3, 5));
        livingRoomLights.getEnergyManager().setCurrentDate(LocalDateTime.now());
    }

    public static void voiceCommands(){
        jane.controlDevice("Turn on the living room lights.");
        alice.controlDevice("Lock the front door");
        maria.controlDevice("Turn the living room lights off.");
        maria.controlDevice("Change the brightness of living room lights to 20%");
        maria.controlDevice("Open the front door"); // Doesn't exist in the list.
    }

    public static void automations(){
        Trigger frontDoorTrigger = new Trigger(TriggerType.TIME);
        frontDoor.addTrigger(frontDoorTrigger);

        jane.setTriggerRule(frontDoor, frontDoorTrigger, LocalTime.of(17, 50), ControlType.LOCK);
        jane.setTriggerRule(frontDoor, frontDoorTrigger, LocalTime.of(8, 0), ControlType.UNLOCK);

        Trigger thermostatTrigger = new Trigger(TriggerType.TEMPERATURE);
        bedRoomThermostat.addTrigger(thermostatTrigger);

        jane.setTriggerRule(bedRoomThermostat, thermostatTrigger, 19d, ControlType.CHANGE_TEMPERATURE, 23d);
        jane.setTriggerRule(bedRoomThermostat, thermostatTrigger, 24d, ControlType.TURN_OFF);

        frontDoorTrigger.setCurrentValue(LocalTime.of(8, 1));
        frontDoorTrigger.setCurrentValue(LocalTime.of(17, 51));

        thermostatTrigger.setCurrentValue(18d);
        thermostatTrigger.setCurrentValue(24d);
        thermostatTrigger.setCurrentValue(18.9);
    }

    public static void scenes(){
        maria.addScene("Night Mode");
        maria.addSceneAction("Night Mode", frontDoor, ControlType.CLOSE);
        maria.addSceneAction("Night Mode", kitchenWindow, ControlType.CLOSE);
        maria.addSceneAction("Night Mode", livingRoomWindow, ControlType.CLOSE);
        maria.applyScene("Night Mode");

        System.out.println();
        alice.addScene("Night Mode");
        alice.addSceneAction("Night Mode", frontDoor, ControlType.CLOSE);
        alice.addSceneAction("Night Mode", kitchenWindow, ControlType.CLOSE);
        alice.addSceneAction("Night Mode", livingRoomWindow, ControlType.CLOSE);
        alice.addSceneAction("Night Mode", livingRoomLights, ControlType.CHANGE_BRIGHTNESS, 30);
        alice.addSceneAction("Night Mode", livingRoomLights, ControlType.CHANGE_COLOUR, Colour.YELLOW);
        alice.applyScene("Night Mode");
    }

    public static void deviceManagement(){
        jane.controlDevice(frontDoor, ControlType.OPEN);
        alice.controlDevice(kitchenWindow, ControlType.OPEN);
        maria.controlDevice(kitchenWindow, ControlType.CLOSE);
        maria.controlDevice(livingRoomWindow, ControlType.OPEN);
        maria.controlDevice(livingRoomLights, ControlType.CHANGE_BRIGHTNESS, 20);

        livingRoomLights.showDetails();
    }

    public static void userProfile(){
        System.out.println("User profile");

        for (Room room : rooms){
            jane.addRoom(room);
        }

        jane.makeRoomCommon(livingRoom, true);

        jane.addFriend(alice);
        jane.addFriend(maria);

        for (Map.Entry<Device, Room> entry : devices.entrySet()){
            jane.addDevice(entry.getKey(), entry.getValue());
        }

        jane.deleteDevice(doorToDelete);

        System.out.println(jane);
        System.out.println(alice);
        System.out.println(maria);
    }
}
