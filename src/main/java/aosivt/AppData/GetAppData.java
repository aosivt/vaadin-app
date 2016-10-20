package aosivt.AppData;

import java.sql.ResultSet;
import java.util.Date;

/**
 * Created by alex on 20.10.16.
 */
public class GetAppData {
    private Long id_protocol;
    private  Long id_view_protocol;
    private  Long id_organization;

    private  String date_in;
    private  String date_out;

    private  String name_organization;
    private  String reason;
    private  String review;
    private  String comment;
    private  double sum;

    public GetAppData()
    {

    }

    public Long getId_protocol() {
        return id_protocol==null?Long.parseLong("0"):id_protocol;
    }

    public Long getId_view_protocol() {
        return id_view_protocol==null?Long.parseLong("0"):id_view_protocol;
    }

    public Long getId_organization() {
        return id_organization==null?Long.parseLong("0"):id_view_protocol;
    }

    public String getDate_in() {
        return date_in==null?"Не указана":date_in;
    }

    public String getDate_out() {
        return date_out==null?"Не указана":date_out;
    }

    public String getName_organization() {
        return name_organization==null?"Не указана":name_organization;
    }

    public String getReason() {
        return reason==null?"Не указана":reason;
    }

    public String getReview() {
        return review==null?"Не указана":review;
    }

    public String getComment() {
        return comment==null?"Не указана":comment;
    }

    public double getSum() {
        return  sum;
    }

    public void setId_protocol(Long id_protocol) {
        this.id_protocol = id_protocol==null?Long.parseLong("0"):id_protocol;
    }

    public void setId_view_protocol(Long id_view_protocol) {
        this.id_view_protocol = id_view_protocol==null?Long.parseLong("0"):id_view_protocol;
    }

    public void setId_organization(Long id_organization) {
        this.id_organization = id_organization==null?Long.parseLong("0"):id_view_protocol;
    }

    public void setDate_in(String date_in) {
        this.date_in = date_in==null?"Не указана":date_in;
    }

    public void setDate_out(String date_out) {
        this.date_out = date_out==null?"Не указана":date_out;
    }

    public void setName_organization(String name_organization) {
        this.name_organization = name_organization==null?"Не указана":name_organization;
    }

    public void setReason(String reason) {
        this.reason = reason==null?"Не указана":reason;
    }

    public void setReview(String review) {
        this.review = review==null?"Не указана":review;
    }

    public void setComment(String comment) {
        this.comment = comment==null?"Не указана":comment;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }
}
