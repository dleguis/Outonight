package edu.fst.m2.ipii.outonight.service.impl;

import com.activeandroid.query.Select;

import java.util.List;

import edu.fst.m2.ipii.outonight.model.Establishment;
import edu.fst.m2.ipii.outonight.service.EstablishmentService;

/**
 * Created by Dimitri on 10/05/2015.
 */
public class EstablishmentServiceImpl implements EstablishmentService {

    private static EstablishmentService instance;

    public static EstablishmentService getInstance() {
        if (null == instance) {
            instance = new EstablishmentServiceImpl();
        }
        return instance;
    }

    private EstablishmentServiceImpl() {

    }

    @Override
    public List<Establishment> getAllCached() {
        return getAllEstablishments();
    }

    @Override
    public Establishment getCached(int id) {
        return new Select().from(Establishment.class).orderBy("name ASC").where("establishmentId = ?", id).executeSingle();
    }

    @Override
    public List<Establishment> getCachedByName(String name) {
        return new Select().from(Establishment.class).orderBy("name ASC").where("name = ?", name).execute();
    }

    @Override
    public List<Establishment> getCachedByType(String type) {

        if (type == null) {
            // si type null alors on est dans la section "Selec"
            return getAllStarredEstablishments();
        }

        List<Establishment> establishments = new Select().from(Establishment.class).orderBy("name ASC").where("type = ?", type).execute();

        return  establishments;

    }


    private List<Establishment> getAllEstablishments() {
        return new Select().from(Establishment.class).orderBy("name ASC").execute();
    }

    private List<Establishment> getAllStarredEstablishments() {
        return new Select().from(Establishment.class).orderBy("name ASC").where("stared = ?", true).execute();
    }



}
