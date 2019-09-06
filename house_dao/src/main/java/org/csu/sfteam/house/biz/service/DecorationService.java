package org.csu.sfteam.house.biz.service;
import org.csu.sfteam.house.common.model.items.Decoration;

import java.util.List;
//均可用
public interface DecorationService {
    //添加/上传装修
    //可用
    public int CreateDecoration(Decoration decoration);
    //修改上传的装修内容
    //可用
    public int UpdateDecoration(Decoration decoration);
    //
    public int delete(Decoration decoration);

    public int delete(int id);
    //
    public Decoration GetDecoration(String company);
    //
    public List<Decoration> GetDecorationListByKeywords(String keywords);

    public List<Decoration> ShowDecorations();

    public List<Decoration> ShowDecorationsByStyle(int style);

    public List<Decoration> ShowDecorationsByAddress(String address);

    public List<Decoration> showDecorationsByItemFrom(int ID);

    public int selectDecorationCount();
}
