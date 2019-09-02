package org.csu.sfteam.house.biz.mapper;

import org.csu.sfteam.house.common.model.items.Decoration;

import java.util.List;

/**
 * @email 1694522669@qq.com
 * @author: A
 * @date: 2019/9/2 14:07
 */
public interface DecorationMapper {
    public int insert(Decoration decoration);

    public int delete(Decoration decoration);

    public int delete(int id, int type);

    public int update(Decoration decoration);

    public Decoration getDecoration(String company);

    public List<Decoration> getDecorationListByKeywords(String keywords);

    public List<Decoration> showDecorations();

    public List<Decoration> showDecorationsByStyle(int style);

    public List<Decoration> showDecorationsByAddress(String address);


}
