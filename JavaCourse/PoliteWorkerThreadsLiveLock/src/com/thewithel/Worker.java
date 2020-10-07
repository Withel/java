package com.thewithel;

public class Worker {

    private String name;
    private boolean active;

    public Worker(String name, boolean active) {
        this.name = name;
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public boolean isActive() {
        return active;
    }

    //the only way to exit this loop is to thread having a resource, and
    //another thread isnt active
    public synchronized  void work(SharedResource sharedResource, Worker otherWorker){

        while(active){
            if(sharedResource.getOwner() != this){
                try {
                    wait(10);
                } catch (InterruptedException e){

                }
                continue;
            }

            if(otherWorker.isActive() ){
                System.out.println(getName() + " : give the resource to the worker " + otherWorker.getName());
                sharedResource.setOwner(otherWorker);
                continue;
            }

            System.out.println(getName() + ": working on th ecommon resoruce");
            active = false;
            sharedResource.setOwner(otherWorker);
        }
    }
}
