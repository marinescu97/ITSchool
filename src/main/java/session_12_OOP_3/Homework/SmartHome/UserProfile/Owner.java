package session_12_OOP_3.Homework.SmartHome.UserProfile;

import session_12_OOP_3.Homework.SmartHome.Automation.Trigger;
import session_12_OOP_3.Homework.SmartHome.Devices.Device;
import session_12_OOP_3.Homework.SmartHome.Room;
import session_12_OOP_3.Homework.SmartHome.Types.ControlType;

import java.util.HashSet;
import java.util.Set;

public class Owner extends User {
    private final Set<User> friends;

    public Owner(String name) {
        super(name);
        this.friends = new HashSet<>();
    }

    public Set<User> getFriends() {
        return friends;
    }

    public void makeRoomCommon(Room room, boolean common){
        if (getRooms().contains(room)){
            room.setCommon(common);
        }
    }

    @Override
    public void addRoom(Room room){
        super.addRoom(room);
        handleFriendsRooms("Add", room);
    }

    @Override
    public void deleteRoom(Room room) {
        super.deleteRoom(room);
        handleFriendsRooms("Delete", room);
    }

    private void handleFriendsRooms(String action, Room room){
        for (User friend : friends){
            if (action.equals("Add")){
                friend.addRoom(room);
            } else if (action.equals("Delete")) {
                friend.deleteRoom(room);
            }
        }
    }

    public void addFriend(User user){
        if (friends.add(user)){
            System.out.println(user.getClass().getSimpleName() + " " + user.getName() + " added successfully.");
            updateFriendRooms(user);
        }
    }

    private void updateFriendRooms(User friend){
        for (Room room : getRooms()){
            friend.addRoom(room);
        }
    }

    public void addDevice(Device device, Room room){
        if (getRooms().contains(room)){
            room.addDevice(device);
            device.setHomeOwner(this);
        } else {
            System.out.println("The " + room + " is not in the list.");
        }
    }

    public void deleteDevice(Device device){
        Room room = getDeviceRoom(device);

        if (room == null){
            System.out.println("The " + device.getName() + " is not assigned to any room.");
        } else {
            room.getDevices().remove(device);
            device.setHomeOwner(null);
            System.out.println("The " + device.getName() + " was deleted from " + room.getName() + ".");
        }
    }

    private Room getDeviceRoom(Device device){
        for (Room room : getRooms()){
            if (room.getDevices().contains(device)){
                return room;
            }
        }

        return null;
    }

    public void setTriggerRule(Device device, Trigger trigger, Object targetValue, ControlType controlType){
        setTriggerRule(device, trigger, targetValue, controlType, null);
    }

    public void setTriggerRule(Device device,Trigger trigger, Object targetValue, ControlType controlType, Object value){
        if (existDevice(device)){
            device.addTriggerRule(trigger, targetValue, controlType, value);
        }
    }

    public void deleteTriggerRule(Device device, Trigger trigger, Object value){
        if (existDevice(device)){
            device.deleteTriggerRule(trigger, value);
        }
    }
}
