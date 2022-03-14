package hands.on.grpc;

import java.util.Objects;

public class Beer {

    public enum Type {
        IndianPaleAle, SessionIpa, Lager
    }

    private String asin;
    private String name;
    private String brand;
    private String country;
    private float alcohol;
    private Type type;

    public Beer() {
    }

    public Beer(String asin, String name, String brand, String country, float alcohol, Type type) {
        this.asin = asin;
        this.name = name;
        this.brand = brand;
        this.country = country;
        this.alcohol = alcohol;
        this.type = type;
    }

    public String getAsin() {
        return asin;
    }

    public void setAsin(String asin) {
        this.asin = asin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public float getAlcohol() {
        return alcohol;
    }

    public void setAlcohol(float alcohol) {
        this.alcohol = alcohol;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Beer that = (Beer) o;
        return Float.compare(that.alcohol, alcohol) == 0 && Objects.equals(asin, that.asin) && Objects.equals(name, that.name) && Objects.equals(brand, that.brand) && Objects.equals(country, that.country) && type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(asin, name, brand, country, alcohol, type);
    }
}
