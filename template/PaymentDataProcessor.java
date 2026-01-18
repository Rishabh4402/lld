package template;

public class PaymentDataProcessor extends DataProcessor {
    @Override
    protected void validate() {
        System.out.println("Validating payment data");
    }

    @Override
    protected void enrich() {
        System.out.println("Enriching Payment data");
    }
}
