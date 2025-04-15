package session_12_OOP_3.Homework.SmartHome.UserProfile;


import session_12_OOP_3.Homework.SmartHome.Devices.Device;
import session_12_OOP_3.Homework.SmartHome.Room;
import session_12_OOP_3.Homework.SmartHome.Scenes.Scene;
import session_12_OOP_3.Homework.SmartHome.Types.ControlType;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class User {
    private String name;
    private final Set<Room> rooms;
    private final Set<Scene> scenes;

    public User(String name) {
        this.name = name;
        this.rooms = new HashSet<>();
        this.scenes = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Room> getRooms() {
        return rooms;
    }

    protected void addRoom(Room room){
        if (this instanceof Owner || this instanceof Member || (this instanceof Guest && room.isCommon())){
            if (rooms.add(room)){
                System.out.println(room.getName() + " added to " + this.name);
            }
        }
    }

    protected void deleteRoom(Room room){
        if (rooms.remove(room)){
            System.out.println(room.getName() + " deleted from " + this.name);
        }
    }

    public <T> void controlDevice(Device device, ControlType control, T value){
        if (existDevice(device)){
            device.handleControl(control, value);
        }
    }

    public void controlDevice(Device device, ControlType control){
        controlDevice(device, control, null);
    }

    protected boolean existDevice(Device device){
        for (Room room : rooms){
            if (room.getDevices().contains(device)){
                return true;
            }
        }
        System.out.println(device.getName() + " doesn't exist in " + name + "'s profile.");
        return false;
    }

    public void addScene(String name){
        if (scenes.add(new Scene(name))){
            System.out.println("Scene " + name + " added to " + this.name + "'s profile.");
        } else {
            System.out.println("Scene " + name + " already exist in " + this.name + "'s profile.");
        }
    }

    public void deleteScene(String name){
        Scene scene = findScene(name);
        if (scene != null){
            System.out.println("Scene " + name + " deleted from " + this.name + "'s profile.");
        }
    }

    private Scene findScene(String name){
        for (Scene scene : scenes){
            if (scene.getName().equals(name)){
                return scene;
            }
        }
        System.out.println("Scene " + name + " doesn't exist in " + this.name + "'s profile.");
        return null;
    }

    public <T> void addSceneAction(String sceneName, Device device, ControlType control, T value){
        Scene scene = findScene(sceneName);

        if (scene != null && existDevice(device)){
            scene.addAction(device, control, value);
        }
    }

    public void addSceneAction(String sceneName, Device device, ControlType control){
        addSceneAction(sceneName, device, control, null);
    }

    public void applyScene(String sceneName){
        Scene scene = findScene(sceneName);

        if (scene != null){
            scene.applyActions();
        }
    }

    public void controlDevice(String voiceCommand){
        Device device = findDevice(voiceCommand.toLowerCase());
        ControlType controlType = findControl(voiceCommand.toLowerCase());
        Object value = findValue(voiceCommand.toLowerCase());

        if (device!=null && controlType != null){
            device.handleControl(controlType, value);
        } else {
            System.out.println("I don't understand the command.");
        }
    }

    private Device findDevice(String voiceCommand){
        for (Device currentDevice : getDevices()){
            if (looselyContains(voiceCommand, currentDevice.getName())){
                return currentDevice;
            }
        }
        return null;
    }

    private Set<Device> getDevices(){
        Set<Device> devices = new LinkedHashSet<>();

        for (Room room : rooms){
            devices.addAll(room.getDevices());
        }

        return devices;
    }

    private boolean looselyContains(String fullText, String phrase) {
        String[] phraseWords = phrase.toLowerCase().toLowerCase().split(" ");

        for (String word : phraseWords) {
            if (!fullText.toLowerCase().contains(word)) {
                return false;
            }
        }
        return true;
    }

    private ControlType findControl(String voiceCommand){
        for (ControlType currentControl : ControlType.values()){
            if (looselyContains(voiceCommand, currentControl.toString().toLowerCase())){
                return currentControl;
            }
        }
        return null;
    }

    private Object findValue(String voiceCommand){
        voiceCommand = voiceCommand.toLowerCase();

        // Check for "to be"
        if (voiceCommand.contains("to be")) {
            return extractAfter(voiceCommand, "to be");
        }
        // Check for just "to"
        else if (voiceCommand.contains("to")) {
            return extractAfter(voiceCommand, "to");
        }

        return null;
    }

    private String extractAfter(String text, String keyword) {
        int index = text.indexOf(keyword);
        if (index == -1) return null;

        String after = text.substring(index + keyword.length()).trim();
        // Stop at first punctuation if any
        after = after.split("[.?!%]")[0];
        // Optional: only grab the first word or value
        return after.split("\\s+")[0];
    }

    @Override
    public String toString() {
        return String.format("""
                %s: %s
                """, name, rooms);
    }
}
