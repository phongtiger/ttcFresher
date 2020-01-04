package Part1Collection;

import java.util.ArrayList;
import java.util.List;

public class Bill {
    private int id;
    private String name;
    private long money;
    private String date;

    public Bill() {
    }

    public Bill(int id, String name, long money, String date) {
        this.id = id;
        this.name = name;
        this.money = money;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money=" + money +
                ", date='" + date + '\'' +
                '}';
    }
    public static List<Bill> getList(){
        Bill bill1 = new Bill(1, "a1", 1000000, "2020-01-22");
        Bill bill2 = new Bill(2, "a2", 20, "2020-01-22");
        Bill bill3 = new Bill(3, "a3", 120000000, "2020-03-22");
        Bill bill4 = new Bill(4, "a4", 1333, "2020-05-22");
        Bill bill5 = new Bill(3, "a3", 9555, "2020-05-22");
        Bill bill6 = new Bill(6, "a6", 70, "2020-02-22");
        Bill bill7 = new Bill(7, "a7", 9000000, "2020-01-22");
        Bill bill8 = new Bill(8, "a8", 1009, "2020-01-20");
        Bill bill9 = new Bill(9, "a1", 1000000, "2020-01-22");
        Bill bill10 = new Bill(7, "a2", 20, "2020-01-22");
        Bill bill11 = new Bill(11, "a6", 120000000, "2020-03-22");
        Bill bill12 = new Bill(12, "a4", 1333, "2020-05-22");
        Bill bill13 = new Bill(13, "a5", 9555, "2020-05-22");
        Bill bill14 = new Bill(11, "a6", 70, "2020-02-22");
        Bill bill15 = new Bill(15, "a7", 9000000, "2020-01-22");
        Bill bill16 = new Bill(11, "a6", 1009, "2020-01-20");
        List<Bill> list = new ArrayList<>();
        list.add(bill1);
        list.add(bill2);
        list.add(bill3);
        list.add(bill4);
        list.add(bill5);
        list.add(bill6);
        list.add(bill7);
        list.add(bill8);
        list.add(bill9);
        list.add(bill10);
        list.add(bill11);
        list.add(bill12);
        list.add(bill13);
        list.add(bill14);
        list.add(bill15);
        list.add(bill16);
        return list;
    }
    @Override

    public int hashCode(){

        return id;

    }
    @Override

    public boolean equals(Object obj){

        if(obj instanceof Bill){

            return ((Bill) obj).name.equals(this.name);

        }

        return false;
    }
}
