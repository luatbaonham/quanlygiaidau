package com.example.fe_quanlygiaidau.modeladapter;

public class DoiBongModelAdapter {
    private int stt;
    private String doiBong;
    private int tranDau;
    private int tranThang;
    private int tranHoa;
    private int tranThua;
    private int hieuSo;
    private int diem;

    public DoiBongModelAdapter(int stt, String doiBong, int tranDau, int tranThang, int tranHoa, int tranThua, int hieuSo, int diem) {
        this.stt = stt;
        this.doiBong = doiBong;
        this.tranThang = tranThang;
        this.tranHoa = tranHoa;
        this.tranDau = tranDau;
        this.tranThua = tranThua;
        this.hieuSo = hieuSo;
        this.diem = diem;
    }

    public DoiBongModelAdapter() {
    }

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public String getDoiBong() {
        return doiBong;
    }

    public void setDoiBong(String doiBong) {
        this.doiBong = doiBong;
    }

    public int getTranDau() {
        return tranDau;
    }

    public void setTranDau(int tranDau) {
        this.tranDau = tranDau;
    }

    public int getTranThang() {
        return tranThang;
    }

    public void setTranThang(int tranThang) {
        this.tranThang = tranThang;
    }

    public int getTranHoa() {
        return tranHoa;
    }

    public void setTranHoa(int tranHoa) {
        this.tranHoa = tranHoa;
    }

    public int getTranThua() {
        return tranThua;
    }

    public void setTranThua(int tranThua) {
        this.tranThua = tranThua;
    }

    public int getHieuSo() {
        return hieuSo;
    }

    public void setHieuSo(int hieuSo) {
        this.hieuSo = hieuSo;
    }

    public int getDiem() {
        return diem;
    }

    public void setDiem(int diem) {
        this.diem = diem;
    }
}
