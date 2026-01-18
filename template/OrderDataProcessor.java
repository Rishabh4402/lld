package template;

public class OrderDataProcessor extends DataProcessor {
    @Override
    protected void validate() {
        System.out.println("Validating Order data");
    }

    @Override
    protected void enrich() {
        System.out.println("Enriching order data");
    }
}
