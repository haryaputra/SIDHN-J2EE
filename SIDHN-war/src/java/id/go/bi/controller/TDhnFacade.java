/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package id.go.bi.controller;

import id.go.bi.entity.TDhn;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Harya Putra
 */
@Stateless
public class TDhnFacade extends AbstractFacade<TDhn> {
    @PersistenceContext(unitName = "SIDHN-warPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TDhnFacade() {
        super(TDhn.class);
    }
    
}
