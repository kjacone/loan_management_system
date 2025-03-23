
package com.credable.app.middleware_service.generated;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for transactionData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="transactionData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="accountNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="alternativechanneltrnscrAmount" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="alternativechanneltrnscrNumber" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="alternativechanneltrnsdebitAmount" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="alternativechanneltrnsdebitNumber" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="atmTransactionsNumber" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="atmtransactionsAmount" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="bouncedChequesDebitNumber" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="bouncedchequescreditNumber" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="bouncedchequetransactionscrAmount" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="bouncedchequetransactionsdrAmount" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="chequeDebitTransactionsAmount" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="chequeDebitTransactionsNumber" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="createdAt" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="createdDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="credittransactionsAmount" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="debitcardpostransactionsAmount" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="debitcardpostransactionsNumber" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="fincominglocaltransactioncrAmount" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="incominginternationaltrncrAmount" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="incominginternationaltrncrNumber" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="incominglocaltransactioncrNumber" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="intrestAmount" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="lastTransactionDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="lastTransactionType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lastTransactionValue" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="maxAtmTransactions" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="maxMonthlyBebitTransactions" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="maxalternativechanneltrnscr" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="maxalternativechanneltrnsdebit" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="maxbouncedchequetransactionscr" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="maxchequedebittransactions" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="maxdebitcardpostransactions" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="maxincominginternationaltrncr" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="maxincominglocaltransactioncr" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="maxmobilemoneycredittrn" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="maxmobilemoneydebittransaction" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="maxmonthlycredittransactions" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="maxoutgoinginttrndebit" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="maxoutgoinglocaltrndebit" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="maxoverthecounterwithdrawals" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="minAtmTransactions" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="minMonthlyDebitTransactions" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="minalternativechanneltrnscr" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="minalternativechanneltrnsdebit" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="minbouncedchequetransactionscr" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="minchequedebittransactions" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="mindebitcardpostransactions" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="minincominginternationaltrncr" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="minincominglocaltransactioncr" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="minmobilemoneycredittrn" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="minmobilemoneydebittransaction" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="minmonthlycredittransactions" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="minoutgoinginttrndebit" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="minoutgoinglocaltrndebit" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="minoverthecounterwithdrawals" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="mobilemoneycredittransactionAmount" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="mobilemoneycredittransactionNumber" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="mobilemoneydebittransactionAmount" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="mobilemoneydebittransactionNumber" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="monthlyBalance" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="monthlydebittransactionsAmount" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="outgoinginttransactiondebitAmount" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="outgoinginttrndebitNumber" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="outgoinglocaltransactiondebitAmount" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="outgoinglocaltransactiondebitNumber" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="overdraftLimit" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="overthecounterwithdrawalsAmount" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="overthecounterwithdrawalsNumber" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="transactionValue" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="updatedAt" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "transactionData", propOrder = {
    "accountNumber",
    "alternativechanneltrnscrAmount",
    "alternativechanneltrnscrNumber",
    "alternativechanneltrnsdebitAmount",
    "alternativechanneltrnsdebitNumber",
    "atmTransactionsNumber",
    "atmtransactionsAmount",
    "bouncedChequesDebitNumber",
    "bouncedchequescreditNumber",
    "bouncedchequetransactionscrAmount",
    "bouncedchequetransactionsdrAmount",
    "chequeDebitTransactionsAmount",
    "chequeDebitTransactionsNumber",
    "createdAt",
    "createdDate",
    "credittransactionsAmount",
    "debitcardpostransactionsAmount",
    "debitcardpostransactionsNumber",
    "fincominglocaltransactioncrAmount",
    "id",
    "incominginternationaltrncrAmount",
    "incominginternationaltrncrNumber",
    "incominglocaltransactioncrNumber",
    "intrestAmount",
    "lastTransactionDate",
    "lastTransactionType",
    "lastTransactionValue",
    "maxAtmTransactions",
    "maxMonthlyBebitTransactions",
    "maxalternativechanneltrnscr",
    "maxalternativechanneltrnsdebit",
    "maxbouncedchequetransactionscr",
    "maxchequedebittransactions",
    "maxdebitcardpostransactions",
    "maxincominginternationaltrncr",
    "maxincominglocaltransactioncr",
    "maxmobilemoneycredittrn",
    "maxmobilemoneydebittransaction",
    "maxmonthlycredittransactions",
    "maxoutgoinginttrndebit",
    "maxoutgoinglocaltrndebit",
    "maxoverthecounterwithdrawals",
    "minAtmTransactions",
    "minMonthlyDebitTransactions",
    "minalternativechanneltrnscr",
    "minalternativechanneltrnsdebit",
    "minbouncedchequetransactionscr",
    "minchequedebittransactions",
    "mindebitcardpostransactions",
    "minincominginternationaltrncr",
    "minincominglocaltransactioncr",
    "minmobilemoneycredittrn",
    "minmobilemoneydebittransaction",
    "minmonthlycredittransactions",
    "minoutgoinginttrndebit",
    "minoutgoinglocaltrndebit",
    "minoverthecounterwithdrawals",
    "mobilemoneycredittransactionAmount",
    "mobilemoneycredittransactionNumber",
    "mobilemoneydebittransactionAmount",
    "mobilemoneydebittransactionNumber",
    "monthlyBalance",
    "monthlydebittransactionsAmount",
    "outgoinginttransactiondebitAmount",
    "outgoinginttrndebitNumber",
    "outgoinglocaltransactiondebitAmount",
    "outgoinglocaltransactiondebitNumber",
    "overdraftLimit",
    "overthecounterwithdrawalsAmount",
    "overthecounterwithdrawalsNumber",
    "transactionValue",
    "updatedAt"
})
public class TransactionData {

