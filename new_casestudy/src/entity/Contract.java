package entity;

public class Contract {
    String idContract;
    String idBooking;
    double moneyFirst;
    double moneyTotal;

    public Contract() {
    }

    public Contract(String idContract, String idBooking, double moneyFirst, double moneyTotal) {
        this.idContract = idContract;
        this.idBooking = idBooking;
        this.moneyFirst = moneyFirst;
        this.moneyTotal = moneyTotal;
    }

    public String getIdContract() {
        return idContract;
    }

    public void setIdContract(String idContract) {
        this.idContract = idContract;
    }

    public String getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(String idBooking) {
        this.idBooking = idBooking;
    }

    public double getMoneyFirst() {
        return moneyFirst;
    }

    public void setMoneyFirst(double moneyFirst) {
        this.moneyFirst = moneyFirst;
    }

    public double getMoneyTotal() {
        return moneyTotal;
    }

    public void setMoneyTotal(double moneyTotal) {
        this.moneyTotal = moneyTotal;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "idContract='" + idContract + '\'' +
                ", idBooking='" + idBooking + '\'' +
                ", moneyFirst=" + moneyFirst +
                ", moneyTotal=" + moneyTotal +
                '}';
    }
}
