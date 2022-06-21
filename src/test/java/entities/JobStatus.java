package entities;

public enum JobStatus {
    IN_PROGRESS,
    SUCCESS,
    ERROR;

    private final String value;

    JobStatus() {
        this.value = this.toString();
    }

    @Override
    public String toString() {
        return value;
    }
}
