package data.enums;

public enum State {
    NCR("NCR", "Delhi", "Gurgaon", "Noida"),
    UTTAR_PRADESH("Uttar Pradesh", "Agra", "Lucknow", "Merrut"),
    HARYANA("Haryana", "Karnal", "Panipat"),
    RAJASTHAN("Rajasthan", "Jaipur", "Jaiselmer");

    private final String displayName;
    private final String[] cities;

    State(String displayName, String... cities) {
        this.displayName = displayName;
        this.cities = cities;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String[] getCities() {
        return cities;
    }
}
