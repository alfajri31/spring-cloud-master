package org.group.dcost.util;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Random;
import java.util.UUID;

public class Util {

    public static Integer getRandomValue() {
        Random random = new Random();
        return random.nextInt(50000) + 1000;
    }

    public static String getRandomUUID() {
        return UUID.randomUUID().toString();
    }


    public static String convertToIndonesianRupiah(Integer amount) {
        DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();

        formatRp.setCurrencySymbol("Rp. ");
        formatRp.setGroupingSeparator('.');
        kursIndonesia.setDecimalFormatSymbols(formatRp);
        return kursIndonesia.format(amount);
    }
}
