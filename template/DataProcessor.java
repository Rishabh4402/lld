package template;

public abstract class DataProcessor {
    protected abstract void validate();

    protected abstract void enrich();

    public void process() {
        validate();
        enrich();
    }
}
