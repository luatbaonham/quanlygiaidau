package com.example.fe_quanlygiaidau.dto;

import com.example.fe_quanlygiaidau.model.DoiBong;
import com.example.fe_quanlygiaidau.model.DoiBongGiaiDau;
import com.example.fe_quanlygiaidau.model.Giaidau;
import com.example.fe_quanlygiaidau.model.KetQuaTranDau;
import com.example.fe_quanlygiaidau.model.TranDau;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Join_hienthi_KQ {
        public List<Item_hienthi_KQ> mapKetQuaNhanh(List<KetQuaTranDau> ketQuas,
                                                    List<TranDau> tranDaus,
                                                    List<DoiBong> doiBongs,
                                                    List<Giaidau> giaiDaus,
                                                    List<DoiBongGiaiDau> doiBongGiaiDaus) {

        Map<String, TranDau> mapTranDau = new HashMap<>();
        for (TranDau td : tranDaus) {
            mapTranDau.put(td.getMaTranDau(), td);
        }

        Map<String, DoiBong> mapDoiBong = new HashMap<>();
        for (DoiBong db : doiBongs) {
            mapDoiBong.put(db.getMaDoiBong(), db);
        }

        Map<String, DoiBongGiaiDau> mapDoiBongGiaiDau = new HashMap<>();
        for (DoiBongGiaiDau dbgd : doiBongGiaiDaus) {
            mapDoiBongGiaiDau.put(dbgd.getMaDoiBong(), dbgd);
        }

        Map<String, Giaidau> mapGiaiDau = new HashMap<>();
        for (Giaidau gd : giaiDaus) {
            mapGiaiDau.put(gd.getMaGiaidau(),gd);
        }

        List<Item_hienthi_KQ> result = new ArrayList<>();

        for (KetQuaTranDau kq : ketQuas) {
            TranDau td = mapTranDau.get(kq.getMaTranDau());
            if (td != null) {
                DoiBong doi1 = mapDoiBong.get(td.getMaDoi1());
                DoiBong doi2 = mapDoiBong.get(td.getMaDoi2());
                Giaidau gd = mapGiaiDau.get(td.getMaGiaiDau());
                DoiBongGiaiDau doiBongGiaiDau1 = mapDoiBongGiaiDau.get(td.getMaDoi1());
                DoiBongGiaiDau doiBongGiaiDau2 = mapDoiBongGiaiDau.get(td.getMaDoi2());

                if (doi1 != null && doi2 != null) {
                    result.add(new Item_hienthi_KQ(
                            doiBongGiaiDau1.getTenDoiBong(),
                            doiBongGiaiDau2.getTenDoiBong(),
                            doi1.getLogo(),
                            doi2.getLogo(),
                            gd.getTenGiaiDau(),
                            kq.getSoBanDoi1(),
                            kq.getSoBanDoi2(),
                            td.getNgayDienRa(),
                            td.getGioDienRa()
                    ));
                }
            }
        }

        return result;
    }

}
