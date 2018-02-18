package com.sda.watki;

public class Waiter implements Runnable {

    private Message message;

    public Waiter(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();

        synchronized (message) {
            try{
                System.out.println("Watek o nazwie "+name+" został powiadomiony o godzinie: "+System.currentTimeMillis());
                message.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Object waiter otrzymał notyfikację: "+System.currentTimeMillis());
            System.out.println("Wiadomość: "+message.getMessage());
        }
    }
}
