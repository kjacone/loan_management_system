
package com.credable.app.shared.generated.transactions;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for currency.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="currency">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="TZS"/>
 *     &lt;enumeration value="KES"/>
 *     &lt;enumeration value="UGX"/>
 *     &lt;enumeration value="USD"/>
 *     &lt;enumeration value="GBP"/>
 *     &lt;enumeration value="EURO"/>
 *     &lt;enumeration value="PKR"/>
 *     &lt;enumeration value="NGN"/>
 *     &lt;enumeration value="EGP"/>
 *     &lt;enumeration value="ETB"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "currency")
@XmlEnum
public enum Currency {

    TZS,
    KES,
    UGX,
    USD,
    GBP,
    EURO,
    PKR,
    NGN,
    EGP,
    ETB;

    public String value() {
        return name();
    }

    public static Currency fromValue(String v) {
        return valueOf(v);
    }

}
