package zrc.array.DigitGroup.src.zrc.array;

import java.util.Scanner;

/*
作业：使用二维数组模拟酒店管理系统，模拟订房、退房、打印所有房间状态功能
 */
public class ArrayManager {
}

class Room{
    private String roomIndex;
    private String roomType;
    private boolean isHire;

    public Room(String roomIndex, String roomType) {
        this.roomIndex = roomIndex;
        this.roomType = roomType;
    }

    public String getRoomIndex() {
        return roomIndex;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setHire(boolean hire) {
        isHire = hire;
    }

    public boolean isHire() {
        return isHire;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomIndex='" + roomIndex + '\'' +
                ", roomType='" + roomType + '\'' +
                '}';
    }
}

class Hotel{
    private Room[][] rooms;
    private int floorNum;
    private int roomNum;

    public Hotel(int floorNum, int roomNum) {
        rooms = new Room[floorNum][roomNum];
        this.floorNum = floorNum;
        this.roomNum = roomNum;
    }

    public void fixedRoom(){
        System.out.println("空闲房间编号如下");
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                if (!rooms[i][j].isHire()){
                    System.out.println(rooms[i][j]);
                }
            }
        }
        System.out.println("请输入要预定的房间编号");
        Scanner scanner = new Scanner(System.in);
        String index = scanner.next();
        for (int i = 0; i < rooms.length; i++){
            for (int j = 0; j < rooms[i].length; j++) {
                if (rooms[i][j].getRoomIndex() == index){
                    rooms[i][j].setHire(true);
                }
            }
        }
    }

    public void checkOut(){
        System.out.println("请输入房间编号");
        Scanner scanner = new Scanner(System.in);
        String index = scanner.next();
        for (int i = 0; i < rooms.length; i++){
            for (int j = 0; j < rooms[i].length; j++) {
                if (rooms[i][j].getRoomIndex() == index){
                    rooms[i][j].setHire(false);
                }
            }
        }
    }

    public void printRoom(){
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                System.out.println(rooms[i][j]);
            }
        }
    }
}