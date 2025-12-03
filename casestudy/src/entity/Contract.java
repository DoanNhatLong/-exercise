package entity;

public class Contract {
    int numberContract;
    String idBooking;
    double depositMoney;
    double totalMoney;

    public Contract() {
    }

    public Contract(int numberContract, String idBooking, double depositMoney, double totalMoney) {
        this.numberContract = numberContract;
        this.idBooking = idBooking;
        this.depositMoney = depositMoney;
        this.totalMoney = totalMoney;
    }

    public int getNumberContract() {
        return numberContract;
    }

    public void setNumberContract(int numberContract) {
        this.numberContract = numberContract;
    }

    public String getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(String idBooking) {
        this.idBooking = idBooking;
    }

    public double getDepositMoney() {
        return depositMoney;
    }

    public void setDepositMoney(double depositMoney) {
        this.depositMoney = depositMoney;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "numberContract=" + numberContract +
                ", idCustomer='" + idBooking + '\'' +
                ", depositMoney=" + depositMoney +
                ", totalMoney=" + totalMoney +
                '}';
    }
}
