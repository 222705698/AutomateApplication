package za.ac.cput.Domain;

import java.time.LocalDate;

public class Payments {
    private String paymentID;
    private String paymentType;
    private LocalDate paymentDate;
    private String paymentMethod;
    private double paymentAmount;
    private String paymentDescription;

    public Payments(PaymentBuilder paymentBuilder) {
        this.paymentID = paymentBuilder.paymentID;
        this.paymentType = paymentBuilder.paymentType;
        this.paymentDate = paymentBuilder.paymentDate;
        this.paymentMethod = paymentBuilder.paymentMethod;
        this.paymentAmount = paymentBuilder.paymentAmount;
        this.paymentDescription = paymentBuilder.paymentDescription;
    }

    public static class PaymentBuilder {
        private String paymentID;
        private String paymentType;
        private LocalDate paymentDate;
        private String paymentMethod;
        private double paymentAmount;
        private String paymentDescription;

        public PaymentBuilder setPaymentID(String paymentID) {
            this.paymentID = paymentID;
            return this;
        }

        public PaymentBuilder setPaymentType(String paymentType) {
            this.paymentType = paymentType;
            return this;
        }

        public PaymentBuilder setPaymentDate(LocalDate paymentDate) {
            this.paymentDate = paymentDate;
            return this;
        }

        public PaymentBuilder setPaymentMethod(String paymentMethod) {
            this.paymentMethod = paymentMethod;
            return this;
        }

        public PaymentBuilder setPaymentAmount(double paymentAmount) {
            this.paymentAmount = paymentAmount;
            return this;
        }

        public PaymentBuilder setPaymentDescription(String paymentDescription) {
            this.paymentDescription = paymentDescription;
            return this;
        }

        public Payments build() {
            return new Payments(this);
        }

        public Payments.PaymentBuilder copy(Payments payments) {
            this.paymentID = payments.paymentID;
            this.paymentType = payments.paymentType;
            this.paymentDate = payments.paymentDate;
            this.paymentMethod = payments.paymentMethod;
            this.paymentAmount = payments.paymentAmount;
            this.paymentDescription = payments.paymentDescription;
            return this;
        }
    }

    public String getPaymentID() {
        return paymentID;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public String getPaymentDescription() {
        return paymentDescription;
    }

    @Override
    public String toString() {
        return "Payments{" +
                "paymentID='" + paymentID + '\'' +
                ", paymentType='" + paymentType + '\'' +
                ", paymentDate=" + paymentDate +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", paymentAmount=" + paymentAmount +
                ", paymentDescription='" + paymentDescription + '\'' +
                '}';
    }


}
