package com.mapping.model.reloadly;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import lombok.Data;

import java.util.ArrayList;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class OperatorID {
    public int id;
    public int operatorId;
    public String name;
    public boolean bundle;
    public boolean data;
    public boolean pin;
    public boolean supportsLocalAmounts;
    public boolean supportsGeographicalRechargePlans;
    public String denominationType;
    public String senderCurrencyCode;
    public String senderCurrencySymbol;
    public String destinationCurrencyCode;
    public String destinationCurrencySymbol;
    public double commission;
    public double internationalDiscount;
    public double localDiscount;
    public double mostPopularAmount;
    public Object mostPopularLocalAmount;
    public Object minAmount;
    public Object maxAmount;
    public Object localMinAmount;
    public Object localMaxAmount;
    public Country country;
    public Fx fx;
    public ArrayList<String> logoUrls;
    public ArrayList<Double> fixedAmounts;
    public FixedAmountsDescriptions fixedAmountsDescriptions;
    public ArrayList<Object> localFixedAmounts;
    public LocalFixedAmountsDescriptions localFixedAmountsDescriptions;
    public ArrayList<Object> suggestedAmounts;
    public SuggestedAmountsMap suggestedAmountsMap;
    public ArrayList<Object> geographicalRechargePlans;
    public ArrayList<Object> promotions;
    public String status;
}
