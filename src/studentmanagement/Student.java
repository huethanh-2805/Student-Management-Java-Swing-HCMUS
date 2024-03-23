package studentmanagement;

import java.io.Serializable;

//Thêm  "implements Serializable" để lưu file nhị phân
public class Student  implements Serializable {
    private String MHS;
    private String TenHS;
    private float Diem;
    private String UrlAvatar;
    private String DiaChi;
    private String GhiChu;

    public Student(String MHS, String TenHS, float Diem, String UrlAvatar, String DiaChi, String GhiChu) {
        this.MHS = MHS;
        this.TenHS = TenHS;
        this.Diem = Diem;
        this.UrlAvatar = UrlAvatar;
        this.DiaChi = DiaChi;
        this.GhiChu = GhiChu;
    }

    public void setMHS(String MHS) {
        this.MHS = MHS;
    }

    public void setTenHS(String TenHS) {
        this.TenHS = TenHS;
    }

    public void setDiem(float Diem) {
        this.Diem = Diem;
    }

    public void setUrlAvatar(String UrlAvatar) {
        this.UrlAvatar = UrlAvatar;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    public String getMHS() {
        return MHS;
    }

    public String getTenHS() {
        return TenHS;
    }

    public float getDiem() {
        return Diem;
    }

    public String getUrlAvatar() {
        return UrlAvatar;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    
    
}
