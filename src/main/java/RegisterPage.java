import com.microsoft.playwright.Page;

public class RegisterPage {

    private Page page;

    public RegisterPage(Page page){
        this.page = page;
    }

    public void fillMandatoryInformation(String fName, String lName, String password,
                                         String address, String city, String state,
                                         String postalCode, String country, String mobilePhone){
        page.fill("#customer_firstname",fName);
        page.fill("#customer_lastname",lName);
        page.fill("#passwd",password);
        page.fill("#firstname",fName);
        page.fill("#lastname",lName);
        page.fill("#address1",address);
        page.fill("#city",city);
        page.click("#id_state");
        page.selectOption("#id_country",country);
        page.selectOption("#id_state",state);
        page.fill("#postcode",postalCode);
        page.fill("#phone_mobile",mobilePhone);
    }

    public void clickRegister() {
        page.click("#submitAccount");
    }

    public Boolean isParametersMissingErrorDisplayed(){
        return isPhoneNumberErrorDisplayed() && isLastNameErrorDisplayed() && isFirstNameErrorDisplayed()
                && isPasswordErrorDisplayed() && isAddressErrorDisplayed() && isCityErrorDisplayed()
                && isPostalCodeErrorDisplayed() && isStateErrorDisplayed();
    }

    public Boolean isPhoneNumberErrorDisplayed(){
        page.waitForSelector(".alert");
        return page.isVisible("text=You must register at least one phone number.");
    }

    public Boolean isLastNameErrorDisplayed() {
        page.waitForSelector(".alert");
        return page.isVisible("text=lastname is required.");
    }

    public Boolean isFirstNameErrorDisplayed() {
        page.waitForSelector(".alert");
        return page.isVisible("text=firstname is required.");
    }

    public Boolean isPasswordErrorDisplayed() {
        page.waitForSelector(".alert");
        return page.isVisible("text=passwd is required.");
    }

    public Boolean isAddressErrorDisplayed() {
        page.waitForSelector(".alert");
        return page.isVisible("text=address1 is required.");
    }

    public Boolean isCityErrorDisplayed() {
        page.waitForSelector(".alert");
        return page.isVisible("text=city is required.");
    }

    public Boolean isPostalCodeErrorDisplayed() {
        page.waitForSelector(".alert");
        return page.isVisible("text=The Zip/Postal code you've entered is invalid. It must follow this format: 00000");
    }

    public Boolean isStateErrorDisplayed() {
        page.waitForSelector(".alert");
        return page.isVisible("text=This country requires you to choose a State.");
    }
}
