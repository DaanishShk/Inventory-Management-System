package logic;

import domain.containers.Container;

import java.util.ArrayList;

public class Warehouse {

    ArrayList<Container> containerList;
    private int maxCount;
    private int currCount;

    public Warehouse(int maxNumber) {
        this.containerList = new ArrayList<>();
        this.maxCount = maxNumber;
        this.currCount = 0;
    }

    public boolean addContainer(Container container) {
        if(currCount == maxCount) {
            return false;
        }
        this.containerList.add(container);
        return true;
    }

    public Container getContainer(int containerID) {
        Container temp = null;
        for(Container c: this.containerList) {
            if(c.getId() == containerID) {
                temp = c;
                break;
            }
        }
        return temp;
    }

    public boolean removeContainer(int containerID) {
        Container temp = this.getContainer(containerID);
        if(temp==null) {
            return false;
        }
        return this.containerList.remove(temp);
    }

    public void printContainers() {
        System.out.println("Warehouse Contents:");
        int cnt = 1;
        for(Container c: this.containerList) {
            System.out.println(cnt+". "+c);
            cnt++;
        }
    }
}