    protected String accountNumber;
    protected double alternativechanneltrnscrAmount;
    protected int alternativechanneltrnscrNumber;
    protected double alternativechanneltrnsdebitAmount;
    protected int alternativechanneltrnsdebitNumber;
    protected int atmTransactionsNumber;
    protected double atmtransactionsAmount;
    protected int bouncedChequesDebitNumber;
    protected int bouncedchequescreditNumber;
    protected double bouncedchequetransactionscrAmount;
    protected double bouncedchequetransactionsdrAmount;
    protected double chequeDebitTransactionsAmount;
    protected int chequeDebitTransactionsNumber;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar createdAt;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar createdDate;
    protected double credittransactionsAmount;
    protected double debitcardpostransactionsAmount;
    protected int debitcardpostransactionsNumber;
    protected double fincominglocaltransactioncrAmount;
    protected Long id;
    protected double incominginternationaltrncrAmount;
    protected int incominginternationaltrncrNumber;
    protected int incominglocaltransactioncrNumber;
    protected Integer intrestAmount;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar lastTransactionDate;
    protected String lastTransactionType;
    protected Integer lastTransactionValue;
    protected double maxAtmTransactions;
    protected double maxMonthlyBebitTransactions;
    protected double maxalternativechanneltrnscr;
    protected double maxalternativechanneltrnsdebit;
    protected double maxbouncedchequetransactionscr;
    protected double maxchequedebittransactions;
    protected double maxdebitcardpostransactions;
    protected double maxincominginternationaltrncr;
    protected double maxincominglocaltransactioncr;
    protected double maxmobilemoneycredittrn;
    protected double maxmobilemoneydebittransaction;
    protected double maxmonthlycredittransactions;
    protected double maxoutgoinginttrndebit;
    protected double maxoutgoinglocaltrndebit;
    protected double maxoverthecounterwithdrawals;
    protected double minAtmTransactions;
    protected double minMonthlyDebitTransactions;
    protected double minalternativechanneltrnscr;
    protected double minalternativechanneltrnsdebit;
    protected double minbouncedchequetransactionscr;
    protected double minchequedebittransactions;
    protected double mindebitcardpostransactions;
    protected double minincominginternationaltrncr;
    protected double minincominglocaltransactioncr;
    protected double minmobilemoneycredittrn;
    protected double minmobilemoneydebittransaction;
    protected double minmonthlycredittransactions;
    protected double minoutgoinginttrndebit;
    protected double minoutgoinglocaltrndebit;
    protected double minoverthecounterwithdrawals;
    protected double mobilemoneycredittransactionAmount;
    protected int mobilemoneycredittransactionNumber;
    protected double mobilemoneydebittransactionAmount;
    protected int mobilemoneydebittransactionNumber;
    protected double monthlyBalance;
    protected double monthlydebittransactionsAmount;
    protected double outgoinginttransactiondebitAmount;
    protected int outgoinginttrndebitNumber;
    protected double outgoinglocaltransactiondebitAmount;
    protected int outgoinglocaltransactiondebitNumber;
    protected double overdraftLimit;
    protected double overthecounterwithdrawalsAmount;
    protected int overthecounterwithdrawalsNumber;
    protected double transactionValue;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar updatedAt;

