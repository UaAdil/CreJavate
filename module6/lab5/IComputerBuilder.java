package Modules.module6.lab5;

public interface IComputerBuilder {
    void setCPU();
    void setRAM();
    void setStorage();
    void setGPU();
    void setOS();
    void setCooling();
    void setPowerSupply();
    Computer getComputer();
}


class OfficeComputerBuilder implements IComputerBuilder {
    private Computer computer;

    public OfficeComputerBuilder() {
        this.computer = new Computer();
    }

    @Override
    public void setCPU() {
        computer.setCPU("Intel i3");
    }

    @Override
    public void setRAM() {
        computer.setRAM("8GB");
    }

    @Override
    public void setStorage() {
        computer.setStorage("1TB HDD");
    }

    @Override
    public void setGPU() {
        computer.setGPU("Integrated GPU");
    }

    @Override
    public void setOS() {
        computer.setOS("Windows 10");
    }
    @Override
    public void setCooling() { computer.setCooling("Aerial");}
    @Override
    public void setPowerSupply() { computer.setPowerSupply("30W");}
    @Override
    public Computer getComputer() {
        return this.computer;
    }
}


class GamingComputerBuilder implements IComputerBuilder {
    private Computer computer;

    public GamingComputerBuilder() {
        this.computer = new Computer();
    }

    @Override
    public void setCPU() {
        computer.setCPU("Intel i9");
    }

    @Override
    public void setRAM() {
        computer.setRAM("32GB");
    }

    @Override
    public void setStorage() {
        computer.setStorage("1TB SSD");
    }

    @Override
    public void setGPU() {
        computer.setGPU("NVIDIA RTX 3080");
    }

    @Override
    public void setOS() {
        computer.setOS("Windows 11");
    }
    @Override
    public void setCooling() { computer.setCooling("Liquid");}
    @Override
    public void setPowerSupply() { computer.setPowerSupply("120W");}

    @Override
    public Computer getComputer() {
        return this.computer;
    }
}


class ServerComputerBuilder implements IComputerBuilder {
    private Computer computer;

    public ServerComputerBuilder() {
        this.computer = new Computer();
    }

    @Override
    public void setCPU() {
        computer.setCPU("Intel Xeon");
    }

    @Override
    public void setRAM() {
        computer.setRAM("64GB ECC");
    }

    @Override
    public void setStorage() {
        computer.setStorage("2TB SSD RAID");
    }

    @Override
    public void setGPU() {
        computer.setGPU("Integrated");
    }

    @Override
    public void setOS() {
        computer.setOS("Linux");
    }

    @Override
    public void setCooling() { computer.setCooling("Liquid");}
    @Override
    public void setPowerSupply() { computer.setPowerSupply("200W");}

    @Override
    public Computer getComputer() {
        return this.computer;
    }
}


