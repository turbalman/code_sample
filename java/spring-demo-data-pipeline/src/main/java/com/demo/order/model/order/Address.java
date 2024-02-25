package com.demo.order.model.order;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * The type Address.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Address implements Serializable {
    /**
     * The First name.
     */
    @NotEmpty
    private String firstName;

    /**
     * The Last name.
     */
    @NotEmpty
    private String lastName;

    /**
     * The Line 1.
     */
    @NotEmpty
    private String line1;

    /**
     * The Line 2.
     */
    @NotEmpty
    private String line2;

    /**
     * The City.
     */
    @NotEmpty
    private String city;

    /**
     * The State.
     */
    @NotEmpty
    private String state;

    /**
     * The Country.
     */
    @NotEmpty
    private String country;

    /**
     * The Zipcode.
     */
    @NotEmpty
    private String zipcode;

    /**
     * Instantiates a new Address.
     *
     * @param address0 the address 0
     */
    public Address(final com.demo.order.model.protobuf.generated.Address address0) {
        firstName = address0.getFirstName();
        lastName = address0.getLastName();
        line1 = address0.getLine1();
        line2 = address0.getLine2();
        city = address0.getCity();
        state = address0.getState();
        country = address0.getCountry();
        zipcode = address0.getZipcode();
    }
}
