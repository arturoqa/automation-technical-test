import com.microsoft.playwright.Page;

public class RegisterPage {

    private Page page;

    public RegisterPage(Page page){
        this.page = page;
    }

    public void fillMandatoryInformation(String fName, String lName, String password,
                                         String address, String city, String state,
                                         String postalCode, String country, String mobilePhone){
        fillCustomerFirstName(fName);
        fillCustomerLastName(lName);
        fillPassword(password);
        fillFirstName(fName);
        fillLastName(lName);
        fillAddress1(address);
        fillCity(city);
        selectCountry(country);
        selectState(state);
        fillPostalCode(postalCode);
        fillMobilePhone(mobilePhone);
    }

    public void fillCustomerFirstName(String fName){
        page.fill("#customer_firstname",fName);
    }

    public void fillCustomerLastName(String lName){
        page.fill("#customer_lastname",lName);
    }

    public void fillPassword(String password){
        page.fill("#passwd",password);
    }

    public void fillFirstName(String fName){
        page.fill("#lastname",fName);
    }

    public void fillLastName(String lName){
        page.fill("#firstname",lName);
    }

    public void fillAddress1(String address){
        page.fill("#address1",address);
    }

    public void fillCity(String city){
        page.fill("#city",city);
    }

    public void selectCountry(String country){
        page.selectOption("#id_country",country);
    }

    public void selectState(String state){
        page.selectOption("#id_state",state);
    }

    public void fillPostalCode(String postalCode){
        page.fill("#postcode",postalCode);
    }

    public void fillMobilePhone(String mobilePhone){
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
