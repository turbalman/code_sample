package com.demo.order.util;

import com.demo.order.model.product.Sku;
import com.demo.order.model.protobuf.generated.Address;
import com.demo.order.model.protobuf.generated.Order;
import com.demo.order.model.protobuf.generated.OrderAddress;
import com.demo.order.model.protobuf.generated.OrderSku;
import com.github.javafaker.Faker;
import com.github.javafaker.FunnyName;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

import java.util.List;
import java.util.UUID;

/**
 * The type Order util.
 */
@SuppressWarnings("checkstyle:all")
final public class OrderUtil {
    /**
     * Instantiates a new Order util.
     */
    private OrderUtil() {
    }

    /**
     * The constant COUNTRY_ABBREVIATION_MAP.
     */
    private static final BiMap<String, String> COUNTRY_ABBREVIATION_MAP = OrderUtil.getCountryAbbreviationMap();

    /**
     * Gets order sku.
     *
     * @param order the order
     * @param index the index
     * @return the order sku
     */
    public static OrderSku getOrderSku(final Order order, final int index) {
        return OrderSku.newBuilder()
                .setOrderId(order.getId())
                .setUserId(order.getUserId())
                .setSkuId(order.getSkuIds(index))
                .setBillingAddress(order.getBillingAddress())
                .setShippingAddress(order.getShippingAddress())
                .build();
    }

    /**
     * Gets order address.
     *
     * @param order the order
     * @return the order address
     */
    public static OrderAddress getOrderAddress(final Order order) {
        return OrderAddress.newBuilder()
                .setId(UUID.randomUUID().toString())
                .setOrderId(order.getId())
                .setUserId(order.getUserId())
                .setBillingAddress(order.getBillingAddress())
                .setShippingAddress(order.getShippingAddress())
                .setTimestamp(System.currentTimeMillis())
                .build();
    }

    /**
     * Fake order order.
     *
     * @param skuIds the sku ids
     * @return the order
     */
    public static Order fakeOrder(final List<String> skuIds) {
        Faker faker = new Faker();
        int subtotal = (int) (Math.random() * (1000 - 10)) + 10;
        int tax = (int) (0.1 * subtotal);
        int discount = (int) (Math.random() * subtotal);
        int total = subtotal + tax + discount;
        int omnichannel = (int) (Math.random() * (Order.Omnichannel.values().length - 1));
        long orderTimestamp = System.currentTimeMillis() - (long) (365 * 24 * 3600 * 1000L * Math.random());
        return Order.newBuilder()
                .setId(UUID.randomUUID().toString())
                .setStatus(Order.Status.CREATED)
                .setUserId(UUID.randomUUID().toString())
                .addAllSkuIds(skuIds)
                .setIp(faker.internet().ipV4Address())
                .setShippingAddress(fakeAddress())
                .setBillingAddress(fakeAddress())
                .setSubtotal(subtotal)
                .setTax(tax)
                .setDiscount(discount)
                .setTotal(total)
                .setOmnichannel(Order.Omnichannel.forNumber(omnichannel))
                .setTimestamp(orderTimestamp)
                .build();
    }

    /**
     * Fake sku sku.
     *
     * @return the sku
     */
    public static Sku fakeSku() {
        Faker faker = new Faker();
        FunnyName funnyName = faker.funnyName();
        UUID uuid = UUID.nameUUIDFromBytes(faker.funnyName().name().getBytes());
        int categoryNumber = (int) (Math.random() * (OrderSku.SkuCategory.values().length - 1));
        return new Sku(uuid, funnyName.name(), faker.commerce().department(),
                OrderSku.SkuCategory.forNumber(categoryNumber == 0 ? 1 : categoryNumber));
    }

