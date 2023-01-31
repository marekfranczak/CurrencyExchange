package org.example;

import calculations.Calc;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

/**
 * Class responsible for controlling the graphic layer of the application. See MVC architecture.
 * @author Marek Frańczak
 * @since 1.0.0
 */
public class Controller {

    /**
     * TextField that passes the currency value to be converted.
     * @see TextField
     */
    @FXML
    private TextField firstCurrencyTextField;
    /**
     * TextField that passes the currency value after the change.
     * @see TextField
     */
    @FXML
    private TextField secondCurrencyTextField;
    /**
     * RadioMenuItem object that provide information about the selected currency.
     * @see RadioMenuItem
     */
    @FXML
    private RadioMenuItem fromUSD, fromAUD, fromCAD, fromEUR, fromHUF, fromCHF, fromGBP, fromJPY, fromCZK, fromDKK, fromNOK, fromSEK, fromPLN;
    /**
     * RadioMenuItem object that provide information about the selected currency.
     * @see RadioMenuItem
     */
    @FXML
    private RadioMenuItem toUSD, toAUD, toCAD, toEUR, toHUF, toCHF, toGBP, toJPY, toCZK, toDKK, toNOK, toSEK, toPLN;
    /**
     * Fields responsible for providing information to be displayed.
     * @see Label
     */
    @FXML
    private Label firstCurrencyLabel, secondCurrencyLabel, rateLabel, connectionLabel;
    /**
     * Fields responsible for providing layout.
     * @see BorderPane
     */
    @FXML
    private BorderPane mainWindow;

    /**
     * Field containing ISO 4217 currency code.
     */
    private String exchangeFrom = "USD";
    /**
     * Field containing ISO 4217 currency code.
     */
    private String exchangeTo = "AUD";
    /**
     * @see Calc
     */
    private Calc calc;
    /**
     * @see Dialog
     */
    private Dialog dialog = new Dialog();

    /**
     * Method responsible for calling the Calc.calc().
     * @see Calc
     */
    @FXML
    public void exchangeCurrency(){
        try{
            calc = new Calc();
            connectionLabel.setText("Połączono z witryną: https://www.alphavantage.co");
            secondCurrencyTextField.setText(calc.calc(Double.parseDouble(firstCurrencyTextField.getText()), exchangeFrom, exchangeTo));
            rateLabel.setText("Kurs: "+calc.getExchangeRate());
        } catch (NumberFormatException e){
            System.out.println("NumberFormatException: " + e.getMessage());
        }
    }

    /**
     * Method responsible for calling the Dialog.aboutDialog().
     * @see Dialog
     */
    @FXML
    public void aboutDialog(){
        dialog.aboutDialog(mainWindow.getScene().getWindow());
    }

    /**
     * Method responsible for calling Platform.exit() which closes the app.
     * @see Platform
     */
    @FXML
    public void close(){
        Platform.exit();
    }

    /**
     * Method the method transfers the selected currency to the field. ISO 4217 compliant currency.
     */
    @FXML
    public void selectFirstCurrency() {
        if (fromUSD.isSelected()) {
            exchangeFrom = "USD";
            firstCurrencyLabel.setText("USD");
        } else if (fromAUD.isSelected()) {
            exchangeFrom = "AUD";
            firstCurrencyLabel.setText("AUD");
        } else if (fromCAD.isSelected()) {
            exchangeFrom = "CAD";
            firstCurrencyLabel.setText("CAD");
        } else if (fromCHF.isSelected()) {
            exchangeFrom = "CHF";
            firstCurrencyLabel.setText("CHF");
        } else if (fromEUR.isSelected()) {
            exchangeFrom = "EUR";
            firstCurrencyLabel.setText("EUR");
        } else if (fromGBP.isSelected()) {
            exchangeFrom = "GBP";
            firstCurrencyLabel.setText("GBP");
        } else if (fromHUF.isSelected()) {
            exchangeFrom = "HUF";
            firstCurrencyLabel.setText("HUF");
        } else if (fromJPY.isSelected()) {
            exchangeFrom = "JPY";
            firstCurrencyLabel.setText("JPY");
        } else if (fromCZK.isSelected()) {
            exchangeFrom = "CZK";
            firstCurrencyLabel.setText("CZK");
        } else if (fromDKK.isSelected()) {
            exchangeFrom = "DKK";
            firstCurrencyLabel.setText("DKK");
        } else if (fromNOK.isSelected()) {
            exchangeFrom = "NOK";
            firstCurrencyLabel.setText("NOK");
        } else if (fromSEK.isSelected()) {
            exchangeFrom = "SEK";
            firstCurrencyLabel.setText("SEK");
        } else if (fromPLN.isSelected()) {
            exchangeFrom = "PLN";
            firstCurrencyLabel.setText("PLN");
        } else{
            System.out.println("Nie rozpoznano..");
        }
    }

    /**
     * Method the method transfers the selected currency to the field. ISO 4217 compliant currency.
     */
    @FXML
    public void selectSecondCurrency(){
        if(toAUD.isSelected()){
            exchangeTo = "AUD";
            secondCurrencyLabel.setText("AUD");
        } else if (toCAD.isSelected()){
            exchangeTo = "CAD";
            secondCurrencyLabel.setText("CAD");
        } else if (toCHF.isSelected()){
            exchangeTo = "CHF";
            secondCurrencyLabel.setText("CHF");
        } else if (toEUR.isSelected()){
            exchangeTo = "EUR";
            secondCurrencyLabel.setText("EUR");
        } else if (toGBP.isSelected()){
            exchangeTo = "GBP";
            secondCurrencyLabel.setText("GBP");
        } else if (toHUF.isSelected()){
            exchangeTo = "HUF";
            secondCurrencyLabel.setText("HUF");
        } else if (toJPY.isSelected()){
            exchangeTo = "JPY";
            secondCurrencyLabel.setText("JPY");
        } else if (toUSD.isSelected()){
            exchangeTo = "USD";
            secondCurrencyLabel.setText("USD");
        } else if (toCZK.isSelected()){
            exchangeTo = "CZK";
            secondCurrencyLabel.setText("CZK");
        } else if (toDKK.isSelected()){
            exchangeTo = "DKK";
            secondCurrencyLabel.setText("DKK");
        } else if (toNOK.isSelected()){
            exchangeTo = "NOK";
            secondCurrencyLabel.setText("NOK");
        } else if (toSEK.isSelected()){
            exchangeTo = "SEK";
            secondCurrencyLabel.setText("SEK");
        } else if (toPLN.isSelected()){
            exchangeTo = "PLN";
            secondCurrencyLabel.setText("PLN");
        } else {
            System.out.println("Nie rozpoznano..");
        }
    }


}