    /**
     * Gets the value of the accountNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * Sets the value of the accountNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountNumber(String value) {
        this.accountNumber = value;
    }

    /**
     * Gets the value of the alternativechanneltrnscrAmount property.
     * 
     */
    public double getAlternativechanneltrnscrAmount() {
        return alternativechanneltrnscrAmount;
    }

    /**
     * Sets the value of the alternativechanneltrnscrAmount property.
     * 
     */
    public void setAlternativechanneltrnscrAmount(double value) {
        this.alternativechanneltrnscrAmount = value;
    }

    /**
     * Gets the value of the alternativechanneltrnscrNumber property.
     * 
     */
    public int getAlternativechanneltrnscrNumber() {
        return alternativechanneltrnscrNumber;
    }

    /**
     * Sets the value of the alternativechanneltrnscrNumber property.
     * 
     */
    public void setAlternativechanneltrnscrNumber(int value) {
        this.alternativechanneltrnscrNumber = value;
    }

    /**
     * Gets the value of the alternativechanneltrnsdebitAmount property.
     * 
     */
    public double getAlternativechanneltrnsdebitAmount() {
        return alternativechanneltrnsdebitAmount;
    }

    /**
     * Sets the value of the alternativechanneltrnsdebitAmount property.
     * 
     */
    public void setAlternativechanneltrnsdebitAmount(double value) {
        this.alternativechanneltrnsdebitAmount = value;
    }

    /**
     * Gets the value of the alternativechanneltrnsdebitNumber property.
     * 
     */
    public int getAlternativechanneltrnsdebitNumber() {
        return alternativechanneltrnsdebitNumber;
    }

    /**
     * Sets the value of the alternativechanneltrnsdebitNumber property.
     * 
     */
    public void setAlternativechanneltrnsdebitNumber(int value) {
        this.alternativechanneltrnsdebitNumber = value;
    }

    /**
     * Gets the value of the atmTransactionsNumber property.
     * 
     */
    public int getAtmTransactionsNumber() {
        return atmTransactionsNumber;
    }

    /**
     * Sets the value of the atmTransactionsNumber property.
     * 
     */
    public void setAtmTransactionsNumber(int value) {
        this.atmTransactionsNumber = value;
    }

    /**
     * Gets the value of the atmtransactionsAmount property.
     * 
     */
    public double getAtmtransactionsAmount() {
        return atmtransactionsAmount;
    }

    /**
     * Sets the value of the atmtransactionsAmount property.
     * 
     */
    public void setAtmtransactionsAmount(double value) {
        this.atmtransactionsAmount = value;
    }

    /**
     * Gets the value of the bouncedChequesDebitNumber property.
     * 
     */
    public int getBouncedChequesDebitNumber() {
        return bouncedChequesDebitNumber;
    }

    /**
     * Sets the value of the bouncedChequesDebitNumber property.
     * 
     */
    public void setBouncedChequesDebitNumber(int value) {
        this.bouncedChequesDebitNumber = value;
    }

    /**
     * Gets the value of the bouncedchequescreditNumber property.
     * 
     */
    public int getBouncedchequescreditNumber() {
        return bouncedchequescreditNumber;
    }

    /**
     * Sets the value of the bouncedchequescreditNumber property.
     * 
     */
    public void setBouncedchequescreditNumber(int value) {
        this.bouncedchequescreditNumber = value;
    }

    /**
     * Gets the value of the bouncedchequetransactionscrAmount property.
     * 
     */
    public double getBouncedchequetransactionscrAmount() {
        return bouncedchequetransactionscrAmount;
    }

    /**
     * Sets the value of the bouncedchequetransactionscrAmount property.
     * 
     */
    public void setBouncedchequetransactionscrAmount(double value) {
        this.bouncedchequetransactionscrAmount = value;
    }

    /**
     * Gets the value of the bouncedchequetransactionsdrAmount property.
     * 
     */
    public double getBouncedchequetransactionsdrAmount() {
        return bouncedchequetransactionsdrAmount;
    }

    /**
     * Sets the value of the bouncedchequetransactionsdrAmount property.
     * 
     */
    public void setBouncedchequetransactionsdrAmount(double value) {
        this.bouncedchequetransactionsdrAmount = value;
    }

    /**
     * Gets the value of the chequeDebitTransactionsAmount property.
     * 
     */
    public double getChequeDebitTransactionsAmount() {
        return chequeDebitTransactionsAmount;
    }

