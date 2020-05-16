package fzz.wsback.domain;

/**
 * @author ZJH
 */
public class ShippingAddress {
    private Integer id;
    private String userPhone;
    private String consignee;
    private String province;
    private String city;
    private String region;
    private String address;
    private String postPhone;
    private Integer defaultAddress;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() { return region; }

    public void setRegion(String region) { this.region = region; }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostPhone() {
        return postPhone;
    }

    public void setPostPhone(String postPhone) {
        this.postPhone = postPhone;
    }

    public Integer getDefaultAddress() { return defaultAddress; }

    public void setDefaultAddress(Integer defaultAddress) { this.defaultAddress = defaultAddress; }
}
