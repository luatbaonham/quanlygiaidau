package com.example.fe_quanlygiaidau.joindatabase;

import com.example.fe_quanlygiaidau.model.CauThu;
import com.example.fe_quanlygiaidau.model.DoiBong;
import com.example.fe_quanlygiaidau.model.ViTriCauThu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Join_hienthi_cauthu {
    public List<Item_hienthi_cauthu> mapCauThuNhanh(List<CauThu> cauThus,
                                                    List<DoiBong> doiBongs,
                                                    List<ViTriCauThu> vitris) {
        Map<String, DoiBong> mapDoiBong = new HashMap<>();
        for (DoiBong db : doiBongs) {
            mapDoiBong.put(db.getMaDoiBong(), db);
        }

        Map<String, ViTriCauThu> mapViTri = new HashMap<>();
        for (ViTriCauThu vt : vitris) {
            mapViTri.put(vt.getMaViTri(), vt);
        }

        List<Item_hienthi_cauthu> result = new ArrayList<>();

        for (CauThu ct : cauThus) {
            DoiBong doi = mapDoiBong.get(ct.getMaDoiBong());
            ViTriCauThu vitri = mapViTri.get(ct.getMaViTri());
            if (doi != null && vitri != null) {
                result.add(new Item_hienthi_cauthu(
                        ct.getHoTen(),
                        ct.getNgaySinh(),
                        ct.getSoAo(),
                        vitri.getTenViTri(),
                        ct.getHinhAnh(),
                        doi.getTenDoiBong(),
                        doi.getLogo(),
                        ct.getMaDoiBong()
                ));
            }
        }
        return result;
    }
}
