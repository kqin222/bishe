package djj.domain;

public class StudentInOutLog {
    private String date;
    private String name;
    private String num;
    private String phone;
    private String outTime;
    private String inTime;
    private String reason;

    private String startAddress;
    private String purposeAddress;
    private String myResponse;

    private String checked;

    public StudentInOutLog() {
    }

    @Override
    public String toString() {
        return "StudentInOutLog{" +
                "date='" + date + '\'' +
                ", name='" + name + '\'' +
                ", num='" + num + '\'' +
                ", phone='" + phone + '\'' +
                ", outTime='" + outTime + '\'' +
                ", inTime='" + inTime + '\'' +
                ", reason='" + reason + '\'' +
                ", startAddress='" + startAddress + '\'' +
                ", purposeAddress='" + purposeAddress + '\'' +
                ", myResponse='" + myResponse + '\'' +
                ", checked='" + checked + '\'' +
                '}';
    }

    public String getMyResponse() {
        return myResponse;
    }

    public void setMyResponse(String myResponse) {
        this.myResponse = myResponse;
    }

    public StudentInOutLog(String date, String name, String num, String phone, String outTime, String inTime, String reason, String startAddress, String purposeAddress, String myResponse, String checked) {
        this.date = date;
        this.name = name;
        this.num = num;
        this.phone = phone;
        this.outTime = outTime;
        this.inTime = inTime;
        this.reason = reason;
        this.startAddress = startAddress;
        this.purposeAddress = purposeAddress;
        this.myResponse = myResponse;
        this.checked = checked;
    }

    public String getStartAddress() {
        return startAddress;
    }

    public void setStartAddress(String startAddress) {
        this.startAddress = startAddress;
    }

    public StudentInOutLog(String date, String name, String num, String phone, String outTime, String inTime, String reason, String startAddress, String purposeAddress, String checked) {
        this.date = date;
        this.name = name;
        this.num = num;
        this.phone = phone;
        this.outTime = outTime;
        this.inTime = inTime;
        this.reason = reason;
        this.startAddress = startAddress;
        this.purposeAddress = purposeAddress;
        this.checked = checked;
    }

    public StudentInOutLog(String date, String name, String num, String phone, String outTime, String inTime, String reason, String purposeAddress, String checked) {
        this.date = date;
        this.name = name;
        this.num = num;
        this.phone = phone;
        this.outTime = outTime;
        this.inTime = inTime;
        this.reason = reason;
        this.purposeAddress = purposeAddress;
        this.checked = checked;
    }

    public String getChecked() {
        return checked;
    }

    public void setChecked(String checked) {
        this.checked = checked;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOutTime() {
        return outTime;
    }

    public void setOutTime(String outTime) {
        this.outTime = outTime;
    }

    public String getInTime() {
        return inTime;
    }

    public void setInTime(String inTime) {
        this.inTime = inTime;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getPurposeAddress() {
        return purposeAddress;
    }

    public void setPurposeAddress(String purposeAddress) {
        this.purposeAddress = purposeAddress;
    }

    public StudentInOutLog(String date, String name, String num, String phone, String outTime, String inTime, String reason, String purposeAddress) {
        this.date = date;
        this.name = name;
        this.num = num;
        this.phone = phone;
        this.outTime = outTime;
        this.inTime = inTime;
        this.reason = reason;
        this.purposeAddress = purposeAddress;
    }
}
