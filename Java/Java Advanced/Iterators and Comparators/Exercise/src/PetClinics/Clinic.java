package PetClinics;

import java.util.Iterator;

public class Clinic implements Iterable {
    private String name;
    private Pet[] rooms;

    public Clinic(String name, int roomsCount) {
        this.name = name;
        this.setRooms(roomsCount);
    }

    private void setRooms(int roomsCount) {
        this.rooms = new Pet[roomsCount];
    }

    public boolean add(Pet pet) {
        int index = 0;
        for (int i = 0; i < this.rooms.length; i += 2) {
            int currentIndex = this.rooms.length / 2;
            if (this.rooms[currentIndex - index] == null) {
                this.rooms[currentIndex - index] = pet;
                return true;
            } else if (rooms[currentIndex + index] == null) {
                this.rooms[currentIndex + index] = pet;
                return true;
            }

            index++;
        }

        return false;
    }

    public boolean release() {
        for (int i = this.rooms.length / 2; i < this.rooms.length; i++) {
            if (this.rooms[i] != null) {
                this.rooms[i] = null;
                return true;
            }
        }

        for (int i = 0; i < this.rooms.length / 2; i++) {
            if (this.rooms[i] != null) {
                this.rooms[i] = null;
                return true;
            }
        }
        return false;
    }

    public boolean HasEmptyRooms() {
        for (int i = 0; i < this.rooms.length; i++) {
            if (this.rooms[i] == null) {
                return true;
            }
        }

        return false;
    }

    public void print() {
        for (int i = 0; i < this.rooms.length; i++) {
            if (this.rooms[i] == null) {
                System.out.println("Room empty");
            } else {
                System.out.println(this.rooms[i].toString());
            }
        }
    }

    public void print(int room) {
        if (this.rooms[room - 1] == null) {
            System.out.println("Room empty");
        } else {
            System.out.println(this.rooms[room - 1].toString());
        }
    }

    @Override
    public Iterator iterator() {
        return null;
    }
}
