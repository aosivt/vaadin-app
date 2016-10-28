package aosivt.AppData;

import java.util.Date;

/**
 * Created by oshchepkovayu on 20.10.16.
 */
public final class SaveAppData {
    private static Long id_protocol;
    private static Long id_view_protocol;
    private static Long id_organization;

    private static Date date_in;
    private static Date date_out;

    private static String name_organization;
    private static String reason;
    private static String review;
    private static double sum;

    public SaveAppData()
    {
    }

    public static Long getId_protocol() {
        return id_protocol;
    }

    public static void setId_protocol(Long id_protocol) {
        SaveAppData.id_protocol = id_protocol;
    }

    public static Long getId_view_protocol() {
        return id_view_protocol;
    }

    public static void setId_view_protocol(Long id_view_protocol) {
        SaveAppData.id_view_protocol = id_view_protocol;
    }

    public static Date getDate_in() {
        return date_in;
    }

    public static void setDate_in(Date date_in) {
        SaveAppData.date_in = date_in;
    }

    public static Date getDate_out() {
        return date_out;
    }

    public static void setDate_out(Date date_out) {
        SaveAppData.date_out = date_out;
    }

    public static String getName_organization() {
        return name_organization;
    }

    public static void setName_organization(String name_organization) {
        SaveAppData.name_organization = name_organization;
    }

    public static String getReason() {
        return reason;
    }

    public static void setReason(String reason) {
        SaveAppData.reason = reason;
    }

    public static double getSum() {
        return sum;
    }

    public static void setSum(double sum) {
        SaveAppData.sum = sum;
    }

    public static String getReview() {
        return review;
    }

    public static void setReview(String review) {
        SaveAppData.review = review;
    }
}
