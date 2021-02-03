package cn.itcast.bank_record.entity;

public class TransferRecord {
    private String id;
    private String code;
    private String rec_account;
    private String rec_bank_name;
    private String rec_name;
    private String pay_account;
    private String pay_name;
    private String pay_comments;
    private String pay_channel;
    private String pay_way;
    private String status;
    private String timestamp;
    private String money;

    public TransferRecord() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getRec_account() {
        return rec_account;
    }

    public void setRec_account(String rec_account) {
        this.rec_account = rec_account;
    }

    public String getRec_bank_name() {
        return rec_bank_name;
    }

    public void setRec_bank_name(String rec_bank_name) {
        this.rec_bank_name = rec_bank_name;
    }

    public String getRec_name() {
        return rec_name;
    }

    public void setRec_name(String rec_name) {
        this.rec_name = rec_name;
    }

    public String getPay_account() {
        return pay_account;
    }

    public void setPay_account(String pay_account) {
        this.pay_account = pay_account;
    }

    public String getPay_name() {
        return pay_name;
    }

    public void setPay_name(String pay_name) {
        this.pay_name = pay_name;
    }

    public String getPay_comments() {
        return pay_comments;
    }

    public void setPay_comments(String pay_comments) {
        this.pay_comments = pay_comments;
    }

    public String getPay_channel() {
        return pay_channel;
    }

    public void setPay_channel(String pay_channel) {
        this.pay_channel = pay_channel;
    }

    public String getPay_way() {
        return pay_way;
    }

    public void setPay_way(String pay_way) {
        this.pay_way = pay_way;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    // 通过调用parse方法就可以将一行逗号分隔的文本解析为TransferRecord
    public static TransferRecord parse(String line) {
        String[] fieldsArray = line.split(",");

        TransferRecord transferRecord = new TransferRecord();
        transferRecord.setId(fieldsArray[0]);
        transferRecord.setCode(fieldsArray[1]);
        transferRecord.setRec_account(fieldsArray[2]);
        transferRecord.setRec_bank_name(fieldsArray[3]);
        transferRecord.setRec_name(fieldsArray[4]);
        transferRecord.setPay_account(fieldsArray[5]);
        transferRecord.setPay_name(fieldsArray[6]);
        transferRecord.setPay_comments(fieldsArray[7]);
        transferRecord.setPay_channel(fieldsArray[8]);
        transferRecord.setPay_way(fieldsArray[9]);
        transferRecord.setStatus(fieldsArray[10]);
        transferRecord.setTimestamp(fieldsArray[11]);
        transferRecord.setMoney(fieldsArray[12]);

        return transferRecord;
    }
}
