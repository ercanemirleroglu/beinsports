package common;

public enum Browser {
    CHROME("Chrome"),
    FIREFOX("Firefox");

    private String browser;

    Browser(String browser) {
        this.browser = browser;
    }

    public String getBrowser() {
        return browser;
    }

}
