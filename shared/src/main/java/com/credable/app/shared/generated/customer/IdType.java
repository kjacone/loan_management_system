
package com.credable.app.shared.generated.customer;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for idType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="idType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="PASSPORT"/>
 *     &lt;enumeration value="NATIONAL_ID"/>
 *     &lt;enumeration value="DRIVERS_LICENSE"/>
 *     &lt;enumeration value="VOTERS_ID"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "idType")
@XmlEnum
public enum IdType {

    PASSPORT,
    NATIONAL_ID,
    DRIVERS_LICENSE,
    VOTERS_ID;

    public String value() {
        return name();
    }

    public static IdType fromValue(String v) {
        return valueOf(v);
    }

}