    /**
     * Sets the value of the chequeDebitTransactionsAmount property.
     * 
     */
    public void setChequeDebitTransactionsAmount(double value) {
        this.chequeDebitTransactionsAmount = value;
    }

    /**
     * Gets the value of the chequeDebitTransactionsNumber property.
     * 
     */
    public int getChequeDebitTransactionsNumber() {
        return chequeDebitTransactionsNumber;
    }

    /**
     * Sets the value of the chequeDebitTransactionsNumber property.
     * 
     */
    public void setChequeDebitTransactionsNumber(int value) {
        this.chequeDebitTransactionsNumber = value;
    }

    /**
     * Gets the value of the createdAt property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreatedAt() {
        return createdAt;
    }

    /**
     * Sets the value of the createdAt property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreatedAt(XMLGregorianCalendar value) {
        this.createdAt = value;
    }

    /**
     * Gets the value of the createdDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreatedDate() {
        return createdDate;
    }

    /**
     * Sets the value of the createdDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreatedDate(XMLGregorianCalendar value) {
        this.createdDate = value;
    }

    /**
     * Gets the value of the credittransactionsAmount property.
     * 
     */
    public double getCredittransactionsAmount() {
        return credittransactionsAmount;
    }

    /**
     * Sets the value of the credittransactionsAmount property.
     * 
     */
    public void setCredittransactionsAmount(double value) {
        this.credittransactionsAmount = value;
    }

    /**
     * Gets the value of the debitcardpostransactionsAmount property.
     * 
     */
    public double getDebitcardpostransactionsAmount() {
        return debitcardpostransactionsAmount;
    }

    /**
     * Sets the value of the debitcardpostransactionsAmount property.
     * 
     */
    public void setDebitcardpostransactionsAmount(double value) {
        this.debitcardpostransactionsAmount = value;
    }

    /**
     * Gets the value of the debitcardpostransactionsNumber property.
     * 
     */
    public int getDebitcardpostransactionsNumber() {
        return debitcardpostransactionsNumber;
    }

    /**
     * Sets the value of the debitcardpostransactionsNumber property.
     * 
     */
    public void setDebitcardpostransactionsNumber(int value) {
        this.debitcardpostransactionsNumber = value;
    }

    /**
     * Gets the value of the fincominglocaltransactioncrAmount property.
     * 
     */
    public double getFincominglocaltransactioncrAmount() {
        return fincominglocaltransactioncrAmount;
    }

