import java.util.List;

interface Vehicle {
    void move();
}

interface EngineStartable {
    void startEngine();
}

interface Refuelable {
    void isiBahanBakar();
}

interface Rechargeable {
    void isiBaterai();
}

class ElectricCar implements Vehicle, EngineStartable, Rechargeable {
    @Override
    public void move() {
        System.out.println("Mobil listrik melaju tanpa suara.");
    }

    @Override
    public void startEngine() {
        System.out.println("Menyalakan motor listrik...");
    }

    @Override
    public void isiBaterai() {
        System.out.println("Mengisi baterai kendaraan listrik...");
    }
}

class GasolineCar implements Vehicle, EngineStartable, Refuelable {
    @Override
    public void move() {
        System.out.println("Mobil bensin melaju di jalan raya.");
    }

    @Override
    public void startEngine() {
        System.out.println("Menyalakan mesin kendaraan...");
    }

    @Override
    public void isiBahanBakar() {
        System.out.println("Mengisi bahan bakar kendaraan...");
    }
}

class Bicycle implements Vehicle {
    @Override
    public void move() {
        System.out.println("Sepeda dikayuh.");
    }
}

class HybridCar implements Vehicle, EngineStartable, Refuelable, Rechargeable {
    @Override
    public void move() {
        System.out.println("Mobil hybrid melaju hemat energi.");
    }

    @Override
    public void startEngine() {
        System.out.println("Menyalakan sistem hybrid...");
    }

    @Override
    public void isiBahanBakar() {
        System.out.println("Mengisi bahan bakar mobil hybrid...");
    }

    @Override
    public void isiBaterai() {
        System.out.println("Mengisi baterai mobil hybrid...");
    }
}

class ChargingStation {
    public void charge(Rechargeable vehicle) {
        vehicle.isiBaterai();
    }
}

class GasStation {
    public void refuel(Refuelable vehicle) {
        vehicle.isiBahanBakar();
    }
}

public class Latihan3 {
    public static void main(String[] args) {
        ChargingStation chargingStation = new ChargingStation();
        GasStation gasStation = new GasStation();

        ElectricCar electricCar = new ElectricCar();
        electricCar.startEngine();
        chargingStation.charge(electricCar);

        Bicycle bicycle = new Bicycle();
        bicycle.move();

        HybridCar hybridCar = new HybridCar();
        gasStation.refuel(hybridCar);
        chargingStation.charge(hybridCar);

        GasolineCar gasolineCar = new GasolineCar();
        gasolineCar.startEngine();
        gasStation.refuel(gasolineCar);

        List<Vehicle> vehicles = List.of(
                electricCar,
                bicycle,
                hybridCar,
                gasolineCar
        );

        for (Vehicle vehicle : vehicles) {
            vehicle.move();
        }
    }
}