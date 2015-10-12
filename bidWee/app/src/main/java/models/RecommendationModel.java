package models;

/**
 * Created by Suneet on 07-Oct-15.
 */
public class RecommendationModel {
    private String prodctName;
    private String mrp;
    private String bestPriceAvailable;

    public RecommendationModel(String mrp, String bestPriceAvailable) {
        this.mrp = mrp;
        this.bestPriceAvailable = bestPriceAvailable;
    }

    public String getProdctName() {
        return prodctName;
    }

    public void setProdctName(String prodctName) {
        this.prodctName = prodctName;
    }

    public String getMrp() {
        return mrp;
    }

    public void setMrp(String mrp) {
        this.mrp = mrp;
    }

    public String getBestPriceAvailable() {
        return bestPriceAvailable;
    }

    public void setBestPriceAvailable(String bestPriceAvailable) {
        this.bestPriceAvailable = bestPriceAvailable;
    }
}