    /**
     * Sets the value of the fincominglocaltransactioncrAmount property.
     * 
     */
    public void setFincominglocaltransactioncrAmount(double value) {
        this.fincominglocaltransactioncrAmount = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setId(Long value) {
        this.id = value;
    }

    /**
     * Gets the value of the incominginternationaltrncrAmount property.
     * 
     */
    public double getIncominginternationaltrncrAmount() {
        return incominginternationaltrncrAmount;
    }

    /**
     * Sets the value of the incominginternationaltrncrAmount property.
     * 
     */
    public void setIncominginternationaltrncrAmount(double value) {
        this.incominginternationaltrncrAmount = value;
    }

    /**
     * Gets the value of the incominginternationaltrncrNumber property.
     * 
     */
    public int getIncominginternationaltrncrNumber() {
        return incominginternationaltrncrNumber;
    }

    /**
     * Sets the value of the incominginternationaltrncrNumber property.
     * 
     */
    public void setIncominginternationaltrncrNumber(int value) {
        this.incominginternationaltrncrNumber = value;
    }

    /**
     * Gets the value of the incominglocaltransactioncrNumber property.
     * 
     */
    public int getIncominglocaltransactioncrNumber() {
        return incominglocaltransactioncrNumber;
    }

    /**
     * Sets the value of the incominglocaltransactioncrNumber property.
     * 
     */
    public void setIncominglocaltransactioncrNumber(int value) {
        this.incominglocaltransactioncrNumber = value;
    }

    /**
     * Gets the value of the intrestAmount property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIntrestAmount() {
        return intrestAmount;
    }

    /**
     * Sets the value of the intrestAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIntrestAmount(Integer value) {
        this.intrestAmount = value;
    }

    /**
     * Gets the value of the lastTransactionDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLastTransactionDate() {
        return lastTransactionDate;
    }

    /**
     * Sets the value of the lastTransactionDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLastTransactionDate(XMLGregorianCalendar value) {
        this.lastTransactionDate = value;
    }

    /**
     * Gets the value of the lastTransactionType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastTransactionType() {
        return lastTransactionType;
    }

    /**
     * Sets the value of the lastTransactionType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastTransactionType(String value) {
        this.lastTransactionType = value;
    }

    /**
     * Gets the value of the lastTransactionValue property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getLastTransactionValue() {
        return lastTransactionValue;
    }

    /**
     * Sets the value of the lastTransactionValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setLastTransactionValue(Integer value) {
        this.lastTransactionValue = value;
    }

    /**
     * Gets the value of the maxAtmTransactions property.
     * 
     */
    public double getMaxAtmTransactions() {
        return maxAtmTransactions;
    }

    /**
     * Sets the value of the maxAtmTransactions property.
     * 
     */
    public void setMaxAtmTransactions(double value) {
        this.maxAtmTransactions = value;
    }

    /**
     * Gets the value of the maxMonthlyBebitTransactions property.
     * 
     */
    public double getMaxMonthlyBebitTransactions() {
        return maxMonthlyBebitTransactions;
    }

    /**
     * Sets the value of the maxMonthlyBebitTransactions property.
     * 
     */
    public void setMaxMonthlyBebitTransactions(double value) {
        this.maxMonthlyBebitTransactions = value;
    }

    /**
     * Gets the value of the maxalternativechanneltrnscr property.
     * 
     */
    public double getMaxalternativechanneltrnscr() {
        return maxalternativechanneltrnscr;
    }

    /**
     * Sets the value of the maxalternativechanneltrnscr property.
     * 
     */
    public void setMaxalternativechanneltrnscr(double value) {
        this.maxalternativechanneltrnscr = value;
    }

    /**
     * Gets the value of the maxalternativechanneltrnsdebit property.
     * 
     */
    public double getMaxalternativechanneltrnsdebit() {
        return maxalternativechanneltrnsdebit;
    }

    /**
     * Sets the value of the maxalternativechanneltrnsdebit property.
     * 
     */
    public void setMaxalternativechanneltrnsdebit(double value) {
        this.maxalternativechanneltrnsdebit = value;
    }

    /**
     * Gets the value of the maxbouncedchequetransactionscr property.
     * 
     */
    public double getMaxbouncedchequetransactionscr() {
        return maxbouncedchequetransactionscr;
    }

    /**
     * Sets the value of the maxbouncedchequetransactionscr property.
     * 
     */
    public void setMaxbouncedchequetransactionscr(double value) {
        this.maxbouncedchequetransactionscr = value;
    }

    /**
     * Gets the value of the maxchequedebittransactions property.
     * 
     */
    public double getMaxchequedebittransactions() {
        return maxchequedebittransactions;
    }

    /**
     * Sets the value of the maxchequedebittransactions property.
     * 
     */
    public void setMaxchequedebittransactions(double value) {
        this.maxchequedebittransactions = value;
    }

    /**
     * Gets the value of the maxdebitcardpostransactions property.
     * 
     */
    public double getMaxdebitcardpostransactions() {
        return maxdebitcardpostransactions;
    }

    /**
     * Sets the value of the maxdebitcardpostransactions property.
     * 
     */
    public void setMaxdebitcardpostransactions(double value) {
        this.maxdebitcardpostransactions = value;
    }

    /**
     * Gets the value of the maxincominginternationaltrncr property.
     * 
     */
    public double getMaxincominginternationaltrncr() {
        return maxincominginternationaltrncr;
    }

    /**
     * Sets the value of the maxincominginternationaltrncr property.
     * 
     */
    public void setMaxincominginternationaltrncr(double value) {
        this.maxincominginternationaltrncr = value;
    }

    /**
     * Gets the value of the maxincominglocaltransactioncr property.
     * 
     */
    public double getMaxincominglocaltransactioncr() {
        return maxincominglocaltransactioncr;
    }

    /**
     * Sets the value of the maxincominglocaltransactioncr property.
     * 
     */
    public void setMaxincominglocaltransactioncr(double value) {
        this.maxincominglocaltransactioncr = value;
    }

    /**
     * Gets the value of the maxmobilemoneycredittrn property.
     * 
     */
    public double getMaxmobilemoneycredittrn() {
        return maxmobilemoneycredittrn;
    }

    /**
     * Sets the value of the maxmobilemoneycredittrn property.
     * 
     */
    public void setMaxmobilemoneycredittrn(double value) {
        this.maxmobilemoneycredittrn = value;
    }

    /**
     * Gets the value of the maxmobilemoneydebittransaction property.
     * 
     */
    public double getMaxmobilemoneydebittransaction() {
        return maxmobilemoneydebittransaction;
    }

    /**
     * Sets the value of the maxmobilemoneydebittransaction property.
     * 
     */
    public void setMaxmobilemoneydebittransaction(double value) {
        this.maxmobilemoneydebittransaction = value;
    }

    /**
     * Gets the value of the maxmonthlycredittransactions property.
     * 
     */
    public double getMaxmonthlycredittransactions() {
        return maxmonthlycredittransactions;
    }

    /**
     * Sets the value of the maxmonthlycredittransactions property.
     * 
     */
    public void setMaxmonthlycredittransactions(double value) {
        this.maxmonthlycredittransactions = value;
    }

    /**
     * Gets the value of the maxoutgoinginttrndebit property.
     * 
     */
    public double getMaxoutgoinginttrndebit() {
        return maxoutgoinginttrndebit;
    }

    /**
     * Sets the value of the maxoutgoinginttrndebit property.
     * 
     */
    public void setMaxoutgoinginttrndebit(double value) {
        this.maxoutgoinginttrndebit = value;
    }

    /**
     * Gets the value of the maxoutgoinglocaltrndebit property.
     * 
     */
    public double getMaxoutgoinglocaltrndebit() {
        return maxoutgoinglocaltrndebit;
    }

    /**
     * Sets the value of the maxoutgoinglocaltrndebit property.
     * 
     */
    public void setMaxoutgoinglocaltrndebit(double value) {
        this.maxoutgoinglocaltrndebit = value;
    }

    /**
     * Gets the value of the maxoverthecounterwithdrawals property.
     * 
     */
    public double getMaxoverthecounterwithdrawals() {
        return maxoverthecounterwithdrawals;
    }

    /**
     * Sets the value of the maxoverthecounterwithdrawals property.
     * 
     */
    public void setMaxoverthecounterwithdrawals(double value) {
        this.maxoverthecounterwithdrawals = value;
    }

    /**
     * Gets the value of the minAtmTransactions property.
     * 
     */
    public double getMinAtmTransactions() {
        return minAtmTransactions;
    }

    /**
     * Sets the value of the minAtmTransactions property.
     * 
     */
    public void setMinAtmTransactions(double value) {
        this.minAtmTransactions = value;
    }

    /**
     * Gets the value of the minMonthlyDebitTransactions property.
     * 
     */
    public double getMinMonthlyDebitTransactions() {
        return minMonthlyDebitTransactions;
    }

    /**
     * Sets the value of the minMonthlyDebitTransactions property.
     * 
     */
    public void setMinMonthlyDebitTransactions(double value) {
        this.minMonthlyDebitTransactions = value;
    }

    /**
     * Gets the value of the minalternativechanneltrnscr property.
     * 
     */
    public double getMinalternativechanneltrnscr() {
        return minalternativechanneltrnscr;
    }

    /**
     * Sets the value of the minalternativechanneltrnscr property.
     * 
     */
    public void setMinalternativechanneltrnscr(double value) {
        this.minalternativechanneltrnscr = value;
    }

    /**
     * Gets the value of the minalternativechanneltrnsdebit property.
     * 
     */
    public double getMinalternativechanneltrnsdebit() {
        return minalternativechanneltrnsdebit;
    }

    /**
     * Sets the value of the minalternativechanneltrnsdebit property.
     * 
     */
    public void setMinalternativechanneltrnsdebit(double value) {
        this.minalternativechanneltrnsdebit = value;
    }

    /**
     * Gets the value of the minbouncedchequetransactionscr property.
     * 
     */
    public double getMinbouncedchequetransactionscr() {
        return minbouncedchequetransactionscr;
    }

    /**
     * Sets the value of the minbouncedchequetransactionscr property.
     * 
     */
    public void setMinbouncedchequetransactionscr(double value) {
        this.minbouncedchequetransactionscr = value;
    }

    /**
     * Gets the value of the minchequedebittransactions property.
     * 
     */
    public double getMinchequedebittransactions() {
        return minchequedebittransactions;
    }

    /**
     * Sets the value of the minchequedebittransactions property.
     * 
     */
    public void setMinchequedebittransactions(double value) {
        this.minchequedebittransactions = value;
    }

    /**
     * Gets the value of the mindebitcardpostransactions property.
     * 
     */
    public double getMindebitcardpostransactions() {
        return mindebitcardpostransactions;
    }

    /**
     * Sets the value of the mindebitcardpostransactions property.
     * 
     */
    public void setMindebitcardpostransactions(double value) {
        this.mindebitcardpostransactions = value;
    }

    /**
     * Gets the value of the minincominginternationaltrncr property.
     * 
     */
    public double getMinincominginternationaltrncr() {
        return minincominginternationaltrncr;
    }

    /**
     * Sets the value of the minincominginternationaltrncr property.
     * 
     */
    public void setMinincominginternationaltrncr(double value) {
        this.minincominginternationaltrncr = value;
    }

    /**
     * Gets the value of the minincominglocaltransactioncr property.
     * 
     */
    public double getMinincominglocaltransactioncr() {
        return minincominglocaltransactioncr;
    }

    /**
     * Sets the value of the minincominglocaltransactioncr property.
     * 
     */
    public void setMinincominglocaltransactioncr(double value) {
        this.minincominglocaltransactioncr = value;
    }

    /**
     * Gets the value of the minmobilemoneycredittrn property.
     * 
     */
    public double getMinmobilemoneycredittrn() {
        return minmobilemoneycredittrn;
    }

    /**
     * Sets the value of the minmobilemoneycredittrn property.
     * 
     */
    public void setMinmobilemoneycredittrn(double value) {
        this.minmobilemoneycredittrn = value;
    }

    /**
     * Gets the value of the minmobilemoneydebittransaction property.
     * 
     */
    public double getMinmobilemoneydebittransaction() {
        return minmobilemoneydebittransaction;
    }

    /**
     * Sets the value of the minmobilemoneydebittransaction property.
     * 
     */
    public void setMinmobilemoneydebittransaction(double value) {
        this.minmobilemoneydebittransaction = value;
    }

    /**
     * Gets the value of the minmonthlycredittransactions property.
     * 
     */
    public double getMinmonthlycredittransactions() {
        return minmonthlycredittransactions;
    }

    /**
     * Sets the value of the minmonthlycredittransactions property.
     * 
     */
    public void setMinmonthlycredittransactions(double value) {
        this.minmonthlycredittransactions = value;
    }

    /**
     * Gets the value of the minoutgoinginttrndebit property.
     * 
     */
    public double getMinoutgoinginttrndebit() {
        return minoutgoinginttrndebit;
    }

    /**
     * Sets the value of the minoutgoinginttrndebit property.
     * 
     */
    public void setMinoutgoinginttrndebit(double value) {
        this.minoutgoinginttrndebit = value;
    }

    /**
     * Gets the value of the minoutgoinglocaltrndebit property.
     * 
     */
    public double getMinoutgoinglocaltrndebit() {
        return minoutgoinglocaltrndebit;
    }

    /**
     * Sets the value of the minoutgoinglocaltrndebit property.
     * 
     */
    public void setMinoutgoinglocaltrndebit(double value) {
        this.minoutgoinglocaltrndebit = value;
    }

    /**
     * Gets the value of the minoverthecounterwithdrawals property.
     * 
     */
    public double getMinoverthecounterwithdrawals() {
        return minoverthecounterwithdrawals;
    }

    /**
     * Sets the value of the minoverthecounterwithdrawals property.
     * 
     */
    public void setMinoverthecounterwithdrawals(double value) {
        this.minoverthecounterwithdrawals = value;
    }

    /**
     * Gets the value of the mobilemoneycredittransactionAmount property.
     * 
     */
    public double getMobilemoneycredittransactionAmount() {
        return mobilemoneycredittransactionAmount;
    }

    /**
     * Sets the value of the mobilemoneycredittransactionAmount property.
     * 
     */
    public void setMobilemoneycredittransactionAmount(double value) {
        this.mobilemoneycredittransactionAmount = value;
    }

    /**
     * Gets the value of the mobilemoneycredittransactionNumber property.
     * 
     */
    public int getMobilemoneycredittransactionNumber() {
        return mobilemoneycredittransactionNumber;
    }

    /**
     * Sets the value of the mobilemoneycredittransactionNumber property.
     * 
     */
    public void setMobilemoneycredittransactionNumber(int value) {
        this.mobilemoneycredittransactionNumber = value;
    }

    /**
     * Gets the value of the mobilemoneydebittransactionAmount property.
     * 
     */
    public double getMobilemoneydebittransactionAmount() {
        return mobilemoneydebittransactionAmount;
    }

    /**
     * Sets the value of the mobilemoneydebittransactionAmount property.
     * 
     */
    public void setMobilemoneydebittransactionAmount(double value) {
        this.mobilemoneydebittransactionAmount = value;
    }

    /**
     * Gets the value of the mobilemoneydebittransactionNumber property.
     * 
     */
    public int getMobilemoneydebittransactionNumber() {
        return mobilemoneydebittransactionNumber;
    }

    /**
     * Sets the value of the mobilemoneydebittransactionNumber property.
     * 
     */
    public void setMobilemoneydebittransactionNumber(int value) {
        this.mobilemoneydebittransactionNumber = value;
    }

    /**
     * Gets the value of the monthlyBalance property.
     * 
     */
    public double getMonthlyBalance() {
        return monthlyBalance;
    }

    /**
     * Sets the value of the monthlyBalance property.
     * 
     */
    public void setMonthlyBalance(double value) {
        this.monthlyBalance = value;
    }

    /**
     * Gets the value of the monthlydebittransactionsAmount property.
     * 
     */
    public double getMonthlydebittransactionsAmount() {
        return monthlydebittransactionsAmount;
    }

    /**
     * Sets the value of the monthlydebittransactionsAmount property.
     * 
     */
    public void setMonthlydebittransactionsAmount(double value) {
        this.monthlydebittransactionsAmount = value;
    }

    /**
     * Gets the value of the outgoinginttransactiondebitAmount property.
     * 
     */
    public double getOutgoinginttransactiondebitAmount() {
        return outgoinginttransactiondebitAmount;
    }

    /**
     * Sets the value of the outgoinginttransactiondebitAmount property.
     * 
     */
    public void setOutgoinginttransactiondebitAmount(double value) {
        this.outgoinginttransactiondebitAmount = value;
    }

    /**
     * Gets the value of the outgoinginttrndebitNumber property.
     * 
     */
    public int getOutgoinginttrndebitNumber() {
        return outgoinginttrndebitNumber;
    }

    /**
     * Sets the value of the outgoinginttrndebitNumber property.
     * 
     */
    public void setOutgoinginttrndebitNumber(int value) {
        this.outgoinginttrndebitNumber = value;
    }

    /**
     * Gets the value of the outgoinglocaltransactiondebitAmount property.
     * 
     */
    public double getOutgoinglocaltransactiondebitAmount() {
        return outgoinglocaltransactiondebitAmount;
    }

    /**
     * Sets the value of the outgoinglocaltransactiondebitAmount property.
     * 
     */
    public void setOutgoinglocaltransactiondebitAmount(double value) {
        this.outgoinglocaltransactiondebitAmount = value;
    }

    /**
     * Gets the value of the outgoinglocaltransactiondebitNumber property.
     * 
     */
    public int getOutgoinglocaltransactiondebitNumber() {
        return outgoinglocaltransactiondebitNumber;
    }

    /**
     * Sets the value of the outgoinglocaltransactiondebitNumber property.
     * 
     */
    public void setOutgoinglocaltransactiondebitNumber(int value) {
        this.outgoinglocaltransactiondebitNumber = value;
    }

    /**
     * Gets the value of the overdraftLimit property.
     * 
     */
    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    /**
     * Sets the value of the overdraftLimit property.
     * 
     */
    public void setOverdraftLimit(double value) {
        this.overdraftLimit = value;
    }

    /**
     * Gets the value of the overthecounterwithdrawalsAmount property.
     * 
     */
    public double getOverthecounterwithdrawalsAmount() {
        return overthecounterwithdrawalsAmount;
    }

    /**
     * Sets the value of the overthecounterwithdrawalsAmount property.
     * 
     */
    public void setOverthecounterwithdrawalsAmount(double value) {
        this.overthecounterwithdrawalsAmount = value;
    }

    /**
     * Gets the value of the overthecounterwithdrawalsNumber property.
     * 
     */
    public int getOverthecounterwithdrawalsNumber() {
        return overthecounterwithdrawalsNumber;
    }

    /**
     * Sets the value of the overthecounterwithdrawalsNumber property.
     * 
     */
    public void setOverthecounterwithdrawalsNumber(int value) {
        this.overthecounterwithdrawalsNumber = value;
    }

    /**
     * Gets the value of the transactionValue property.
     * 
     */
    public double getTransactionValue() {
        return transactionValue;
    }

    /**
     * Sets the value of the transactionValue property.
     * 
     */
    public void setTransactionValue(double value) {
        this.transactionValue = value;
    }

    /**
     * Gets the value of the updatedAt property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Sets the value of the updatedAt property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setUpdatedAt(XMLGregorianCalendar value) {
        this.updatedAt = value;
    }

}