    /**
     * Gets country abbreviation map.
     *
     * @return the country abbreviation map
     */
    private static BiMap<String, String> getCountryAbbreviationMap() {
        BiMap<String, String> countryMap = HashBiMap.create();
        countryMap.put("AA", "Aruba");
        countryMap.put("AC", "Antigua and Barbuda");
        countryMap.put("AE", "United Arab Emirates");
        countryMap.put("AF", "Afghanistan");
        countryMap.put("AG", "Algeria");
        countryMap.put("AJ", "Azerbaijan");
        countryMap.put("AL", "Albania");
        countryMap.put("AM", "Armenia");
        countryMap.put("AN", "Andorra");
        countryMap.put("AO", "Angola");
        countryMap.put("AR", "Argentina");
        countryMap.put("AS", "Australia");
        countryMap.put("AU", "Austria");
        countryMap.put("AV", "Anguilla");
        countryMap.put("AY", "Antarctica");
        countryMap.put("BA", "Bahrain");
        countryMap.put("BB", "Barbados");
        countryMap.put("BC", "Botswana");
        countryMap.put("BD", "Bermuda");
        countryMap.put("BE", "Belgium");
        countryMap.put("BF", "Bahamas");
        countryMap.put("BG", "Bangladesh");
        countryMap.put("BH", "Belize");
        countryMap.put("BK", "Bosnia-Herzegovina");
        countryMap.put("BL", "Bolivia");
        countryMap.put("BM", "Burma");
        countryMap.put("BN", "Benin");
        countryMap.put("BO", "Belarus");
        countryMap.put("BP", "Solomon Islands");
        countryMap.put("BR", "Brazil");
        countryMap.put("BT", "Bhutan");
        countryMap.put("BU", "Bulgaria");
        countryMap.put("BX", "Brunei Darussalam");
        countryMap.put("BY", "Burundi");
        countryMap.put("CA", "Canada");
        countryMap.put("CB", "Cambodia");
        countryMap.put("CD", "Chad");
        countryMap.put("CE", "Sri Lanka");
        countryMap.put("CF", "Congo (Brazzaville)");
        countryMap.put("CG", "Congo (Kinshasa)");
        countryMap.put("CH", "China");
        countryMap.put("CI", "Chile");
        countryMap.put("CJ", "Cayman Islands");
        countryMap.put("CK", "Cocos Islands");
        countryMap.put("CM", "Cameroon");
        countryMap.put("CN", "Comoros");
        countryMap.put("CO", "Colombia");
        countryMap.put("CS", "Costa Rica");
        countryMap.put("CT", "Central African Rep");
        countryMap.put("CU", "Cuba");
        countryMap.put("CV", "Cape Verde");
        countryMap.put("CW", "Cook Islands");
        countryMap.put("CY", "Cyprus");
        countryMap.put("DA", "Denmark");
        countryMap.put("DJ", "Djibouti");
        countryMap.put("DO", "Dominica");
        countryMap.put("DR", "Dominican Republic");
        countryMap.put("EC", "Ecuador");
        countryMap.put("EG", "Egypt");
        countryMap.put("EI", "Ireland");
        countryMap.put("EK", "Equatorial Guinea");
        countryMap.put("EN", "Estonia");
        countryMap.put("ER", "Eritrea");
        countryMap.put("ES", "El Salvador");
        countryMap.put("ET", "Ethiopia");
        countryMap.put("EZ", "Czech Republic");
        countryMap.put("FG", "French Guiana");
        countryMap.put("FI", "Finland");
        countryMap.put("FJ", "Fiji");
        countryMap.put("FK", "Falkland Islands");
        countryMap.put("FM", "Micronesia");
        countryMap.put("FO", "Faroe Islands");
        countryMap.put("FP", "French Polynesia");
        countryMap.put("FR", "France");
        countryMap.put("GA", "Gambia");
        countryMap.put("GB", "Gabon");
        countryMap.put("GG", "Republic of Georgia");
        countryMap.put("GH", "Ghana");
        countryMap.put("GI", "Gibraltar");
        countryMap.put("GJ", "Grenada");
        countryMap.put("GK", "Guernsey");
        countryMap.put("GL", "Greenland");
        countryMap.put("GM", "Germany");
        countryMap.put("GP", "Guadeloupe");
        countryMap.put("GR", "Greece");
        countryMap.put("GT", "Guatemala");
        countryMap.put("GV", "Guinea");
        countryMap.put("GY", "Guyana");
        countryMap.put("HA", "Haiti");
        countryMap.put("HK", "Hong Kong");
        countryMap.put("HO", "Honduras");
        countryMap.put("HR", "Croatia");
        countryMap.put("HU", "Hungary");
        countryMap.put("IC", "Iceland");
        countryMap.put("ID", "Indonesia");
        countryMap.put("IM", "Isle of Man");
        countryMap.put("IN", "India");
        countryMap.put("IR", "Iran");
        countryMap.put("IS", "Israel");
        countryMap.put("IT", "Italy");
        countryMap.put("IV", "Cote d'Ivoire");
        countryMap.put("IZ", "Iraq");
        countryMap.put("JA", "Japan");
        countryMap.put("JE", "Jersey");
        countryMap.put("JM", "Jamaica");
        countryMap.put("JO", "Jordan");
        countryMap.put("KE", "Kenya");
        countryMap.put("KG", "Kyrgyzstan");
        countryMap.put("KN", "North Korea");
        countryMap.put("KR", "Kiribati");
        countryMap.put("KS", "South Korea");
        countryMap.put("KT", "Christmas Island");
        countryMap.put("KU", "Kuwait");
        countryMap.put("KV", "Kosovo");
        countryMap.put("KZ", "Kazakhstan");
        countryMap.put("LA", "Laos");
        countryMap.put("LE", "Lebanon");
        countryMap.put("LG", "Latvi");
        countryMap.put("LH", "Lithuania");
        countryMap.put("LI", "Liberia");
        countryMap.put("LO", "Slovak Republic");
        countryMap.put("LS", "Liechtenstein");
        countryMap.put("LT", "Lesotho");
        countryMap.put("LU", "Luxembourg");
        countryMap.put("LY", "Libya");
        countryMap.put("MA", "Madagascar");
        countryMap.put("MB", "Martinique");
        countryMap.put("MC", "Macau");
        countryMap.put("MD", "Moldova");
        countryMap.put("MF", "Mayotte");
        countryMap.put("MG", "Mongolia");
        countryMap.put("MH", "Montserrat");
        countryMap.put("MI", "Malawi");
        countryMap.put("MK", "Macedonia");
        countryMap.put("MJ", "Montenegro");
        countryMap.put("ML", "Mali");
        countryMap.put("MN", "Monaco");
        countryMap.put("MO", "Morocco");
        countryMap.put("MP", "Mauritius");
        countryMap.put("MR", "Mauritania");
        countryMap.put("MT", "Malta");
        countryMap.put("MU", "Oman");
        countryMap.put("MV", "Maldives");
        countryMap.put("MX", "Mexico");
        countryMap.put("MY", "Malaysia");
        countryMap.put("MZ", "Mozambique");
        countryMap.put("NC", "New Caledonia");
        countryMap.put("NE", "Niue");
        countryMap.put("NF", "Norfolk Island");
        countryMap.put("NG", "Niger");
        countryMap.put("NH", "Vanuatu");
        countryMap.put("NI", "Nigeria");
        countryMap.put("NL", "Netherlands");
        countryMap.put("NO", "Norway");
        countryMap.put("NP", "Nepal");
        countryMap.put("NR", "Nauru");
        countryMap.put("NS", "Suriname");
        countryMap.put("NT", "Netherlands Antilles");
        countryMap.put("NU", "Nicaragua");
        countryMap.put("NZ", "New Zealand");
        countryMap.put("OD", "South Sudan");
        countryMap.put("PA", "Paraguay");
        countryMap.put("PC", "Pitcairn Island");
        countryMap.put("PE", "Peru");
        countryMap.put("PK", "Pakistan");
        countryMap.put("PL", "Poland");
        countryMap.put("PM", "Panama");
        countryMap.put("PO", "Portugal");
        countryMap.put("PP", "Papua New Guinea");
        countryMap.put("PS", "Palau");
        countryMap.put("PU", "Guinea-Bissau");
        countryMap.put("QA", "Qatar");
        countryMap.put("RB", "Serbia");
        countryMap.put("RE", "Reunion");
        countryMap.put("RM", "Marshall Islands");
        countryMap.put("RO", "Romania");
        countryMap.put("RP", "Philippines");
        countryMap.put("RS", "Russia");
        countryMap.put("RW", "Rwanda");
        countryMap.put("SA", "Saudi Arabia");
        countryMap.put("SB", "St Pierre & Miquelon");
        countryMap.put("SC", "St Kitts & Nevis");
        countryMap.put("SE", "Seychelles");
        countryMap.put("SF", "South Africa");
        countryMap.put("SG", "Senegal");
        countryMap.put("SH", "Saint Helena");
        countryMap.put("SI", "Slovenia");
        countryMap.put("SL", "Sierra Leone");
        countryMap.put("SM", "San Marino");
        countryMap.put("SN", "Singapore");
        countryMap.put("SO", "Somalia");
        countryMap.put("SP", "Spain");
        countryMap.put("ST", "Saint Lucia");
        countryMap.put("SU", "Sudan");
        countryMap.put("SW", "Sweden");
        countryMap.put("SY", "Syrian Arab Republic");
        countryMap.put("SZ", "Switzerland");
        countryMap.put("TD", "Trinidad and Tobago");
        countryMap.put("TH", "Thailand");
        countryMap.put("TI", "Tajikistan");
        countryMap.put("TK", "Turks and Caicos Iss");
        countryMap.put("TL", "Tokelau");
        countryMap.put("TN", "Tonga");
        countryMap.put("TO", "Togo");
        countryMap.put("TP", "Sao Tome & Principe");
        countryMap.put("TS", "Tunisia");
        countryMap.put("TT", "East Timor");
        countryMap.put("TU", "Turkey");
        countryMap.put("TV", "Tuvalu");
        countryMap.put("TW", "Taiwan");
        countryMap.put("TX", "Turkmenistan");
        countryMap.put("TZ", "Tanzania");
        countryMap.put("UG", "Uganda");
        countryMap.put("UK", "United Kingdom");
        countryMap.put("UP", "Ukraine");
        countryMap.put("US", "United States");
        countryMap.put("UV", "Burkina Faso");
        countryMap.put("UY", "Uruguay");
        countryMap.put("UZ", "Uzbekistan");
        countryMap.put("VC", "St Vincent&Grenadine");
        countryMap.put("VE", "Venezuela");
        countryMap.put("VI", "British Virgin Iss");
        countryMap.put("VM", "Vietnam");
        countryMap.put("VT", "Vatican City");
        countryMap.put("WA", "Namibia");
        countryMap.put("WF", "Wallis and Futuna");
        countryMap.put("WS", "Samoa");
        countryMap.put("WZ", "Swaziland");
        countryMap.put("YM", "Yemen");
        countryMap.put("ZA", "Zambia");
        countryMap.put("ZI", "Zimbabwe");
        return countryMap.inverse();
    }

    /**
     * Fake address address.
     *
     * @return the address
     */
    public static Address fakeAddress() {
        com.github.javafaker.Address address = new Faker().address();
        return Address.newBuilder()
                .setFirstName(address.firstName())
                .setLastName(address.lastName())
                .setLine1(address.streetAddress())
                .setCity(address.city())
                .setState(address.stateAbbr())
                .setCountry(OrderUtil.COUNTRY_ABBREVIATION_MAP.getOrDefault(address.country(), "US"))
                .build();
    }
}
