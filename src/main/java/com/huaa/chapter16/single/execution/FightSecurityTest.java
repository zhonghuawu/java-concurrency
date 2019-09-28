package com.huaa.chapter16.single.execution;

public class FightSecurityTest {
    static class Passengers extends Thread {
        private final FlightSecurity flightSecurity;
        private final String idCard;
        private final String boardingPass;

        public Passengers(FlightSecurity flightSecurity, String idCard, String boardingPass) {
            this.flightSecurity = flightSecurity;
            this.idCard = idCard;
            this.boardingPass = boardingPass;
        }


        public void run() {
            int count = 100_000;
            while (count-- >= 0) {
                flightSecurity.pass(boardingPass, idCard);
            }
        }

    }


    public static void main(String[] args) {
        final FlightSecurity flightSecurity = new FlightSecurity();
        new Passengers(flightSecurity, "A123456", "AF123456").start();
        new Passengers(flightSecurity, "B123456", "BF123456").start();
        new Passengers(flightSecurity, "C123456", "CF123456").start();
    }

}
