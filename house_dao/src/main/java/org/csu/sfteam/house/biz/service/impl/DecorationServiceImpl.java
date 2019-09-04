package org.csu.sfteam.house.biz.service.impl;

import org.csu.sfteam.house.biz.service.DecorationService;
import org.csu.sfteam.house.biz.mapper.DecorationMapper;
import org.csu.sfteam.house.common.model.items.Decoration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DecorationServiceImpl implements DecorationService {

    @Autowired
    private DecorationMapper decorationMapper;

    @Override
    public int CreateDecoration(Decoration decoration) {
        return decorationMapper.insert(decoration);
    }

    @Override
    public int UpdateDecoration(Decoration decoration) {
        return decorationMapper.update(decoration);
    }

    @Override
    public int delete(Decoration decoration) {
        return decorationMapper.delete(decoration);
    }

    @Override
    public int delete(int id, int type) {
        return decorationMapper.deleteByID(id, type);
    }

    @Override
    public Decoration GetDecoration(String company) {
        return decorationMapper.getDecoration(company);
    }

    @Override
    public List<Decoration> GetDecorationListByKeywords(String keywords) {
        return decorationMapper.getDecorationListByKeywords(keywords);
    }

    @Override
    public List<Decoration> ShowDecorations() {
        return decorationMapper.showDecorations();
    }

    @Override
    public List<Decoration> ShowDecorationsByStyle(int style) {
        return decorationMapper.showDecorationsByStyle(style);
    }

    @Override
    public List<Decoration> ShowDecorationsByAddress(String address) {
        return decorationMapper.showDecorationsByAddress(address);
    }

    @Override
    public List<Decoration> showDecorationsByItemFrom(int ID) {
        return decorationMapper.showDecorationsByItemFrom(ID);
    }
}
