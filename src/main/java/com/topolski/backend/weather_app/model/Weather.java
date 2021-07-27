package com.topolski.backend.weather_app.model;

public class Weather {
    private String locationCountry;
    private String locationCity;
    private Double currentTempC;
    private Double currentFeelsLikeC;
    private String currentConditionText;
    private String currentConditionIcon;
    private Double currentWindKM;
    private String currentWindDir;
    private Integer currentPressureMB;
    private Integer currentUV;
    private Double currentPrecipMM;
    private Integer currentHumidity;
    private Double co;
    private Double no2;
    private Double o3;
    private Double so2;
    private Double pm25;
    private Double pm10;

    public String getLocationCountry() {
        return locationCountry;
    }
    public void setLocationCountry(String locationCountry) {
        this.locationCountry = locationCountry;
    }
    public String getLocationCity() {
        return locationCity;
    }
    public void setLocationCity(String locationCity) {
        this.locationCity = locationCity;
    }
    public double getCurrentTempC() {
        return currentTempC;
    }
    public void setCurrentTempC(double currentTempC) {
        this.currentTempC = currentTempC;
    }
    public double getCurrentFeelsLikeC() {
        return currentFeelsLikeC;
    }
    public void setCurrentFeelsLikeC(double currentFeelsLikeC) {
        this.currentFeelsLikeC = currentFeelsLikeC;
    }
    public String getCurrentConditionText() {
        return currentConditionText;
    }
    public void setCurrentConditionText(String currentConditionText) {
        this.currentConditionText = currentConditionText;
    }
    public String getCurrentConditionIcon() {
        return currentConditionIcon;
    }
    public void setCurrentConditionIcon(String currentConditionIcon) {
        this.currentConditionIcon = currentConditionIcon;
    }
    public double getCurrentWindKM() {
        return currentWindKM;
    }
    public void setCurrentWindKM(double currentWindKM) {
        this.currentWindKM = currentWindKM;
    }
    public String getCurrentWindDir() {
        return currentWindDir;
    }
    public void setCurrentWindDir(String currentWindDir) {
        this.currentWindDir = currentWindDir;
    }
    public int getCurrentPressureMB() {
        return currentPressureMB;
    }
    public void setCurrentPressureMB(int currentPressureMB) {
        this.currentPressureMB = currentPressureMB;
    }
    public int getCurrentUV() {
        return currentUV;
    }
    public void setCurrentUV(int currentUV) {
        this.currentUV = currentUV;
    }
    public double getCurrentPrecipMM() {
        return currentPrecipMM;
    }
    public void setCurrentPrecipMM(double currentPrecipMM) {
        this.currentPrecipMM = currentPrecipMM;
    }
    public int getCurrentHumidity() {
        return currentHumidity;
    }
    public void setCurrentHumidity(int currentHumidity) {
        this.currentHumidity = currentHumidity;
    }
    public double getCo() {
        return co;
    }
    public void setCo(double co) {
        this.co = co;
    }
    public double getNo2() {
        return no2;
    }
    public void setNo2(double no2) {
        this.no2 = no2;
    }
    public double getO3() {
        return o3;
    }
    public void setO3(double o3) {
        this.o3 = o3;
    }
    public double getSo2() {
        return so2;
    }
    public void setSo2(double so2) {
        this.so2 = so2;
    }
    public double getPm25() {
        return pm25;
    }
    public void setPm25(double pm25) {
        this.pm25 = pm25;
    }
    public double getPm10() {
        return pm10;
    }
    public void setPm10(double pm10) {
        this.pm10 = pm10;
    }
    @Override
    public String toString() {
        return "Weather{" +
                "locationCountry='" + locationCountry + '\'' +
                ", locationCity='" + locationCity + '\'' +
                ", currentTempC=" + currentTempC +
                ", currentFeelsLikeC=" + currentFeelsLikeC +
                ", currentConditionText='" + currentConditionText + '\'' +
                ", currentConditionIcon='" + currentConditionIcon + '\'' +
                ", currentWindKM=" + currentWindKM +
                ", currentWindDir='" + currentWindDir + '\'' +
                ", currentPressureMB=" + currentPressureMB +
                ", currentUV=" + currentUV +
                ", currentPrecipMM=" + currentPrecipMM +
                ", currentHumidity=" + currentHumidity +
                ", co=" + co +
                ", no2=" + no2 +
                ", o3=" + o3 +
                ", so2=" + so2 +
                ", pm25=" + pm25 +
                ", pm10=" + pm10 +
                '}';
    }
}
